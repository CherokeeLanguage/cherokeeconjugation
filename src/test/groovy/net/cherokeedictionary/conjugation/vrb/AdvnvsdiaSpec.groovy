package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdvnvsdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Ready",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadvnvsdia', habitual: 'gadvnvsdisgoi', remote_past: 'agwadvnvstanvi', imperative: 'gadvnvsda', infinitive: 'agwadvnvsdohdi'],
            [subject: 'SG2', object: '', present: 'hadvnvsdia', habitual: 'hadvnvsdisgoi', remote_past: 'jadvnvstanvi', imperative: 'hadvnvsda', infinitive: 'jadvnvsdohdi'],
            [subject: 'SG3', object: '', present: 'advnvsdia', habitual: 'advnvsdisgoi', remote_past: 'udvnvstanvi', imperative: 'advnvsda', infinitive: 'udvnvsdohdi'],
            [subject: 'PL3', object: '', present: 'anadvnvsdia', habitual: 'anadvnvsdisgoi', remote_past: 'anadvnvstanvi', imperative: 'anadvnvsda', infinitive: 'unadvnvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadvnvsdia', habitual: 'idadvnvsdisgoi', remote_past: 'igadvnvstanvi', imperative: 'idadvnvsda', infinitive: 'igadvnvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Advnvsdia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Advnvsdia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvnvsdia"
        "SG1" | "" | Tense.HABITUAL        | "gadvnvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadvnvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnvsda"
        "SG1" | "" | Tense.INFINITIVE      | "agwadvnvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "hadvnvsdia"
        "SG2" | "" | Tense.HABITUAL        | "hadvnvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvnvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvnvsda"
        "SG2" | "" | Tense.INFINITIVE      | "jadvnvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "advnvsdia"
        "SG3" | "" | Tense.HABITUAL        | "advnvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvnvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advnvsda"
        "SG3" | "" | Tense.INFINITIVE      | "udvnvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "anadvnvsdia"
        "PL3" | "" | Tense.HABITUAL        | "anadvnvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "anadvnvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadvnvsda"
        "PL3" | "" | Tense.INFINITIVE      | "unadvnvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadvnvsdia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadvnvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadvnvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadvnvsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadvnvsdohdi"
    }
}
