package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhltawoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Combing His/Her Own Hair",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galitawoa', habitual: 'galitawosgoi', remote_past: 'agwahltawovi', imperative: 'galitawoja', infinitive: 'agwahltawosdi'],
            [subject: 'SG2', object: '', present: 'hahltawoa', habitual: 'hahltawosgoi', remote_past: 'jahltawovi', imperative: 'hahltawoja', infinitive: 'jahltawosdi'],
            [subject: 'SG3', object: '', present: 'ahltawoa', habitual: 'ahltawosgoi', remote_past: 'uhltawovi', imperative: 'ahltawoja', infinitive: 'uhltawosdi'],
            [subject: 'PL3', object: '', present: 'danahltawoa', habitual: 'danahltawosgoi', remote_past: 'dunahltawovi', imperative: 'dinahltawoja', infinitive: 'junahltawosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedahltawoa', habitual: 'dedahltawosgoi', remote_past: 'degahltawovi', imperative: 'didahltawoja', infinitive: 'digahltawosdi']
        ]
    ]

    @Unroll
    def "conjugating Ahltawoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahltawoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galitawoa"
        "SG1" | "" | Tense.HABITUAL        | "galitawosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahltawovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galitawoja"
        "SG1" | "" | Tense.INFINITIVE      | "agwahltawosdi"
        "SG2" | "" | Tense.PRESENT         | "hahltawoa"
        "SG2" | "" | Tense.HABITUAL        | "hahltawosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahltawovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahltawoja"
        "SG2" | "" | Tense.INFINITIVE      | "jahltawosdi"
        "SG3" | "" | Tense.PRESENT         | "ahltawoa"
        "SG3" | "" | Tense.HABITUAL        | "ahltawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhltawovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahltawoja"
        "SG3" | "" | Tense.INFINITIVE      | "uhltawosdi"
        "PL3" | "" | Tense.PRESENT         | "danahltawoa"
        "PL3" | "" | Tense.HABITUAL        | "danahltawosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunahltawovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinahltawoja"
        "PL3" | "" | Tense.INFINITIVE      | "junahltawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedahltawoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedahltawosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degahltawovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didahltawoja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digahltawosdi"
    }
}
