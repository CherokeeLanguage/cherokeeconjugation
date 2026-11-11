package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtsdeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Biting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gajisdea', habitual: 'gajisdesgoi', remote_past: 'agwatsdesvi', imperative: 'gajisdagi', infinitive: 'agwatsdesdi'],
            [subject: 'SG2', object: '', present: 'hatsdea', habitual: 'hatsdesgoi', remote_past: 'jatsdesvi', imperative: 'hatsdagi', infinitive: 'jatsdesdi'],
            [subject: 'SG3', object: '', present: 'atsdea', habitual: 'atsdesgoi', remote_past: 'utsdesvi', imperative: 'atsdagi', infinitive: 'utsdesdi'],
            [subject: 'PL3', object: '', present: 'anatsdea', habitual: 'anatsdesgoi', remote_past: 'unatsdesvi', imperative: 'anatsdagi', infinitive: 'unatsdesdi'],
            [subject: 'PL1INCL', object: '', present: 'idatsdea', habitual: 'idatsdesgoi', remote_past: 'igatsdesvi', imperative: 'idatsdagi', infinitive: 'igatsdesdi']
        ]
    ]

    @Unroll
    def "conjugating Atsdea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atsdea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajisdea"
        "SG1" | "" | Tense.HABITUAL        | "gajisdesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatsdesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gajisdagi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatsdesdi"
        "SG2" | "" | Tense.PRESENT         | "hatsdea"
        "SG2" | "" | Tense.HABITUAL        | "hatsdesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatsdesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsdagi"
        "SG2" | "" | Tense.INFINITIVE      | "jatsdesdi"
        "SG3" | "" | Tense.PRESENT         | "atsdea"
        "SG3" | "" | Tense.HABITUAL        | "atsdesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsdesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsdagi"
        "SG3" | "" | Tense.INFINITIVE      | "utsdesdi"
        "PL3" | "" | Tense.PRESENT         | "anatsdea"
        "PL3" | "" | Tense.HABITUAL        | "anatsdesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsdesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsdagi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsdesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsdea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsdesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsdesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsdagi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsdesdi"
    }
}
