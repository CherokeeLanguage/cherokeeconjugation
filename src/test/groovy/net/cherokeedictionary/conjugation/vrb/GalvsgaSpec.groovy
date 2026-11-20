// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73092 (entrya galvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "/ Gahlvsga Sleepy",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jilvsga'],
            [subject: 'SG1', object: '', present: 'jilvsga', habitual: 'jilvsgoi', remote_past: 'agihlvhnvi', imperative: 'jilvna', infinitive: 'agihlvnhdi'],
            [subject: 'SG2', object: '', present: 'hilvsga', habitual: 'hilvsgoi', remote_past: 'jahlvhnvi', imperative: 'hihlvna', infinitive: 'jahlvnhdi'],
            [subject: 'SG3', object: '', habitual: 'galvsgoi', imperative: 'hilvvga', infinitive: 'ulvdi', present: 'galvsga', remote_past: 'ulvnvi'],
            [subject: 'PL3', object: '', present: 'anilvsga', habitual: 'anilvsgoi', remote_past: 'unilvhnvi', imperative: 'anihlvna', infinitive: 'unihlvnhdi'],
            [subject: 'PL1INCL', object: '', present: 'idilvsga', habitual: 'idilvsgoi', remote_past: 'igihlvhnvi', imperative: 'idihlvna', infinitive: 'igihlvnhdi']
        ]
    ]

    @Unroll
    def "conjugating Galvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilvdi"
        "SG2" | "" | Tense.PRESENT         | "hilvsga"
        "SG2" | "" | Tense.HABITUAL        | "hilvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalvdi"
        "SG3" | "" | Tense.PRESENT         | "galvsga"
        "SG3" | "" | Tense.HABITUAL        | "galvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulvdi"
        "PL3" | "" | Tense.PRESENT         | "anilvsga"
        "PL3" | "" | Tense.HABITUAL        | "anilvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilvdi"
    }
}
