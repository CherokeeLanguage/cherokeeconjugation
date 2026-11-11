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
            [subject: 'SG1', object: '', present: 'agwadanhta', habitual: 'agwadanhtoi', remote_past: 'agwadanhtvi', imperative: 'agwadanhtesdi', infinitive: 'agwadanhdadisdi'],
            [subject: 'SG2', object: '', present: 'jadanhta', habitual: 'jadanhtoi', remote_past: 'jadanhtvi', imperative: 'jadanhtesdi', infinitive: 'jadanhdadisdi'],
            [subject: 'SG3', object: '', present: 'udanhta', habitual: 'udanhtoi', remote_past: 'udanhtvi', imperative: 'udanhtesdi', infinitive: 'udanhdadisdi'],
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
        "SG1" | "" | Tense.PRESENT         | "agwadanhta"
        "SG1" | "" | Tense.HABITUAL        | "agwadanhtoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanhtvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadanhtesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanhdadisdi"
        "SG2" | "" | Tense.PRESENT         | "jadanhta"
        "SG2" | "" | Tense.HABITUAL        | "jadanhtoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanhtvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadanhtesdi"
        "SG2" | "" | Tense.INFINITIVE      | "jadanhdadisdi"
        "SG3" | "" | Tense.PRESENT         | "udanhta"
        "SG3" | "" | Tense.HABITUAL        | "udanhtoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanhtvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udanhtesdi"
        "SG3" | "" | Tense.INFINITIVE      | "udanhdadisdi"
        "PL3" | "" | Tense.PRESENT         | "unadanhta"
        "PL3" | "" | Tense.HABITUAL        | "unadanhtoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanhtvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadanhtesdi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanhdadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadanhta"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadanhtoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanhtvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadanhtesdi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanhdadisdi"
    }
}
