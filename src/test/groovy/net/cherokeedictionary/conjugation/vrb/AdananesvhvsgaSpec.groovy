// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72214 (entrya adananesvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdananesvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shopping",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadananesvhvsga'],
            [subject: 'SG1', object: '', present: 'gadananesvhvsga', habitual: 'gadananesvhvsgoi', remote_past: 'agwadananesvhnvi', imperative: 'gadananesvhvga', infinitive: 'agwadananesvhvsdi'],
            [subject: 'SG2', object: '', present: 'hadananesvhvsga', habitual: 'hadananesvhvsgoi', remote_past: 'jadananesvhnvi', imperative: 'hadananesvhvga', infinitive: 'jadananesvhvsdi'],
            [subject: 'SG3', object: '', habitual: 'adananesvhvsgoi', imperative: 'hadananesvhvga', infinitive: 'udananesvhvsdi', present: 'adananesvhvsga', remote_past: 'udananesvhnvi'],
            [subject: 'PL3', object: '', present: 'anadananesvhvsga', habitual: 'anadananesvhvsgoi', remote_past: 'unadananesvhnvi', imperative: 'anadananesvhvga', infinitive: 'unadananesvhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadananesvhvsga', habitual: 'idadananesvhvsgoi', remote_past: 'igadananesvhnvi', imperative: 'idadananesvhvga', infinitive: 'igadananesvhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adananesvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adananesvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadananesvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadananesvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadananesvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadananesvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadananesvhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadananesvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadananesvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadananesvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadananesvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadananesvhvsdi"
        "SG3" | "" | Tense.PRESENT         | "adananesvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "adananesvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udananesvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adananesvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "udananesvhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadananesvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadananesvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadananesvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadananesvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadananesvhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadananesvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadananesvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadananesvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadananesvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadananesvhvsdi"
    }
}
