package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaligaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Burning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galiga', habitual: 'galigoi', remote_past: 'ulijvi', imperative: 'dagaliji', infinitive: 'It']
        ]
    ]

    @Unroll
    def "conjugating Galiga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galiga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galiga"
        "SG1" | "" | Tense.HABITUAL        | "galigoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ulijvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dagaliji"
        "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
