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
        "SG1" | "" | Tense.PRESENT         | "gajvsiyea"
        "SG1" | "" | Tense.HABITUAL        | "gajvsiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajvsiyevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gajvsiya"
        "SG1" | "" | Tense.INFINITIVE      | "agwajvsiyedi"
        "SG2" | "" | Tense.PRESENT         | "hajvsiyea"
        "SG2" | "" | Tense.HABITUAL        | "hajvsiyesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajvsiyevi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hajvsiya"
        "SG2" | "" | Tense.INFINITIVE      | "jajvsiyedi"
        "SG3" | "" | Tense.PRESENT         | "ajvsiyea"
        "SG3" | "" | Tense.HABITUAL        | "ajvsiyesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujvsiyevi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajvsiya"
        "SG3" | "" | Tense.INFINITIVE      | "ujvsiyedi"
        "PL3" | "" | Tense.PRESENT         | "anajvsiyea"
        "PL3" | "" | Tense.HABITUAL        | "anajvsiyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajvsiyevi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anajvsiya"
        "PL3" | "" | Tense.INFINITIVE      | "unajvsiyedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajvsiyea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajvsiyesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajvsiyevi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idajvsiya"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajvsiyedi"
    }
}
