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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitlosga"
        "SG1" | "" | Tense.HABITUAL        | "tsitlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hitlosga"
        "SG2" | "" | Tense.HABITUAL        | "hitlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlohisdi"
        "SG3" | "" | Tense.PRESENT         | "atlosga"
        "SG3" | "" | Tense.HABITUAL        | "atlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlohisdi"
        "PL3" | "" | Tense.PRESENT         | "anitlosga"
        "PL3" | "" | Tense.HABITUAL        | "anitlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iditlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iditlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditlosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitlohisdi"
    }
}
