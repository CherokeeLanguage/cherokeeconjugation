// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73115) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73115 (entrya ganela) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanelaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Living At",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsinela'],
            [subject: 'SG3', object: '', habitual: 'ganeloi', imperative: 'hinelesdi', infinitive: '', present: 'ganela', remote_past: '']
        ]
    ]

    @Unroll
    def "conjugating Ganela (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganela", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinela"
        "SG1" | "" | Tense.HABITUAL        | "tsineloi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "X"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsine"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
    }
}
