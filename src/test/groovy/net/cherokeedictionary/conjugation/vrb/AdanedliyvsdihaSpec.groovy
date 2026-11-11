package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanedliyvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Taking Turns, Change",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanedliyvsdiha', habitual: 'gadanedliyvsdisgoi', remote_past: 'agwadanedliyvstanvi', imperative: 'gadanedliyvsda', infinitive: 'agwadanedliyvsdohdi'],
            [subject: 'SG2', object: '', present: 'hadanedliyvsdiha', habitual: 'hadanedliyvsdisgoi', remote_past: 'jadanedliyvstanvi', imperative: 'hadanedliyvsda', infinitive: 'jadanedliyvsdohdi'],
            [subject: 'SG3', object: '', present: 'adanedliyvsdiha', habitual: 'adanedliyvsdisgoi', remote_past: 'udanedliyvstanvi', imperative: 'adanedliyvsda', infinitive: 'udanedliyvsdohdi'],
            [subject: 'PL3', object: '', present: 'anadanedliyvsdiha', habitual: 'anadanedliyvsdisgoi', remote_past: 'unadanedliyvstanvi', imperative: 'anadanedliyvsda', infinitive: 'unadanedliyvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanedliyvsdiha', habitual: 'idadanedliyvsdisgoi', remote_past: 'igadanedliyvstanvi', imperative: 'idadanedliyvsda', infinitive: 'igadanedliyvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adanedliyvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanedliyvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanedliyvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadanedliyvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanedliyvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanedliyvsda"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanedliyvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "hadanedliyvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadanedliyvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanedliyvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanedliyvsda"
        "SG2" | "" | Tense.INFINITIVE      | "jadanedliyvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "adanedliyvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "adanedliyvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanedliyvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanedliyvsda"
        "SG3" | "" | Tense.INFINITIVE      | "udanedliyvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "anadanedliyvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anadanedliyvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanedliyvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanedliyvsda"
        "PL3" | "" | Tense.INFINITIVE      | "unadanedliyvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanedliyvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanedliyvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanedliyvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanedliyvsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanedliyvsdohdi"
    }
}
