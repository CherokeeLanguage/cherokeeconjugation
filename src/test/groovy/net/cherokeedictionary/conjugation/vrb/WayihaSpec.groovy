package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WayihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijiyia', habitual: 'wijiyisgoi', remote_past: 'wagiyvhvi', imperative: 'wijiya', infinitive: 'wagiyhdi'],
            [subject: 'SG2', object: '', present: 'hwiyiha', habitual: 'hwiyisgoi', remote_past: 'wijayvhvi', imperative: 'hwiya', infinitive: 'wijayhdi'],
            [subject: 'SG3', object: '', present: 'wayiha', habitual: 'wayisgoi', remote_past: 'wuyvhvi', imperative: 'waya', infinitive: 'wuyhdi'],
            [subject: 'SG3', object: '', present: 'waniyiha', habitual: 'waniyisgoi', remote_past: 'wuniyvhvi', imperative: 'waniya', infinitive: 'wuniyhdi']
        ]
    ]

    @Unroll
    def "conjugating Wayiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wayiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "witsiyia"
        "SG3" | "" | Tense.HABITUAL        | "witsiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "wagiyhdi"
        "SG2" | "" | Tense.PRESENT         | "hitsiyia"
        "SG2" | "" | Tense.HABITUAL        | "hitsiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawagiyvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwagiyvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "wijayhdi"
        "SG3" | "" | Tense.PRESENT         | "witsiyia"
        "SG3" | "" | Tense.HABITUAL        | "witsiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuyhdi"
        "SG3" | "" | Tense.PRESENT         | "witsiyia"
        "SG3" | "" | Tense.HABITUAL        | "witsiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuniyhdi"
    }
}
