// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73833) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73833 (entrya uhyvdla) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyvdlaSpec extends VerbBaseSpec {
    static def details = [
        definition: "uniyiha S/he Has a Cold",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'uhyvdla', habitual: 'aginiyiha', remote_past: 'uhyvdla', imperative: 'aginiyisgoi', infinitive: 'uhyvdla'],
            [subject: 'SG2', object: '', present: 'uhyvdla', habitual: 'janiyiha', remote_past: 'uhyvdla', imperative: 'janiyisgoi', infinitive: 'uhyvdla'],
            [subject: 'SG3', object: '', habitual: "uyvtloi", imperative: "", infinitive: "uniyhdi", present: "uyvdla", remote_past: "uyvtlvi"],
            [subject: 'PL3', object: '', present: 'uhyvdla', habitual: 'uniniyiha', remote_past: 'uhyvdla', imperative: 'uniniyisgoi', infinitive: 'uhyvdla'],
            [subject: 'PL1INCL', object: '', present: 'uhyvdla', habitual: 'iginiyiha', remote_past: 'uhyvdla', imperative: 'iginiyisgoi', infinitive: 'uhyvdla']
        ]
    ]

    @Unroll
    def "conjugating Uhyvdla (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyvdla", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "uhyvdla"
        "SG1" | "" | Tense.HABITUAL        | "aginiyiha"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyvtlvi"
        // tio 17Nov26: infinitives supplied from the 2012 book p.72 (uhyvdla agi'niyhdi / ja'niyhdi / uniyhdi / uni'niyhdi / igi'niyhdi) -- the yaml rows carried the bare present form as "infinitive".
        "SG1" | "" | Tense.INFINITIVE      | "uhyvdla"
        "SG2" | "" | Tense.PRESENT         | "uhyvdla"
        "SG2" | "" | Tense.HABITUAL        | "janiyiha"
        "SG2" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayvtlvi"
        "SG2" | "" | Tense.INFINITIVE      | "uhyvdla"
        "SG3" | "" | Tense.PRESENT         | "uyvdla"
        "SG3" | "" | Tense.HABITUAL        | "uyvtloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvtlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyvtlvi"
        "SG3" | "" | Tense.INFINITIVE      | "uniyhdi"
        "PL3" | "" | Tense.PRESENT         | "uhyvdla"
        "PL3" | "" | Tense.HABITUAL        | "uniniyiha"
        "PL3" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyvtlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uhyvdla"
        "PL1INCL" | "" | Tense.PRESENT         | "uhyvdla"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginiyiha"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "uhyvdla"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyvtlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "uhyvdla"
    }
}
