package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Climbing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilega', habitual: 'jilegoi', remote_past: 'agilvsvi', imperative: 'jiluga', infinitive: 'agilvsdi'],
            [subject: 'SG2', object: '', present: 'hilega', habitual: 'hilegoi', remote_past: 'jalvsvi', imperative: 'hiluga', infinitive: 'jalvsdi'],
            [subject: 'SG3', object: '', present: 'galega', habitual: 'galegoi', remote_past: 'ulvsvi', imperative: 'galuga', infinitive: 'ulvsdi'],
            [subject: 'PL3', object: '', present: 'anilega', habitual: 'anilegoi', remote_past: 'unilvsvi', imperative: 'aniluga', infinitive: 'unilvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idilega', habitual: 'idilegoi', remote_past: 'igilvsvi', imperative: 'idiluga', infinitive: 'igilvsdi']
        ]
    ]

    @Unroll
    def "conjugating Galega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilega"
        "SG1" | "" | Tense.HABITUAL        | "jilegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiluga"
        "SG1" | "" | Tense.INFINITIVE      | "agilvsdi"
        "SG2" | "" | Tense.PRESENT         | "hilega"
        "SG2" | "" | Tense.HABITUAL        | "hilegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiluga"
        "SG2" | "" | Tense.INFINITIVE      | "jalvsdi"
        "SG3" | "" | Tense.PRESENT         | "galega"
        "SG3" | "" | Tense.HABITUAL        | "galegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galuga"
        "SG3" | "" | Tense.INFINITIVE      | "ulvsdi"
        "PL3" | "" | Tense.PRESENT         | "anilega"
        "PL3" | "" | Tense.HABITUAL        | "anilegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniluga"
        "PL3" | "" | Tense.INFINITIVE      | "unilvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiluga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilvsdi"
    }
}
