package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UgohniyogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Late",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agigohniyoga', habitual: 'agigohniyogoi', remote_past: 'agigohniyojvi', imperative: 'agigohniyogi', infinitive: 'agigohniyosdi'],
            [subject: 'SG2', object: '', present: 'jagohniyoga', habitual: 'jagohniyogoi', remote_past: 'jagohniyojvi', imperative: 'jagohniyogi', infinitive: 'jagohniyosdi'],
            [subject: 'SG3', object: '', present: 'ugohniyoga', habitual: 'ugohniyogoi', remote_past: 'ugohniyojvi', imperative: 'ugohniyogi', infinitive: 'ugohniyosdi'],
            [subject: 'PL3', object: '', present: 'unigohniyoga', habitual: 'unigohniyogoi', remote_past: 'unigohniyojvi', imperative: 'unigohniyogi', infinitive: 'unigohniyosdi'],
            [subject: 'PL1INCL', object: '', present: 'igigohniyoga', habitual: 'igigohniyogoi', remote_past: 'igigohniyojvi', imperative: 'igigohniyogi', infinitive: 'igigohniyosdi']
        ]
    ]

    @Unroll
    def "conjugating Ugohniyoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ugohniyoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agigohniyoga"
        "SG1" | "" | Tense.HABITUAL        | "agigohniyogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigohniyojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agigohniyogi"
        "SG1" | "" | Tense.INFINITIVE      | "agigohniyosdi"
        "SG2" | "" | Tense.PRESENT         | "jagohniyoga"
        "SG2" | "" | Tense.HABITUAL        | "jagohniyogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jagohniyojvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jagohniyogi"
        "SG2" | "" | Tense.INFINITIVE      | "jagohniyosdi"
        "SG3" | "" | Tense.PRESENT         | "ugohniyoga"
        "SG3" | "" | Tense.HABITUAL        | "ugohniyogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugohniyojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugohniyogi"
        "SG3" | "" | Tense.INFINITIVE      | "ugohniyosdi"
        "PL3" | "" | Tense.PRESENT         | "unigohniyoga"
        "PL3" | "" | Tense.HABITUAL        | "unigohniyogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigohniyojvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unigohniyogi"
        "PL3" | "" | Tense.INFINITIVE      | "unigohniyosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igigohniyoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igigohniyogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigohniyojvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igigohniyogi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigohniyosdi"
    }
}
