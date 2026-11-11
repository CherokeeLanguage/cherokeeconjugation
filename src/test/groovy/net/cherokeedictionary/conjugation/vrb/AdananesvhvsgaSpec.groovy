package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdananesvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shopping",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadananesvhvsga', habitual: 'gadananesvhvsgoi', remote_past: 'agwadananesvhnvi', imperative: 'gadananesvhvga', infinitive: 'agwadananesvhvsdi'],
            [subject: 'SG2', object: '', present: 'hadananesvhvsga', habitual: 'hadananesvhvsgoi', remote_past: 'jadananesvhnvi', imperative: 'hadananesvhvga', infinitive: 'jadananesvhvsdi'],
            [subject: 'SG3', object: '', present: 'adananesvhvsga', habitual: 'adananesvhvsgoi', remote_past: 'udananesvhnvi', imperative: 'adananesvhvga', infinitive: 'udananesvhvsdi'],
            [subject: 'PL3', object: '', present: 'anadananesvhvsga', habitual: 'anadananesvhvsgoi', remote_past: 'unadananesvhnvi', imperative: 'anadananesvhvga', infinitive: 'unadananesvhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadananesvhvsga', habitual: 'idadananesvhvsgoi', remote_past: 'igadananesvhnvi', imperative: 'idadananesvhvga', infinitive: 'igadananesvhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adananesvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adananesvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadananesvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadananesvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadananesvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadananesvhvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadananesvhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadananesvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadananesvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadananesvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadananesvhvga"
        "SG2" | "" | Tense.INFINITIVE      | "jadananesvhvsdi"
        "SG3" | "" | Tense.PRESENT         | "adananesvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "adananesvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udananesvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adananesvhvga"
        "SG3" | "" | Tense.INFINITIVE      | "udananesvhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadananesvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadananesvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadananesvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadananesvhvga"
        "PL3" | "" | Tense.INFINITIVE      | "unadananesvhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadananesvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadananesvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadananesvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadananesvhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadananesvhvsdi"
    }
}
