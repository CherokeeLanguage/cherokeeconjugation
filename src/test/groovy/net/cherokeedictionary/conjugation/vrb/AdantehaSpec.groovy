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
        "SG1" | "" | Tense.PRESENT         | "gadaniteha"
        "SG1" | "" | Tense.HABITUAL        | "gadanitesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanitetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanitetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanitedi"
        "SG2" | "" | Tense.PRESENT         | "hadaniteha"
        "SG2" | "" | Tense.HABITUAL        | "hadanitesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanitetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanitetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanitedi"
        "SG3" | "" | Tense.PRESENT         | "adaniteha"
        "SG3" | "" | Tense.HABITUAL        | "adanitesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanitetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanitetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanitedi"
        "PL3" | "" | Tense.PRESENT         | "anadaniteha"
        "PL3" | "" | Tense.HABITUAL        | "anadanitesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanitetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanitetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanitedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadaniteha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanitesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanitetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanitetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanitedi"
    }
}
