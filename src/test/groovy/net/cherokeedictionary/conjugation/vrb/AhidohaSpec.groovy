package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiidoha', habitual: 'jiidohoi', remote_past: 'agihidolvi', imperative: 'jiida', infinitive: 'agihidasdi'],
            [subject: 'SG2', object: '', present: 'hihidoha', habitual: 'hihidohoi', remote_past: 'jahidolvi', imperative: 'hihida', infinitive: 'jahidasdi'],
            [subject: 'SG3', object: '', present: 'ahidoha', habitual: 'ahidohoi', remote_past: 'uhidolvi', imperative: 'ahida', infinitive: 'uhidasdi'],
            [subject: 'PL3', object: '', present: 'anihidoha', habitual: 'anihidohoi', remote_past: 'unihidolvi', imperative: 'anihida', infinitive: 'unihidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiidoha"
        "SG1" | "" | Tense.HABITUAL        | "jiidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiida"
        "SG1" | "" | Tense.INFINITIVE      | "agihidasdi"
        "SG2" | "" | Tense.PRESENT         | "hihidoha"
        "SG2" | "" | Tense.HABITUAL        | "hihidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihida"
        "SG2" | "" | Tense.INFINITIVE      | "jahidasdi"
        "SG3" | "" | Tense.PRESENT         | "ahidoha"
        "SG3" | "" | Tense.HABITUAL        | "ahidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahida"
        "SG3" | "" | Tense.INFINITIVE      | "uhidasdi"
        "PL3" | "" | Tense.PRESENT         | "anihidoha"
        "PL3" | "" | Tense.HABITUAL        | "anihidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihida"
        "PL3" | "" | Tense.INFINITIVE      | "unihidasdi"
    }
}
