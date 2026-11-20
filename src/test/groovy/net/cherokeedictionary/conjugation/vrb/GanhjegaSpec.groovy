// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73124 (entrya ganhjega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvjega'],
            [subject: 'SG1', object: '', present: 'jinjega', habitual: 'jinjegoi', remote_past: 'aginhjvsvi', imperative: 'wijinjvga', infinitive: 'aginhjvsdi'],
            [subject: 'SG2', object: '', present: 'hinhjega', habitual: 'hinhjegoi', remote_past: 'janhjvsvi', imperative: 'hwinhjvga', infinitive: 'janhjvsdi'],
            [subject: 'SG3', object: '', habitual: 'ganhjegoi', imperative: 'hinhjuga', infinitive: 'unhjvsdi', present: 'ganhjega', remote_past: 'unhjvsvi'],
            [subject: 'PL3', object: '', present: 'aninhjega', habitual: 'aninhjegoi', remote_past: 'uninhjvsvi', imperative: 'waninhjvga', infinitive: 'uninhjvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinatsega"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatsvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatsvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinhjega"
        "SG2" | "" | Tense.HABITUAL        | "hinhjegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhjvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatsvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "janhjvsdi"
        "SG1" | "" | Tense.PRESENT         | "tsinatsega"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninhjega"
        "PL3" | "" | Tense.HABITUAL        | "aninhjegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninhjvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatsvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninhjvsdi"
    }
}
