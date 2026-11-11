package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Specification

abstract class VerbBaseSpec extends Specification {

    protected static def conjugateVerb(String verbName, Map details, String subj, String obj, String tense, String expected) {
        def stemmer = new Stemmer()
        // Here we build the stemmer based on the provided details for the specific verb
        def conjugations = details.conjugations ?: []
        def thirdPersonRow = conjugations.find { it.subject == "SG3" }

        if (thirdPersonRow) {
            if (thirdPersonRow.habitual) stemmer.habitual = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.habitual))
            if (thirdPersonRow.imperative) stemmer.imperative = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.imperative))
            if (thirdPersonRow.infinitive) stemmer.infinitive = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.infinitive))
            if (thirdPersonRow.present) stemmer.present3rd = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.present))
            if (thirdPersonRow.remote_past) stemmer.remotepast = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(thirdPersonRow.remote_past))

            def firstPersonRow = conjugations.find { it.subject == "SG1" }
            if (firstPersonRow && firstPersonRow.present) {
                stemmer.present1st = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(firstPersonRow.present))
            }
        }

        def verbRes = Conjugate.conjugate(subj, obj, stemmer, tense, details.get("part_of_speech", "v.i."), false)
        return verbRes.wholeWord
    }
}
