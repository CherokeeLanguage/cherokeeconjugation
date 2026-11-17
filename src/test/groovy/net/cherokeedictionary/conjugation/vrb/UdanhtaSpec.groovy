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
        "SG1" | "" | Tense.PRESENT         | "aquadanata"
        "SG1" | "" | Tense.HABITUAL        | "aquadanadoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadanadvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanadadisdi"
        "SG2" | "" | Tense.PRESENT         | "tsadanata"
        "SG2" | "" | Tense.HABITUAL        | "tsadanadoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadanadvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanadadisdi"
        "SG3" | "" | Tense.PRESENT         | "udanata"
        "SG3" | "" | Tense.HABITUAL        | "udanadoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udanadvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanadadisdi"
        "PL3" | "" | Tense.PRESENT         | "unadanata"
        "PL3" | "" | Tense.HABITUAL        | "unadanadoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanadvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadanadvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanadadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadanata"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadanadoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanadvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadanadvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanadadisdi"
    }
}
