package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlitiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Running Away / Escaping (40)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galitia', habitual: 'galitisgoi', remote_past: 'agwalitisvi', imperative: 'galiti', infinitive: 'agwalitisdi'],
            [subject: 'SG2', object: '', present: 'halitia', habitual: 'halitisgoi', remote_past: 'jalitisvi', imperative: 'haliti', infinitive: 'jalitisdi'],
            [subject: 'SG3', object: '', present: 'alitia', habitual: 'alitisgoi', remote_past: 'ulitisvi', imperative: 'aliti', infinitive: 'ulitisdi'],
            [subject: 'PL3', object: '', present: 'analitia', habitual: 'analitisgoi', remote_past: 'unalitisvi', imperative: 'analiti', infinitive: 'unalitisdi'],
            [subject: 'PL1INCL', object: '', present: 'idalitia', habitual: 'idalitisgoi', remote_past: 'igalitisvi', imperative: 'idaliti', infinitive: 'igalitisdi']
        ]
    ]

    @Unroll
    def "conjugating Alitia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alitia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galitia"
        "SG1" | "" | Tense.HABITUAL        | "galitisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalitisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galiti"
        "SG1" | "" | Tense.INFINITIVE      | "agwalitisdi"
        "SG2" | "" | Tense.PRESENT         | "halitia"
        "SG2" | "" | Tense.HABITUAL        | "halitisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalitisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haliti"
        "SG2" | "" | Tense.INFINITIVE      | "jalitisdi"
        "SG3" | "" | Tense.PRESENT         | "alitia"
        "SG3" | "" | Tense.HABITUAL        | "alitisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulitisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aliti"
        "SG3" | "" | Tense.INFINITIVE      | "ulitisdi"
        "PL3" | "" | Tense.PRESENT         | "analitia"
        "PL3" | "" | Tense.HABITUAL        | "analitisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalitisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analiti"
        "PL3" | "" | Tense.INFINITIVE      | "unalitisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalitia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalitisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalitisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaliti"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalitisdi"
    }
}
