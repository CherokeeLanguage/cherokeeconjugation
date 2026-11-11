package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanhtehiloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Pondering, Considering",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanvtehiloa', habitual: 'gadanhtehilosgoi', remote_past: 'agwadanhtehilovi', imperative: 'gadanhtehiloja', infinitive: 'agwadanhtehilosdi'],
            [subject: 'SG2', object: '', present: 'hadanvtehiloa', habitual: 'hadanhtehilosgoi', remote_past: 'jadanhtehilovi', imperative: 'hadanhtehiloja', infinitive: 'jadanhtehilosdi'],
            [subject: 'SG3', object: '', present: 'adanvtehiloa', habitual: 'adanhtehilosgoi', remote_past: 'udanhtehilovi', imperative: 'adanhtehiloja', infinitive: 'udanhtehilosdi'],
            [subject: 'PL3', object: '', present: 'anadanvtehiloa', habitual: 'anadanhtehilosgoi', remote_past: 'unadanhtehilovi', imperative: 'anadanhtehiloja', infinitive: 'unadanhtehilosdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanvtehiloa', habitual: 'idadanhtehilosgoi', remote_past: 'igadanhtehilovi', imperative: 'idadanhtehiloja', infinitive: 'igadanhtehilosdi']
        ]
    ]

    @Unroll
    def "conjugating Adanhtehiloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanhtehiloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanvtehiloa"
        "SG1" | "" | Tense.HABITUAL        | "gadanhtehilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanhtehilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanhtehiloja"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanhtehilosdi"
        "SG2" | "" | Tense.PRESENT         | "hadanvtehiloa"
        "SG2" | "" | Tense.HABITUAL        | "hadanhtehilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanhtehilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanhtehiloja"
        "SG2" | "" | Tense.INFINITIVE      | "jadanhtehilosdi"
        "SG3" | "" | Tense.PRESENT         | "adanvtehiloa"
        "SG3" | "" | Tense.HABITUAL        | "adanhtehilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanhtehilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanhtehiloja"
        "SG3" | "" | Tense.INFINITIVE      | "udanhtehilosdi"
        "PL3" | "" | Tense.PRESENT         | "anadanvtehiloa"
        "PL3" | "" | Tense.HABITUAL        | "anadanhtehilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanhtehilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanhtehiloja"
        "PL3" | "" | Tense.INFINITIVE      | "unadanhtehilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanvtehiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanhtehilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanhtehilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanhtehiloja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanhtehilosdi"
    }
}
