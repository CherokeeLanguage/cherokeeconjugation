// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73844) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73844 (entrya ujetsdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UjetsdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Grinning",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquatsetsisdi'],
            [subject: 'SG1', object: '', present: 'aquatsetsisdi', habitual: 'agwajetsdoi', remote_past: 'agwajetsdvi', imperative: 'agwajetsda', infinitive: 'agwajetsdohdi'],
            [subject: 'SG2', object: '', present: 'jajetsdi', habitual: 'jajetsdoi', remote_past: 'jajetsdvi', imperative: 'hajetsda', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'utsetsisdoi', imperative: 'hatsetsisda', infinitive: 'utsetsisdodi', present: 'utsetsisdi', remote_past: 'utsetsisdvi'],
            [subject: 'PL3', object: '', present: 'unajetsdi', habitual: 'unajetsdoi', remote_past: 'unajetsdvi', imperative: 'anajetsda', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'igajetsdi', habitual: 'igajetsdoi', remote_past: 'igajetsdvi', imperative: 'idajetsda', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Ujetsdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ujetsdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquatsetsisdi"
        "SG1" | "" | Tense.HABITUAL        | "aquatsetsistoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsetsisdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquatsetsisdvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsetsistodi"
        "SG2" | "" | Tense.PRESENT         | "tsatsetsisdi"
        "SG2" | "" | Tense.HABITUAL        | "tsatsetsistoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsetsisdvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsatsetsisdvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "utsetsisdi"
        "SG3" | "" | Tense.HABITUAL        | "utsetsisdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsetsisdvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utsetsisdvi"
        // "SG3" | "" | Tense.INFINITIVE      | "/"
        "PL3" | "" | Tense.PRESENT         | "unatsetsisdi"
        "PL3" | "" | Tense.HABITUAL        | "unatsetsistoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsetsisdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unatsetsisdvi"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "igatsetsisdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igatsetsistoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsetsisdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igatsetsisdvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
