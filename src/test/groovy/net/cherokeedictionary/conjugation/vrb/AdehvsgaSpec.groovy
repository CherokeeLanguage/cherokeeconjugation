// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72247 (entrya adehvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gadevsga'],
            [subject: 'SG1', object: '', present: 'gadevsga', habitual: 'gadevsgoi', remote_past: 'agwadehnvi', imperative: 'gadevga', infinitive: 'agwadehdi'],
            [subject: 'SG2', object: '', present: 'hadehvsga', habitual: 'hadehvsgoi', remote_past: 'jadehnvi', imperative: 'hadehvga', infinitive: 'jadehdi'],
            [subject: 'SG3', object: '', habitual: 'adehvsgoi', imperative: 'hadehvga', infinitive: 'udehdi', present: 'adehvsga', remote_past: 'udehnvi'],
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
        "SG1" | "" | Tense.PRESENT         | "gadehvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadehvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadenvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadenvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadedi"
        "SG2" | "" | Tense.PRESENT         | "hadehvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadenvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadenvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadedi"
        "SG3" | "" | Tense.PRESENT         | "adehvsga"
        "SG3" | "" | Tense.HABITUAL        | "adehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udenvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adenvi"
        "SG3" | "" | Tense.INFINITIVE      | "udedi"
        "PL3" | "" | Tense.PRESENT         | "anadehvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadenvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadenvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadenvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadenvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadedi"
    }
}
