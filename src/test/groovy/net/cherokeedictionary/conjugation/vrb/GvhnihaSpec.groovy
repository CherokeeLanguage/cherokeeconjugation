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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvniha', habitual: 'jiyvnihoi', remote_past: 'jiyvnilvi', imperative: 'jiyvniga', infinitive: 'jiyansdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gvniha', habitual: 'gvnihoi', remote_past: 'agwvhnilvi', imperative: 'gvniga', infinitive: 'agwvnsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhniha', habitual: 'hiyvhnihoi', remote_past: 'hiyvhnilvi', imperative: 'hiyvniga', infinitive: 'hiyvnsdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hvhniha', habitual: 'hvhnihoi', remote_past: 'jvhnilvi', imperative: 'hvnhga', infinitive: 'jvnsdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'gvhniha', habitual: 'gvhnihoi', remote_past: 'uwahnilvi', imperative: 'gvnhga', infinitive: 'uwansdi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvniha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvnihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyvnilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyvniga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyansdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gvniha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gvnihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwvhnilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gvniga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwvnsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhniha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhnihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvhnilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvniga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvnsdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hvhniha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hvhnihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jvhnilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hvnhga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jvnsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gvhniha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gvhnihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwahnilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "gvnhga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwansdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anvhniha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anvhnihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unvhnilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anvnhga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvnsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idvhniha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idvhnihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvhnilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idvnhga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvnsdi"
    }
}
