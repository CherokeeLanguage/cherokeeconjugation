// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72601 (entrya asgitsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgitsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Dreaming About Him/It",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyasgitsga, gasgitsga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasgitsga', habitual: 'jiyasgitsgoi', remote_past: 'jiyasgitsvi', imperative: 'jiyasgitsdi', infinitive: ''],
            [subject: 'SG1', object: '', present: 'gasgitsga', habitual: 'gasgitsgoi', remote_past: 'agwasgitsvi', imperative: 'agwasgitsdi', infinitive: ''],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasgitsga', habitual: 'hiyasgitsgoi', remote_past: 'hiyasgitsvi', imperative: 'hiyasgitsdi', infinitive: ''],
            [subject: 'SG2', object: '', present: 'hasgitsga', habitual: 'hasgitsgoi', remote_past: 'jasgitsvi', imperative: 'jasgitsdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'asgitsgoi', imperative: 'hiyasgitsa, hasgitsa', infinitive: 'usgitsdi', present: 'asgitsga', remote_past: 'usgitsvi'],
            [subject: 'SG3', object: '', present: 'anasgitsga', habitual: 'anasgitsgoi', remote_past: 'unasgitsvi', imperative: 'anasgitsa', infinitive: 'unasgitsdi'],
            [subject: 'SG3', object: '', present: 'edasgitsga', habitual: 'edasgitsgoi', remote_past: 'edasgitsvi', imperative: 'edasgitsdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'idasgitsga', habitual: 'idasgitsgoi', remote_past: 'igasgitsvi', imperative: 'igasgitsdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Asgitsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgitsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasgitsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasgitsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyasgitsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyasgitsvi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyasgitsidi"
        "SG1" | "" | Tense.PRESENT         | "gasgitsga"
        "SG1" | "" | Tense.HABITUAL        | "gasgitsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquasgitsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasgitsvi"
        // "SG1" | "" | Tense.INFINITIVE      | "aquasgitsidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasgitsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasgitsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "asgitsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasgitsvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "asgitsidi"
        "SG2" | "" | Tense.PRESENT         | "hasgitsga"
        "SG2" | "" | Tense.HABITUAL        | "hasgitsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasgitsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasgitsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "tsasgitsidi"
        "SG3" | "" | Tense.PRESENT         | "asgitsga"
        "SG3" | "" | Tense.HABITUAL        | "asgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgitsidi"
        "SG3" | "" | Tense.PRESENT         | "anasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "anasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgitsidi"
        "SG3" | "" | Tense.PRESENT         | "edasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "edasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitsvi"
        // "SG3" | "" | Tense.INFINITIVE      | "usgitsidi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasgitsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasgitsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasgitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasgitsvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "igasgitsidi"
    }
}
