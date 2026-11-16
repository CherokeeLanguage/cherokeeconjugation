// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73358 (entrya igaluhga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class IgaluhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Returning (131)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ijiluga'],
            [subject: 'SG3', object: '', habitual: 'igaluhgoi', imperative: 'jihiluhgi', infinitive: 'vuluhisdi, uluhisdi', present: 'igaluhga', remote_past: 'vuluhjvi, uluhjvi'],
            [subject: 'SG3', object: '', present: 'ihiluhga', habitual: 'ihiluhgoi', remote_past: 'vjaluhjvi', imperative: 'jihiluhgi', infinitive: 'vjaluhisdi'],
            [subject: 'SG3', object: '', present: 'ianiluhga', habitual: 'ianiluhgoi', remote_past: 'vuniluhjvi', imperative: 'jianiluhgi', infinitive: 'vuniluhisdi'],
            [subject: 'SG3', object: '', present: 'iidiluhga', habitual: 'iidiluhgoi', remote_past: 'vigiluhjvi', imperative: 'jiidiluhgi', infinitive: 'vigiluhisdi']
        ]
    ]

    @Unroll
    def "conjugating Igaluhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Igaluhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiluhisdi"
    }
}
