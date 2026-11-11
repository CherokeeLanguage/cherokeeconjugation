package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WiganehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijinevsga', habitual: 'wijinevsgoi', remote_past: 'waginehnvi', imperative: 'wijinevga', infinitive: 'waginehdi'],
            [subject: 'SG2', object: '', present: 'hwinehvsga', habitual: 'hwinehvsgoi', remote_past: 'wijanehnvi', imperative: 'hwinehvga', infinitive: 'wijanehdi'],
            [subject: 'SG3', object: '', present: 'wiganehvsga', habitual: 'wiganehvsgoi', remote_past: 'wunehnvi', imperative: 'wiganehvga', infinitive: 'wunehdi'],
            [subject: 'SG3', object: '', present: 'waninehvsga', habitual: 'waninehvsgoi', remote_past: 'wuninehnvi', imperative: 'waninehvga', infinitive: 'wunihehdi']
        ]
    ]

    @Unroll
    def "conjugating Wiganehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wiganehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijinevsga"
        "SG3" | "" | Tense.HABITUAL        | "wijinevsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "waginehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijinevga"
        "SG3" | "" | Tense.INFINITIVE      | "waginehdi"
        "SG2" | "" | Tense.PRESENT         | "hwinehvsga"
        "SG2" | "" | Tense.HABITUAL        | "hwinehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijanehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinehvga"
        "SG2" | "" | Tense.INFINITIVE      | "wijanehdi"
        "SG3" | "" | Tense.PRESENT         | "wiganehvsga"
        "SG3" | "" | Tense.HABITUAL        | "wiganehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wiganehvga"
        "SG3" | "" | Tense.INFINITIVE      | "wunehdi"
        "SG3" | "" | Tense.PRESENT         | "waninehvsga"
        "SG3" | "" | Tense.HABITUAL        | "waninehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuninehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waninehvga"
        "SG3" | "" | Tense.INFINITIVE      | "wunihehdi"
    }
}
