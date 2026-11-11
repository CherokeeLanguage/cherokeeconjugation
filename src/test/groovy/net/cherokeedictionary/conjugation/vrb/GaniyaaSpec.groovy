package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaniyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiniyaa', habitual: 'jiniyasgoi', remote_past: 'aginiyvi', imperative: 'jiniya', infinitive: 'aginiyasdi'],
            [subject: 'SG2', object: '', present: 'hiniyaa', habitual: 'hiniyasgoi', remote_past: 'janiyvi', imperative: 'hiniya', infinitive: 'janiyasdi'],
            [subject: 'SG1', object: '', present: 'ganiyaa', habitual: 'ganiyasgoi', remote_past: 'uniyvi', imperative: 'ganiya', infinitive: 'uniyasdi'],
            [subject: 'PL3', object: '', present: 'aniniyaa', habitual: 'aniniyasgoi', remote_past: 'uniniyvi', imperative: 'aniniya', infinitive: 'uniniyasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiniyaa"
        "SG1" | "" | Tense.HABITUAL        | "jiniyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiniya"
        "SG1" | "" | Tense.INFINITIVE      | "aginiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hiniyaa"
        "SG2" | "" | Tense.HABITUAL        | "hiniyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiniya"
        "SG2" | "" | Tense.INFINITIVE      | "janiyasdi"
        "SG1" | "" | Tense.PRESENT         | "ganiyaa"
        "SG1" | "" | Tense.HABITUAL        | "ganiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uniyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganiya"
        "SG1" | "" | Tense.INFINITIVE      | "uniyasdi"
        "PL3" | "" | Tense.PRESENT         | "aniniyaa"
        "PL3" | "" | Tense.HABITUAL        | "aniniyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniniyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniniya"
        "PL3" | "" | Tense.INFINITIVE      | "uniniyasdi"
    }
}
