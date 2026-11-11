package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnalvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Angry (Getting)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'akinalvga', habitual: 'akinalvgoi', remote_past: 'akinalvjvi', imperative: 'akinalvgi', infinitive: 'akinalvisdi'],
            [subject: 'SG2', object: '', present: 'jahnalvga', habitual: 'jahnalvgoi', remote_past: 'jahnalvjvi', imperative: 'chanalvgi', infinitive: 'jahnalvisdi'],
            [subject: 'SG3', object: '', present: 'uhnalvga', habitual: 'uhnalvgoi', remote_past: 'uhnalvjvi', imperative: 'uhnalvgi', infinitive: 'uhnalvisdi'],
            [subject: 'PL3', object: '', present: 'unihnalvga', habitual: 'unihnalvgoi', remote_past: 'unihnalvjvi', imperative: 'uninalvgi', infinitive: 'unihnalvisdi'],
            [subject: 'PL1INCL', object: '', present: 'igihnalvga', habitual: 'igihnalvgoi', remote_past: 'igihnalvjvi', imperative: 'iginalvgi', infinitive: 'igihnalvisdi']
        ]
    ]

    @Unroll
    def "conjugating Uhnalvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhnalvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akinalvga"
        "SG1" | "" | Tense.HABITUAL        | "akinalvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinalvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "akinalvgi"
        "SG1" | "" | Tense.INFINITIVE      | "akinalvisdi"
        "SG2" | "" | Tense.PRESENT         | "jahnalvga"
        "SG2" | "" | Tense.HABITUAL        | "jahnalvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnalvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "chanalvgi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnalvisdi"
        "SG3" | "" | Tense.PRESENT         | "uhnalvga"
        "SG3" | "" | Tense.HABITUAL        | "uhnalvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnalvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhnalvgi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnalvisdi"
        "PL3" | "" | Tense.PRESENT         | "unihnalvga"
        "PL3" | "" | Tense.HABITUAL        | "unihnalvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnalvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninalvgi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnalvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihnalvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihnalvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnalvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginalvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnalvisdi"
    }
}
