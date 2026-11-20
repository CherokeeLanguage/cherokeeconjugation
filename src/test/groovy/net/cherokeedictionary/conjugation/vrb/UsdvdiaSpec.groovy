// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73930 (entrya usdvdia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UsdvdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Being Punished",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aksdvdia'],
            [subject: 'SG1', object: '', present: 'aksdvdia', habitual: 'aksdvdisgoi', remote_past: 'aksdvdvi', imperative: 'aksdvda', infinitive: 'aksdvdisdi'],
            [subject: 'SG2', object: '', present: 'tsdvdia', habitual: 'tsdvdisgoi', remote_past: 'tsdvdvi', imperative: 'tsdvda', infinitive: 'tsdvdisdi'],
            [subject: 'SG3', object: '', habitual: 'usdvdisgoi', imperative: 'tsdvda', infinitive: 'usdvdisdi', present: 'usdvdia', remote_past: 'usdvdvi'],
            [subject: 'PL3', object: '', present: 'unisdvdia', habitual: 'unisdvdisgoi', remote_past: 'unisdvdvi', imperative: 'unisdvda', infinitive: 'unisdvdisdi'],
            [subject: 'PL1INCL', object: '', present: 'igisdvdia', habitual: 'igisdvdisgoi', remote_past: 'igisdvdvi', imperative: 'igisdvda', infinitive: 'igisdvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Usdvdia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Usdvdia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aksdvdia"
        "SG1" | "" | Tense.HABITUAL        | "aksdvdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksdvdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agisdvdvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksdvdisdi"
        "SG2" | "" | Tense.PRESENT         | "tsdvdia"
        "SG2" | "" | Tense.HABITUAL        | "tsdvdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdvdvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsasdvdvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdvdisdi"
        "SG3" | "" | Tense.PRESENT         | "usdvdia"
        "SG3" | "" | Tense.HABITUAL        | "usdvdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdvdvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usdvdvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdvdisdi"
        "PL3" | "" | Tense.PRESENT         | "unisdvdia"
        "PL3" | "" | Tense.HABITUAL        | "unisdvdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdvdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unisdvdvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisdvdisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igisdvdia"
        "PL1INCL" | "" | Tense.HABITUAL        | "igisdvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisdvdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igisdvdvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisdvdisdi"
    }
}
