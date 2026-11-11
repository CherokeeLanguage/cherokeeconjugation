package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Validates the new compositional object-de- trigger (plural objects).
 * Data sourced from Grammar Guide "hit" paradigm.
 */
class PluralObjectSpec extends Specification {

    static Stemmer makeHitStemmer() {
        def stemmer = new Stemmer()
        // Gvhniha (Hitting Him/It)
        stemmer.present3rd = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("gvhniha"))
        stemmer.present1st = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("jiyvniha"))
        stemmer.habitual   = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("gvhnihoi"))
        stemmer.remotepast = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("uwahnihlvvi"))
        stemmer.imperative = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("gvnhga"))
        stemmer.infinitive = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("uwansdi"))
        return stemmer
    }

    @Unroll
    def "conjugating hit for #subj x #obj in #tense should be #expectedLatin"() {
        given: "A stemmer for hit and trigger-enabled object"
        def stemmer = makeHitStemmer()

        when: "We conjugate"
        def verb = Conjugate.conjugate(subj, obj, stemmer, tense.toString(), "v.t.", false)
        def actualSyllabary = verb.wholeWord ?: verb.pronounReflexiveRoot
        def expectedSyllabary = SyllabaryUtil.tsalagiToSyllabary(expectedLatin)

        then: "Print trace for debugging"
        println "--- TRACE for ${subj}/${obj}/${tense} ---"
        println "Actual Syllabary: ${actualSyllabary}"
        println "Trace:\n${verb.getTraceReport()}"
        println "-----------------------"

        actualSyllabary == expectedSyllabary

        where:
        subj  | obj    | tense             || expectedLatin
        // Attested guide surfaces:
        "PL3" | "PL3AN"| Tense.PRESENT     || "danvhniha"
        "PL3" | "PL3IN"| Tense.PRESENT     || "danvhniha"
        "PL3" | "PL3IN"| Tense.REMOTE_PAST || "dunvhnihlvvi"
    }
}
