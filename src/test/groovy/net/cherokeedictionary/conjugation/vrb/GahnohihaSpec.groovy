package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinohiha', habitual: 'jinohihoi', remote_past: 'agihnolvi', imperative: 'jinoga', infinitive: 'agihnohisdi'],
            [subject: 'SG2', object: '', present: 'hihnohiha', habitual: 'hihnohihoi', remote_past: 'jahnolvi', imperative: 'hihnoga', infinitive: 'jahnohisdi'],
            [subject: 'SG3', object: '', present: 'gahnohiha', habitual: 'gahnohihoi', remote_past: 'uhnolvi', imperative: 'wigahnoga', infinitive: 'uhnohisdi'],
            [subject: 'PL3', object: '', present: 'anihnohiha', habitual: 'anihnohihoi', remote_past: 'unihnolvi', imperative: 'wanihnoga', infinitive: 'unihnohisdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihnohisdi"
        "SG2" | "" | Tense.PRESENT         | "hihnohiha"
        "SG2" | "" | Tense.HABITUAL        | "hihnohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinolvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnohisdi"
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihnohisdi"
        "PL3" | "" | Tense.PRESENT         | "anihnohiha"
        "PL3" | "" | Tense.HABITUAL        | "anihnohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninolvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnohisdi"
    }
}
