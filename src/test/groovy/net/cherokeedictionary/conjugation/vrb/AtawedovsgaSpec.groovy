package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtawedovsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Kissing (58)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidawedovsga', habitual: 'jidawedovsga', remote_past: 'agidawedonvi', imperative: 'jidawedovga', infinitive: 'agidawedodi'],
            [subject: 'SG2', object: '', present: 'hidawedovsga', habitual: 'hidawedovsgoi', remote_past: 'jadawedonvi', imperative: 'hidawedovga', infinitive: 'jadawedodi'],
            [subject: 'SG3', object: '', present: 'atawedovsga', habitual: 'atawedovsgoi', remote_past: 'utawedonvi', imperative: 'atawedovga', infinitive: 'utawedodi'],
            [subject: 'PL3', object: '', present: 'anidawedovsga', habitual: 'anidawedovsgoi', remote_past: 'unidawedonvi', imperative: 'anidawedovga', infinitive: 'unidawedodi'],
            [subject: 'PL1INCL', object: '', present: 'ididawedovsga', habitual: 'ididawedovsgoi', remote_past: 'igidawedonvi', imperative: 'ididawedovga', infinitive: 'igidawedodi']
        ]
    ]

    @Unroll
    def "conjugating Atawedovsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atawedovsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidawedovsga"
        "SG1" | "" | Tense.HABITUAL        | "jidawedovsga"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidawedonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jidawedovga"
        "SG1" | "" | Tense.INFINITIVE      | "agidawedodi"
        "SG2" | "" | Tense.PRESENT         | "hidawedovsga"
        "SG2" | "" | Tense.HABITUAL        | "hidawedovsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadawedonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidawedovga"
        "SG2" | "" | Tense.INFINITIVE      | "jadawedodi"
        "SG3" | "" | Tense.PRESENT         | "atawedovsga"
        "SG3" | "" | Tense.HABITUAL        | "atawedovsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utawedonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atawedovga"
        "SG3" | "" | Tense.INFINITIVE      | "utawedodi"
        "PL3" | "" | Tense.PRESENT         | "anidawedovsga"
        "PL3" | "" | Tense.HABITUAL        | "anidawedovsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidawedonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidawedovga"
        "PL3" | "" | Tense.INFINITIVE      | "unidawedodi"
        "PL1INCL" | "" | Tense.PRESENT         | "ididawedovsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "ididawedovsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igidawedonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ididawedovga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igidawedodi"
    }
}
