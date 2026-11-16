// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73809 (entrya uhnalvha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhnalvhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Angry",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'akinalvha'],
            [subject: 'SG1', object: '', present: 'akinalvha', habitual: 'akinalvsoi', remote_past: 'akinalvsvi', imperative: 'akinalvsesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jahnalvha', habitual: 'jahnalvsoi', remote_past: 'jahnalvsvi', imperative: 'chanalvsesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'uhnalvsoi', imperative: 'chanalvsesdi', infinitive: '', present: 'uhnalvha', remote_past: 'uhnalvsvi'],
            [subject: 'PL3', object: '', present: 'unihnalvha', habitual: 'unihnalvsoi', remote_past: 'unihnalvsvi', imperative: 'uninalvsesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igihnalvha', habitual: 'igihnalvsoi', remote_past: 'igihnalvsvi', imperative: 'iginalvsesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uhnalvha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhnalvha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginalvha"
        "SG1" | "" | Tense.HABITUAL        | "aginalvsoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginalvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginalvsvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "tsanalvha"
        "SG2" | "" | Tense.HABITUAL        | "tsanalvsoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanalvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanalvsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "unalvha"
        "SG3" | "" | Tense.HABITUAL        | "unalvsoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unalvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unalvsvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "uninalvha"
        "PL3" | "" | Tense.HABITUAL        | "uninalvsoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninalvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninalvsvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "iginalvha"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginalvsoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginalvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginalvsvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
