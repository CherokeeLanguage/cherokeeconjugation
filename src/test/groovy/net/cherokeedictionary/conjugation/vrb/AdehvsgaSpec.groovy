package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Being Born",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadevsga', habitual: 'gadevsgoi', remote_past: 'agwadehnvi', imperative: 'gadevga', infinitive: 'agwadehdi'],
            [subject: 'SG2', object: '', present: 'hadehvsga', habitual: 'hadehvsgoi', remote_past: 'jadehnvi', imperative: 'hadehvga', infinitive: 'jadehdi'],
            [subject: 'SG3', object: '', present: 'adehvsga', habitual: 'adehvsgoi', remote_past: 'udehnvi', imperative: 'adehvga', infinitive: 'udehdi'],
            [subject: 'PL3', object: '', present: 'anadehvsga', habitual: 'anadehvsgoi', remote_past: 'unadehnvi', imperative: 'anadehvga', infinitive: 'unadehdi'],
            [subject: 'PL1INCL', object: '', present: 'idadehvsga', habitual: 'idadehvsgoi', remote_past: 'igadehnvi', imperative: 'idadehvga', infinitive: 'igadehdi']
        ]
    ]

    @Unroll
    def "conjugating Adehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadevsga"
        "SG1" | "" | Tense.HABITUAL        | "gadevsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadevga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadehdi"
        "SG2" | "" | Tense.PRESENT         | "hadehvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadehvga"
        "SG2" | "" | Tense.INFINITIVE      | "jadehdi"
        "SG3" | "" | Tense.PRESENT         | "adehvsga"
        "SG3" | "" | Tense.HABITUAL        | "adehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adehvga"
        "SG3" | "" | Tense.INFINITIVE      | "udehdi"
        "PL3" | "" | Tense.PRESENT         | "anadehvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadehnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadehvga"
        "PL3" | "" | Tense.INFINITIVE      | "unadehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadehnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadehvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadehdi"
    }
}
