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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquuwanvga"
        "SG1" | "" | Tense.HABITUAL        | "aquuwanvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquuwanvgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquuwanvgvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquuwanvsdi"
        "SG2" | "" | Tense.PRESENT         | "tsuwanvga"
        "SG2" | "" | Tense.HABITUAL        | "tsuwanvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuwanvgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsuwanvgvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsuwanvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwuwanvga"
        "SG3" | "" | Tense.HABITUAL        | "uwuwanvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwanvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwuwanvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwuwanvsdi"
        "PL3" | "" | Tense.PRESENT         | "unuwanvga"
        "PL3" | "" | Tense.HABITUAL        | "unuwanvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuwanvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unuwanvgvi"
        "PL3" | "" | Tense.INFINITIVE      | "unuwanvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iguwanvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iguwanvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguwanvgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iguwanvgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iguwanvsdi"
    }
}
