// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72518 (entrya alsdayvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsdayvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eating (Meal)s",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisdayvhvsga'],
            [subject: 'SG1', object: '', present: 'galisdayvhvsga', habitual: 'galisdayvhvsgoi', remote_past: 'agwalsdayvhnvi', imperative: 'galisdayvhvga', infinitive: 'agwalsdayhdi'],
            [subject: 'SG2', object: '', present: 'halisdayvhvsga', habitual: 'halisdayvhvsgoi', remote_past: 'jalsdayvhnvi', imperative: 'halisdayvhvga', infinitive: 'jalsdayhdi'],
            [subject: 'SG3', object: '', habitual: 'alsdayvhvsgoi', imperative: 'halsdayvhvga', infinitive: 'ulsdayhdi', present: 'alsdayvhvsga', remote_past: 'ulsdayvhnvi'],
            [subject: 'PL3', object: '', present: 'analsdayvhvsga', habitual: 'analsdayvhvsgoi', remote_past: 'unalsdayvhnvi', imperative: 'analsdayvhvga', infinitive: 'unalsdayhdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsdayvhvsga', habitual: 'idalsdayvhvsgoi', remote_past: 'igalsdayvhnvi', imperative: 'idalsdayvhvga', infinitive: 'igalsdayhdi']
        ]
    ]

    @Unroll
    def "conjugating Alsdayvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsdayvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisdayvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "galisdayvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsdayvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwalsdayvhnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsdayhdi"
        "SG2" | "" | Tense.PRESENT         | "halisdayvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "halisdayvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsdayvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jalsdayvhnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalsdayhdi"
        "SG3" | "" | Tense.PRESENT         | "alsdayvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "alsdayvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsdayvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulsdayvhnvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulsdayhdi"
        "PL3" | "" | Tense.PRESENT         | "analsdayvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "analsdayvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsdayvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unalsdayvhnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalsdayhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsdayvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsdayvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsdayvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igalsdayvhnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsdayhdi"
    }
}
