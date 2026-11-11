package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnohyvhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sound (It is making)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'aginohyvhga', habitual: 'aginohyvhgoi', remote_past: 'aginohyvlsvi', imperative: 'aginohyvla', infinitive: 'aginohyvhlisdi'],
            [subject: 'SG2', object: '', present: 'janohyvhga', habitual: 'janohyvhgoi', remote_past: 'janohyvlsvi', imperative: 'janohyvla', infinitive: 'janohyvhlisdi'],
            [subject: 'SG3', object: '', present: 'unohyvhga', habitual: 'unohyvhgoi', remote_past: 'unohyvlsvi', imperative: 'unohyvla', infinitive: 'unohyvhlisdi'],
            [subject: 'PL3', object: '', present: 'uninohyvhga', habitual: 'uninohyvhgoi', remote_past: 'uninohyvlsvi', imperative: 'uninohyvla', infinitive: 'uninohyvhlisdi'],
            [subject: 'PL1INCL', object: '', present: 'iginohyvhga', habitual: 'iginohyvhgoi', remote_past: 'iginohyvlsvi', imperative: 'iginohyvla', infinitive: 'iginohyvhlisdi']
        ]
    ]

    @Unroll
    def "conjugating Unohyvhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unohyvhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginohyvhga"
        "SG1" | "" | Tense.HABITUAL        | "aginohyvhgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohyvlsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginohyvla"
        "SG1" | "" | Tense.INFINITIVE      | "aginohyvhlisdi"
        "SG2" | "" | Tense.PRESENT         | "janohyvhga"
        "SG2" | "" | Tense.HABITUAL        | "janohyvhgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohyvlsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "janohyvla"
        "SG2" | "" | Tense.INFINITIVE      | "janohyvhlisdi"
        "SG3" | "" | Tense.PRESENT         | "unohyvhga"
        "SG3" | "" | Tense.HABITUAL        | "unohyvhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohyvlsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unohyvla"
        "SG3" | "" | Tense.INFINITIVE      | "unohyvhlisdi"
        "PL3" | "" | Tense.PRESENT         | "uninohyvhga"
        "PL3" | "" | Tense.HABITUAL        | "uninohyvhgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohyvlsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninohyvla"
        "PL3" | "" | Tense.INFINITIVE      | "uninohyvhlisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iginohyvhga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginohyvhgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohyvlsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginohyvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginohyvhlisdi"
    }
}
