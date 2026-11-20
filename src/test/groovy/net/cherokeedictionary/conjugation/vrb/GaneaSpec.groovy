// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73101 (entrya ganea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaneaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinea, jinea'],
            [subject: 'SG1', object: '', present: 'jinea', habitual: 'jinesgoi', remote_past: 'aginesvi', imperative: 'jinaga', infinitive: 'aginesdi'],
            [subject: 'SG2', object: '', present: 'hinea', habitual: 'hinesgoi', remote_past: 'janesvi', imperative: 'hwinaga', infinitive: 'janesdi'],
            [subject: 'SG3', object: '', habitual: 'ganesgoi', imperative: 'hinagi, hinagi', infinitive: 'unesdi', present: 'ganea', remote_past: 'unesvi'],
            [subject: 'PL3', object: '', present: 'aninea', habitual: 'aninesgoi', remote_past: 'uninesvi', imperative: 'waninaga', infinitive: 'uninesdi']
        ]
    ]

    @Unroll
    def "conjugating Ganea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinea, jinea"
        "SG1" | "" | Tense.HABITUAL        | "tsinesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinesvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginesdi"
        "SG2" | "" | Tense.PRESENT         | "hinea"
        "SG2" | "" | Tense.HABITUAL        | "hinesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinesvi"
        "SG2" | "" | Tense.INFINITIVE      | "janesdi"
        "SG1" | "" | Tense.PRESENT         | "jinea"
        "SG1" | "" | Tense.HABITUAL        | "jinesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinesvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginesdi"
        "PL3" | "" | Tense.PRESENT         | "aninea"
        "PL3" | "" | Tense.HABITUAL        | "aninesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninesvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninesdi"
    }
}
