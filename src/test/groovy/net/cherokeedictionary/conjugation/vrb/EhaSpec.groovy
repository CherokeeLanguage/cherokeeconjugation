package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class EhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lives (Resides)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gea', habitual: 'geoi', remote_past: 'x', imperative: 'gehesdi', infinitive: 'x']
        ]
    ]

    @Unroll
    def "conjugating Eha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Eha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gea"
        "SG1" | "" | Tense.HABITUAL        | "geoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "x"
    }
}
