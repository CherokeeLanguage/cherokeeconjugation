package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwayaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwvya', habitual: 'agwvyoi', remote_past: 'agwvyvi', imperative: 'agwvyesdi', infinitive: 'agwvdisdi'],
            [subject: 'SG3', object: '', present: 'jvya', habitual: 'jvyoi', remote_past: 'jvyvi', imperative: 'jvyesdi', infinitive: 'jvdisdi'],
            [subject: 'SG3', object: '', present: 'uwaya', habitual: 'uwayoi', remote_past: 'uwayvi', imperative: 'uwayesdi', infinitive: 'udisdi'],
            [subject: 'SG3', object: '', present: 'unvya', habitual: 'unvyoi', remote_past: 'unvyvi', imperative: 'unvyesdi', infinitive: 'unvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwaya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwaya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwvya"
        "SG1" | "" | Tense.HABITUAL        | "agwvyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwvyesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agwvdisdi"
        "SG3" | "" | Tense.PRESENT         | "jvya"
        "SG3" | "" | Tense.HABITUAL        | "jvyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "jvyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jvyesdi"
        "SG3" | "" | Tense.INFINITIVE      | "jvdisdi"
        "SG3" | "" | Tense.PRESENT         | "uwaya"
        "SG3" | "" | Tense.HABITUAL        | "uwayoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwayvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwayesdi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "SG3" | "" | Tense.PRESENT         | "unvya"
        "SG3" | "" | Tense.HABITUAL        | "unvyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unvyesdi"
        "SG3" | "" | Tense.INFINITIVE      | "unvdisdi"
    }
}
