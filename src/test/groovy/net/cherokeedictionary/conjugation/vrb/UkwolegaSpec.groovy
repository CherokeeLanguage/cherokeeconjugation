// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73864 (entrya ukwolega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UkwolegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "No Luck at Hunting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agikwolega'],
            [subject: 'SG1', object: '', present: 'agikwolega', habitual: 'agikwolegoi', remote_past: 'agikwolvsvi', imperative: 'agikwoluga', infinitive: 'agikwolvsdi'],
            [subject: 'SG2', object: '', present: 'jakwolega', habitual: 'jakwolegoi', remote_past: 'jakwolvsvi', imperative: 'jakwoluga', infinitive: 'jakwolvsdi'],
            [subject: 'SG3', object: '', habitual: 'ukwolegoi', imperative: 'jakwoluga', infinitive: 'ukwolvsdi', present: 'ukwolega', remote_past: 'ukwolvsvi'],
            [subject: 'PL3', object: '', present: 'unikwolega', habitual: 'unikwolegoi', remote_past: 'unikwolvsvi', imperative: 'unikwoluga', infinitive: 'unikwolvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igikwolega', habitual: 'igikwolegoi', remote_past: 'igikwolvsvi', imperative: 'igikwoluga', infinitive: 'igikwolvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ukwolega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ukwolega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agikwolega"
        "SG1" | "" | Tense.HABITUAL        | "agikwolegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agikwolvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiquolvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agikwolvsdi"
        "SG2" | "" | Tense.PRESENT         | "jakwolega"
        "SG2" | "" | Tense.HABITUAL        | "jakwolegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jakwolvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsaquolvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jakwolvsdi"
        "SG3" | "" | Tense.PRESENT         | "ukwolega"
        "SG3" | "" | Tense.HABITUAL        | "ukwolegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukwolvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uquolvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ukwolvsdi"
        "PL3" | "" | Tense.PRESENT         | "unikwolega"
        "PL3" | "" | Tense.HABITUAL        | "unikwolegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikwolvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniquolvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unikwolvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igikwolega"
        "PL1INCL" | "" | Tense.HABITUAL        | "igikwolegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikwolvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiquolvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igikwolvsdi"
    }
}
