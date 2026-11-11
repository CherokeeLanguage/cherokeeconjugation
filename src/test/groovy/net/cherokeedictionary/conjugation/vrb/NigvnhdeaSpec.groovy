package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigvnhdeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Taking It Off (147)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'nigvnhdea', habitual: 'nigvnhdesgoi', remote_past: 'nagwvnhdesvi', imperative: 'nigvnhdagi', infinitive: 'iyagwvnhdesdi'],
            [subject: 'SG2', object: '', present: 'hnvnhdea', habitual: 'hnvnhdesgoi', remote_past: 'nijvnhdesvi', imperative: 'hnvnhdagi', infinitive: 'iyijvnhdesdi'],
            [subject: 'SG3', object: '', present: 'nigvnhdea', habitual: 'nigvnhdesgoi', remote_past: 'nuwanhdesvi', imperative: 'nigvnhdagi', infinitive: 'iyuwanhdesdi'],
            [subject: 'PL3', object: '', present: 'nanvnhdea', habitual: 'nanvnhdesgoi', remote_past: 'nunvnhdesvi', imperative: 'nanvnhdagi', infinitive: 'iyunvnhdesdi'],
            [subject: 'PL1INCL', object: '', present: 'nidvnhdea', habitual: 'nidvnhdesgoi', remote_past: 'nigvnhdesvi', imperative: 'nidvnhdagi', infinitive: 'iyigvnhdesdi']
        ]
    ]

    @Unroll
    def "conjugating Nigvnhdea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigvnhdea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "nigvnhdea"
        "SG1" | "" | Tense.HABITUAL        | "nigvnhdesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "nagwvnhdesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "nigvnhdagi"
        "SG1" | "" | Tense.INFINITIVE      | "iyagwvnhdesdi"
        "SG2" | "" | Tense.PRESENT         | "hnvnhdea"
        "SG2" | "" | Tense.HABITUAL        | "hnvnhdesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "nijvnhdesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hnvnhdagi"
        "SG2" | "" | Tense.INFINITIVE      | "iyijvnhdesdi"
        "SG3" | "" | Tense.PRESENT         | "nigvnhdea"
        "SG3" | "" | Tense.HABITUAL        | "nigvnhdesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nuwanhdesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "nigvnhdagi"
        "SG3" | "" | Tense.INFINITIVE      | "iyuwanhdesdi"
        "PL3" | "" | Tense.PRESENT         | "nanvnhdea"
        "PL3" | "" | Tense.HABITUAL        | "nanvnhdesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "nunvnhdesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "nanvnhdagi"
        "PL3" | "" | Tense.INFINITIVE      | "iyunvnhdesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "nidvnhdea"
        "PL1INCL" | "" | Tense.HABITUAL        | "nidvnhdesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "nigvnhdesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "nidvnhdagi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iyigvnhdesdi"
    }
}
