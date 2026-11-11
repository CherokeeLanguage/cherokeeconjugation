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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasgitsga', habitual: 'jiyasgitsgoi', remote_past: 'jiyasgitsvi', imperative: 'jiyasgitsdi', infinitive: ''],
            [subject: 'SG1', object: '', present: 'gasgitsga', habitual: 'gasgitsgoi', remote_past: 'agwasgitsvi', imperative: 'agwasgitsdi', infinitive: ''],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasgitsga', habitual: 'hiyasgitsgoi', remote_past: 'hiyasgitsvi', imperative: 'hiyasgitsdi', infinitive: ''],
            [subject: 'SG2', object: '', present: 'hasgitsga', habitual: 'hasgitsgoi', remote_past: 'jasgitsvi', imperative: 'jasgitsdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'asgitsga', habitual: 'asgitsgoi', remote_past: 'usgitsvi', imperative: 'asgitsa', infinitive: 'usgitsdi'],
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
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasgitsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyasgitsdi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "X"
        "SG1" | "" | Tense.PRESENT         | "gasgitsga"
        "SG1" | "" | Tense.HABITUAL        | "gasgitsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwasgitsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwasgitsdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasgitsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasgitsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasgitsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasgitsdi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "hasgitsga"
        "SG2" | "" | Tense.HABITUAL        | "hasgitsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasgitsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jasgitsdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "asgitsga"
        "SG3" | "" | Tense.HABITUAL        | "asgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgitsa"
        "SG3" | "" | Tense.INFINITIVE      | "usgitsdi"
        "SG3" | "" | Tense.PRESENT         | "anasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "anasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unasgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anasgitsa"
        "SG3" | "" | Tense.INFINITIVE      | "unasgitsdi"
        "SG3" | "" | Tense.PRESENT         | "edasgitsga"
        "SG3" | "" | Tense.HABITUAL        | "edasgitsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "edasgitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "edasgitsdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idasgitsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasgitsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasgitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igasgitsdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
