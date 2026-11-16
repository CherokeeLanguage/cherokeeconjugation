// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72371 (entrya ahltawoa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhltawoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Combing His/Her Own Hair",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galitawoa'],
            [subject: 'SG1', object: '', present: 'galitawoa', habitual: 'galitawosgoi', remote_past: 'agwahltawovi', imperative: 'galitawoja', infinitive: 'agwahltawosdi'],
            [subject: 'SG2', object: '', present: 'hahltawoa', habitual: 'hahltawosgoi', remote_past: 'jahltawovi', imperative: 'hahltawoja', infinitive: 'jahltawosdi'],
            [subject: 'SG3', object: '', habitual: 'ahltawosgoi', imperative: 'hahltawoja', infinitive: 'uhltawosdi', present: 'ahltawoa', remote_past: 'uhltawovi'],
            [subject: 'PL3', object: '', present: 'danahltawoa', habitual: 'danahltawosgoi', remote_past: 'dunahltawovi', imperative: 'dinahltawoja', infinitive: 'junahltawosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedahltawoa', habitual: 'dedahltawosgoi', remote_past: 'degahltawovi', imperative: 'didahltawoja', infinitive: 'digahltawosdi']
        ]
    ]

    @Unroll
    def "conjugating Ahltawoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahltawoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galotawoa"
        "SG1" | "" | Tense.HABITUAL        | "galotawosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualotawovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galotawovi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualotawosdi"
        "SG2" | "" | Tense.PRESENT         | "halotawoa"
        "SG2" | "" | Tense.HABITUAL        | "halotawosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalotawovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halotawovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalotawosdi"
        "SG3" | "" | Tense.PRESENT         | "alotawoa"
        "SG3" | "" | Tense.HABITUAL        | "alotawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulotawovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alotawovi"
        "SG3" | "" | Tense.INFINITIVE      | "ulotawosdi"
        "PL3" | "" | Tense.PRESENT         | "analotawoa"
        "PL3" | "" | Tense.HABITUAL        | "analotawosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalotawovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analotawovi"
        "PL3" | "" | Tense.INFINITIVE      | "unalotawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalotawoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalotawosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalotawovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalotawovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalotawosdi"
    }
}
