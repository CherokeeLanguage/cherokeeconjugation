package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "/ Gahlvsga Sleepy",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilvsga', habitual: 'jilvsgoi', remote_past: 'agihlvhnvi', imperative: 'jilvna', infinitive: 'agihlvnhdi'],
            [subject: 'SG2', object: '', present: 'hilvsga', habitual: 'hilvsgoi', remote_past: 'jahlvhnvi', imperative: 'hihlvna', infinitive: 'jahlvnhdi'],
            [subject: 'SG3', object: '', present: 'galvsga', habitual: 'galvsgoi', remote_past: 'uhlvhnvi', imperative: 'gahlvna', infinitive: 'uhlvnhdi'],
            [subject: 'PL3', object: '', present: 'anilvsga', habitual: 'anilvsgoi', remote_past: 'unilvhnvi', imperative: 'anihlvna', infinitive: 'unihlvnhdi'],
            [subject: 'PL1INCL', object: '', present: 'idilvsga', habitual: 'idilvsgoi', remote_past: 'igihlvhnvi', imperative: 'idihlvna', infinitive: 'igihlvnhdi']
        ]
    ]

    @Unroll
    def "conjugating Galvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihlvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilvna"
        "SG1" | "" | Tense.INFINITIVE      | "agihlvnhdi"
        "SG2" | "" | Tense.PRESENT         | "hilvsga"
        "SG2" | "" | Tense.HABITUAL        | "hilvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahlvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlvna"
        "SG2" | "" | Tense.INFINITIVE      | "jahlvnhdi"
        "SG3" | "" | Tense.PRESENT         | "galvsga"
        "SG3" | "" | Tense.HABITUAL        | "galvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gahlvna"
        "SG3" | "" | Tense.INFINITIVE      | "uhlvnhdi"
        "PL3" | "" | Tense.PRESENT         | "anilvsga"
        "PL3" | "" | Tense.HABITUAL        | "anilvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihlvna"
        "PL3" | "" | Tense.INFINITIVE      | "unihlvnhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihlvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihlvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihlvnhdi"
    }
}
