// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73908 (entrya uneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agineha'],
            [subject: 'SG1', object: '', present: 'agineha', habitual: 'aginehoi', remote_past: 'aginehvi', imperative: 'aginehesdi', infinitive: 'aginehdi'],
            [subject: 'SG2', object: '', present: 'janeha', habitual: 'janehoi', remote_past: 'janehvi', imperative: 'janehesdi', infinitive: 'janehdi'],
            [subject: 'SG3', object: '', habitual: 'unehoi', imperative: 'janehesdi', infinitive: 'unehdi', present: 'uneha', remote_past: 'unehvi'],
            [subject: 'PL3', object: '', present: 'unineha', habitual: 'uninehoi', remote_past: 'uninehvi', imperative: 'uninehesdi', infinitive: 'uninehdi']
        ]
    ]

    @Unroll
    def "conjugating Uneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agineha"
        "SG1" | "" | Tense.HABITUAL        | "aginehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginehvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehdi"
        "SG2" | "" | Tense.PRESENT         | "janeha"
        "SG2" | "" | Tense.HABITUAL        | "janehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanehvi"
        "SG2" | "" | Tense.INFINITIVE      | "janehdi"
        "SG3" | "" | Tense.PRESENT         | "uneha"
        "SG3" | "" | Tense.HABITUAL        | "unehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unehvi"
        "SG3" | "" | Tense.INFINITIVE      | "unehdi"
        "PL3" | "" | Tense.PRESENT         | "unineha"
        "PL3" | "" | Tense.HABITUAL        | "uninehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninehvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninehdi"
    }
}
