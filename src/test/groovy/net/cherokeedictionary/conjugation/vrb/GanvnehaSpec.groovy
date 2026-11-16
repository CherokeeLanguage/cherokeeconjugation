// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73173 (entrya ganvneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvneha'],
            [subject: 'SG1', object: '', present: 'jinvneha', habitual: 'jinvnehoi', remote_past: 'jinvnelvi', imperative: 'jinvvsi', infinitive: 'jinvnehdi'],
            [subject: 'SG2', object: '', present: 'hinvneha', habitual: 'hinvnehoi', remote_past: 'hinvnelv', imperative: 'hinvvsi', infinitive: 'hinvnehdi'],
            [subject: 'SG3', object: '', habitual: 'ganvnehoi', imperative: 'hinvsi', infinitive: 'unvnehdi', present: 'ganvneha', remote_past: 'unvnelvi'],
            [subject: 'PL3', object: '', present: 'aninvneha', habitual: 'aninvnehoi', remote_past: 'uninvnelv', imperative: 'waninvvsi', infinitive: 'uninvnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinvneha"
        "SG1" | "" | Tense.HABITUAL        | "tsinvnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvnelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvnedi"
        "SG2" | "" | Tense.PRESENT         | "hinvneha"
        "SG2" | "" | Tense.HABITUAL        | "hinvnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanvnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvnelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanvnedi"
        "SG1" | "" | Tense.PRESENT         | "tsinvneha"
        "SG1" | "" | Tense.HABITUAL        | "tsinvnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvnelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvnedi"
        "PL3" | "" | Tense.PRESENT         | "aninvneha"
        "PL3" | "" | Tense.HABITUAL        | "aninvnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvnelvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvnedi"
    }
}
