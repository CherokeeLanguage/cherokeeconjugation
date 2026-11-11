package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Ordering",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanvsga', habitual: 'gadanvsgoi', remote_past: 'agwadanvsvi', imperative: 'gadanvla', infinitive: 'agwadanvsdi'],
            [subject: 'SG2', object: '', present: 'hadanvsga', habitual: 'hadanvsgoi', remote_past: 'jadanvsvi', imperative: 'hadanvla', infinitive: 'jadanvsdi'],
            [subject: 'SG3', object: '', present: 'adanvsga', habitual: 'adanvsgoi', remote_past: 'udanvsvi', imperative: 'adanvla', infinitive: 'udanvsdi'],
            [subject: 'PL3', object: '', present: 'anadanvsga', habitual: 'anadanvsgoi', remote_past: 'unadanvsvi', imperative: 'anadanvla', infinitive: 'unadanvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanvsga', habitual: 'idadanvsgoi', remote_past: 'igadanvsvi', imperative: 'idadanvla', infinitive: 'igadanvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adanvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadanvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanvla"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadanvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanvla"
        "SG2" | "" | Tense.INFINITIVE      | "jadanvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanvsga"
        "SG3" | "" | Tense.HABITUAL        | "adanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanvla"
        "SG3" | "" | Tense.INFINITIVE      | "udanvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadanvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanvla"
        "PL3" | "" | Tense.INFINITIVE      | "unadanvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanvsdi"
    }
}
