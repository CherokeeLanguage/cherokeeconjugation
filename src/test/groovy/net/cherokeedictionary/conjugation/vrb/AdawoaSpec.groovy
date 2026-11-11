package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdawoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Swimming, Bathing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadawoa', habitual: 'gadawosgoi', remote_past: 'agwadawovi', imperative: 'gadawoja', infinitive: 'agwadawosdi'],
            [subject: 'SG2', object: '', present: 'hadawoa', habitual: 'hadawosgoi', remote_past: 'jadawovi', imperative: 'hadawoja', infinitive: 'jadawosdi'],
            [subject: 'SG3', object: '', present: 'adawoa', habitual: 'adawosgoi', remote_past: 'udawovi', imperative: 'adawoja', infinitive: 'udawosdi'],
            [subject: 'PL3', object: '', present: 'anadawoa', habitual: 'anadawosgoi', remote_past: 'unadawovi', imperative: 'anadawoja', infinitive: 'unadawosdi'],
            [subject: 'PL1INCL', object: '', present: 'idadawoa', habitual: 'idadawosgoi', remote_past: 'igadawovi', imperative: 'idadawoja', infinitive: 'igadawosdi']
        ]
    ]

    @Unroll
    def "conjugating Adawoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adawoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadawoa"
        "SG1" | "" | Tense.HABITUAL        | "gadawosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadawovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadawoja"
        "SG1" | "" | Tense.INFINITIVE      | "agwadawosdi"
        "SG2" | "" | Tense.PRESENT         | "hadawoa"
        "SG2" | "" | Tense.HABITUAL        | "hadawosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadawovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadawoja"
        "SG2" | "" | Tense.INFINITIVE      | "jadawosdi"
        "SG3" | "" | Tense.PRESENT         | "adawoa"
        "SG3" | "" | Tense.HABITUAL        | "adawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udawovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adawoja"
        "SG3" | "" | Tense.INFINITIVE      | "udawosdi"
        "PL3" | "" | Tense.PRESENT         | "anadawoa"
        "PL3" | "" | Tense.HABITUAL        | "anadawosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadawovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadawoja"
        "PL3" | "" | Tense.INFINITIVE      | "unadawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadawoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadawosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadawovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadawoja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadawosdi"
    }
}
