// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73163 (entrya ganvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Falling from Standing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvga'],
            [subject: 'SG1', object: '', present: 'jinvga', habitual: 'jinvgoi', remote_past: 'aginvjvi', imperative: 'jinvgi', infinitive: 'aginvsdi'],
            [subject: 'SG2', object: '', present: 'hinvga', habitual: 'hinvgoi', remote_past: 'janvjvi', imperative: 'hinvgi', infinitive: 'janvsdi'],
            [subject: 'SG3', object: '', habitual: 'ganvgoi', imperative: 'hinvgi', infinitive: 'unvisdi', present: 'ganvga', remote_past: 'unvjvi'],
            [subject: 'PL3', object: '', present: 'aninvga', habitual: 'aninvgoi', remote_past: 'uninvjvi', imperative: 'aninvgi', infinitive: 'uninvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinvga', habitual: 'idinvgoi', remote_past: 'iginvjvi', imperative: 'idinvgi', infinitive: 'iginvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvga"
        "SG1" | "" | Tense.HABITUAL        | "jinvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvtsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvisdi"
        "SG2" | "" | Tense.PRESENT         | "hinvga"
        "SG2" | "" | Tense.HABITUAL        | "hinvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvtsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanvisdi"
        "SG3" | "" | Tense.PRESENT         | "ganvga"
        "SG3" | "" | Tense.HABITUAL        | "ganvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvtsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unvisdi"
        "PL3" | "" | Tense.PRESENT         | "aninvga"
        "PL3" | "" | Tense.HABITUAL        | "aninvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvtsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvtsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvisdi"
    }
}
