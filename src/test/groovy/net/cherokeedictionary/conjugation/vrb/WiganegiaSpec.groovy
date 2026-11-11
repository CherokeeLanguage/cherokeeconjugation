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
        "SG3" | "" | Tense.PRESENT         | "wijinegia"
        "SG3" | "" | Tense.HABITUAL        | "wijinegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "waginegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijinegi"
        "SG3" | "" | Tense.INFINITIVE      | "waginegisdi"
        "SG2" | "" | Tense.PRESENT         | "hwinegia"
        "SG2" | "" | Tense.HABITUAL        | "hwinegisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijanegisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinegi"
        "SG2" | "" | Tense.INFINITIVE      | "wijanegisdi"
        "SG3" | "" | Tense.PRESENT         | "wiganegia"
        "SG3" | "" | Tense.HABITUAL        | "wiganegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wiganegi"
        "SG3" | "" | Tense.INFINITIVE      | "wunegisdi"
        "SG3" | "" | Tense.PRESENT         | "waninegia"
        "SG3" | "" | Tense.HABITUAL        | "waninegisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuninegisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waninegi"
        "SG3" | "" | Tense.INFINITIVE      | "wuninegisdi"
    }
}
