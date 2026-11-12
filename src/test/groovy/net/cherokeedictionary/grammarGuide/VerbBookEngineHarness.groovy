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
        "May he/she ": "SG3"
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
        "those things": "PL3IN",
        "them": "PL3AN",
        "it": "SG3IN",
        "you": "SG2",
        "me": "SG1"
    ]

    static String getEngineSyllabary(String verbName, String tense, String english, Map details) {
        // timo 12Nov26: longest-key-wins subject match; the matched subject phrase
        // is then stripped so the object scan doesn't mistake the subject's "you"
        // for the object ("You (singular) see me" -> obj must be SG1, not SG2).
        def subj = "SG3"
        def subjPhrase = ""
        for (entry in SUBJ_MAP) {
            if (english.startsWith(entry.key)) {
                subj = entry.value
                subjPhrase = entry.key
                break
            }
        }

        def objText = subjPhrase ? english.substring(subjPhrase.length()) : english
        def obj = "SG3IN"
        def objLower = objText.toLowerCase()
        for (entry in OBJ_MAP) {
            if (objLower.contains(entry.key)) {
                obj = entry.value
                break
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

        // Use the fixture to provide the stemmer-building info
        return VerbBaseSpec.conjugateVerb(verbName, fixture, subj, obj, tense, null)
    }
}
