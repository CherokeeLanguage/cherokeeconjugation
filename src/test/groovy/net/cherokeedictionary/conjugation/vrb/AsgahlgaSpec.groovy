// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72593 (entrya asgahlga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgahlgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Biting Him/It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisgahlga'],
            [subject: 'SG1', object: '', present: 'jisgahlga', habitual: 'jisgahlgoi', remote_past: 'aksgahljvi', imperative: 'jisgala', infinitive: 'aksgalsdi'],
            [subject: 'SG2', object: '', present: 'hisgahlga', habitual: 'hisgahlgoi', remote_past: 'tsgahljvi', imperative: 'hisgala', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'asgahlgoi', imperative: 'hisgala, hisgala', infinitive: 'usgalsdi', present: 'asgahlga', remote_past: 'usgahljvi'],
            [subject: 'PL3', object: '', present: 'anisgahlga', habitual: 'anisgahlgoi', remote_past: 'unisgahljvi', imperative: 'anisgala', infinitive: 'unisgalsdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgahlga', habitual: 'idisgahlgoi', remote_past: 'igisgahljvi', imperative: 'idisgala', infinitive: 'igisgalsdi']
        ]
    ]

    @Unroll
    def "conjugating Asgahlga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgahlga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisgaloga"
        "SG1" | "" | Tense.HABITUAL        | "tsisgalogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisgalotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisgalotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgalsdi"
        "SG2" | "" | Tense.PRESENT         | "hisgaloga"
        "SG2" | "" | Tense.HABITUAL        | "hisgalogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasgalotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgalotsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "asgaloga"
        "SG3" | "" | Tense.HABITUAL        | "asgalogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgalotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wasgalotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgalsdi"
        "PL3" | "" | Tense.PRESENT         | "anisgaloga"
        "PL3" | "" | Tense.HABITUAL        | "anisgalogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgalotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgalotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgalsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgaloga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgalogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgalotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgalotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgalsdi"
    }
}
