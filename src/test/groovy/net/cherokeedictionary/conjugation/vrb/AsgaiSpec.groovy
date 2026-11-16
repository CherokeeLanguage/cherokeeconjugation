package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgaiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Afraid",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisgai', habitual: 'jisgaoi', remote_past: 'aksgalvi', imperative: 'jisgaya', infinitive: 'aksgasdi'],
            [subject: 'SG2', object: '', present: 'hisgai', habitual: 'hisgaoi', remote_past: 'tsgalvi', imperative: 'hisgaya', infinitive: 'tsgasdi'],
            [subject: 'SG3', object: '', present: 'asgai', habitual: 'asgaoi', remote_past: 'usgalvi', imperative: 'asgaya', infinitive: 'usgasdi'],
            [subject: 'PL3', object: '', present: 'anisgai', habitual: 'anisgaoi', remote_past: 'unsgalvi', imperative: 'anisgaya', infinitive: 'unsgasdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgai', habitual: 'idisgaoi', remote_past: 'iksgalvi', imperative: 'idisgaya', infinitive: 'iksgasdi']
        ]
    ]

    @Unroll
    def "conjugating Asgai (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgai", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisgai"
        "SG1" | "" | Tense.HABITUAL        | "tsisgaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisgalvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisgalvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisgasdi"
        "SG2" | "" | Tense.PRESENT         | "hisgai"
        "SG2" | "" | Tense.HABITUAL        | "hisgaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasgalvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgalvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasgasdi"
        "SG3" | "" | Tense.PRESENT         | "asgai"
        "SG3" | "" | Tense.HABITUAL        | "asgaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgalvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgalvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgasdi"
        "PL3" | "" | Tense.PRESENT         | "anisgai"
        "PL3" | "" | Tense.HABITUAL        | "anisgaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgalvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgalvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgai"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgaoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgalvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgalvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgasdi"
    }
}
