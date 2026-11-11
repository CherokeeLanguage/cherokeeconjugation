package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Walking",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gai', habitual: 'gaisoi', remote_past: 'gaisvi', imperative: 'X', infinitive: 'X']
        ]
    ]

    @Unroll
    def "conjugating Ai (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ai", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gai"
        "SG1" | "" | Tense.HABITUAL        | "gaisoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "gaisvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "X"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
    }
}
