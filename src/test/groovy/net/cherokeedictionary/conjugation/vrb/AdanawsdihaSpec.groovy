package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanawsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Running, Take Off",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadanawsdiha', habitual: 'gadanawsdisgoi', remote_past: 'agwadanawstanvi', imperative: 'gadanawsda', infinitive: 'agwadanawsdohdi'],
            [subject: 'SG2', object: '', present: 'hadanawsdiha', habitual: 'hadanawsdisgoi', remote_past: 'jadanawstanvi', imperative: 'hadanawsda', infinitive: 'jadanawsdohdi'],
            [subject: 'SG3', object: '', present: 'adanawsdiha', habitual: 'adanawsdisgoi', remote_past: 'udanawstanvi', imperative: 'adanawsda', infinitive: 'udanawsdohdi'],
            [subject: 'PL3', object: '', present: 'danadanawsdiha', habitual: 'danadanawsdisgoi', remote_past: 'unadanawstanvi', imperative: 'anadanawsda', infinitive: 'unadanawsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadanawsdiha', habitual: 'dedadanawsdisgoi', remote_past: 'igadanawstanvi', imperative: 'idadanawsda', infinitive: 'igadanawsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adanawsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanawsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanawsdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadanawsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanawstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanawsda"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanawsdohdi"
        "SG2" | "" | Tense.PRESENT         | "hadanawsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadanawsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanawstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanawsda"
        "SG2" | "" | Tense.INFINITIVE      | "jadanawsdohdi"
        "SG3" | "" | Tense.PRESENT         | "adanawsdiha"
        "SG3" | "" | Tense.HABITUAL        | "adanawsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanawstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanawsda"
        "SG3" | "" | Tense.INFINITIVE      | "udanawsdohdi"
        "PL3" | "" | Tense.PRESENT         | "danadanawsdiha"
        "PL3" | "" | Tense.HABITUAL        | "danadanawsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanawstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanawsda"
        "PL3" | "" | Tense.INFINITIVE      | "unadanawsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedadanawsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedadanawsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanawstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanawsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanawsdohdi"
    }
}
