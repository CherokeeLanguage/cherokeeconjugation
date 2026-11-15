package net.cherokeedictionary.grammarGuide

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * Harness to bridge VerbBookFixtures with the conjugation engine.
 */
class VerbBookEngineHarness {

    // Maps English phrase parts to engine codes
    static final Map<String, String> SUBJ_MAP = [
        "I ": "SG1",
        "You (singular) ": "SG2",
        "You (more than two) ": "PL2", // tio 12Nov26: book's Second Plural phrasing ("You (more than two) see me")
        "He/she ": "SG3",
        "They ": "PL3",
        "You two ": "DL2",
        "You all ": "PL2",
        "We (you and I and another or others) ": "PL1INCL",
        "We (you and I) ": "DL1INCL",
        "We (another and I) ": "DL1EXCL",
        "We (others and I) ": "PL1EXCL",
        "We (but not you) ": "DL1EXCL",
        "Let him/her ": "SG3",
        "Let me ": "SG1",
        "May I ": "SG1",
        "May he/she ": "SG3",
        // tio 13Nov26: bare "S/he"/"You"/"You (two)" phrasings — the verb book
        // prints several tables with unparenthesized row labels ("You fall",
        // "S/he fell", "May you (two) fall right now!"), which must not fall
        // through to the SG3 default. "You " is matched last so the
        // parenthesized variants ("You (singular) ", "You two ", "You all ")
        // win first (map iteration is insertion order).
        "S/he ": "SG3",
        "You (two) ": "DL2",
        "You ": "SG2"
    ]

    /**
     * Infinitive person phrases. The verb book's infinitive tables phrase the
     * SUBJECT as an object pronoun ("For me to fall", "For you (two) to fall")
     * — the person is the verb's subject, not its object. Longer keys first:
     * "us (you and I and another or others)" must win before "us (you and I)".
     * tio 13Nov26
     */
    static final Map<String, String> INF_SUBJ_MAP = [
        "you (more than two)"                       : "PL2",
        "you (two)"                                 : "DL2",
        "us (you and I and another or others)"      : "PL1INCL",
        "us (another and I)"                        : "DL1EXCL",
        "us (others and I)"                         : "PL1EXCL",
        "us (you and I)"                            : "DL1INCL",
        "you"                                       : "SG2",
        "me"                                        : "SG1",
        "him/her/it"                                : "SG3",
        "him/her"                                   : "SG3",
        "them"                                      : "PL3",
    ]

    // timo 12Nov26: order matters -- multi-person object phrases must be tested
    // before their bare-person components ("you and me" before "you", "me").
    // tio 12Nov26: added "you two" (the book's DL2 phrasing, unparenthesized:
    // "He/she sees you two") and "me and you" (the book's PL1INCL phrasing:
    // "He/she sees another, or others, me and you" -- igi- SG3PL1INCL).
    static final Map<String, String> OBJ_MAP = [
        "you and me and another or others": "PL1INCL",
        "me and you": "PL1INCL",
        "someone else and me": "DL1EXCL",
        "others and me": "PL1EXCL",
        "you and me": "DL1INCL",
        "you (more than two)": "PL2",
        "you (two)": "DL2",
        "you two": "DL2",
        "him/her": "SG3AN",
        "those (things)": "PL3IN",
        "those things": "PL3IN",
        "them": "PL3AN",
        "it": "SG3IN",
        "you": "SG2",
        "me": "SG1"
    ]

