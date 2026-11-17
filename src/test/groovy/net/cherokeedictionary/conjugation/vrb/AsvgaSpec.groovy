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
        // tio 17Nov26: D15 verdict (user): the SG3 remote past is asvgv'i (a- prefix) per the
        // 2012 book p.75. BOOK-ONLY FORM: the CED does not list this form -- because the book
        // has it, that is the form we say exists (annotation per user instruction). The engine
        // composes the table-default u- prefix (usvgvi; cf. sibling Galiga ulijv'i), so the
        // lexeme-specific a- is registered as a whole-form surface; FUTURE_COMMAND asserts
        // the remote row per D1. -- tio 17Nov26
        surfaceOverrides: [
            [tense: 'REMOTE_PAST', subject: 'SG3', obj: 'NONE', form: 'asvgvi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG3', obj: 'NONE', form: 'asvgvi']
        ],
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
        // tio 17Nov26: SG3 remote asserted to the book's asvgv'i (a- prefix, p.75) per the
        // D15 verdict -- BOOK-ONLY FORM (CED does not list it); FUTURE_COMMAND asserts the
        // remote row per D1.
        "SG3" | "" | Tense.REMOTE_PAST     | "asvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulihwosdi"
    }
}
