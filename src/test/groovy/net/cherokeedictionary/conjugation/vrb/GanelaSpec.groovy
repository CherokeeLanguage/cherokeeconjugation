package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanelaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Living At",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinela', habitual: 'jineloi', remote_past: 'X', imperative: 'jinelesdi', infinitive: 'X']
        ]
    ]

    @Unroll
    def "conjugating Ganela (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganela", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinela"
        "SG1" | "" | Tense.HABITUAL        | "jineloi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "X"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinelesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
    }
}
