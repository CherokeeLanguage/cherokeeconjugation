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
            [subject: 'SG1', object: '', present: 'jinvneha', habitual: 'jinvnehoi', remote_past: 'jinvnelvi', imperative: 'jinvvsi', infinitive: 'jinvnehdi'],
            [subject: 'SG2', object: '', present: 'hinvneha', habitual: 'hinvnehoi', remote_past: 'hinvnelv', imperative: 'hinvvsi', infinitive: 'hinvnehdi'],
            [subject: 'SG1', object: '', present: 'ganvneha', habitual: 'ganvnehoi', remote_past: 'unvnelvi', imperative: 'wiganvvsi', infinitive: 'unvnehdi'],
            [subject: 'PL3', object: '', present: 'aninvneha', habitual: 'aninvnehoi', remote_past: 'uninvnelv', imperative: 'waninvvsi', infinitive: 'uninvnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvneha"
        "SG1" | "" | Tense.HABITUAL        | "jinvnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinvnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvvsi"
        "SG1" | "" | Tense.INFINITIVE      | "jinvnehdi"
        "SG2" | "" | Tense.PRESENT         | "hinvneha"
        "SG2" | "" | Tense.HABITUAL        | "hinvnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinvnelv"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvvsi"
        "SG2" | "" | Tense.INFINITIVE      | "hinvnehdi"
        "SG1" | "" | Tense.PRESENT         | "ganvneha"
        "SG1" | "" | Tense.HABITUAL        | "ganvnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unvnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganvvsi"
        "SG1" | "" | Tense.INFINITIVE      | "unvnehdi"
        "PL3" | "" | Tense.PRESENT         | "aninvneha"
        "PL3" | "" | Tense.HABITUAL        | "aninvnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvnelv"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninvvsi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvnehdi"
    }
}
