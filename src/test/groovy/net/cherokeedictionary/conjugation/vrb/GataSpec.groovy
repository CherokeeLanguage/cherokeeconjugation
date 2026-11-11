package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GataSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Hanging",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gata', habitual: 'gatoi', remote_past: 'gatvi', imperative: 'gatesdi', infinitive: 'It']
        ]
    ]

    @Unroll
    def "conjugating Gata (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gata", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gata"
        "SG1" | "" | Tense.HABITUAL        | "gatoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "gatvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatesdi"
        "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
