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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvniha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvnihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvnilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvnilvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvnisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gvniha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gvnihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquvnilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gvnilvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquvnisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvniha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvnihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "vnilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvnilvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "vnisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hvniha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hvnihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsvnilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hvnilvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsvnisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gvniha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gvnihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwanilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "vnilvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwanisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anvniha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anvnihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anvnilvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unanisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idvniha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idvnihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvnilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idvnilvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvnisdi"
    }
}
