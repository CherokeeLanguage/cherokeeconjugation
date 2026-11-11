package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdantehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Thinking",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanvteha', habitual: 'gadanvtesgoi', remote_past: 'agwadanhtehlvi', imperative: 'gadanvtvla', infinitive: 'agwadanhtehdi'],
            [subject: 'SG2', object: '', present: 'hadanteha', habitual: 'hadantesgoi', remote_past: 'jadanhtehlvi', imperative: 'hadanhtvla', infinitive: 'jadanhtehdi'],
            [subject: 'SG3', object: '', present: 'adanteha', habitual: 'adantesgoi', remote_past: 'udanhtehlvi', imperative: 'adanhtvla', infinitive: 'udanhtehdi'],
            [subject: 'PL3', object: '', present: 'anadanteha', habitual: 'anadantesgoi', remote_past: 'unadanhtehlvi', imperative: 'anadanhtvla', infinitive: 'unadanhtehdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanteha', habitual: 'idadantesgoi', remote_past: 'igadanhtehlvi', imperative: 'idadanhtvla', infinitive: 'igadanhtehdi']
        ]
    ]

    @Unroll
    def "conjugating Adanteha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanteha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanvteha"
        "SG1" | "" | Tense.HABITUAL        | "gadanvtesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanhtehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanvtvla"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanhtehdi"
        "SG2" | "" | Tense.PRESENT         | "hadanteha"
        "SG2" | "" | Tense.HABITUAL        | "hadantesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanhtehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanhtvla"
        "SG2" | "" | Tense.INFINITIVE      | "jadanhtehdi"
        "SG3" | "" | Tense.PRESENT         | "adanteha"
        "SG3" | "" | Tense.HABITUAL        | "adantesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanhtehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanhtvla"
        "SG3" | "" | Tense.INFINITIVE      | "udanhtehdi"
        "PL3" | "" | Tense.PRESENT         | "anadanteha"
        "PL3" | "" | Tense.HABITUAL        | "anadantesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanhtehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanhtvla"
        "PL3" | "" | Tense.INFINITIVE      | "unadanhtehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanteha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadantesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanhtehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanhtvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanhtehdi"
    }
}
