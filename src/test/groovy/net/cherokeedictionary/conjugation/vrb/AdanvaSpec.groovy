// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72229 (entrya adanva) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Moving",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanva'],
            [subject: 'SG1', object: '', present: 'gadanva', habitual: 'gadanvsgoi', remote_past: 'agwadanvsvi', imperative: 'gadanvna', infinitive: 'agwadanvsdi'],
            [subject: 'SG2', object: '', present: 'hadanva', habitual: 'hadanvsgoi', remote_past: 'jadanvsvi', imperative: 'hadanvna', infinitive: 'jadanvsdi'],
            [subject: 'SG3', object: '', habitual: 'adanvsgoi', imperative: 'hadanvna', infinitive: 'udanvsdi', present: 'adanva', remote_past: 'udanvsvi'],
            [subject: 'PL3', object: '', present: 'anadanva', habitual: 'anadanvsgoi', remote_past: 'unadanvsvi', imperative: 'anadanvna', infinitive: 'unadanvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanva', habitual: 'idadanvsgoi', remote_past: 'igadanvsvi', imperative: 'idadanvna', infinitive: 'igadanvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adanva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanva"
        "SG1" | "" | Tense.HABITUAL        | "gadanvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanva"
        "SG2" | "" | Tense.HABITUAL        | "hadanvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanva"
        "SG3" | "" | Tense.HABITUAL        | "adanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanva"
        "PL3" | "" | Tense.HABITUAL        | "anadanvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanvsdi"
    }
}
