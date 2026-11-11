package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwelihiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Worried / Anxious",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwelihia', habitual: 'agwelihisgoi', remote_past: 'agwelihisgvi', imperative: 'agwelihisgesdi', infinitive: 'agwelihisdi'],
            [subject: 'SG2', object: '', present: 'jelihia', habitual: 'jelihisgoi', remote_past: 'jelihisgvi', imperative: 'jelihisgesdi', infinitive: 'jelihisdi'],
            [subject: 'SG3', object: '', present: 'uwelihia', habitual: 'uwelihisgoi', remote_past: 'uwelihisgvi', imperative: 'uwelihisgesdi', infinitive: 'uwelihisdi'],
            [subject: 'PL3', object: '', present: 'unelihia', habitual: 'unelihisgoi', remote_past: 'unelihisgvi', imperative: 'unelihisgesdi', infinitive: 'unelihisdi'],
            [subject: 'PL1INCL', object: '', present: 'igelihia', habitual: 'igelihisgoi', remote_past: 'igelihisgvi', imperative: 'igelihisgesdi', infinitive: 'igelihisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwelihia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwelihia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwelihia"
        "SG1" | "" | Tense.HABITUAL        | "agwelihisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwelihisgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwelihisgesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agwelihisdi"
        "SG2" | "" | Tense.PRESENT         | "jelihia"
        "SG2" | "" | Tense.HABITUAL        | "jelihisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jelihisgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jelihisgesdi"
        "SG2" | "" | Tense.INFINITIVE      | "jelihisdi"
        "SG3" | "" | Tense.PRESENT         | "uwelihia"
        "SG3" | "" | Tense.HABITUAL        | "uwelihisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwelihisgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwelihisgesdi"
        "SG3" | "" | Tense.INFINITIVE      | "uwelihisdi"
        "PL3" | "" | Tense.PRESENT         | "unelihia"
        "PL3" | "" | Tense.HABITUAL        | "unelihisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unelihisgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unelihisgesdi"
        "PL3" | "" | Tense.INFINITIVE      | "unelihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igelihia"
        "PL1INCL" | "" | Tense.HABITUAL        | "igelihisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igelihisgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igelihisgesdi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igelihisdi"
    }
}
