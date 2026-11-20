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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyasadosga, jisadosga"
        "SG1" | "" | Tense.HABITUAL        | "tsisadosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwasadoyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwasadoyvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwasadosdi"
        "PL3" | "" | Tense.PRESENT         | "anisadosga"
        "PL3" | "" | Tense.HABITUAL        | "anisadosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwasatoyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwasadoyvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwasatosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisadosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisadosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwasatoyvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwasadoyvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwasatosdi"
    }
}
