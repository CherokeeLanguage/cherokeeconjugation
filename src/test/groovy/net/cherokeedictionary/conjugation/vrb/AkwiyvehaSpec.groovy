package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkwiyvehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Paying (Him)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyagwiyveha', habitual: 'jiyagwiyvehoi', remote_past: 'jiyagwiyvelvi', imperative: 'jiyagwiyvsi', infinitive: 'jiyagwiyvehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyagwiyveha', habitual: 'hiyagwiyvehoi', remote_past: 'hiyakwiyvelvi', imperative: 'hiyagwiyvsi', infinitive: 'hiyakwiyvehdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'akwiyveha', habitual: 'akwiyvehoi', remote_past: 'ukwiyvelvi', imperative: 'akwiyvsi', infinitive: 'ukwiyvehdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anakwiyveha', habitual: 'anakwiyvehoi', remote_past: 'unakwiyvelvi', imperative: 'anakwiyvsi', infinitive: 'unakwiyvehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edakwiyveha', habitual: 'edakwiyvehoi', remote_past: 'edakwiyvelvi', imperative: 'edakwiyvsi', infinitive: 'egakwiyvehdi']
        ]
    ]

    @Unroll
    def "conjugating Akwiyveha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akwiyveha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyagwiyveha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyagwiyvehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyagwiyvelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyagwiyvsi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyagwiyvehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagwiyveha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagwiyvehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakwiyvelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagwiyvsi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakwiyvehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "akwiyveha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "akwiyvehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "ukwiyvelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "akwiyvsi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "ukwiyvehdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anakwiyveha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anakwiyvehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unakwiyvelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anakwiyvsi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unakwiyvehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edakwiyveha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edakwiyvehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edakwiyvelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edakwiyvsi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "egakwiyvehdi"
    }
}
