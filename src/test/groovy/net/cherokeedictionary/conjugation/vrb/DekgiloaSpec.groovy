// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72834 (entrya dekgiloa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DekgiloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Washing Flexible Objects",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degvgiloa'],
            [subject: 'SG1', object: '', present: 'degvgiloa', habitual: 'degvgilosgoi', remote_past: 'dagwvgilovi', imperative: 'digvgiloja', infinitive: 'digwvgilosdi'],
            [subject: 'SG2', object: '', present: 'dehvgiloa', habitual: 'dehvgilosgoi', remote_past: 'dejvgilovi', imperative: 'tvhgiloja', infinitive: 'dijvgilosdi'],
            [subject: 'SG3', object: '', habitual: 'dekgilosgoi', imperative: 'tvhgiloja', infinitive: 'juhgilosdi', present: 'dekgiloa', remote_past: 'duhgilovi'],
            [subject: 'PL3', object: '', present: 'danvgiloa', habitual: 'danvgilosgoi', remote_past: 'dunvgilovi', imperative: 'dinvgiloja', infinitive: 'junhgilosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedvgiloa', habitual: 'dedvgilosgoi', remote_past: 'degvgilovi', imperative: 'didvgiloja', infinitive: 'digvgilosdi']
        ]
    ]

    @Unroll
    def "conjugating Dekgiloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dekgiloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigigiloa"
        "SG1" | "" | Tense.HABITUAL        | "tsigigilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquugilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gugilovi"
        "SG1" | "" | Tense.INFINITIVE      | "agigilosdi"
        "SG2" | "" | Tense.PRESENT         | "higigiloa"
        "SG2" | "" | Tense.HABITUAL        | "higigilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsugilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hugilovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagilosdi"
        "SG3" | "" | Tense.PRESENT         | "degigiloa"
        "SG3" | "" | Tense.HABITUAL        | "degigilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwugilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugilovi"
        "SG3" | "" | Tense.INFINITIVE      | "ugilosdi"
        "PL3" | "" | Tense.PRESENT         | "anigigiloa"
        "PL3" | "" | Tense.HABITUAL        | "anigigilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unugilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anugilovi"
        "PL3" | "" | Tense.INFINITIVE      | "unigilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigigiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigigilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igugilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idugilovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigilosdi"
    }
}
