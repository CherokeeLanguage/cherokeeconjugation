// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72573 (entrya asdeliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdelihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Helping (Him/Her)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisdeliha'],
            [subject: 'SG1', object: '', present: 'jisdeliha', habitual: 'jisdelisgoi', remote_past: 'jisdelvhvi', imperative: 'jisdela', infinitive: 'jisdehldi'],
            [subject: 'SG2', object: '', present: 'hisdeliha', habitual: 'hisdelisgoi', remote_past: 'hisdelvhvi', imperative: 'hisdela', infinitive: 'hisdehldi'],
            [subject: 'SG3', object: '', habitual: 'asdelisgoi', imperative: 'hisdela', infinitive: 'usdehldi', present: 'asdeliha', remote_past: 'usdelvhvi'],
            [subject: 'PL3', object: '', present: 'anisdeliha', habitual: 'anisdelisgoi', remote_past: 'unsdelvhvi', imperative: 'anisdela', infinitive: 'unsdehldi'],
            [subject: 'PL1INCL', object: '', present: 'edisdeliha', habitual: 'edisdelisgoi', remote_past: 'edisdelvhvi', imperative: 'edisdela', infinitive: 'edisdehldi']
        ]
    ]

    @Unroll
    def "conjugating Asdeliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdeliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisdeliha"
        "SG1" | "" | Tense.HABITUAL        | "tsisdelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "tsisdelvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisdelvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisdelodi"
        "SG2" | "" | Tense.PRESENT         | "hisdeliha"
        "SG2" | "" | Tense.HABITUAL        | "hisdelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasdelvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdelvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasdelodi"
        "SG3" | "" | Tense.PRESENT         | "asdeliha"
        "SG3" | "" | Tense.HABITUAL        | "asdelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdelvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdelvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdelodi"
        "PL3" | "" | Tense.PRESENT         | "anisdeliha"
        "PL3" | "" | Tense.HABITUAL        | "anisdelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdelvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdelvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisdelodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisdeliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisdelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisdelvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdelvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisdelodi"
    }
}
