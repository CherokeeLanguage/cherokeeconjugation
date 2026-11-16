// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73734 (entrya udega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Throwing It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadega'],
            [subject: 'SG1', object: '', present: 'agwadega', habitual: 'agwadegoi', remote_past: 'agwadinvsvi', imperative: 'agwaduga', infinitive: 'agwadinvdi'],
            [subject: 'SG2', object: '', present: 'jadega', habitual: 'jadegoi', remote_past: 'jadinvsvi', imperative: 'jaduga', infinitive: 'jadinvdi'],
            [subject: 'SG3', object: '', habitual: 'udegoi', imperative: 'jaduga', infinitive: 'udinvdi', present: 'udega', remote_past: 'udinvsvi'],
            [subject: 'PL3', object: '', present: 'unadega', habitual: 'unadegoi', remote_past: 'unadinvsvi', imperative: 'unaduga', infinitive: 'unadinvdi'],
            [subject: 'PL1INCL', object: '', present: 'igadega', habitual: 'igadegoi', remote_past: 'igadinvsvi', imperative: 'igaduga', infinitive: 'igadinvdi']
        ]
    ]

    @Unroll
    def "conjugating Udega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadega"
        "SG1" | "" | Tense.HABITUAL        | "aquadegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadinvdi"
        "SG2" | "" | Tense.PRESENT         | "tsadega"
        "SG2" | "" | Tense.HABITUAL        | "tsadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadinvdi"
        "SG3" | "" | Tense.PRESENT         | "udega"
        "SG3" | "" | Tense.HABITUAL        | "udegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udinvdi"
        "PL3" | "" | Tense.PRESENT         | "unadega"
        "PL3" | "" | Tense.HABITUAL        | "unadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadinvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadinvdi"
    }
}
