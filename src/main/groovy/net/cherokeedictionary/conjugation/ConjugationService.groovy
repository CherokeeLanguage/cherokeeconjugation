package net.cherokeedictionary.conjugation

import net.cherokeedictionary.proposed.ConjugationRequest
import net.cherokeedictionary.proposed.VerbConjugationFacade

class ConjugationService {

    /**
     * Conjugate a verb using the engine.
     * Takes the stems and relies on the engine's stemmer logic.
     */
    static String conjugate(String subject, String object, String verbTense, String partOfSpeech, Map stems) {
        def request = new ConjugationRequest(
            subject: subject,
            object: object,
            verbTense: verbTense,
            partOfSpeech: partOfSpeech,
            present3rd: stems.present3rd,
            present1st: stems.present1st,
            remotepast: stems.remotepast,
            immediatepast: stems.immediatepast,
            habitual: stems.habitual,
            imperative: stems.imperative,
            infinitive: stems.infinitive
        )

        def facade = new VerbConjugationFacade()
        def verb = facade.conjugate(request)
        return verb?.wholeWord ?: "Conjugation failed"
    }

    /**
     * Breakdown/Deconstruct a conjugated string.
     * Uses the VerbLexicon to find matching entries by syllabary.
     */
    static List<Map> analyze(String inputSyllabary) {
        return VerbLexicon.findMatches(inputSyllabary)
    }
}
