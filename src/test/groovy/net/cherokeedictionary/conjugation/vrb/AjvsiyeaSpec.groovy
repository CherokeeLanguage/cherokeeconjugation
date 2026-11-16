package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjvsiyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Walking Around",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gajvsiyea', habitual: 'gajvsiyesgoi', remote_past: 'agwajvsiyevi', imperative: 'gajvsiya', infinitive: 'agwajvsiyedi'],
            [subject: 'SG2', object: '', present: 'hajvsiyea', habitual: 'hajvsiyesgoi', remote_past: 'jajvsiyevi', imperative: 'hajvsiya', infinitive: 'jajvsiyedi'],
            [subject: 'SG3', object: '', present: 'ajvsiyea', habitual: 'ajvsiyesgoi', remote_past: 'ujvsiyevi', imperative: 'ajvsiya', infinitive: 'ujvsiyedi'],
            [subject: 'PL3', object: '', present: 'anajvsiyea', habitual: 'anajvsiyesgoi', remote_past: 'unajvsiyevi', imperative: 'anajvsiya', infinitive: 'unajvsiyedi'],
            [subject: 'PL1INCL', object: '', present: 'idajvsiyea', habitual: 'idajvsiyesgoi', remote_past: 'igajvsiyevi', imperative: 'idajvsiya', infinitive: 'igajvsiyedi']
        ]
    ]

    @Unroll
    def "conjugating Ajvsiyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajvsiyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsvsiyea"
        "SG1" | "" | Tense.HABITUAL        | "gatsvsiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsvsiyevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsvsiyevi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsvsiyedi"
        "SG2" | "" | Tense.PRESENT         | "hatsvsiyea"
        "SG2" | "" | Tense.HABITUAL        | "hatsvsiyesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsvsiyevi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsvsiyevi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsvsiyedi"
        "SG3" | "" | Tense.PRESENT         | "atsvsiyea"
        "SG3" | "" | Tense.HABITUAL        | "atsvsiyesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsvsiyevi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsvsiyevi"
        "SG3" | "" | Tense.INFINITIVE      | "utsvsiyedi"
        "PL3" | "" | Tense.PRESENT         | "anatsvsiyea"
        "PL3" | "" | Tense.HABITUAL        | "anatsvsiyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsvsiyevi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsvsiyevi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsvsiyedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsvsiyea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsvsiyesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsvsiyevi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsvsiyevi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsvsiyedi"
    }
}
