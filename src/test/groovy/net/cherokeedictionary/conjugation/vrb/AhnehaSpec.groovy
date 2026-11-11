package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jineha', habitual: 'jinehoi', remote_past: 'jinelvi', imperative: 'jihvsi', infinitive: 'jinehdi'],
            [subject: 'SG2', object: '', present: 'hihneha', habitual: 'hihnehoi', remote_past: 'hihnelvi', imperative: 'hihvsi', infinitive: 'hihnehdi'],
            [subject: 'SG3', object: '', present: 'ahneha', habitual: 'ahnehoi', remote_past: 'uhnelvi', imperative: 'ahvsi', infinitive: 'uhnehdi'],
            [subject: 'PL3', object: '', present: 'anihneha', habitual: 'anihnehoi', remote_past: 'unihnelvi', imperative: 'anihvsi', infinitive: 'unihnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineha"
        "SG1" | "" | Tense.HABITUAL        | "jinehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jihvsi"
        "SG1" | "" | Tense.INFINITIVE      | "jinehdi"
        "SG2" | "" | Tense.PRESENT         | "hihneha"
        "SG2" | "" | Tense.HABITUAL        | "hihnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihvsi"
        "SG2" | "" | Tense.INFINITIVE      | "hihnehdi"
        "SG3" | "" | Tense.PRESENT         | "ahneha"
        "SG3" | "" | Tense.HABITUAL        | "ahnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahvsi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnehdi"
        "PL3" | "" | Tense.PRESENT         | "anihneha"
        "PL3" | "" | Tense.HABITUAL        | "anihnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihvsi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnehdi"
    }
}
