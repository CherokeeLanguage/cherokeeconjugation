package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (long)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyia', habitual: 'jiyisgoi', remote_past: 'agiyvhvi', imperative: 'jiya', infinitive: 'agiyhdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyiha', habitual: 'hiyisgoi', remote_past: 'jayvhvi', imperative: 'hiya', infinitive: 'jayhdi'],
            [subject: 'SG3', object: '', present: 'ayiha', habitual: 'ayisgoi', remote_past: 'uyvhvi', imperative: 'waya', infinitive: 'uyhdi'],
            [subject: 'PL3', object: '', present: 'aniyiha', habitual: 'aniyisgoi', remote_past: 'uniyvhvi', imperative: 'waniya', infinitive: 'uniyhdi']
        ]
    ]

    @Unroll
    def "conjugating Ayiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiya"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyhdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiya"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayhdi"
        "SG3" | "" | Tense.PRESENT         | "ayiha"
        "SG3" | "" | Tense.HABITUAL        | "ayisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waya"
        "SG3" | "" | Tense.INFINITIVE      | "uyhdi"
        "PL3" | "" | Tense.PRESENT         | "aniyiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waniya"
        "PL3" | "" | Tense.INFINITIVE      | "uniyhdi"
    }
}
