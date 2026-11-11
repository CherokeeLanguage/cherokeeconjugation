package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnehldihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Trying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganehldia', habitual: 'ganehldisgoi', remote_past: 'agwanehltanvi', imperative: 'ganehlda', infinitive: 'agwanehldohdi'],
            [subject: 'SG2', object: '', present: 'hanehldiha', habitual: 'hanehldisgoi', remote_past: 'janehltanvi', imperative: 'hanehlda', infinitive: 'janehldohdi'],
            [subject: 'SG3', object: '', present: 'anehldiha', habitual: 'anehldisgoi', remote_past: 'unehltanvi', imperative: 'anehlda', infinitive: 'unehldohdi'],
            [subject: 'PL3', object: '', present: 'ananehldiha', habitual: 'ananehldisgoi', remote_past: 'unanehltanvi', imperative: 'ananehlda', infinitive: 'unanehldohdi'],
            [subject: 'PL1INCL', object: '', present: 'idanehldiha', habitual: 'idanehldisgoi', remote_past: 'iganehltanvi', imperative: 'idanehlda', infinitive: 'iganehldohdi']
        ]
    ]

    @Unroll
    def "conjugating Anehldiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anehldiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganehldia"
        "SG1" | "" | Tense.HABITUAL        | "ganehldisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwanehltanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehlda"
        "SG1" | "" | Tense.INFINITIVE      | "agwanehldohdi"
        "SG2" | "" | Tense.PRESENT         | "hanehldiha"
        "SG2" | "" | Tense.HABITUAL        | "hanehldisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehltanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanehlda"
        "SG2" | "" | Tense.INFINITIVE      | "janehldohdi"
        "SG3" | "" | Tense.PRESENT         | "anehldiha"
        "SG3" | "" | Tense.HABITUAL        | "anehldisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unehltanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anehlda"
        "SG3" | "" | Tense.INFINITIVE      | "unehldohdi"
        "PL3" | "" | Tense.PRESENT         | "ananehldiha"
        "PL3" | "" | Tense.HABITUAL        | "ananehldisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanehltanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananehlda"
        "PL3" | "" | Tense.INFINITIVE      | "unanehldohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanehldiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanehldisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganehltanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanehlda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganehldohdi"
    }
}
