// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73178 (entrya gasadosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GasadosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Pushing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyasadosga, jisadosga'],
            [subject: 'SG3', object: '', habitual: 'gasadosgoi', imperative: 'hiyasadohya, hisadohya', infinitive: 'uwasadosdi', present: 'gasadosga', remote_past: 'uwasadohyvi'],
            [subject: 'PL3', object: '', present: 'anisadosga', habitual: 'anisadosgoi', remote_past: 'unsadohyvi', imperative: 'anisadohya', infinitive: 'unsadosdi'],
            [subject: 'PL1INCL', object: '', present: 'idisadosga', habitual: 'idisadosgoi', remote_past: 'iksadohyvi', imperative: 'idisadohya', infinitive: 'iksadosdi']
        ]
    ]

    @Unroll
    def "conjugating Gasadosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gasadosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisadosga"
        "SG1" | "" | Tense.HABITUAL        | "tsisadosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwasadoyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwasadoyvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwasadosdi"
        "PL3" | "" | Tense.PRESENT         | "anisadosga"
        "PL3" | "" | Tense.HABITUAL        | "anisadosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwasadoyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwasadoyvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwasadosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisadosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisadosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwasadoyvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwasadoyvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwasadosdi"
    }
}
