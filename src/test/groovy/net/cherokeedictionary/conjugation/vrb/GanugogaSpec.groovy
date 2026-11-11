package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanugogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Exiting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinugoga', habitual: 'jinugogoi', remote_past: 'aginugojvi', imperative: 'jinugoi', infinitive: 'aginugisdi'],
            [subject: 'SG2', object: '', present: 'hinugoga', habitual: 'hinugogoi', remote_past: 'janugojvi', imperative: 'hinugoi', infinitive: 'janugisdi'],
            [subject: 'SG3', object: '', present: 'ganugoga', habitual: 'ganugogoi', remote_past: 'unugojvi', imperative: 'ganugoi', infinitive: 'unugisdi'],
            [subject: 'PL3', object: '', present: 'aninugoga', habitual: 'aninugogoi', remote_past: 'uninugojvi', imperative: 'aninugoi', infinitive: 'uninugisdi'],
            [subject: 'PL1INCL', object: '', present: 'idinugoga', habitual: 'idinugogoi', remote_past: 'iginugojvi', imperative: 'idinugoi', infinitive: 'iginugisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganugoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganugoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinugoga"
        "SG1" | "" | Tense.HABITUAL        | "jinugogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginugojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinugoi"
        "SG1" | "" | Tense.INFINITIVE      | "aginugisdi"
        "SG2" | "" | Tense.PRESENT         | "hinugoga"
        "SG2" | "" | Tense.HABITUAL        | "hinugogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janugojvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinugoi"
        "SG2" | "" | Tense.INFINITIVE      | "janugisdi"
        "SG3" | "" | Tense.PRESENT         | "ganugoga"
        "SG3" | "" | Tense.HABITUAL        | "ganugogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unugojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganugoi"
        "SG3" | "" | Tense.INFINITIVE      | "unugisdi"
        "PL3" | "" | Tense.PRESENT         | "aninugoga"
        "PL3" | "" | Tense.HABITUAL        | "aninugogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninugojvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninugoi"
        "PL3" | "" | Tense.INFINITIVE      | "uninugisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinugoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinugogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginugojvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinugoi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginugisdi"
    }
}
