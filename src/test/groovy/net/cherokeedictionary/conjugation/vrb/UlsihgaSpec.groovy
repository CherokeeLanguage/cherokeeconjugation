// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73888 (entrya ulsihga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlsihgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dark (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'ulsihgoi', imperative: 'jalsihgesdi', infinitive: '', present: 'ulsihga', remote_past: 'ulsihgvi']
        ]
    ]

    @Unroll
    def "conjugating Ulsihga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulsihga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ulsihga"
        "SG3" | "" | Tense.HABITUAL        | "ulsihgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsihgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulsihgvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
