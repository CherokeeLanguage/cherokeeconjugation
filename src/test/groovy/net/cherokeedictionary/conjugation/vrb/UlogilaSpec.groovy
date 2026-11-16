// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73879 (entrya ulogila) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlogilaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cloudy (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'ulogiloi', imperative: '', infinitive: '', present: 'ulogila', remote_past: 'ulogilvi']
        ]
    ]

    @Unroll
    def "conjugating Ulogila (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulogila", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ulogila"
        "SG3" | "" | Tense.HABITUAL        | "ulogiloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulogilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulogilvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
