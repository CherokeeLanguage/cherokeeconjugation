// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73193) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73193 (entrya gata) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GataSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Hanging",
        part_of_speech: "v.i.",
        conjugations: [
            // tio 17Nov26: remote_past supplied from the 2012 book (Gata, Hanging p.75: past gatv'i); SG1 rows are yaml fabrications -- the book lists only the impersonal SG3 box.
            [subject: 'SG3', object: '', habitual: 'gadoi', imperative: 'hatesdi', infinitive: '', present: 'gata', remote_past: 'gatvi']
        ]
    ]

    @Unroll
    def "conjugating Gata (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gata", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsita"
        "SG1" | "" | Tense.HABITUAL        | "tsidoi"
        // tio 17Nov26: the SG1 remote/future-command/infinitive rows are yaml fabrications (the 2012 book box has no SG1 row); dropped.
        // "SG1" | "" | Tense.REMOTE_PAST     | "agidvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidvi"
        // "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
