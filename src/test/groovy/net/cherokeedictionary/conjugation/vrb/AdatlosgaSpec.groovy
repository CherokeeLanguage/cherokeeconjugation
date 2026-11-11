package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdatlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Winning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadatlosga', habitual: 'gadatlosgoi', remote_past: 'agwadatlosvi', imperative: 'gadatlohi', infinitive: 'agwadatlohisdi'],
            [subject: 'SG2', object: '', present: 'hadatlosga', habitual: 'hadatlosgoi', remote_past: 'jadatlosvi', imperative: 'hadatlohi', infinitive: 'jadatlohisdi'],
            [subject: 'SG3', object: '', present: 'adatlosga', habitual: 'adatlosgoi', remote_past: 'udatlosvi', imperative: 'adatlohi', infinitive: 'udatlohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idadatlosga', habitual: 'idadatlosgoi', remote_past: 'igadatlosvi', imperative: 'idadatlohi', infinitive: 'igadatlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Adatlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adatlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadatlosga"
        "SG1" | "" | Tense.HABITUAL        | "gadatlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadatlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadatlohi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadatlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadatlosga"
        "SG2" | "" | Tense.HABITUAL        | "hadatlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadatlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadatlohi"
        "SG2" | "" | Tense.INFINITIVE      | "jadatlohisdi"
        "SG3" | "" | Tense.PRESENT         | "adatlosga"
        "SG3" | "" | Tense.HABITUAL        | "adatlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udatlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adatlohi"
        "SG3" | "" | Tense.INFINITIVE      | "udatlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadatlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadatlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadatlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadatlohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadatlohisdi"
    }
}
