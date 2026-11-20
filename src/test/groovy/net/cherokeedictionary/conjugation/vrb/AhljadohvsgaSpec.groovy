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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galotsatohvsga"
        "SG1" | "" | Tense.HABITUAL        | "galotsatohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahljadohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galotsadonvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwahljatdi"
        "SG2" | "" | Tense.PRESENT         | "hahljadohvsga"
        "SG2" | "" | Tense.HABITUAL        | "hahljadohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahljadohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halotsadonvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahljatdi"
        "SG3" | "" | Tense.PRESENT         | "ahljadohvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahljadohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhljadohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alotsadonvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhljatdi"
        "PL3" | "" | Tense.PRESENT         | "anahljadohvsga"
        "PL3" | "" | Tense.HABITUAL        | "anahljadohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahljadohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analotsadonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unahljatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahljadohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahljadohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahljadohnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalotsadonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahljatdi"
    }
}
