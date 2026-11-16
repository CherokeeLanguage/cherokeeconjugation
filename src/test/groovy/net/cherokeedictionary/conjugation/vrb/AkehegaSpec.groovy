// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72449 (entrya akehega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkehegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Chasing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jikehega'],
            [subject: 'SG3', object: '', habitual: 'akehegoi', imperative: 'hikehuga, hikehuga', infinitive: 'ukehvsdi', present: 'akehega', remote_past: 'ukehvsvi'],
            [subject: 'PL3', object: '', present: 'anikehega', habitual: 'anikehegoi', remote_past: 'unikehvsvi', imperative: 'anikehuga', infinitive: 'unikehvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idikehega', habitual: 'idikehegoi', remote_past: 'igikehvsvi', imperative: 'idikehuga', infinitive: 'igikehvsdi']
        ]
    ]

    @Unroll
    def "conjugating Akehega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akehega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akehega"
        "SG1" | "" | Tense.HABITUAL        | "akehegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ukehvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ukehvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "ukehvsdi"
        "PL3" | "" | Tense.PRESENT         | "anikehega"
        "PL3" | "" | Tense.HABITUAL        | "anikehegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikehvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unikehvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unikehvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idikehega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idikehegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikehvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igikehvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igikehvsdi"
    }
}
