// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73978 (entrya uwehluhga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwehluhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Yelling/Howling, etc.",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwehluhga'],
            [subject: 'SG1', object: '', present: 'agwehluga', habitual: 'agwehluhgoi', remote_past: 'agwehluhnvi', imperative: 'geluvga', infinitive: 'agwehluhvsdi'],
            [subject: 'SG2', object: '', present: 'jehluga', habitual: 'jehluhgoi', remote_past: 'jehluhnvi', imperative: 'hehluhvga', infinitive: 'jehluhvsdi'],
            [subject: 'SG3', object: '', habitual: 'uwehluhgoi', imperative: 'hehluhvga', infinitive: 'uwehluhvsdi', present: 'uwehluhga', remote_past: 'uwehluhnvi'],
            [subject: 'PL3', object: '', present: 'unehluhga', habitual: 'unehluhgoi', remote_past: 'unehluhnvi', imperative: 'unehluhvga', infinitive: 'unehluhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igehluhga', habitual: 'igehluhgoi', remote_past: 'igehluhnvi', imperative: 'igehluhvga', infinitive: 'igehluhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Uwehluhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwehluhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquetluga"
        "SG1" | "" | Tense.HABITUAL        | "aquetlugoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquetlunvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquetlunvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwetluhvsdi"
        "SG2" | "" | Tense.PRESENT         | "tsetluga"
        "SG2" | "" | Tense.HABITUAL        | "tsetlugoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsetlunvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsetlunvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawetluhvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwetluga"
        "SG3" | "" | Tense.HABITUAL        | "uwetlugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwetlunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwetlunvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwetluhvsdi"
        "PL3" | "" | Tense.PRESENT         | "unetluga"
        "PL3" | "" | Tense.HABITUAL        | "unetlugoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unetlunvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unetlunvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwetluhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igetluga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igetlugoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igetlunvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igetlunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwetluhvsdi"
    }
}
