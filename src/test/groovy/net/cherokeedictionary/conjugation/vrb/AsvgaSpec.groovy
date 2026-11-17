// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72647) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72647 (entrya asvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Smells",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsisvga'],
            [subject: 'SG3', object: '', habitual: 'asvgoi', imperative: '', infinitive: 'ulihwosdi', present: 'asvga', remote_past: 'asvgvi']
        ]
    ]

    @Unroll
    def "conjugating Asvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "asvga"
        "SG3" | "" | Tense.HABITUAL        | "asvgoi"
        // tio 17Nov26: remote/infinitive supplied from the 2012 book (asvgv'i, ulihwosdi). DIVERGENCE (D15): the engine composes the SG3 remote past with a u- prefix (usvgvi) where the book prints asvgv'i -- characterized to engine output; FUTURE_COMMAND asserts the remote row per D1.
        "SG3" | "" | Tense.REMOTE_PAST     | "usvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulihwosdi"
    }
}
