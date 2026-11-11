package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UjaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Inside",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwajaa', habitual: 'agwajaoi', remote_past: 'agwajavi', imperative: 'agwajaesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jajaa', habitual: 'jajaoi', remote_past: 'jajavi', imperative: 'jajaesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'ujaa', habitual: 'ujaoi', remote_past: 'ujavi', imperative: 'ujaesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unajaa', habitual: 'unajaoi', remote_past: 'unajavi', imperative: 'unajaesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igajaa', habitual: 'igajaoi', remote_past: 'igajavi', imperative: 'igajaesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Ujaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ujaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwajaa"
        "SG1" | "" | Tense.HABITUAL        | "agwajaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwajaesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "jajaa"
        "SG2" | "" | Tense.HABITUAL        | "jajaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jajaesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "ujaa"
        "SG3" | "" | Tense.HABITUAL        | "ujaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ujaesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unajaa"
        "PL3" | "" | Tense.HABITUAL        | "unajaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unajaesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igajaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "igajaoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igajaesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
