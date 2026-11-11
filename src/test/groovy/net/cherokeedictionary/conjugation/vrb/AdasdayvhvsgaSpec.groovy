package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdasdayvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cooking (Meal, Place)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadasdayvhvsga', habitual: 'gadasdayvhvsgoi', remote_past: 'agwadasdayvhnvi', imperative: 'gadasdayvhvga', infinitive: 'agwadasdayhdi'],
            [subject: 'SG2', object: '', present: 'hadasdayvhvsga', habitual: 'hadasdayvhvsgoi', remote_past: 'jadasdayvhnvi', imperative: 'hadasdayvhvga', infinitive: 'jadasdayhdi'],
            [subject: 'SG3', object: '', present: 'adasdayvhvsga', habitual: 'adasdayvhvsgoi', remote_past: 'udasdayvhnvi', imperative: 'adasdayvhvga', infinitive: 'udasdayhdi'],
            [subject: 'PL3', object: '', present: 'anadasdayvhvsga', habitual: 'anadasdayvhvsgoi', remote_past: 'unadasdayvhnvi', imperative: 'anadasdayvhvga', infinitive: 'unadasdayhdi'],
            [subject: 'PL1INCL', object: '', present: 'idadasdayvhvsga', habitual: 'idadasdayvhvsgoi', remote_past: 'igadasdayvhnvi', imperative: 'idadasdayvhvga', infinitive: 'igadasdayhdi']
        ]
    ]

    @Unroll
    def "conjugating Adasdayvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adasdayvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadasdayvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadasdayvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadasdayvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadasdayvhvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadasdayhdi"
        "SG2" | "" | Tense.PRESENT         | "hadasdayvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadasdayvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadasdayvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadasdayvhvga"
        "SG2" | "" | Tense.INFINITIVE      | "jadasdayhdi"
        "SG3" | "" | Tense.PRESENT         | "adasdayvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "adasdayvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udasdayvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adasdayvhvga"
        "SG3" | "" | Tense.INFINITIVE      | "udasdayhdi"
        "PL3" | "" | Tense.PRESENT         | "anadasdayvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadasdayvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadasdayvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadasdayvhvga"
        "PL3" | "" | Tense.INFINITIVE      | "unadasdayhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadasdayvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadasdayvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadasdayvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadasdayvhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadasdayhdi"
    }
}
