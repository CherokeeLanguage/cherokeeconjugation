// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73508) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73508 (entrya kdega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Parting With Him/Her in Death",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyvdega'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvdega', habitual: 'jiyvdegoi', remote_past: 'akdejvi', imperative: 'jiyvdegi', infinitive: 'akdeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvdega', habitual: 'hiyvdegoi', remote_past: 'tsdejvi', imperative: 'hiyvdegi', infinitive: 'tsdeisdi'],
            [subject: 'SG3', object: '', habitual: 'gvdegoi', imperative: 'hiyvdegi', infinitive: 'uwvdeisdi', present: 'gvdega', remote_past: 'uwvdetsvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'andega', habitual: 'andegoi', remote_past: 'undejvi', imperative: 'andegi', infinitive: 'undeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idvdega', habitual: 'idvdegoi', remote_past: 'ikdegjvi', imperative: 'idvdegi', infinitive: 'ikdeisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvdega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvdegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "akdejvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvdetsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "akdeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvdega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvdegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "tsdejvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvdetsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "tsdeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "vdega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gvdegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwvdetsvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "vdetsvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwvdeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "andega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "andegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "undejvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anvdetsvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "undeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idvdega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idvdegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ikdegjvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edvdetsvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ikdeisdi"
    }
}
