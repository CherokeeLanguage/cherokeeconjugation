package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DekgiloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Washing Flexible Objects",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degvgiloa', habitual: 'degvgilosgoi', remote_past: 'dagwvgilovi', imperative: 'digvgiloja', infinitive: 'digwvgilosdi'],
            [subject: 'SG2', object: '', present: 'dehvgiloa', habitual: 'dehvgilosgoi', remote_past: 'dejvgilovi', imperative: 'tvhgiloja', infinitive: 'dijvgilosdi'],
            [subject: 'SG3', object: '', present: 'dekgiloa', habitual: 'dekgilosgoi', remote_past: 'duhgilovi', imperative: 'dikgiloja', infinitive: 'juhgilosdi'],
            [subject: 'PL3', object: '', present: 'danvgiloa', habitual: 'danvgilosgoi', remote_past: 'dunvgilovi', imperative: 'dinvgiloja', infinitive: 'junhgilosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedvgiloa', habitual: 'dedvgilosgoi', remote_past: 'degvgilovi', imperative: 'didvgiloja', infinitive: 'digvgilosdi']
        ]
    ]

    @Unroll
    def "conjugating Dekgiloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dekgiloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degvgiloa"
        "SG1" | "" | Tense.HABITUAL        | "degvgilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwvgilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digvgiloja"
        "SG1" | "" | Tense.INFINITIVE      | "digwvgilosdi"
        "SG2" | "" | Tense.PRESENT         | "dehvgiloa"
        "SG2" | "" | Tense.HABITUAL        | "dehvgilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejvgilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tvhgiloja"
        "SG2" | "" | Tense.INFINITIVE      | "dijvgilosdi"
        "SG3" | "" | Tense.PRESENT         | "dekgiloa"
        "SG3" | "" | Tense.HABITUAL        | "dekgilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhgilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikgiloja"
        "SG3" | "" | Tense.INFINITIVE      | "juhgilosdi"
        "PL3" | "" | Tense.PRESENT         | "danvgiloa"
        "PL3" | "" | Tense.HABITUAL        | "danvgilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunvgilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinvgiloja"
        "PL3" | "" | Tense.INFINITIVE      | "junhgilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedvgiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedvgilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degvgilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didvgiloja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digvgilosdi"
    }
}
