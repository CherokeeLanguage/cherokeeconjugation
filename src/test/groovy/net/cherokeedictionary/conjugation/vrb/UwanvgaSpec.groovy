// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73971 (entrya uwanvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwanvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hurrying (182)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwvnvga'],
            [subject: 'SG1', object: '', present: 'agwvnvga', habitual: 'agwvnvgoi', remote_past: 'agwvnvgvi', imperative: 'agwvnvgi', infinitive: 'agwvnvsdi'],
            [subject: 'SG2', object: '', present: 'jvnvga', habitual: 'jvnvgoi', remote_past: 'jvnvgvi', imperative: 'jvnvgi', infinitive: 'jvnvsdi'],
            [subject: 'SG3', object: '', habitual: 'uwanvgoi', imperative: 'jvnvgi', infinitive: 'uwanvsdi', present: 'uwanvga', remote_past: 'uwanvgvi'],
            [subject: 'PL3', object: '', present: 'unvnvga', habitual: 'unvnvgoi', remote_past: 'unvnvgvi', imperative: 'unvnvgi', infinitive: 'unvnvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igvnvga', habitual: 'igvnvgoi', remote_past: 'igvnvgvi', imperative: 'igvnvgi', infinitive: 'igvnvsdi']
        ]
    ]

    @Unroll
    def "conjugating Uwanvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwanvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwvnvga"
        "SG1" | "" | Tense.HABITUAL        | "agwvnvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvnvgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquvnvgvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwvnvsdi"
        "SG2" | "" | Tense.PRESENT         | "jvnvga"
        "SG2" | "" | Tense.HABITUAL        | "jvnvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvnvgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsvnvgvi"
        "SG2" | "" | Tense.INFINITIVE      | "jvnvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwanvga"
        "SG3" | "" | Tense.HABITUAL        | "uwanvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwanvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwanvsdi"
        // D16 (17Nov26): PL3 un- + v-stem fuses the stem v into the boundary
        // as Ꮕ (nv) at every tense (RuleVtoA is SG3-only now); pins re-aligned
        // to the book PL3 row (unvnvga ...).
        "PL3" | "" | Tense.PRESENT         | "unvnvga"
        "PL3" | "" | Tense.HABITUAL        | "unvnvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvnvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unvnvgvi"
        "PL3" | "" | Tense.INFINITIVE      | "unvnvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igvnvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igvnvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnvgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igvnvgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvnvsdi"
    }
}
