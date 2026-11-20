// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73161 (entrya ganvdia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Missing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvdia, jinvdia'],
            [subject: 'SG3', object: '', habitual: 'ganvdisgoi', imperative: 'hinvda, hinvda', infinitive: 'unvdisdi', present: 'ganvdia', remote_past: 'unvdvi'],
            [subject: 'PL3', object: '', present: 'aninvdia', habitual: 'aninvdisgoi', remote_past: 'uninvdvi', imperative: 'aninvda', infinitive: 'uninvdisdi'],
            [subject: 'PL1INCL', object: '', present: 'idinvdia', habitual: 'idinvdisgoi', remote_past: 'iginvdvi', imperative: 'idinvda', infinitive: 'iginvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvdia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvdia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvdia, jinvdia"
        "SG1" | "" | Tense.HABITUAL        | "tsinvdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvdvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvdisdi"
        "PL3" | "" | Tense.PRESENT         | "aninvdia"
        "PL3" | "" | Tense.HABITUAL        | "aninvdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvdvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvdisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvdia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvdvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvdisdi"
    }
}
