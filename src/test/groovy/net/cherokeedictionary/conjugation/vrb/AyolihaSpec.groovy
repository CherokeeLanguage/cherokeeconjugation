package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyolihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Greeting Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoliha', habitual: 'jiyolihoi', remote_past: 'jiyolilvi', imperative: 'jiyoliga', infinitive: 'jiyolisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyoliha', habitual: 'hiyolihoi', remote_past: 'hiyolilvi', imperative: 'hiyoliga', infinitive: 'hiyolisdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayoliha', habitual: 'ayolihoi', remote_past: 'uyolilvi', imperative: 'ayoliga', infinitive: 'uyolisdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyoliha', habitual: 'aniyolihoi', remote_past: 'uniyolilvi', imperative: 'aniyoliga', infinitive: 'uniyolisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'ediyoliha', habitual: 'ediyolihoi', remote_past: 'ediyolilvi', imperative: 'ediyoliga', infinitive: 'ediyolisdi']
        ]
    ]

    @Unroll
    def "conjugating Ayoliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayoliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoliha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyolihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyolilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyoliga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyolisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyoliha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyolihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyolilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyoliga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyolisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayoliha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayolihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyolilvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayoliga"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyolisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyoliha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyolihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyolilvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyoliga"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyolisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyoliha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyolihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ediyolilvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyoliga"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyolisdi"
    }
}
