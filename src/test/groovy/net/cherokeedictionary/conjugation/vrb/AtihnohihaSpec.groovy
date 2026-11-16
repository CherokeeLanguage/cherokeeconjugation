package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtihnohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatihnohiha', habitual: 'jiyatihnohihoi', remote_past: 'jiyatihnohihlvi', imperative: 'jiyatihnoga', infinitive: 'jiyatihnohisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatihnohiha', habitual: 'hiyatihnohihoi', remote_past: 'hiyatihnohihlvi', imperative: 'hiyatihnoga', infinitive: 'hiyatihnohisdi'],
            [subject: 'SG3', object: '', present: 'atihnohiha', habitual: 'atihnohihoi', remote_past: 'utihnohihlvi', imperative: 'watihnoga', infinitive: 'utihnohisdi'],
            [subject: 'SG3', object: '', present: 'anatihnohiha', habitual: 'anatihnohihoi', remote_past: 'unatihnohihlvi', imperative: 'wanatihnoga', infinitive: 'unatihnohisdi']
        ]
    ]

    @Unroll
    def "conjugating Atihnohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atihnohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyatinohiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyatinohihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyatinohitlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyatinohitlvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyatinohisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatinohiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatinohihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "atinohitlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatinohitlvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "atinohisdi"
        "SG3" | "" | Tense.PRESENT         | "atinohiha"
        "SG3" | "" | Tense.HABITUAL        | "atinohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utinohitlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atinohitlvi"
        "SG3" | "" | Tense.INFINITIVE      | "utinohisdi"
        "SG3" | "" | Tense.PRESENT         | "atinohiha"
        "SG3" | "" | Tense.HABITUAL        | "atinohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utinohitlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atinohitlvi"
        "SG3" | "" | Tense.INFINITIVE      | "utinohisdi"
    }
}
