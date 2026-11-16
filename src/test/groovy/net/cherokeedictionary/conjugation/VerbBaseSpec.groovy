package net.cherokeedictionary.conjugation

import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import net.cherokeedictionary.proposed.ConjugationRequest
import net.cherokeedictionary.proposed.VerbConjugationFacade
import net.cherokeedictionary.transliteration.SyllabaryUtil
import spock.lang.Specification

abstract class VerbBaseSpec extends Specification {

    // tio 12Nov26: the verb book's romanization writes the Ꮹ (wa) glyph as a bare
    // "w" in the gow- cluster ("agowtiha" for ᎠᎪᏩᏘᎭ), but SyllabaryUtil parses
    // Ꮹ as "wa", so tsalagiToSyllabary("agowtiha") emits "not a valid letter".
    // Insert the elided vowel: ow + consonant -> owa + consonant ("gowtiha" ->
    // "gowatiha"). Scoped to ow+consonant, which in the verb-book data only occurs
    // in the "to see" stem; sequences like "aws" (phonetic wvs, ᏮᏍ) must not match.
    private static String normalizeBookRomanization(String latin) {
        return latin?.replaceAll("ow(?=[bcdfghjklmnprstz])", "owa")
                     .replaceAll("hl(?=[bcdfghjklmnprstz'])", "lo")
    }

    /**
     * tio 13Nov26: Engine assertions against the book syllabary must be
     * cleaned of romanization artifacts (apostrophes, non-standard punctuation)
     * to match the engine's pure Syllabary output.
     */
    static String cleanForAssertion(String input) {
        if (!input) return ""
        return SyllabaryUtil.cleanTsalagi(input)
    }


    static String getEngineSyllabary(String verbName, String tense, String english, List<Map> conjugations) {
        return VerbBookEngineHarness.getEngineSyllabary(verbName, tense, english, [conjugations: conjugations])
    }

     static def conjugateVerb(String verbName, Map details, String subj, String obj, String tense, String expected) {
        def conjugations = details.conjugations ?: []
        def thirdPersonRow = conjugations.find { it.subject == "SG3" }
        def firstPersonRow = conjugations.find { it.subject == "SG1" }

        // tio 12Nov26: some verb-book forms carry an orientation initial prefix
        // (e.g. "to be somewhere" immediate past rows all print wi- Ꮻ). Specs can
        // declare it lexically via details.initialPrefixes so the engine composes
        // the same surface. Only wi- is mapped until another prefix is needed.
        def initialPrefixes = details.initialPrefixes ?: [:]

        // tio 13Nov26: distributive verbs ("to fall" — the book prints de- on
        // every non-singular-subject row of every tense table) drive the de-
        // initial prefix lexically: fixtures declare distributive: true and the
        // engine's PrefixDe supplies the Ꮥ/Ꮧ/Ꮩ allomorphy. Singular-subject rows
        // never take de-.
        def pluralSubject = subj in ["DL1INCL", "DL1EXCL", "PL1INCL", "PL1EXCL", "DL2", "PL2", "PL3"]
        def wantsDe = initialPrefixes.de || (details.distributive && pluralSubject)

        // tio 12Nov26: VerbBookFixtures entries use the camelCase key
        // "partOfSpeech" while lexicon-style details use "part_of_speech".
        // Defaulting to "v.i." made ConjugationHelper force object=SG3IN for
        // every transitive verb, dropping all object prefixes (the ToSee rows
        // came back as the bare subject form). Accept both spellings.
        def partOfSpeech = details.get("part_of_speech", details.get("partOfSpeech", "v.i."))

        // tio 16Nov26: romanized (vrb/CED) citations convert through the CED
        // convention variant; wired fixtures already carry syllabary and use
        // the plain path. See DISCREPANCIES.md D9/D12.
        def toSyll = { String s ->
            if (!s) { return null }
            boolean hasGlyph = s.chars().any { it >= 0x13A0 && it <= 0x13F5 }
            return hasGlyph ?
                SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(s)) :
                SyllabaryUtil.tsalagiToSyllabaryCed(normalizeBookRomanization(s))
        }

        def request = new ConjugationRequest(
            subject: subj,
            object: obj,
            verbTense: tense,
            partOfSpeech: partOfSpeech,
            wi: initialPrefixes.wi ? "true" : null,
            de: wantsDe ? "true" : null,
            habitual: toSyll(thirdPersonRow?.habitual),
            imperative: toSyll(thirdPersonRow?.imperative),
            infinitive: toSyll(thirdPersonRow?.infinitive),
            present3rd: toSyll(thirdPersonRow?.present),
            remotepast: toSyll(thirdPersonRow?.remote_past),
            immediatepast: toSyll(thirdPersonRow?.immediate_past),
            present1st: toSyll(firstPersonRow?.present)
        )
        
        // Handle immediate past if present in the row
        if (thirdPersonRow?.immediate_past) {
            // Need to see where immediate_past goes in ConjugationRequest
            // It seems it's not mapped yet.
            // Let's print the fields if needed, or update the engine.
        }

        def facade = new VerbConjugationFacade()
        def verb = facade.conjugate(request)
        return verb.wholeWord
    }
}
