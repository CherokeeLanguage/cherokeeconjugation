// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72365 (entrya ahljadohvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhljadohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Preaching",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galijadohvsga'],
            [subject: 'SG1', object: '', present: 'galijadohvsga', habitual: 'galijadohvsgoi', remote_past: 'agwahljadohnvi', imperative: 'galijadohvga', infinitive: 'agwahljatdi'],
            [subject: 'SG2', object: '', present: 'hahljadohvsga', habitual: 'hahljadohvsgoi', remote_past: 'jahljadohnvi', imperative: 'hahljadohvga', infinitive: 'jahljatdi'],
            [subject: 'SG3', object: '', habitual: 'ahljadohvsgoi', imperative: 'hahljadohvga', infinitive: 'uhljatdi', present: 'ahljadohvsga', remote_past: 'uhljadohnvi'],
            [subject: 'PL3', object: '', present: 'anahljadohvsga', habitual: 'anahljadohvsgoi', remote_past: 'unahljadohnvi', imperative: 'anahljadohvga', infinitive: 'unahljatdi'],
            [subject: 'PL1INCL', object: '', present: 'idahljadohvsga', habitual: 'idahljadohvsgoi', remote_past: 'igahljadohnvi', imperative: 'idahljadohvga', infinitive: 'igahljatdi']
        ]
    ]

    @Unroll
    def "conjugating Ahljadohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahljadohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galotsadohvsga"
        "SG1" | "" | Tense.HABITUAL        | "galotsadohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualotsadonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galotsadonvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualotsatidi"
        "SG2" | "" | Tense.PRESENT         | "halotsadohvsga"
        "SG2" | "" | Tense.HABITUAL        | "halotsadohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalotsadonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halotsadonvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalotsatidi"
        "SG3" | "" | Tense.PRESENT         | "alotsadohvsga"
        "SG3" | "" | Tense.HABITUAL        | "alotsadohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulotsadonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alotsadonvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulotsatidi"
        "PL3" | "" | Tense.PRESENT         | "analotsadohvsga"
        "PL3" | "" | Tense.HABITUAL        | "analotsadohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalotsadonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analotsadonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalotsatidi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalotsadohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalotsadohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalotsadonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalotsadonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalotsatidi"
    }
}
