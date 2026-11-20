// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74048 (entrya wiganvvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WiganvvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'wijinvvsga'],
            [subject: 'SG3', object: '', habitual: 'wiganvvsgoi', imperative: 'hwinvvga', infinitive: 'wunvdi', present: 'wiganvvsga', remote_past: 'wunvnvi'],
            [subject: 'SG2', object: '', present: 'hwinvvsga', habitual: 'hwinvvsgoi', remote_past: 'wijanvnvi', imperative: 'hwinvvga', infinitive: 'wijanvdi'],
            [subject: 'SG3', object: '', present: 'wiganvvsga', habitual: 'wiganvvsgoi', remote_past: 'wunvnvi', imperative: 'wiganvvga', infinitive: 'wunvdi'],
            [subject: 'SG3', object: '', present: 'waninvvsga', habitual: 'waninvvsgoi', remote_past: 'wuninvnvi', imperative: 'waninvvga', infinitive: 'wuninvdi']
        ]
    ]

    @Unroll
    def "conjugating Wiganvvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wiganvvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wiganvvsga"
        "SG3" | "" | Tense.HABITUAL        | "wiganvvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "wunvdi"
        "SG2" | "" | Tense.PRESENT         | "hwinvvsga"
        "SG2" | "" | Tense.HABITUAL        | "hwinvvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijanvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "wijanvdi"
        "SG3" | "" | Tense.PRESENT         | "wiganvvsga"
        "SG3" | "" | Tense.HABITUAL        | "wiganvvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "wunvdi"
        "SG3" | "" | Tense.PRESENT         | "waninvvsga"
        "SG3" | "" | Tense.HABITUAL        | "waninvvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuninvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuninvdi"
    }
}
