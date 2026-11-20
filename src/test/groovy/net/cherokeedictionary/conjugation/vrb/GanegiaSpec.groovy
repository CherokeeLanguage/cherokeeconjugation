// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73106 (entrya ganegia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jinegia'],
            [subject: 'SG1', object: '', present: 'jinegia', habitual: 'jinegisgoi', remote_past: 'aginegisvi', imperative: 'jinegi', infinitive: 'aginegisdi'],
            [subject: 'SG2', object: '', present: 'hinegia', habitual: 'hinegisgoi', remote_past: 'janegisvi', imperative: 'hwinegi', infinitive: 'janegisdi'],
            [subject: 'SG3', object: '', habitual: 'ganegisgoi', imperative: 'hinegi', infinitive: 'unegisdi', present: 'ganegia', remote_past: 'unegisvi'],
            [subject: 'PL3', object: '', present: 'aninegia', habitual: 'aninegisgoi', remote_past: 'uningegisvi', imperative: 'waninegi', infinitive: 'uninegisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganegia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganegia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinegia"
        "SG1" | "" | Tense.HABITUAL        | "jinegisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginegisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinegisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginegisdi"
        "SG2" | "" | Tense.PRESENT         | "hinegia"
        "SG2" | "" | Tense.HABITUAL        | "hinegisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janegisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinegisvi"
        "SG2" | "" | Tense.INFINITIVE      | "janegisdi"
        "SG1" | "" | Tense.PRESENT         | "jinegia"
        "SG1" | "" | Tense.HABITUAL        | "jinegisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginegisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinegisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginegisdi"
        "PL3" | "" | Tense.PRESENT         | "aninegia"
        "PL3" | "" | Tense.HABITUAL        | "aninegisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uningegisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninegisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninegisdi"
    }
}
