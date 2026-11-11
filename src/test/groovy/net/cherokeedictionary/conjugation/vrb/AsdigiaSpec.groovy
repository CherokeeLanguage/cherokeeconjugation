package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdigiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisdigia', habitual: 'jisdigisgoi', remote_past: 'aksdigvi', imperative: 'jisdiga', infinitive: 'aksdigisdi'],
            [subject: 'SG2', object: '', present: 'hisdigia', habitual: 'hisdigisgoi', remote_past: 'tsdigvi', imperative: 'hisdiga', infinitive: 'tsdigisdi'],
            [subject: 'SG3', object: '', present: 'asdigia', habitual: 'asdigisgoi', remote_past: 'usdigvi', imperative: 'asdiga', infinitive: 'usdigisdi'],
            [subject: 'PL3', object: '', present: 'anisdigia', habitual: 'anisdigisgoi', remote_past: 'unisdigvi', imperative: 'anisdiga', infinitive: 'unisdigisdi']
        ]
    ]

    @Unroll
    def "conjugating Asdigia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdigia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdigia"
        "SG1" | "" | Tense.HABITUAL        | "jisdigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksdigvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisdiga"
        "SG1" | "" | Tense.INFINITIVE      | "aksdigisdi"
        "SG2" | "" | Tense.PRESENT         | "hisdigia"
        "SG2" | "" | Tense.HABITUAL        | "hisdigisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdigvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdiga"
        "SG2" | "" | Tense.INFINITIVE      | "tsdigisdi"
        "SG3" | "" | Tense.PRESENT         | "asdigia"
        "SG3" | "" | Tense.HABITUAL        | "asdigisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdigvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdiga"
        "SG3" | "" | Tense.INFINITIVE      | "usdigisdi"
        "PL3" | "" | Tense.PRESENT         | "anisdigia"
        "PL3" | "" | Tense.HABITUAL        | "anisdigisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdigvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdiga"
        "PL3" | "" | Tense.INFINITIVE      | "unisdigisdi"
    }
}
