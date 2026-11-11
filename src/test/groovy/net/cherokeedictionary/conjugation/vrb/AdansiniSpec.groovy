package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdansiniSpec extends VerbBaseSpec {
    static def details = [
        definition: "Crawling",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanasini', habitual: 'gadanasinegoi', remote_past: 'agwadansinvsvi', imperative: 'gadanasinuga', infinitive: 'agwadansinvsdi'],
            [subject: 'SG2', object: '', present: 'hadansini', habitual: 'hadansinegoi', remote_past: 'jadansinvsvi', imperative: 'hadansinuga', infinitive: 'jadansinvsdi'],
            [subject: 'SG3', object: '', present: 'adansini', habitual: 'adansinegoi', remote_past: 'udansinvsvi', imperative: 'adansinuga', infinitive: 'udansinvsdi'],
            [subject: 'PL3', object: '', present: 'anadansini', habitual: 'anadansinegoi', remote_past: 'unadansinvsvi', imperative: 'anadansinuga', infinitive: 'unadansinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadansini', habitual: 'idadansinegoi', remote_past: 'igadansinvsvi', imperative: 'idadansinuga', infinitive: 'igadansinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adansini (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adansini", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanasini"
        "SG1" | "" | Tense.HABITUAL        | "gadanasinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadansinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanasinuga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadansinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadansini"
        "SG2" | "" | Tense.HABITUAL        | "hadansinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadansinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadansinuga"
        "SG2" | "" | Tense.INFINITIVE      | "jadansinvsdi"
        "SG3" | "" | Tense.PRESENT         | "adansini"
        "SG3" | "" | Tense.HABITUAL        | "adansinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udansinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adansinuga"
        "SG3" | "" | Tense.INFINITIVE      | "udansinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadansini"
        "PL3" | "" | Tense.HABITUAL        | "anadansinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadansinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadansinuga"
        "PL3" | "" | Tense.INFINITIVE      | "unadansinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadansini"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadansinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadansinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadansinuga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadansinvsdi"
    }
}
