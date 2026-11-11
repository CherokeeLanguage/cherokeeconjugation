package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdwadegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Following Him/It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisdawadega', habitual: 'jisdawadegoi', remote_past: 'aksdawadvsvi', imperative: 'jisdawaduga', infinitive: 'aksdawadvsdi'],
            [subject: 'SG2', object: '', present: 'hisdawadega', habitual: 'hisdawadegoi', remote_past: 'tsdawadvsvi', imperative: 'hisdawaduga', infinitive: 'tsdawadvsdi'],
            [subject: 'SG3', object: '', present: 'asdawadega', habitual: 'asdawadegoi', remote_past: 'usdawadvsvi', imperative: 'asdawaduga', infinitive: 'usdawadvsdi'],
            [subject: 'PL3', object: '', present: 'anisdawadega', habitual: 'anisdawadegoi', remote_past: 'unisdawadvsvi', imperative: 'anisdawaduga', infinitive: 'unisdawadvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idisdawadega', habitual: 'idisdawadegoi', remote_past: 'iksdawadvsvi', imperative: 'idisdawaduga', infinitive: 'iksdawadvsdi']
        ]
    ]

    @Unroll
    def "conjugating Asdwadega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdwadega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdawadega"
        "SG1" | "" | Tense.HABITUAL        | "jisdawadegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksdawadvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisdawaduga"
        "SG1" | "" | Tense.INFINITIVE      | "aksdawadvsdi"
        "SG2" | "" | Tense.PRESENT         | "hisdawadega"
        "SG2" | "" | Tense.HABITUAL        | "hisdawadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdawadvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdawaduga"
        "SG2" | "" | Tense.INFINITIVE      | "tsdawadvsdi"
        "SG3" | "" | Tense.PRESENT         | "asdawadega"
        "SG3" | "" | Tense.HABITUAL        | "asdawadegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdawadvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdawaduga"
        "SG3" | "" | Tense.INFINITIVE      | "usdawadvsdi"
        "PL3" | "" | Tense.PRESENT         | "anisdawadega"
        "PL3" | "" | Tense.HABITUAL        | "anisdawadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdawadvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdawaduga"
        "PL3" | "" | Tense.INFINITIVE      | "unisdawadvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisdawadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisdawadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksdawadvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdawaduga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksdawadvsdi"
    }
}
