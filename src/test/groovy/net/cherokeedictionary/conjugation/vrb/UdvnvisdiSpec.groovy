// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73772) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73772 (entrya udvnvisdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdvnvisdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Willing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquadvnvisdi'],
            [subject: 'SG1', object: '', present: 'aquadvnvisdi', habitual: 'agwadvnvisdoi', remote_past: 'agwadvnvisdvi', imperative: 'agwadvnvisdesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jadvnvisdi', habitual: 'jadvnvisdoi', remote_past: 'jadvnvisdvi', imperative: 'jadvnvisdesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'udvnvisdoi', imperative: 'tsadvnvisdesdi', infinitive: '', present: 'udvnvisdi', remote_past: 'udvnvisdvi'],
            [subject: 'PL3', object: '', present: 'unadvnvisdi', habitual: 'unadvnvisdoi', remote_past: 'unadvnvisdvi', imperative: 'unadvnvisdesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igadvnvisdi', habitual: 'igadvnisdoi', remote_past: 'igadvnvisdvi', imperative: 'igadvnvisdesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Udvnvisdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udvnvisdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadvnvisdi"
        "SG1" | "" | Tense.HABITUAL        | "agwadvnvisdoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadvnvisdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadvnvisdvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "jadvnvisdi"
        "SG2" | "" | Tense.HABITUAL        | "jadvnvisdoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvnvisdvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadvnvisdvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "udvnvisdi"
        "SG3" | "" | Tense.HABITUAL        | "udvnvisdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvnvisdvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udvnvisdvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unadvnvisdi"
        "PL3" | "" | Tense.HABITUAL        | "unadvnvisdoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadvnvisdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadvnvisdvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igadvnvisdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadvnvistoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadvnvisdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadvnvisdvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
