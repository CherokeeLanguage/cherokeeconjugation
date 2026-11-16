// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73512 (entrya kdlosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fire/Light is Going Out (143)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'kdlosgoi', imperative: 'hvhdlohi', infinitive: 'uwhdlohisdi', present: 'kdlosga', remote_past: 'uwhdlosvi'],
            [subject: 'SG3', object: '', present: 'anvhdlosga', habitual: 'anvhdlosgoi', remote_past: 'unhdlosvi', imperative: 'anvhdlohi', infinitive: 'unhdlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "gitlosga"
        "SG3" | "" | Tense.HABITUAL        | "gitlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwetlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwetlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwetlohisdi"
        "SG3" | "" | Tense.PRESENT         | "gitlosga"
        "SG3" | "" | Tense.HABITUAL        | "gitlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwetlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwetlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwetlohisdi"
    }
}
