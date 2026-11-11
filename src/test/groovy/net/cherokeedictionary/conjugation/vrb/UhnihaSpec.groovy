package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is in Bed",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwahniha', habitual: 'agwahnihoi', remote_past: 'agwahnihvi', imperative: 'agwahnihesdi', infinitive: 'x'],
            [subject: 'SG2', object: '', present: 'jahniha', habitual: 'jahnihoi', remote_past: 'jahnihvi', imperative: 'jahnihesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'uhniha', habitual: 'uhnihoi', remote_past: 'uhnihvi', imperative: 'uhnihesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unahniha', habitual: 'unahnihoi', remote_past: 'unahnihhvi', imperative: 'unahnihesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igahniha', habitual: 'igahnihoi', remote_past: 'igahnihvi', imperative: 'igahnihesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uhniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwahniha"
        "SG1" | "" | Tense.HABITUAL        | "agwahnihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwahnihesdi"
        "SG1" | "" | Tense.INFINITIVE      | "x"
        "SG2" | "" | Tense.PRESENT         | "jahniha"
        "SG2" | "" | Tense.HABITUAL        | "jahnihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnihvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jahnihesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uhniha"
        "SG3" | "" | Tense.HABITUAL        | "uhnihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnihvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhnihesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unahniha"
        "PL3" | "" | Tense.HABITUAL        | "unahnihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnihhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unahnihesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igahniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igahnihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnihvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igahnihesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
