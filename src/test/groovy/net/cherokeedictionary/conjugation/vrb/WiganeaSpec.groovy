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
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "witsinea"
        "SG3" | "" | Tense.HABITUAL        | "witsinesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginesdi"
        "SG2" | "" | Tense.PRESENT         | "hitsinea"
        "SG2" | "" | Tense.HABITUAL        | "hitsinesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawaginesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwaginesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaginesdi"
        "SG3" | "" | Tense.PRESENT         | "witsinea"
        "SG3" | "" | Tense.HABITUAL        | "witsinesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginesdi"
        "SG3" | "" | Tense.PRESENT         | "witsinea"
        "SG3" | "" | Tense.HABITUAL        | "witsinesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginesdi"
    }
}
