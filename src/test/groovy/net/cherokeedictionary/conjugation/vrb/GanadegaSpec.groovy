package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanadegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Selling",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jindega', habitual: 'jindegoi', remote_past: 'agindinvsvi', imperative: 'jinduga', infinitive: 'agindinvsdi'],
            [subject: 'SG2', object: '', present: 'hinadega', habitual: 'hinadegoi', remote_past: 'janadinvsvi', imperative: 'hinaduga', infinitive: 'janadinvsdi'],
            [subject: 'SG3', object: '', present: 'ganadega', habitual: 'ganedegoi', remote_past: 'unadinvsvi', imperative: 'ganaduga', infinitive: 'unadinvsdi'],
            [subject: 'PL3', object: '', present: 'aninadega', habitual: 'aninadegoi', remote_past: 'uninadinvsvi', imperative: 'aninaduga', infinitive: 'uninadinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinadega', habitual: 'idinadegoi', remote_past: 'idinadinvsvi', imperative: 'idinaduga', infinitive: 'iginadinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganadega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganadega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jindega"
        "SG1" | "" | Tense.HABITUAL        | "jindegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agindinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinduga"
        "SG1" | "" | Tense.INFINITIVE      | "agindinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinadega"
        "SG2" | "" | Tense.HABITUAL        | "hinadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinaduga"
        "SG2" | "" | Tense.INFINITIVE      | "janadinvsdi"
        "SG3" | "" | Tense.PRESENT         | "ganadega"
        "SG3" | "" | Tense.HABITUAL        | "ganedegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unadinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganaduga"
        "SG3" | "" | Tense.INFINITIVE      | "unadinvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninadega"
        "PL3" | "" | Tense.HABITUAL        | "aninadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninaduga"
        "PL3" | "" | Tense.INFINITIVE      | "uninadinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "idinadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinaduga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginadinvsdi"
    }
}
