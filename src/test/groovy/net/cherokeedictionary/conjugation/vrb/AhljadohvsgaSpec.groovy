package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhljadohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Preaching",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galijadohvsga', habitual: 'galijadohvsgoi', remote_past: 'agwahljadohnvi', imperative: 'galijadohvga', infinitive: 'agwahljatdi'],
            [subject: 'SG2', object: '', present: 'hahljadohvsga', habitual: 'hahljadohvsgoi', remote_past: 'jahljadohnvi', imperative: 'hahljadohvga', infinitive: 'jahljatdi'],
            [subject: 'SG3', object: '', present: 'ahljadohvsga', habitual: 'ahljadohvsgoi', remote_past: 'uhljadohnvi', imperative: 'ahljadohvga', infinitive: 'uhljatdi'],
            [subject: 'PL3', object: '', present: 'anahljadohvsga', habitual: 'anahljadohvsgoi', remote_past: 'unahljadohnvi', imperative: 'anahljadohvga', infinitive: 'unahljatdi'],
            [subject: 'PL1INCL', object: '', present: 'idahljadohvsga', habitual: 'idahljadohvsgoi', remote_past: 'igahljadohnvi', imperative: 'idahljadohvga', infinitive: 'igahljatdi']
        ]
    ]

    @Unroll
    def "conjugating Ahljadohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahljadohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galijadohvsga"
        "SG1" | "" | Tense.HABITUAL        | "galijadohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahljadohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galijadohvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwahljatdi"
        "SG2" | "" | Tense.PRESENT         | "hahljadohvsga"
        "SG2" | "" | Tense.HABITUAL        | "hahljadohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahljadohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahljadohvga"
        "SG2" | "" | Tense.INFINITIVE      | "jahljatdi"
        "SG3" | "" | Tense.PRESENT         | "ahljadohvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahljadohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhljadohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahljadohvga"
        "SG3" | "" | Tense.INFINITIVE      | "uhljatdi"
        "PL3" | "" | Tense.PRESENT         | "anahljadohvsga"
        "PL3" | "" | Tense.HABITUAL        | "anahljadohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahljadohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahljadohvga"
        "PL3" | "" | Tense.INFINITIVE      | "unahljatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahljadohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahljadohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahljadohnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idahljadohvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahljatdi"
    }
}
