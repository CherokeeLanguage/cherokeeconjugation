// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73725 (entrya udanhta) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdanhtaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Feeling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadanhta'],
            [subject: 'SG1', object: '', present: 'agwadanhta', habitual: 'agwadanhtoi', remote_past: 'agwadanhtvi', imperative: 'agwadanhtesdi', infinitive: 'agwadanhdadisdi'],
            [subject: 'SG2', object: '', present: 'jadanhta', habitual: 'jadanhtoi', remote_past: 'jadanhtvi', imperative: 'jadanhtesdi', infinitive: 'jadanhdadisdi'],
            [subject: 'SG3', object: '', habitual: 'udanhtoi', imperative: 'jadanhtesdi', infinitive: 'udanhdadisdi', present: 'udanhta', remote_past: 'udanhtvi'],
            [subject: 'PL3', object: '', present: 'unadanhta', habitual: 'unadanhtoi', remote_past: 'unadanhtvi', imperative: 'unadanhtesdi', infinitive: 'unadanhdadisdi'],
            [subject: 'PL1INCL', object: '', present: 'igadanhta', habitual: 'igadanhtoi', remote_past: 'igadanhtvi', imperative: 'igadanhtesdi', infinitive: 'igadanhdadisdi']
        ]
    ]

    @Unroll
    def "conjugating Udanhta (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udanhta", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadanita"
        "SG1" | "" | Tense.HABITUAL        | "aquadanidoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadanidvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanidadisdi"
        "SG2" | "" | Tense.PRESENT         | "tsadanita"
        "SG2" | "" | Tense.HABITUAL        | "tsadanidoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanidvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadanidvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanidadisdi"
        "SG3" | "" | Tense.PRESENT         | "udanita"
        "SG3" | "" | Tense.HABITUAL        | "udanidoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udanidvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanidadisdi"
        "PL3" | "" | Tense.PRESENT         | "unadanita"
        "PL3" | "" | Tense.HABITUAL        | "unadanidoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadanidvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanidadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadanita"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadanidoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadanidvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanidadisdi"
    }
}
