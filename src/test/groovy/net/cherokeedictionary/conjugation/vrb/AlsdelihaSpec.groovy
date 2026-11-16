// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72520 (entrya alsdeliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsdelihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Helping",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisdeliha'],
            [subject: 'SG1', object: '', present: 'galisdeliha', habitual: 'galisdelisgoi', remote_past: 'agwalsdelvhvi', imperative: 'galisdela', infinitive: 'agwalsdehldi'],
            [subject: 'SG2', object: '', present: 'halisdeliha', habitual: 'halisdelisgoi', remote_past: 'jalsdelvhvi', imperative: 'halsdela', infinitive: 'jalsdehldi'],
            [subject: 'SG3', object: '', habitual: 'alsdelisgoi', imperative: 'halsdela', infinitive: 'ulsdehldi', present: 'alsdeliha', remote_past: 'ulsdelvhvi'],
            [subject: 'PL3', object: '', present: 'analsdeliha', habitual: 'analsdelisgoi', remote_past: 'unalsdelvhvi', imperative: 'analsdela', infinitive: 'unalsdehldi'],
            [subject: 'PL1INCL', object: '', present: 'idalsdeliha', habitual: 'idalsdelisgoi', remote_past: 'igalsdelvhvi', imperative: 'idalsdela', infinitive: 'igalsdehldi']
        ]
    ]

    @Unroll
    def "conjugating Alsdeliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsdeliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisdeliha"
        "SG1" | "" | Tense.HABITUAL        | "galisdelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "tsisdelvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisdelvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualisdelodi"
        "SG2" | "" | Tense.PRESENT         | "halisdeliha"
        "SG2" | "" | Tense.HABITUAL        | "halisdelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalisdelvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halisdelvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalisdelodi"
        "SG3" | "" | Tense.PRESENT         | "alisdeliha"
        "SG3" | "" | Tense.HABITUAL        | "alisdelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisdelvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisdelvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisdelodi"
        "PL3" | "" | Tense.PRESENT         | "analisdeliha"
        "PL3" | "" | Tense.HABITUAL        | "analisdelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalisdelvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analisdelvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalisdelodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalisdeliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalisdelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalisdelvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalisdelvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalisdelodi"
    }
}
