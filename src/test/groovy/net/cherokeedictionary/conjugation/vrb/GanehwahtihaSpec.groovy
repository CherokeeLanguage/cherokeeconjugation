// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73112 (entrya ganehwahtiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinewahtiha'],
            [subject: 'SG1', object: '', present: 'jinewahtiha', habitual: 'jinehwahtisgoi', remote_past: 'aginehwahtvhvi', imperative: 'jinehwahta', infinitive: 'aginehwahtvhdi'],
            [subject: 'SG2', object: '', present: 'hinehwahtiha', habitual: 'hinehwahtisgoi', remote_past: 'janehwahtvhvi', imperative: 'hinehwahta', infinitive: 'janehwahtvhdi'],
            [subject: 'SG3', object: '', habitual: 'ganehwahtisgoi', imperative: 'hinehwahta', infinitive: 'unehwahtvhdi', present: 'ganehwahtiha', remote_past: 'unehwahtvhvi'],
            [subject: 'PL3', object: '', present: 'aninehwahtiha', habitual: 'aninehwahtisgoi', remote_past: 'uninehwahtvhvi', imperative: 'aninehwahta', infinitive: 'uninehwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinewatiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinewatisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginewadvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewadvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginewadvdi"
        "SG2" | "" | Tense.PRESENT         | "hinewatiha"
        "SG2" | "" | Tense.HABITUAL        | "hinewatisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanewadvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinewadvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanewadvdi"
        "SG1" | "" | Tense.PRESENT         | "tsinewatiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinewatisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginewadvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewadvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginewadvdi"
        "PL3" | "" | Tense.PRESENT         | "aninewatiha"
        "PL3" | "" | Tense.HABITUAL        | "aninewatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninewadvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninewadvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninewadvdi"
    }
}
