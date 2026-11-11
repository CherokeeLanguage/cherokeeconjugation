package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DekanogiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Singing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejinogia', habitual: 'dejinogisgoi', remote_past: 'dakihnogisvi', imperative: 'dijinogi', infinitive: 'dikihnogisdi'],
            [subject: 'SG2', object: '', present: 'dehihnogia', habitual: 'dehihnogisgoi', remote_past: 'dejahnogisvi', imperative: 'tihnogi', infinitive: 'dijahnogisdi'],
            [subject: 'SG3', object: '', present: 'dekanogia', habitual: 'dekanogisgoi', remote_past: 'duhnogisvi', imperative: 'dikanogi', infinitive: 'juhnogisdi'],
            [subject: 'PL3', object: '', present: 'danihnogia', habitual: 'danihnogisgoi', remote_past: 'dunihnogisvi', imperative: 'dinihnogi', infinitive: 'junihnogisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedihnogia', habitual: 'dedihnogisgoi', remote_past: 'degihnogisvi', imperative: 'didihnogi', infinitive: 'digihnogisdi']
        ]
    ]

    @Unroll
    def "conjugating Dekanogia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dekanogia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejinogia"
        "SG1" | "" | Tense.HABITUAL        | "dejinogisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dakihnogisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijinogi"
        "SG1" | "" | Tense.INFINITIVE      | "dikihnogisdi"
        "SG2" | "" | Tense.PRESENT         | "dehihnogia"
        "SG2" | "" | Tense.HABITUAL        | "dehihnogisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejahnogisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tihnogi"
        "SG2" | "" | Tense.INFINITIVE      | "dijahnogisdi"
        "SG3" | "" | Tense.PRESENT         | "dekanogia"
        "SG3" | "" | Tense.HABITUAL        | "dekanogisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhnogisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikanogi"
        "SG3" | "" | Tense.INFINITIVE      | "juhnogisdi"
        "PL3" | "" | Tense.PRESENT         | "danihnogia"
        "PL3" | "" | Tense.HABITUAL        | "danihnogisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunihnogisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinihnogi"
        "PL3" | "" | Tense.INFINITIVE      | "junihnogisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedihnogia"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedihnogisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degihnogisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didihnogi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digihnogisdi"
    }
}
