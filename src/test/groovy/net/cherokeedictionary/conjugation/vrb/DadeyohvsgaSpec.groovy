package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DadeyohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Teaching",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degadeyohvsga', habitual: 'degadeyohvsgoi', remote_past: 'dagwadeyohnvi', imperative: 'digadeyohvga', infinitive: 'digwadehyohdi'],
            [subject: 'SG2', object: '', present: 'dehadeyohvsga', habitual: 'dehadeyohvsgoi', remote_past: 'dejadeyohnvi', imperative: 'tadeyohvga', infinitive: 'dijadehyohdi'],
            [subject: 'SG3', object: '', present: 'dadeyohvsga', habitual: 'dadeyohvsgoi', remote_past: 'dudeyohnvi', imperative: 'dideyohvga', infinitive: 'judehyohdi'],
            [subject: 'PL3', object: '', present: 'danadeyohvsga', habitual: 'danadeyohvsgoi', remote_past: 'dunadeyohnvi', imperative: 'dinadeyohvga', infinitive: 'junadehyohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadeyohvsga', habitual: 'dedadeyohvsgoi', remote_past: 'degadeyohnvi', imperative: 'didadeyohvga', infinitive: 'digadehyohdi']
        ]
    ]

    @Unroll
    def "conjugating Dadeyohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dadeyohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degadeyohvsga"
        "SG1" | "" | Tense.HABITUAL        | "degadeyohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwadeyohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digadeyohvga"
        "SG1" | "" | Tense.INFINITIVE      | "digwadehyohdi"
        "SG2" | "" | Tense.PRESENT         | "dehadeyohvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehadeyohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejadeyohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tadeyohvga"
        "SG2" | "" | Tense.INFINITIVE      | "dijadehyohdi"
        "SG3" | "" | Tense.PRESENT         | "dadeyohvsga"
        "SG3" | "" | Tense.HABITUAL        | "dadeyohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dudeyohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dideyohvga"
        "SG3" | "" | Tense.INFINITIVE      | "judehyohdi"
        "PL3" | "" | Tense.PRESENT         | "danadeyohvsga"
        "PL3" | "" | Tense.HABITUAL        | "danadeyohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunadeyohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinadeyohvga"
        "PL3" | "" | Tense.INFINITIVE      | "junadehyohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedadeyohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedadeyohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degadeyohnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didadeyohvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digadehyohdi"
    }
}
