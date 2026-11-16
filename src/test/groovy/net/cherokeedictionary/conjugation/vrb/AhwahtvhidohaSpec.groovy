// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72396 (entrya ahwahtvhidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwahtvhidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Visiting (Him/Her)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwahtvhidoha'],
            [subject: 'SG1', object: '', present: 'jiwahtvhidoha', habitual: 'jiwahtvhidohoi', remote_past: 'jiwahtvhidolvi', imperative: 'jiwahtvhida', infinitive: 'jiwahtvhidasdi'],
            [subject: 'SG2', object: '', present: 'hihwahtvhidoha', habitual: 'hihwahtvhidohoi', remote_past: 'hihwahtvhidolvi', imperative: 'hiwahtvhida', infinitive: 'hihwahtvhidasdi'],
            [subject: 'SG3', object: '', habitual: 'ahwahtvhidohoi', imperative: 'hiwahtvhida', infinitive: 'uhwahtvhidasdi', present: 'ahwahtvhidoha', remote_past: 'uhwahtvhidolvi'],
            [subject: 'PL3', object: '', present: 'anihwahtvhidoha', habitual: 'anihwahtvhidohoi', remote_past: 'unihwahtvhidolvi', imperative: 'aniwahtvhida', infinitive: 'unihwahtvhidasdi'],
            [subject: 'PL1INCL', object: '', present: 'edihwahtvhidoha', habitual: 'edihwahtvhidohoi', remote_past: 'edihwahtvhidolvi', imperative: 'ediwahtvhida', infinitive: 'edihwahtvhidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwahtvhidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwahtvhidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwadvhidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsiwadvhidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwadvhidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwadvhidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwadvhidasdi"
        "SG2" | "" | Tense.PRESENT         | "hiwadvhidoha"
        "SG2" | "" | Tense.HABITUAL        | "hiwadvhidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawadvhidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwadvhidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawadvhidasdi"
        "SG3" | "" | Tense.PRESENT         | "awadvhidoha"
        "SG3" | "" | Tense.HABITUAL        | "awadvhidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadvhidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awadvhidolvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwadvhidasdi"
        "PL3" | "" | Tense.PRESENT         | "aniwadvhidoha"
        "PL3" | "" | Tense.HABITUAL        | "aniwadvhidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwadvhidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwadvhidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwadvhidasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwadvhidoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwadvhidohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwadvhidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwadvhidolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwadvhidasdi"
    }
}
