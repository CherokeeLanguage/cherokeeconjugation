// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73110 (entrya ganehiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jineiyaa'],
            [subject: 'SG1', object: '', present: 'jineiyaa', habitual: 'jineiyasgoi', remote_past: 'aginehiyvi', imperative: 'jineiya', infinitive: 'aginehiyasdi'],
            [subject: 'SG2', object: '', present: 'hinehiyaa', habitual: 'hinehiyasgoi', remote_past: 'janehiyvi', imperative: 'hinehiya', infinitive: 'janehiyasdi'],
            [subject: 'SG3', object: '', habitual: 'ganehiyasgoi', imperative: 'hinehiya', infinitive: 'unehiyasdi', present: 'ganehiyaa', remote_past: 'unehiyvi'],
            [subject: 'PL3', object: '', present: 'aninehiyaa', habitual: 'aninehiyasgoi', remote_past: 'uninehiyvi', imperative: 'aninehiya', infinitive: 'uninehiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinehiyaa"
        "SG1" | "" | Tense.HABITUAL        | "tsinehiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinehiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hinehiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hinehiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanehiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehiyvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanehiyasdi"
        "SG1" | "" | Tense.PRESENT         | "tsinehiyaa"
        "SG1" | "" | Tense.HABITUAL        | "tsinehiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinehiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehiyasdi"
        "PL3" | "" | Tense.PRESENT         | "aninehiyaa"
        "PL3" | "" | Tense.HABITUAL        | "aninehiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninehiyasdi"
    }
}
