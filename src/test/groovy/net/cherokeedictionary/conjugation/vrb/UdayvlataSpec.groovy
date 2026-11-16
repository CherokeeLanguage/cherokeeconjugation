// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73733 (entrya udayvlata) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdayvlataSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its in View",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadayvlata'],
            [subject: 'SG1', object: '', present: 'agwadayvlata', habitual: 'agwadayvlatoi', remote_past: 'agwadayvlatvi', imperative: 'agwadayvlatesdi', infinitive: 'agwadayvlatdi'],
            [subject: 'SG2', object: '', present: 'jadayvlata', habitual: 'jadayvlatoi', remote_past: 'jadayvlatvi', imperative: 'jadayvlatesdi', infinitive: 'jadayvlatdi'],
            [subject: 'SG3', object: '', habitual: 'udayvlatoi', imperative: 'jadayvlatesdi', infinitive: 'udayvlatdi', present: 'udayvlata', remote_past: 'udayvlatvi'],
            [subject: 'PL3', object: '', present: 'unadayvlata', habitual: 'unadayvlatoi', remote_past: 'unadayvlatvi', imperative: 'unadayvlatesdi', infinitive: 'unadayvlatdi'],
            [subject: 'PL1INCL', object: '', present: 'igadayvlata', habitual: 'igadayvlatoi', remote_past: 'igadayvlatvi', imperative: 'igadayvlatesdi', infinitive: 'igadayvlatdi']
        ]
    ]

    @Unroll
    def "conjugating Udayvlata (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udayvlata", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadayvlata"
        "SG1" | "" | Tense.HABITUAL        | "aquadayvladoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadayvladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadayvladvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadayvlatidi"
        "SG2" | "" | Tense.PRESENT         | "tsadayvlata"
        "SG2" | "" | Tense.HABITUAL        | "tsadayvladoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadayvladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadayvladvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadayvlatidi"
        "SG3" | "" | Tense.PRESENT         | "udayvlata"
        "SG3" | "" | Tense.HABITUAL        | "udayvladoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udayvladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udayvladvi"
        "SG3" | "" | Tense.INFINITIVE      | "udayvlatidi"
        "PL3" | "" | Tense.PRESENT         | "unadayvlata"
        "PL3" | "" | Tense.HABITUAL        | "unadayvladoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadayvladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadayvladvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadayvlatidi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadayvlata"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadayvladoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadayvladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadayvladvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadayvlatidi"
    }
}
