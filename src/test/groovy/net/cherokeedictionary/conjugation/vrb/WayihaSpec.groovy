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
        "SG3" | "" | Tense.PRESENT         | "wijiyia"
        "SG3" | "" | Tense.HABITUAL        | "wijiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijiya"
        "SG3" | "" | Tense.INFINITIVE      | "wagiyhdi"
        "SG2" | "" | Tense.PRESENT         | "hwiyiha"
        "SG2" | "" | Tense.HABITUAL        | "hwiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijayvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwiya"
        "SG2" | "" | Tense.INFINITIVE      | "wijayhdi"
        "SG3" | "" | Tense.PRESENT         | "wayiha"
        "SG3" | "" | Tense.HABITUAL        | "wayisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waya"
        "SG3" | "" | Tense.INFINITIVE      | "wuyhdi"
        "SG3" | "" | Tense.PRESENT         | "waniyiha"
        "SG3" | "" | Tense.HABITUAL        | "waniyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuniyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waniya"
        "SG3" | "" | Tense.INFINITIVE      | "wuniyhdi"
    }
}
