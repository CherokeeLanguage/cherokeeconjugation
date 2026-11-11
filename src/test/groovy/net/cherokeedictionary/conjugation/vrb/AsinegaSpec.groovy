package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsinegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Backing Up",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gasinega', habitual: 'gasinegoi', remote_past: 'agwasinvsvi', imperative: 'gasinuga', infinitive: 'agwasinvsdi'],
            [subject: 'SG2', object: '', present: 'hasinega', habitual: 'hasinegoi', remote_past: 'jasinvsvi', imperative: 'hasinuga', infinitive: 'jasinvsdi'],
            [subject: 'SG3', object: '', present: 'asinega', habitual: 'asinegoi', remote_past: 'usinvsvi', imperative: 'asinuga', infinitive: 'usinvsdi'],
            [subject: 'PL3', object: '', present: 'anasinega', habitual: 'anasinegoi', remote_past: 'unasinvsvi', imperative: 'anisinuga', infinitive: 'unasinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idasinega', habitual: 'idasinegoi', remote_past: 'igasinvsvi', imperative: 'idisinuga', infinitive: 'igasinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Asinega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asinega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gasinega"
        "SG1" | "" | Tense.HABITUAL        | "gasinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwasinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasinuga"
        "SG1" | "" | Tense.INFINITIVE      | "agwasinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hasinega"
        "SG2" | "" | Tense.HABITUAL        | "hasinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasinuga"
        "SG2" | "" | Tense.INFINITIVE      | "jasinvsdi"
        "SG3" | "" | Tense.PRESENT         | "asinega"
        "SG3" | "" | Tense.HABITUAL        | "asinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asinuga"
        "SG3" | "" | Tense.INFINITIVE      | "usinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anasinega"
        "PL3" | "" | Tense.HABITUAL        | "anasinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unasinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisinuga"
        "PL3" | "" | Tense.INFINITIVE      | "unasinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasinega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisinuga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igasinvsdi"
    }
}
