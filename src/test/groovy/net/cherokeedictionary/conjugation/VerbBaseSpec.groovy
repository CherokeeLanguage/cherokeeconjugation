package net.cherokeedictionary.conjugation

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

        // tio 12Nov26: VerbBookFixtures entries use the camelCase key
        // "partOfSpeech" while lexicon-style details use "part_of_speech".
        // Defaulting to "v.i." made ConjugationHelper force object=SG3IN for
        // every transitive verb, dropping all object prefixes (the ToSee rows
        // came back as the bare subject form). Accept both spellings.
        def partOfSpeech = details.get("part_of_speech", details.get("partOfSpeech", "v.i."))

        def request = new ConjugationRequest(
            subject: subj,
            object: obj,
            verbTense: tense,
            partOfSpeech: partOfSpeech,
            wi: initialPrefixes.wi ? "true" : null,
            habitual: thirdPersonRow?.habitual ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.habitual)) : null,
            imperative: thirdPersonRow?.imperative ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.imperative)) : null,
            infinitive: thirdPersonRow?.infinitive ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.infinitive)) : null,
            present3rd: thirdPersonRow?.present ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.present)) : null,
            remotepast: thirdPersonRow?.remote_past ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.remote_past)) : null,
            immediatepast: thirdPersonRow?.immediate_past ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(thirdPersonRow.immediate_past)) : null,
            present1st: firstPersonRow?.present ? SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(firstPersonRow.present)) : null
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
