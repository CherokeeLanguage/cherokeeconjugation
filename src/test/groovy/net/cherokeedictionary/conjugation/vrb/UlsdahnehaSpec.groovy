// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73881 (entrya ulsdahneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlsdahnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Happening",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwalsdahneha'],
            [subject: 'SG1', object: '', present: 'agwalsdahneha', habitual: 'agwalsdahnehoi', remote_past: 'agwalsdahnelvi', imperative: 'agwalsdasi', infinitive: 'agwalsdahnehdi'],
            [subject: 'SG2', object: '', present: 'jalsdahneha', habitual: 'jalsdahnehoi', remote_past: 'jalsdahnelvi', imperative: 'jalsdasi', infinitive: 'jalsdahnehdi'],
            [subject: 'SG3', object: '', habitual: 'ulsdahnehoi', imperative: 'jalsdasi', infinitive: 'ulsdahnehdi', present: 'ulsdahneha', remote_past: 'ulsdahnelvi'],
            [subject: 'PL3', object: '', present: 'unalsdahneha', habitual: 'unalsdahnehoi', remote_past: 'unalsdahnelvi', imperative: 'unalsdasi', infinitive: 'unalsdahnehdi'],
            [subject: 'PL1INCL', object: '', present: 'igalsdahneha', habitual: 'igalsdahnehoi', remote_past: 'igalsdahnelvi', imperative: 'igalsdasi', infinitive: 'igalsdahnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ulsdahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulsdahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aqualisdaneha"
        "SG1" | "" | Tense.HABITUAL        | "aqualisdanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualisdanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aqualisdanelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualisdanedi"
        "SG2" | "" | Tense.PRESENT         | "tsalisdaneha"
        "SG2" | "" | Tense.HABITUAL        | "tsalisdanehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalisdanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalisdanelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalisdanedi"
        "SG3" | "" | Tense.PRESENT         | "ulisdaneha"
        "SG3" | "" | Tense.HABITUAL        | "ulisdanehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisdanelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulisdanelvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisdanedi"
        "PL3" | "" | Tense.PRESENT         | "unalisdaneha"
        "PL3" | "" | Tense.HABITUAL        | "unalisdanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalisdanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unalisdanelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalisdanedi"
        "PL1INCL" | "" | Tense.PRESENT         | "igalisdaneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igalisdanehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalisdanelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igalisdanelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalisdanedi"
    }
}
