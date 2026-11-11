package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvvsga', habitual: 'jinvvsgoi', remote_past: 'aginvnvi', imperative: 'jinvvga', infinitive: 'aginvdi'],
            [subject: 'SG2', object: '', present: 'hinvvsga', habitual: 'hinvvsgoi', remote_past: 'janvnvi', imperative: 'hinvvga', infinitive: 'janvdi'],
            [subject: 'SG1', object: '', present: 'ganvvsga', habitual: 'ganvvsgoi', remote_past: 'unvnvi', imperative: 'wiganvvga', infinitive: 'unvdi'],
            [subject: 'PL3', object: '', present: 'aninvvsga', habitual: 'aninvvsgoi', remote_past: 'uninvnvi', imperative: 'waninvvga', infinitive: 'uninvdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvvsga"
        "SG1" | "" | Tense.HABITUAL        | "jinvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvvga"
        "SG1" | "" | Tense.INFINITIVE      | "aginvdi"
        "SG2" | "" | Tense.PRESENT         | "hinvvsga"
        "SG2" | "" | Tense.HABITUAL        | "hinvvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvvga"
        "SG2" | "" | Tense.INFINITIVE      | "janvdi"
        "SG1" | "" | Tense.PRESENT         | "ganvvsga"
        "SG1" | "" | Tense.HABITUAL        | "ganvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganvvga"
        "SG1" | "" | Tense.INFINITIVE      | "unvdi"
        "PL3" | "" | Tense.PRESENT         | "aninvvsga"
        "PL3" | "" | Tense.HABITUAL        | "aninvvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninvvga"
        "PL3" | "" | Tense.INFINITIVE      | "uninvdi"
    }
}
