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
        "SG1" | "" | Tense.PRESENT         | "gadanisini"
        "SG1" | "" | Tense.HABITUAL        | "gadanisinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanisinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanisinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanisinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanisini"
        "SG2" | "" | Tense.HABITUAL        | "hadanisinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanisinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanisinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanisinvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanisini"
        "SG3" | "" | Tense.HABITUAL        | "adanisinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanisinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanisinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanisinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanisini"
        "PL3" | "" | Tense.HABITUAL        | "anadanisinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanisinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanisinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanisinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanisini"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanisinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanisinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanisinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanisinvsdi"
    }
}
