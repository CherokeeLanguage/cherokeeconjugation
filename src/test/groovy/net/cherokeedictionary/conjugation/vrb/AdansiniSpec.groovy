// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72227 (entrya adansini) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gadanasini'],
            [subject: 'SG1', object: '', present: 'gadanasini', habitual: 'gadanasinegoi', remote_past: 'agwadansinvsvi', imperative: 'gadanasinuga', infinitive: 'agwadansinvsdi'],
            [subject: 'SG2', object: '', present: 'hadansini', habitual: 'hadansinegoi', remote_past: 'jadansinvsvi', imperative: 'hadansinuga', infinitive: 'jadansinvsdi'],
            [subject: 'SG3', object: '', habitual: 'adansinegoi', imperative: 'hadansinuga', infinitive: 'udansinvsdi', present: 'adansini', remote_past: 'udansinvsvi'],
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
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanasinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanasinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanasinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanasini"
        "SG2" | "" | Tense.HABITUAL        | "hadanasinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanasinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanasinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanasinvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanasini"
        "SG3" | "" | Tense.HABITUAL        | "adanasinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanasinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanasinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanasinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanasini"
        "PL3" | "" | Tense.HABITUAL        | "anadanasinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanasinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanasinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanasinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanasini"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanasinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanasinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanasinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanasinvsdi"
    }
}
