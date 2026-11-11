package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdanilaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Ill",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwadanila', habitual: 'agwadaniloi', remote_past: 'agwadanilvi', imperative: 'X', infinitive: 'agwadanilvsdi'],
            [subject: 'SG2', object: '', present: 'jadanila', habitual: 'jadaniloi', remote_past: 'jadanilvi', imperative: 'jadanilvsdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'udanila', habitual: 'udaniloi', remote_past: 'udanilvi', imperative: 'udanilvsdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unadanila', habitual: 'unadaniloi', remote_past: 'unadanilvi', imperative: 'unadanilvsdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igadanila', habitual: 'igadaniloi', remote_past: 'igadanilvi', imperative: 'igadanilvsdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Udanila (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udanila", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwadanila"
        "SG1" | "" | Tense.HABITUAL        | "agwadaniloi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanilvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "X"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanilvsdi"
        "SG2" | "" | Tense.PRESENT         | "jadanila"
        "SG2" | "" | Tense.HABITUAL        | "jadaniloi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadanilvsdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "udanila"
        "SG3" | "" | Tense.HABITUAL        | "udaniloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udanilvsdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unadanila"
        "PL3" | "" | Tense.HABITUAL        | "unadaniloi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadanilvsdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igadanila"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadaniloi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadanilvsdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
