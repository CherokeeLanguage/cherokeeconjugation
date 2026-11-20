// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73808 (entrya uhnalvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnalvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Angry (Getting)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'akinalvga'],
            [subject: 'SG1', object: '', present: 'akinalvga', habitual: 'akinalvgoi', remote_past: 'akinalvjvi', imperative: 'akinalvgi', infinitive: 'akinalvisdi'],
            [subject: 'SG2', object: '', present: 'jahnalvga', habitual: 'jahnalvgoi', remote_past: 'jahnalvjvi', imperative: 'chanalvgi', infinitive: 'jahnalvisdi'],
            [subject: 'SG3', object: '', habitual: 'uhnalvgoi', imperative: 'chanalvgi', infinitive: 'uhnalvisdi', present: 'uhnalvga', remote_past: 'uhnalvjvi'],
            [subject: 'PL3', object: '', present: 'unihnalvga', habitual: 'unihnalvgoi', remote_past: 'unihnalvjvi', imperative: 'uninalvgi', infinitive: 'unihnalvisdi'],
            [subject: 'PL1INCL', object: '', present: 'igihnalvga', habitual: 'igihnalvgoi', remote_past: 'igihnalvjvi', imperative: 'iginalvgi', infinitive: 'igihnalvisdi']
        ]
    ]

    @Unroll
    def "conjugating Uhnalvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhnalvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akinalvga"
        "SG1" | "" | Tense.HABITUAL        | "akinalvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinalvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginalvtsvi"
        "SG1" | "" | Tense.INFINITIVE      | "akinalvisdi"
        "SG2" | "" | Tense.PRESENT         | "jahnalvga"
        "SG2" | "" | Tense.HABITUAL        | "jahnalvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnalvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanalvtsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnalvisdi"
        "SG3" | "" | Tense.PRESENT         | "uhnalvga"
        "SG3" | "" | Tense.HABITUAL        | "uhnalvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnalvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unalvtsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnalvisdi"
        "PL3" | "" | Tense.PRESENT         | "unihnalvga"
        "PL3" | "" | Tense.HABITUAL        | "unihnalvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnalvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninalvtsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnalvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihnalvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihnalvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnalvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginalvtsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnalvisdi"
    }
}
