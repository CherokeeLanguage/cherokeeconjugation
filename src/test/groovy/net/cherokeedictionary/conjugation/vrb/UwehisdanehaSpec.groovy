package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwehisdanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Aching, Hurting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwehisdaneha', habitual: 'agwehisdanehoi', remote_past: 'agwehisdanelvi', imperative: 'agwehisdasi', infinitive: 'agwehisdanehdi'],
            [subject: 'SG2', object: '', present: 'jehisdaneha', habitual: 'jehisdanehoi', remote_past: 'jehisdanelvi', imperative: 'jehisdasi', infinitive: 'jehisdanehdi'],
            [subject: 'SG3', object: '', present: 'uwehisdaneha', habitual: 'uwehisdanehoi', remote_past: 'uwehisdanelvi', imperative: 'uwehisdasi', infinitive: 'uwehisdanehdi'],
            [subject: 'PL3', object: '', present: 'unehisdaneha', habitual: 'unehisdanehoi', remote_past: 'unehisdanelvi', imperative: 'unehisdasi', infinitive: 'unehisdanehdi'],
            [subject: 'PL1INCL', object: '', present: 'igehisdaneha', habitual: 'igehisdanehoi', remote_past: 'igehisdanelvi', imperative: 'igehisdasi', infinitive: 'igehisdanehdi']
        ]
    ]

    @Unroll
    def "conjugating Uwehisdaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwehisdaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwehisdaneha"
        "SG1" | "" | Tense.HABITUAL        | "agwehisdanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwehisdanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwehisdasi"
        "SG1" | "" | Tense.INFINITIVE      | "agwehisdanehdi"
        "SG2" | "" | Tense.PRESENT         | "jehisdaneha"
        "SG2" | "" | Tense.HABITUAL        | "jehisdanehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jehisdanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jehisdasi"
        "SG2" | "" | Tense.INFINITIVE      | "jehisdanehdi"
        "SG3" | "" | Tense.PRESENT         | "uwehisdaneha"
        "SG3" | "" | Tense.HABITUAL        | "uwehisdanehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehisdanelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwehisdasi"
        "SG3" | "" | Tense.INFINITIVE      | "uwehisdanehdi"
        "PL3" | "" | Tense.PRESENT         | "unehisdaneha"
        "PL3" | "" | Tense.HABITUAL        | "unehisdanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unehisdanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unehisdasi"
        "PL3" | "" | Tense.INFINITIVE      | "unehisdanehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igehisdaneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igehisdanehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igehisdanelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igehisdasi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igehisdanehdi"
    }
}
