package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WigakahvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (living)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijiyakahvsga', habitual: 'wijiyakahvsgoi', remote_past: 'wijiyakanvi', imperative: 'wijiyakahvga', infinitive: 'wijiyakohdi'],
            [subject: 'SG2', object: '', present: 'hwiyakahvsga', habitual: 'hwiyakahvsgoi', remote_past: 'hwiyakanvi', imperative: 'hwiyakahvga', infinitive: 'hwiyakohdi'],
            [subject: 'SG3', object: '', present: 'wigakahvsga', habitual: 'wigakahvsgoi', remote_past: 'wuwakanvi', imperative: 'wigakahvga', infinitive: 'wuwakohdi'],
            [subject: 'SG3', object: '', present: 'wanakahvsga', habitual: 'wanakahvsgoi', remote_past: 'wunakanvi', imperative: 'wanakahvga', infinitive: 'wunakohdi']
        ]
    ]

    @Unroll
    def "conjugating Wigakahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wigakahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijiyakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wijiyakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wijiyakanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijiyakahvga"
        "SG3" | "" | Tense.INFINITIVE      | "wijiyakohdi"
        "SG2" | "" | Tense.PRESENT         | "hwiyakahvsga"
        "SG2" | "" | Tense.HABITUAL        | "hwiyakahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hwiyakanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwiyakahvga"
        "SG2" | "" | Tense.INFINITIVE      | "hwiyakohdi"
        "SG3" | "" | Tense.PRESENT         | "wigakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wigakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuwakanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wigakahvga"
        "SG3" | "" | Tense.INFINITIVE      | "wuwakohdi"
        "SG3" | "" | Tense.PRESENT         | "wanakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wanakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunakanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanakahvga"
        "SG3" | "" | Tense.INFINITIVE      | "wunakohdi"
    }
}
