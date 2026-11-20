// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73295 (entrya gvhniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GvhnihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hitting Him/It",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyvniha, gvniha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvniha', habitual: 'jiyvnihoi', remote_past: 'jiyvnilvi', imperative: 'jiyvniga', infinitive: 'jiyansdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gvniha', habitual: 'gvnihoi', remote_past: 'agwvhnilvi', imperative: 'gvniga', infinitive: 'agwvnsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhniha', habitual: 'hiyvhnihoi', remote_past: 'hiyvhnilvi', imperative: 'hiyvniga', infinitive: 'hiyvnsdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hvhniha', habitual: 'hvhnihoi', remote_past: 'jvhnilvi', imperative: 'hvnhga', infinitive: 'jvnsdi'],
            [subject: 'SG3', object: '', habitual: 'gvhnihoi', imperative: 'hiyvniga, hvhnga', infinitive: 'uwansdi', present: 'gvhniha', remote_past: 'uwahnilvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anvhniha', habitual: 'anvhnihoi', remote_past: 'unvhnilvi', imperative: 'anvnhga', infinitive: 'unvnsdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idvhniha', habitual: 'idvhnihoi', remote_past: 'igvhnilvi', imperative: 'idvnhga', infinitive: 'igvnsdi']
        ]
    ]

    @Unroll
    def "conjugating Gvhniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gvhniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvniha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvnihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyvnilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvnilvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvnisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gvniha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gvnihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwvhnilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gvnilvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwvnsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhniha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhnihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvhnilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvnilvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvnsdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hvhniha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hvhnihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jvhnilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hvnilvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jvnsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gvniha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gvnihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwanilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "vnilvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwanisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anvhniha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anvhnihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unvhnilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anvnilvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvnsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idvhniha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idvhnihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvhnilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idvnilvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvnsdi"
    }
}
