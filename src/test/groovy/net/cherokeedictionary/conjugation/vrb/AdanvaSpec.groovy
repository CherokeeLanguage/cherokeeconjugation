package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Moving",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanva', habitual: 'gadanvsgoi', remote_past: 'agwadanvsvi', imperative: 'gadanvna', infinitive: 'agwadanvsdi'],
            [subject: 'SG2', object: '', present: 'hadanva', habitual: 'hadanvsgoi', remote_past: 'jadanvsvi', imperative: 'hadanvna', infinitive: 'jadanvsdi'],
            [subject: 'SG3', object: '', present: 'adanva', habitual: 'adanvsgoi', remote_past: 'udanvsvi', imperative: 'adanvna', infinitive: 'udanvsdi'],
            [subject: 'PL3', object: '', present: 'anadanva', habitual: 'anadanvsgoi', remote_past: 'unadanvsvi', imperative: 'anadanvna', infinitive: 'unadanvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanva', habitual: 'idadanvsgoi', remote_past: 'igadanvsvi', imperative: 'idadanvna', infinitive: 'igadanvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adanva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanva"
        "SG1" | "" | Tense.HABITUAL        | "gadanvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanvna"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanva"
        "SG2" | "" | Tense.HABITUAL        | "hadanvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanvna"
        "SG2" | "" | Tense.INFINITIVE      | "jadanvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanva"
        "SG3" | "" | Tense.HABITUAL        | "adanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanvna"
        "SG3" | "" | Tense.INFINITIVE      | "udanvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanva"
        "PL3" | "" | Tense.HABITUAL        | "anadanvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanvna"
        "PL3" | "" | Tense.INFINITIVE      | "unadanvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanvsdi"
    }
}
