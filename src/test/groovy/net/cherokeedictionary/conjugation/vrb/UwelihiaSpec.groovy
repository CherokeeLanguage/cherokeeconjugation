// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73988 (entrya uwelihia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwelihiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Worried / Anxious",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwelihia'],
            [subject: 'SG1', object: '', present: 'agwelihia', habitual: 'agwelihisgoi', remote_past: 'agwelihisgvi', imperative: 'agwelihisgesdi', infinitive: 'agwelihisdi'],
            [subject: 'SG2', object: '', present: 'jelihia', habitual: 'jelihisgoi', remote_past: 'jelihisgvi', imperative: 'jelihisgesdi', infinitive: 'jelihisdi'],
            [subject: 'SG3', object: '', habitual: 'uwelihisgoi', imperative: 'jelihisgesdi', infinitive: 'uwelihisdi', present: 'uwelihia', remote_past: 'uwelihisgvi'],
            [subject: 'PL3', object: '', present: 'unelihia', habitual: 'unelihisgoi', remote_past: 'unelihisgvi', imperative: 'unelihisgesdi', infinitive: 'unelihisdi'],
            [subject: 'PL1INCL', object: '', present: 'igelihia', habitual: 'igelihisgoi', remote_past: 'igelihisgvi', imperative: 'igelihisgesdi', infinitive: 'igelihisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwelihia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwelihia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwelihia"
        "SG1" | "" | Tense.HABITUAL        | "agwelihisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwelihisgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquelihisgvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwelihisdi"
        "SG2" | "" | Tense.PRESENT         | "jelihia"
        "SG2" | "" | Tense.HABITUAL        | "jelihisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jelihisgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tselihisgvi"
        "SG2" | "" | Tense.INFINITIVE      | "jelihisdi"
        "SG3" | "" | Tense.PRESENT         | "uwelihia"
        "SG3" | "" | Tense.HABITUAL        | "uwelihisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwelihisgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwelihisgvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwelihisdi"
        "PL3" | "" | Tense.PRESENT         | "unelihia"
        "PL3" | "" | Tense.HABITUAL        | "unelihisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unelihisgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unelihisgvi"
        "PL3" | "" | Tense.INFINITIVE      | "unelihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igelihia"
        "PL1INCL" | "" | Tense.HABITUAL        | "igelihisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igelihisgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igelihisgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igelihisdi"
    }
}
