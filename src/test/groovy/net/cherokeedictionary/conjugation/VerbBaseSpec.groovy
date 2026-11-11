package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Specification

abstract class VerbBaseSpec extends Specification {

    protected static def conjugateVerb(String verbName, Map details, String subj, String obj, String tense, String expected) {
        def conjugations = details.conjugations ?: []
        def thirdPersonRow = conjugations.find { it.subject == "SG3" }
        def firstPersonRow = conjugations.find { it.subject == "SG1" }

        def request = new net.cherokeedictionary.proposed.ConjugationRequest(
            subject: subj,
            object: obj,
            verbTense: tense,
            partOfSpeech: details.get("part_of_speech", "v.i."),
            habitual: thirdPersonRow?.habitual ? SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.habitual) : null,
            imperative: thirdPersonRow?.imperative ? SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.imperative) : null,
            infinitive: thirdPersonRow?.infinitive ? SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.infinitive) : null,
            present3rd: thirdPersonRow?.present ? SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.present) : null,
            remotepast: thirdPersonRow?.remote_past ? SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.remote_past) : null,
            present1st: firstPersonRow?.present ? SyllabaryUtil.tsalagiToSyllabary(firstPersonRow.present) : null
        )

        def facade = new net.cherokeedictionary.proposed.VerbConjugationFacade()
        def verb = facade.conjugate(request)
        return verb.wholeWord
    }
}
