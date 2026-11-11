package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnalvhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Angry",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'akinalvha', habitual: 'akinalvsoi', remote_past: 'akinalvsvi', imperative: 'akinalvsesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jahnalvha', habitual: 'jahnalvsoi', remote_past: 'jahnalvsvi', imperative: 'chanalvsesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'uhnalvha', habitual: 'uhnalvsoi', remote_past: 'uhnalvsvi', imperative: 'uhnalvsesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unihnalvha', habitual: 'unihnalvsoi', remote_past: 'unihnalvsvi', imperative: 'uninalvsesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igihnalvha', habitual: 'igihnalvsoi', remote_past: 'igihnalvsvi', imperative: 'iginalvsesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uhnalvha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhnalvha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akinalvha"
        "SG1" | "" | Tense.HABITUAL        | "akinalvsoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinalvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "akinalvsesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "jahnalvha"
        "SG2" | "" | Tense.HABITUAL        | "jahnalvsoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnalvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "chanalvsesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uhnalvha"
        "SG3" | "" | Tense.HABITUAL        | "uhnalvsoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnalvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhnalvsesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unihnalvha"
        "PL3" | "" | Tense.HABITUAL        | "unihnalvsoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnalvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninalvsesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igihnalvha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihnalvsoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnalvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginalvsesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
