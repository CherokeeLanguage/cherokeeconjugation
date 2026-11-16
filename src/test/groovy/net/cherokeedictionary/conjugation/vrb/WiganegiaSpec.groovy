package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WiganegiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijinegia', habitual: 'wijinegisgoi', remote_past: 'waginegisvi', imperative: 'wijinegi', infinitive: 'waginegisdi'],
            [subject: 'SG2', object: '', present: 'hwinegia', habitual: 'hwinegisgoi', remote_past: 'wijanegisvi', imperative: 'hwinegi', infinitive: 'wijanegisdi'],
            [subject: 'SG3', object: '', present: 'wiganegia', habitual: 'wiganegisgoi', remote_past: 'wunegisvi', imperative: 'wiganegi', infinitive: 'wunegisdi'],
            [subject: 'SG3', object: '', present: 'waninegia', habitual: 'waninegisgoi', remote_past: 'wuninegisvi', imperative: 'waninegi', infinitive: 'wuninegisdi']
        ]
    ]

    @Unroll
    def "conjugating Wiganegia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wiganegia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "witsinegia"
        "SG3" | "" | Tense.HABITUAL        | "witsinegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginegisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginegisdi"
        "SG2" | "" | Tense.PRESENT         | "hitsinegia"
        "SG2" | "" | Tense.HABITUAL        | "hitsinegisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawaginegisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwaginegisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaginegisdi"
        "SG3" | "" | Tense.PRESENT         | "witsinegia"
        "SG3" | "" | Tense.HABITUAL        | "witsinegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginegisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginegisdi"
        "SG3" | "" | Tense.PRESENT         | "witsinegia"
        "SG3" | "" | Tense.HABITUAL        | "witsinegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaginegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawaginegisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uginegisdi"
    }
}
