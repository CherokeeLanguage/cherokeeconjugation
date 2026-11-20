// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73512) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73512 (entrya kdlosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fire/Light is Going Out (143)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'gvtlosgoi', imperative: 'hvtlohi', infinitive: 'uwvtlohisdi', present: 'gvtlosga', remote_past: 'uwvtlosvi'],
            [subject: 'SG3', object: '', present: 'anvhdlosga', habitual: 'anvhdlosgoi', remote_past: 'unhdlosvi', imperative: 'anvhdlohi', infinitive: 'unhdlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "gvtlosga"
        "SG3" | "" | Tense.HABITUAL        | "gvtlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwvtlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vtlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvtlohisdi"
        "SG3" | "" | Tense.PRESENT         | "anvhdlosga"
        "SG3" | "" | Tense.HABITUAL        | "anvhdlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unhdlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vtlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "unhdlohisdi"
    }
}
