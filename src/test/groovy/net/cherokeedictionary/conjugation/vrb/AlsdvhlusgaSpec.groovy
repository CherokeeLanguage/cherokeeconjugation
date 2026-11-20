// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72525 (entrya alsdvhlusga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsdvhlusgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Taking a Seat",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisdvhlusga'],
            [subject: 'SG1', object: '', present: 'galisdvhlusga', habitual: 'galisdvhlusgoi', remote_past: 'agwalsdvhlunvi', imperative: 'galisdvhluga', infinitive: 'agwalsdvhlusdi'],
            [subject: 'SG2', object: '', present: 'halsdvhlusga', habitual: 'halsdvhlusgoi', remote_past: 'jalsdvhlunvi', imperative: 'halsdvhluga', infinitive: 'jalsdvhlusdi'],
            [subject: 'SG3', object: '', habitual: 'alsdvhlusgoi', imperative: 'halsdvhluga', infinitive: 'ulsdvhlusdi', present: 'alsdvhlusga', remote_past: 'ulsdvhlunvi'],
            [subject: 'PL3', object: '', present: 'analsdvhlusga', habitual: 'analsdvhlusgoi', remote_past: 'unalsdvhlunvi', imperative: 'analsdvhluga', infinitive: 'unalsdvhlusdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsdvhlusga', habitual: 'idalsdvhlusgoi', remote_past: 'igalsdvhlunvi', imperative: 'idalsdvhluga', infinitive: 'igalsdvhlusdi']
        ]
    ]

    @Unroll
    def "conjugating Alsdvhlusga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsdvhlusga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisdvhlusga"
        "SG1" | "" | Tense.HABITUAL        | "galisdvhlusgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsdvhlunvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisdvtlunvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsdvhlusdi"
        "SG2" | "" | Tense.PRESENT         | "halsdvhlusga"
        "SG2" | "" | Tense.HABITUAL        | "halsdvhlusgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsdvhlunvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halisdvtlunvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalsdvhlusdi"
        "SG3" | "" | Tense.PRESENT         | "alsdvhlusga"
        "SG3" | "" | Tense.HABITUAL        | "alsdvhlusgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsdvhlunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisdvtlunvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulsdvhlusdi"
        "PL3" | "" | Tense.PRESENT         | "analsdvhlusga"
        "PL3" | "" | Tense.HABITUAL        | "analsdvhlusgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsdvhlunvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analisdvtlunvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalsdvhlusdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsdvhlusga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsdvhlusgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsdvhlunvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalisdvtlunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsdvhlusdi"
    }
}
