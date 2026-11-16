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
            [subject: 'SG3', object: '', habitual: 'gadoi', imperative: 'hatesdi', infinitive: '', present: 'gata', remote_past: '']
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
        "SG1" | "" | Tense.REMOTE_PAST     | "agidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidvi"
        "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
