package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwohiyuhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Believe, Confident, Faith",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwohiyuha', habitual: 'agwohiyusoi', remote_past: 'agwohiyusvi', imperative: 'agwohiyusesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'johiyuha', habitual: 'johiyusoi', remote_past: 'johiyusvi', imperative: 'johiyusesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'uwohiyuha', habitual: 'uwohiyusoi', remote_past: 'uwohiyusvi', imperative: 'uwohiyusesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unohiyuha', habitual: 'unohiyusoi', remote_past: 'unohiyusvi', imperative: 'unohiyusesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igohiyuha', habitual: 'igohiyusoi', remote_past: 'igohiyusvi', imperative: 'igohiyusesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uwohiyuha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwohiyuha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwohiyuha"
        "SG1" | "" | Tense.HABITUAL        | "agwohiyusoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwohiyusvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwohiyusesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "johiyuha"
        "SG2" | "" | Tense.HABITUAL        | "johiyusoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "johiyusvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "johiyusesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uwohiyuha"
        "SG3" | "" | Tense.HABITUAL        | "uwohiyusoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwohiyusvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwohiyusesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unohiyuha"
        "PL3" | "" | Tense.HABITUAL        | "unohiyusoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unohiyusvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unohiyusesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igohiyuha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igohiyusoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igohiyusvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igohiyusesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
