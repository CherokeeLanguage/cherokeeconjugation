package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgahlgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Biting Him/It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisgahlga', habitual: 'jisgahlgoi', remote_past: 'aksgahljvi', imperative: 'jisgala', infinitive: 'aksgalsdi'],
            [subject: 'SG2', object: '', present: 'hisgahlga', habitual: 'hisgahlgoi', remote_past: 'tsgahljvi', imperative: 'hisgala', infinitive: '/'],
            [subject: 'SG3', object: '', present: 'asgahlga', habitual: 'asgahlgoi', remote_past: 'usgahljvi', imperative: 'asgala', infinitive: 'usgalsdi'],
            [subject: 'PL3', object: '', present: 'anisgahlga', habitual: 'anisgahlgoi', remote_past: 'unisgahljvi', imperative: 'anisgala', infinitive: 'unisgalsdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgahlga', habitual: 'idisgahlgoi', remote_past: 'igisgahljvi', imperative: 'idisgala', infinitive: 'igisgalsdi']
        ]
    ]

    @Unroll
    def "conjugating Asgahlga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgahlga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgahlga"
        "SG1" | "" | Tense.HABITUAL        | "jisgahlgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgahljvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisgala"
        "SG1" | "" | Tense.INFINITIVE      | "aksgalsdi"
        "SG2" | "" | Tense.PRESENT         | "hisgahlga"
        "SG2" | "" | Tense.HABITUAL        | "hisgahlgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsgahljvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgala"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "asgahlga"
        "SG3" | "" | Tense.HABITUAL        | "asgahlgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgahljvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgala"
        "SG3" | "" | Tense.INFINITIVE      | "usgalsdi"
        "PL3" | "" | Tense.PRESENT         | "anisgahlga"
        "PL3" | "" | Tense.HABITUAL        | "anisgahlgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgahljvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgala"
        "PL3" | "" | Tense.INFINITIVE      | "unisgalsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgahlga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgahlgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgahljvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgala"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgalsdi"
    }
}
