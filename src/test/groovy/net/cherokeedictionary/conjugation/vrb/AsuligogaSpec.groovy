package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsuligogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Quitting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisuligoga', habitual: 'jisuligogoi', remote_past: 'aksuligojvi', imperative: 'jisuligoi', infinitive: 'aksuligosdi'],
            [subject: 'SG2', object: '', present: 'hisuligoga', habitual: 'hisuligogoi', remote_past: 'tsuligojvi', imperative: 'hisuligoi', infinitive: 'tsuligosdi'],
            [subject: 'SG3', object: '', present: 'asuligoga', habitual: 'asuligogoi', remote_past: 'usuligojvi', imperative: 'asuligoi', infinitive: 'usuligosdi'],
            [subject: 'PL3', object: '', present: 'anisuligoga', habitual: 'anisuligogoi', remote_past: 'unisuligojvi', imperative: 'anisuligoi', infinitive: 'unsuligosdi'],
            [subject: 'PL1INCL', object: '', present: 'idisuligoga', habitual: 'idisuligogoi', remote_past: 'iksuligojvi', imperative: 'idisuligoi', infinitive: 'iksuligosdi']
        ]
    ]

    @Unroll
    def "conjugating Asuligoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuligoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisuligoga"
        "SG1" | "" | Tense.HABITUAL        | "jisuligogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksuligojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisuligoi"
        "SG1" | "" | Tense.INFINITIVE      | "aksuligosdi"
        "SG2" | "" | Tense.PRESENT         | "hisuligoga"
        "SG2" | "" | Tense.HABITUAL        | "hisuligogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuligojvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisuligoi"
        "SG2" | "" | Tense.INFINITIVE      | "tsuligosdi"
        "SG3" | "" | Tense.PRESENT         | "asuligoga"
        "SG3" | "" | Tense.HABITUAL        | "asuligogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usuligojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asuligoi"
        "SG3" | "" | Tense.INFINITIVE      | "usuligosdi"
        "PL3" | "" | Tense.PRESENT         | "anisuligoga"
        "PL3" | "" | Tense.HABITUAL        | "anisuligogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisuligojvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisuligoi"
        "PL3" | "" | Tense.INFINITIVE      | "unsuligosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisuligoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisuligogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksuligojvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisuligoi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksuligosdi"
    }
}
