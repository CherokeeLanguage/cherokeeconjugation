package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Gathering It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jihlisiha', habitual: 'jihlisisgoi', remote_past: 'akihlisahnvi', imperative: 'jihlisa', infinitive: 'akihlisohdi'],
            [subject: 'SG2', object: '', present: 'hihlvisiha', habitual: 'hihlisisgoi', remote_past: 'jahlisahnvi', imperative: 'hihlisa', infinitive: 'jahlisohdi'],
            [subject: 'SG3', object: '', present: 'gahlisiha', habitual: 'gahlisisgoi', remote_past: 'uwahlisahnvi', imperative: 'gahlisa', infinitive: 'uwahlisohdi'],
            [subject: 'PL3', object: '', present: 'anihlisiha', habitual: 'anihlisisgoi', remote_past: 'unihlisahnvi', imperative: 'anihlisa', infinitive: 'unihlisohdi'],
            [subject: 'PL1INCL', object: '', present: 'idihlisiha', habitual: 'idihlisisgoi', remote_past: 'igihlisahnvi', imperative: 'idihlisa', infinitive: 'igihlisohdi']
        ]
    ]

    @Unroll
    def "conjugating Gahlisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahlisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jihlisiha"
        "SG1" | "" | Tense.HABITUAL        | "jihlisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akihlisahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jihlisa"
        "SG1" | "" | Tense.INFINITIVE      | "akihlisohdi"
        "SG2" | "" | Tense.PRESENT         | "hihlvisiha"
        "SG2" | "" | Tense.HABITUAL        | "hihlisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahlisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlisa"
        "SG2" | "" | Tense.INFINITIVE      | "jahlisohdi"
        "SG3" | "" | Tense.PRESENT         | "gahlisiha"
        "SG3" | "" | Tense.HABITUAL        | "gahlisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwahlisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gahlisa"
        "SG3" | "" | Tense.INFINITIVE      | "uwahlisohdi"
        "PL3" | "" | Tense.PRESENT         | "anihlisiha"
        "PL3" | "" | Tense.HABITUAL        | "anihlisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihlisa"
        "PL3" | "" | Tense.INFINITIVE      | "unihlisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihlisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihlisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihlisahnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihlisa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihlisohdi"
    }
}
