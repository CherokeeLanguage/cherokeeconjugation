package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanegiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinegia', habitual: 'jinegisgoi', remote_past: 'aginegisvi', imperative: 'jinegi', infinitive: 'aginegisdi'],
            [subject: 'SG2', object: '', present: 'hinegia', habitual: 'hinegisgoi', remote_past: 'janegisvi', imperative: 'hwinegi', infinitive: 'janegisdi'],
            [subject: 'SG1', object: '', present: 'ganegia', habitual: 'ganegisgoi', remote_past: 'unegisvi', imperative: 'wiganegi', infinitive: 'unegisdi'],
            [subject: 'PL3', object: '', present: 'aninegia', habitual: 'aninegisgoi', remote_past: 'uningegisvi', imperative: 'waninegi', infinitive: 'uninegisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganegia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganegia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinegia"
        "SG1" | "" | Tense.HABITUAL        | "jinegisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginegisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinegi"
        "SG1" | "" | Tense.INFINITIVE      | "aginegisdi"
        "SG2" | "" | Tense.PRESENT         | "hinegia"
        "SG2" | "" | Tense.HABITUAL        | "hinegisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janegisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinegi"
        "SG2" | "" | Tense.INFINITIVE      | "janegisdi"
        "SG1" | "" | Tense.PRESENT         | "ganegia"
        "SG1" | "" | Tense.HABITUAL        | "ganegisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unegisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganegi"
        "SG1" | "" | Tense.INFINITIVE      | "unegisdi"
        "PL3" | "" | Tense.PRESENT         | "aninegia"
        "PL3" | "" | Tense.HABITUAL        | "aninegisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uningegisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninegi"
        "PL3" | "" | Tense.INFINITIVE      | "uninegisdi"
    }
}
