package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hes Beating Him/Her at a Game",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jihlosga', habitual: 'jihlosgoi', remote_past: 'jihlosvi', imperative: 'jihlohi', infinitive: 'jihlohisdi'],
            [subject: 'SG2', object: '', present: 'hihlosga', habitual: 'hihlosgoi', remote_past: 'hihlosvi', imperative: 'hihlohi', infinitive: 'hihlohisdi'],
            [subject: 'SG3', object: '', present: 'ahlosga', habitual: 'ahlosgoi', remote_past: 'uhlosvi', imperative: 'ahlohi', infinitive: 'uhlohisdi'],
            [subject: 'PL3', object: '', present: 'anihlosga', habitual: 'anihlosgoi', remote_past: 'unihlosvi', imperative: 'anihlohi', infinitive: 'unihlohisdi'],
            [subject: 'PL1INCL', object: '', present: 'edihlosga', habitual: 'edihlosgoi', remote_past: 'edihlosvi', imperative: 'edihlohi', infinitive: 'edihlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jihlosga"
        "SG1" | "" | Tense.HABITUAL        | "jihlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jihlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jihlohi"
        "SG1" | "" | Tense.INFINITIVE      | "jihlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hihlosga"
        "SG2" | "" | Tense.HABITUAL        | "hihlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlohi"
        "SG2" | "" | Tense.INFINITIVE      | "hihlohisdi"
        "SG3" | "" | Tense.PRESENT         | "ahlosga"
        "SG3" | "" | Tense.HABITUAL        | "ahlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahlohi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlohisdi"
        "PL3" | "" | Tense.PRESENT         | "anihlosga"
        "PL3" | "" | Tense.HABITUAL        | "anihlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihlohi"
        "PL3" | "" | Tense.INFINITIVE      | "unihlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edihlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "edihlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edihlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edihlohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edihlohisdi"
    }
}
