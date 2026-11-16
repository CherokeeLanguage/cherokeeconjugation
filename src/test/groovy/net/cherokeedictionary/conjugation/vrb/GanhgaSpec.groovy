// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73121) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73121 (entrya ganhga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Lying Down",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsinvga'],
            // tio 16Nov26: the yaml extraction cited only the ji- row with junk
            // 'x' remote/future/infinitive cells. CED cedEntries.csv 'ganhga'
            // ᎦᏅᎦ "he's lying down" is the 3sg citation, so SG3 = 'ganhga'
            // (imperative 'jinvgesdi' kept from the extraction) and the ji- row
            // restored as SG1. The 'x' expected cells below are junk-data rows.
            [subject: 'SG3', object: '', habitual: 'ganvgoi', imperative: 'hinvgesdi', infinitive: '', present: 'ganvga', remote_past: ''],
            [subject: 'SG1', object: '', present: 'tsinvga', habitual: 'jinvgoi'],
        ]
    ]

    @Unroll
    def "conjugating Ganhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinvga"
        "SG1" | "" | Tense.HABITUAL        | "tsinvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinv"
        "SG1" | "" | Tense.INFINITIVE      | "x"
    }
}
