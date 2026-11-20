// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72370 (entrya ahlosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jihlosga'],
            [subject: 'SG1', object: '', present: 'jihlosga', habitual: 'jihlosgoi', remote_past: 'jihlosvi', imperative: 'jihlohi', infinitive: 'jihlohisdi'],
            [subject: 'SG2', object: '', present: 'hihlosga', habitual: 'hihlosgoi', remote_past: 'hihlosvi', imperative: 'hihlohi', infinitive: 'hihlohisdi'],
            [subject: 'SG3', object: '', habitual: 'ahlosgoi', imperative: 'hihlohi', infinitive: 'uhlohisdi', present: 'ahlosga', remote_past: 'uhlosvi'],
            [subject: 'PL3', object: '', present: 'anihlosga', habitual: 'anihlosgoi', remote_past: 'unihlosvi', imperative: 'anihlohi', infinitive: 'unihlohisdi'],
            [subject: 'PL1INCL', object: '', present: 'edihlosga', habitual: 'edihlosgoi', remote_past: 'edihlosvi', imperative: 'edihlohi', infinitive: 'edihlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jihlosga"
        "SG1" | "" | Tense.HABITUAL        | "jihlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jihlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlosvi"
        "SG1" | "" | Tense.INFINITIVE      | "jihlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hihlosga"
        "SG2" | "" | Tense.HABITUAL        | "hihlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlosvi"
        "SG2" | "" | Tense.INFINITIVE      | "hihlohisdi"
        "SG3" | "" | Tense.PRESENT         | "ahlosga"
        "SG3" | "" | Tense.HABITUAL        | "ahlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlohisdi"
        "PL3" | "" | Tense.PRESENT         | "anihlosga"
        "PL3" | "" | Tense.HABITUAL        | "anihlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edihlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "edihlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edihlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditlosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edihlohisdi"
    }
}
