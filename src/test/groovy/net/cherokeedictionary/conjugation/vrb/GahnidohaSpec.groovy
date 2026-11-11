package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinidoha', habitual: 'jinidohoi', remote_past: 'akinidolvi', imperative: 'jinida', infinitive: 'akinidasdi'],
            [subject: 'SG2', object: '', present: 'hihnidoha', habitual: 'hihnidohoi', remote_past: 'jahnidolvi', imperative: 'hihnida', infinitive: 'jahnidasdi'],
            [subject: 'SG1', object: '', present: 'gahnidoha', habitual: 'gahnidohoi', remote_past: 'uhnidolvi', imperative: 'gahnida', infinitive: 'uhnidasdi'],
            [subject: 'PL3', object: '', present: 'anihnidoha', habitual: 'anihnidohoi', remote_past: 'unihnidolvi', imperative: 'anihnida', infinitive: 'unihnidasdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinidoha"
        "SG1" | "" | Tense.HABITUAL        | "jinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinida"
        "SG1" | "" | Tense.INFINITIVE      | "akinidasdi"
        "SG2" | "" | Tense.PRESENT         | "hihnidoha"
        "SG2" | "" | Tense.HABITUAL        | "hihnidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnida"
        "SG2" | "" | Tense.INFINITIVE      | "jahnidasdi"
        "SG1" | "" | Tense.PRESENT         | "gahnidoha"
        "SG1" | "" | Tense.HABITUAL        | "gahnidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhnidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gahnida"
        "SG1" | "" | Tense.INFINITIVE      | "uhnidasdi"
        "PL3" | "" | Tense.PRESENT         | "anihnidoha"
        "PL3" | "" | Tense.HABITUAL        | "anihnidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihnida"
        "PL3" | "" | Tense.INFINITIVE      | "unihnidasdi"
    }
}
