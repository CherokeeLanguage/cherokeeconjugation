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
            [subject: 'SG1', object: '', present: 'gasadosga', habitual: 'gasadosgoi', remote_past: 'uwasadohyvi', imperative: 'gasadohya', infinitive: 'uwasadosdi'],
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
        "SG1" | "" | Tense.PRESENT         | "gasadosga"
        "SG1" | "" | Tense.HABITUAL        | "gasadosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwasadohyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasadohya"
        "SG1" | "" | Tense.INFINITIVE      | "uwasadosdi"
        "PL3" | "" | Tense.PRESENT         | "anisadosga"
        "PL3" | "" | Tense.HABITUAL        | "anisadosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsadohyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisadohya"
        "PL3" | "" | Tense.INFINITIVE      | "unsadosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisadosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisadosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksadohyvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisadohya"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksadosdi"
    }
}
