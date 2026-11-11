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
            [subject: 'SG1', object: '', present: 'agwadega', habitual: 'agwadegoi', remote_past: 'agwadinvsvi', imperative: 'agwaduga', infinitive: 'agwadinvdi'],
            [subject: 'SG2', object: '', present: 'jadega', habitual: 'jadegoi', remote_past: 'jadinvsvi', imperative: 'jaduga', infinitive: 'jadinvdi'],
            [subject: 'SG3', object: '', present: 'udega', habitual: 'udegoi', remote_past: 'udinvsvi', imperative: 'uduga', infinitive: 'udinvdi'],
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
        "SG1" | "" | Tense.PRESENT         | "agwadega"
        "SG1" | "" | Tense.HABITUAL        | "agwadegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwaduga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadinvdi"
        "SG2" | "" | Tense.PRESENT         | "jadega"
        "SG2" | "" | Tense.HABITUAL        | "jadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jaduga"
        "SG2" | "" | Tense.INFINITIVE      | "jadinvdi"
        "SG3" | "" | Tense.PRESENT         | "udega"
        "SG3" | "" | Tense.HABITUAL        | "udegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uduga"
        "SG3" | "" | Tense.INFINITIVE      | "udinvdi"
        "PL3" | "" | Tense.PRESENT         | "unadega"
        "PL3" | "" | Tense.HABITUAL        | "unadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unaduga"
        "PL3" | "" | Tense.INFINITIVE      | "unadinvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igaduga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadinvdi"
    }
}
