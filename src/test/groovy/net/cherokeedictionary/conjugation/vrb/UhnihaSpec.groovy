// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73818) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73818 (entrya uhniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is in Bed",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquaniha'],
            [subject: 'SG1', object: '', present: 'aquaniha', habitual: 'agwahnihoi', remote_past: 'agwahnihvi', imperative: 'agwahnihesdi', infinitive: 'x'],
            [subject: 'SG2', object: '', present: 'jahniha', habitual: 'jahnihoi', remote_past: 'jahnihvi', imperative: 'jahnihesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'unihoi', imperative: 'tsanihesdi', infinitive: '', present: 'uniha', remote_past: 'unihvi'],
            [subject: 'PL3', object: '', present: 'unahniha', habitual: 'unahnihoi', remote_past: 'unahnihhvi', imperative: 'unahnihesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igahniha', habitual: 'igahnihoi', remote_past: 'igahnihvi', imperative: 'igahnihesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uhniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquaniha"
        "SG1" | "" | Tense.HABITUAL        | "agwahnihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquanihvi"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book (Uhniha, In Bed) prints x in the infinitive column.
        "SG2" | "" | Tense.PRESENT         | "jahniha"
        "SG2" | "" | Tense.HABITUAL        | "jahnihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnihvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanihvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uniha"
        "SG3" | "" | Tense.HABITUAL        | "unihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unihvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unihvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unahniha"
        "PL3" | "" | Tense.HABITUAL        | "unahnihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnihhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unanihvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igahniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igahnihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnihvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iganihvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
