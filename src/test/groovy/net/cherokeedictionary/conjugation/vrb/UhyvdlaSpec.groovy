package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyvdlaSpec extends VerbBaseSpec {
    static def details = [
        definition: "uniyiha S/he Has a Cold",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'uhyvdla', habitual: 'aginiyiha', remote_past: 'uhyvdla', imperative: 'aginiyisgoi', infinitive: 'uhyvdla'],
            [subject: 'SG2', object: '', present: 'uhyvdla', habitual: 'janiyiha', remote_past: 'uhyvdla', imperative: 'janiyisgoi', infinitive: 'uhyvdla'],
            [subject: 'SG3', object: '', present: 'uhyvdla', habitual: 'uniyiha', remote_past: 'uhyvdla', imperative: 'uniyisgoi', infinitive: 'uhyvdla'],
            [subject: 'PL3', object: '', present: 'uhyvdla', habitual: 'uniniyiha', remote_past: 'uhyvdla', imperative: 'uniniyisgoi', infinitive: 'uhyvdla'],
            [subject: 'PL1INCL', object: '', present: 'uhyvdla', habitual: 'iginiyiha', remote_past: 'uhyvdla', imperative: 'iginiyisgoi', infinitive: 'uhyvdla']
        ]
    ]

    @Unroll
    def "conjugating Uhyvdla (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyvdla", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "uhyvdla"
        "SG1" | "" | Tense.HABITUAL        | "aginiyiha"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginiyisgoi"
        "SG1" | "" | Tense.INFINITIVE      | "uhyvdla"
        "SG2" | "" | Tense.PRESENT         | "uhyvdla"
        "SG2" | "" | Tense.HABITUAL        | "janiyiha"
        "SG2" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "janiyisgoi"
        "SG2" | "" | Tense.INFINITIVE      | "uhyvdla"
        "SG3" | "" | Tense.PRESENT         | "uhyvdla"
        "SG3" | "" | Tense.HABITUAL        | "uniyiha"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uniyisgoi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvdla"
        "PL3" | "" | Tense.PRESENT         | "uhyvdla"
        "PL3" | "" | Tense.HABITUAL        | "uniniyiha"
        "PL3" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniniyisgoi"
        "PL3" | "" | Tense.INFINITIVE      | "uhyvdla"
        "PL1INCL" | "" | Tense.PRESENT         | "uhyvdla"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginiyiha"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginiyisgoi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "uhyvdla"
    }
}