    static String getEngineSyllabary(String verbName, String tense, String english, Map details) {
        // tio 13Nov26: the book's "May ..." volative rows (IMMEDIATE_IMPERATIVE_VOLATIVE
        // tables, e.g. "May we (another and I) fall right now!") label the same
        // person phrases as the declarative tables — strip the "May " and rematch,
        // so "May you (two) ..." resolves through the same keys as "You (two) ...".
        def matchText = english.startsWith("May ") ? english.substring(4) : english

        def subj = "SG3"
        def obj = "SG3IN"

        // tio 13Nov26: infinitive rows ("For me to fall", "For you (two) to
        // fall") phrase the subject as an object pronoun after "For"; the
        // person before " to " is the SUBJECT, and the object scan applies to
        // the remainder only (transitive rows: "For me to bite it" -> SG1
        // subject + SG3IN object). Without this the person lands in the
        // object slot, which determineSubjectObject then forces to SG3IN and
        // every row prints the bare sg3 citation (ᎤᏅᎢᏍᏗ).
        // tio 15Nov26: some tables print the infinitive label parenthesized
        // ("(For) me to see it", To See p.119) — strip the parens so the
        // regex still matches; otherwise the subject falls through to the
        // SG3 default and the SG1 row prints the bare sg3 citation.
        matchText = matchText.replaceFirst("(?i)^\\(?For\\)?\\s+", "For ")
        def infMatcher = (matchText =~ /(?i)^for\s+(.*?)\s+\bto\b(.*)$/)
        if (infMatcher.matches()) {
            def personLower = infMatcher.group(1).toLowerCase()
            for (entry in INF_SUBJ_MAP) {
                if (personLower.startsWith(entry.key.toLowerCase())) {
                    subj = entry.value
                    break
                }
            }
            def restLower = infMatcher.group(2).toLowerCase()
            for (entry in OBJ_MAP) {
                if (restLower.contains(" " + entry.key)) {
                    obj = entry.value
                    break
                }
            }
        } else {
            // tio 12Nov26: longest-key-wins subject match; the matched subject
            // phrase is then stripped so the object scan doesn't mistake the
            // subject's "you" for the object ("You (singular) see me" -> obj
            // must be SG1, not SG2).
            def subjPhrase = ""
            def matchLower = matchText.toLowerCase()
            for (entry in SUBJ_MAP) {
                if (matchLower.startsWith(entry.key.toLowerCase())) {
                    subj = entry.value
                    subjPhrase = matchText.substring(0, entry.key.length())
                    break
                }
            }

            def objText = subjPhrase ? english.substring(subjPhrase.length()) : english
            // tio 13Nov26: object keys must match as PHRASES preceded by a space —
            // the book's English rows put the verb before the object ("are biting
            // me"), and verbs themselves contain object-key substrings ("biting"
            // contains "it"), so a bare contains() mapped every To Bite row to
            // the SG3IN object. Object phrases always follow the verb after a
            // space, so " " + key is sufficient.
            def objLower = objText.toLowerCase()
            for (entry in OBJ_MAP) {
                if (objLower.contains(" " + entry.key)) {
                    obj = entry.value
                    break
                }
            }
        }

        // timo 12Nov26: the raw VERB_BOOK rows passed as `details` carry no
        // `subject` field, so VerbBaseSpec.conjugateVerb can't locate the SG3/SG1
        // stem rows and the stemmer is built empty (MISSING_STEM / NPE). The clean
        // normalized stems live in VerbBookFixtures (present3rd "agowtiha", etc.);
        // prefer the fixture (overrides first) and fall back to the passed details
        // for verbs not yet fixture-backed.
        def fixture = (VerbBookFixtures.OVERRIDES[verbName]
                        ?: VerbBookFixtures.FIXTURES[verbName]) ?: details

        // tio 13Nov26: specs can declare per-tense initial prefixes lexically
        // ("to fall" immediate imperative/volative rows print wi- on the
        // vowel-initial cells); overlay the spec's initialPrefixes onto the
        // fixture so a verb-level fixture can't suppress them (the fixture is
        // verb-level, the prefix need is tense-level).
        if (details.initialPrefixes) {
            def merged = new LinkedHashMap(fixture ?: [:])
            merged.initialPrefixes = new LinkedHashMap((fixture?.initialPrefixes ?: [:]) + details.initialPrefixes)
            fixture = merged
        }

        // Use the fixture to provide the stemmer-building info
        return VerbBaseSpec.conjugateVerb(verbName, fixture, subj, obj, tense, null)
    }
}
