package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WiganeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijinea', habitual: 'wijinesgoi', remote_past: 'waginesvi', imperative: 'wijinagi', infinitive: 'waginesdi'],
            [subject: 'SG2', object: '', present: 'hwinea', habitual: 'hwinesgoi', remote_past: 'wijanesvi', imperative: 'hwinagi', infinitive: 'wijanesdi'],
            [subject: 'SG3', object: '', present: 'wiganea', habitual: 'wiganesgoi', remote_past: 'wunesvi', imperative: 'wiganagi', infinitive: 'wunesdi'],
            [subject: 'SG3', object: '', present: 'waninea', habitual: 'waninesgoi', remote_past: 'wuninesvi', imperative: 'waninagi', infinitive: 'wuninesdi']
        ]
    ]

    @Unroll
    def "conjugating Wiganea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wiganea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijinea"
        "SG3" | "" | Tense.HABITUAL        | "wijinesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "waginesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "waginesdi"
        "SG2" | "" | Tense.PRESENT         | "hwinea"
        "SG2" | "" | Tense.HABITUAL        | "hwinesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijanesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwaginesvi"
        "SG2" | "" | Tense.INFINITIVE      | "wijanesdi"
        "SG3" | "" | Tense.PRESENT         | "wiganea"
        "SG3" | "" | Tense.HABITUAL        | "wiganesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "wunesdi"
        "SG3" | "" | Tense.PRESENT         | "waninea"
        "SG3" | "" | Tense.HABITUAL        | "waninesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuninesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuninesdi"
    }
}
