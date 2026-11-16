// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72500 (entrya alidliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlidlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its Boiling (39)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'alidlisgoi', imperative: '', infinitive: 'ulihldi', present: 'alidliha', remote_past: 'ulidlvhvi']
        ]
    ]

    @Unroll
    def "conjugating Alidliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        def tenz = tense.toString()
        def syllabary = SyllabaryUtil.tsalagiToSyllabary(expected)

        conjugateVerb("Alidliha", details, subj, obj, tenz, expected) == syllabary
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "alitliha"
        "SG3" | "" | Tense.HABITUAL        | "alitlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulitlvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alitlvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulilodi"
    }
}
