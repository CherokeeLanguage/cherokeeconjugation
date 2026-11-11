package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jineiyaa', habitual: 'jineiyasgoi', remote_past: 'aginehiyvi', imperative: 'jineiya', infinitive: 'aginehiyasdi'],
            [subject: 'SG2', object: '', present: 'hinehiyaa', habitual: 'hinehiyasgoi', remote_past: 'janehiyvi', imperative: 'hinehiya', infinitive: 'janehiyasdi'],
            [subject: 'SG1', object: '', present: 'ganehiyaa', habitual: 'ganehiyasgoi', remote_past: 'unehiyvi', imperative: 'ganehiya', infinitive: 'unehiyasdi'],
            [subject: 'PL3', object: '', present: 'aninehiyaa', habitual: 'aninehiyasgoi', remote_past: 'uninehiyvi', imperative: 'aninehiya', infinitive: 'uninehiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineiyaa"
        "SG1" | "" | Tense.HABITUAL        | "jineiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jineiya"
        "SG1" | "" | Tense.INFINITIVE      | "aginehiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hinehiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hinehiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehiya"
        "SG2" | "" | Tense.INFINITIVE      | "janehiyasdi"
        "SG1" | "" | Tense.PRESENT         | "ganehiyaa"
        "SG1" | "" | Tense.HABITUAL        | "ganehiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unehiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehiya"
        "SG1" | "" | Tense.INFINITIVE      | "unehiyasdi"
        "PL3" | "" | Tense.PRESENT         | "aninehiyaa"
        "PL3" | "" | Tense.HABITUAL        | "aninehiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehiya"
        "PL3" | "" | Tense.INFINITIVE      | "uninehiyasdi"
    }
}
