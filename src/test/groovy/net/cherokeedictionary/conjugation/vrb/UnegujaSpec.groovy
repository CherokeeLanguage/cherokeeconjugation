package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnegujaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Mean",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agineguja', habitual: 'aginegujoi', remote_past: 'aginegujvi', imperative: 'aginegujesdi', infinitive: 'x'],
            [subject: 'SG2', object: '', present: 'janeguja', habitual: 'janegujoi', remote_past: 'janegujvi', imperative: 'janegujesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'uneguja', habitual: 'unegujoi', remote_past: 'unegujvi', imperative: 'unegujesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unineguja', habitual: 'uninegujoi', remote_past: 'uninegujvi', imperative: 'uninegujesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igineguja', habitual: 'iginegujoi', remote_past: 'iginegujvi', imperative: 'iginegujesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uneguja (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uneguja", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agineguja"
        "SG1" | "" | Tense.HABITUAL        | "aginegujoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginegujvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginegujesdi"
        "SG1" | "" | Tense.INFINITIVE      | "x"
        "SG2" | "" | Tense.PRESENT         | "janeguja"
        "SG2" | "" | Tense.HABITUAL        | "janegujoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janegujvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "janegujesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uneguja"
        "SG3" | "" | Tense.HABITUAL        | "unegujoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unegujvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unegujesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unineguja"
        "PL3" | "" | Tense.HABITUAL        | "uninegujoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninegujvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninegujesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igineguja"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginegujoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginegujvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginegujesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
