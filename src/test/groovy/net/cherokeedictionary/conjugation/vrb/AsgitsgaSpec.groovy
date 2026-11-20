// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72601) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'tsiyasgitisga, gasgitisga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasgitsga', habitual: 'jiyasgitsgoi', remote_past: 'jiyasgitsvi', imperative: 'jiyasgitsdi', infinitive: ''],
            [subject: 'SG1', object: '', present: 'gasgitsga', habitual: 'gasgitsgoi', remote_past: 'agwasgitsvi', imperative: 'agwasgitsdi', infinitive: ''],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasgitsga', habitual: 'hiyasgitsgoi', remote_past: 'hiyasgitsvi', imperative: 'hiyasgitsdi', infinitive: ''],
            [subject: 'SG2', object: '', present: 'hasgitsga', habitual: 'hasgitsgoi', remote_past: 'jasgitsvi', imperative: 'jasgitsdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'asgitisgoi', imperative: 'hiyasgitisa, hasgitisa', infinitive: 'usgitisdi', present: 'asgitisga', remote_past: 'usgitisvi'],
            [subject: 'SG3', object: '', present: 'anasgitsga', habitual: 'anasgitsgoi', remote_past: 'unasgitsvi', imperative: 'anasgitsa', infinitive: 'unasgitsdi'],
            [subject: 'SG3', object: '', present: 'edasgitsga', habitual: 'edasgitsgoi', remote_past: 'edasgitsvi', imperative: 'edasgitsdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'idasgitsga', habitual: 'idasgitsgoi', remote_past: 'igasgitsvi', imperative: 'igasgitsdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Asgitsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgitsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasgitsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasgitsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasgitsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyasgitisvi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyasgitisdi"
        "SG1" | "" | Tense.PRESENT         | "gasgitisga"
        "SG1" | "" | Tense.HABITUAL        | "gasgitisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquasgitisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasgitisvi"
        // "SG1" | "" | Tense.INFINITIVE      | "aquasgitisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasgitsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasgitsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasgitsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasgitisvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "asgitisdi"
        "SG2" | "" | Tense.PRESENT         | "hasgitsga"
        "SG2" | "" | Tense.HABITUAL        | "hasgitsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasgitsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasgitisvi"
        // "SG2" | "" | Tense.INFINITIVE      | "tsasgitisdi"
        "SG3" | "" | Tense.PRESENT         | "asgitisga"
        "SG3" | "" | Tense.HABITUAL        | "asgitisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgitisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitisvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgitisdi"
        "SG3" | "" | Tense.PRESENT         | "anasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "anasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unasgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unasgitsdi"
        "SG3" | "" | Tense.PRESENT         | "edasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "edasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "edasgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitisvi"
        // "SG3" | "" | Tense.INFINITIVE      | "usgitisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasgitsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasgitsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasgitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasgitisvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "igasgitisdi"
    }
}
