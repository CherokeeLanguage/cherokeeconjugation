// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72496 (entrya alehvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Standing (In A Certain Spot)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galevsga'],
            [subject: 'SG1', object: '', present: 'galevsga', habitual: 'galevsgoi', remote_past: 'agwalehnvi', imperative: 'galehvga', infinitive: 'agwalehdi'],
            [subject: 'SG2', object: '', present: 'halehvsga', habitual: 'halehvsgoi', remote_past: 'jalehnvi', imperative: 'halehvga', infinitive: 'jalehdi'],
            [subject: 'SG3', object: '', habitual: 'alehvsgoi', imperative: 'halehvga', infinitive: 'ulehdi', present: 'alehvsga', remote_past: 'ulehnvi'],
            [subject: 'PL3', object: '', present: 'analehvsga', habitual: 'analehvsgoi', remote_past: 'unalehnvi', imperative: 'analehvga', infinitive: 'unalehdi'],
            [subject: 'PL1INCL', object: '', present: 'idalehvsga', habitual: 'idalehvsgoi', remote_past: 'igalehnvi', imperative: 'idalehvga', infinitive: 'igalehdi']
        ]
    ]

    @Unroll
    def "conjugating Alehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galevsga"
        "SG1" | "" | Tense.HABITUAL        | "galevsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galenvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalehdi"
        "SG2" | "" | Tense.PRESENT         | "halehvsga"
        "SG2" | "" | Tense.HABITUAL        | "halehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halenvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalehdi"
        "SG3" | "" | Tense.PRESENT         | "alehvsga"
        "SG3" | "" | Tense.HABITUAL        | "alehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alenvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulehdi"
        "PL3" | "" | Tense.PRESENT         | "analehvsga"
        "PL3" | "" | Tense.HABITUAL        | "analehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalehnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analenvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalehnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalenvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalehdi"
    }
}
