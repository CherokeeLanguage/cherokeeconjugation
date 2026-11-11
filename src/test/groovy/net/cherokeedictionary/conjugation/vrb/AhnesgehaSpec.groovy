package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnesgehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Building It (25)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganesgeha', habitual: 'ganesgesgoi', remote_past: 'agwahnesgehvi', imperative: 'ganesgvla', infinitive: 'agwahnesgehdi'],
            [subject: 'SG2', object: '', present: 'hahnesgeha', habitual: 'hahnesgesgoi', remote_past: 'jahnesgehvi', imperative: 'hahnesgvla', infinitive: 'jahnesgehdi'],
            [subject: 'SG3', object: '', present: 'ahnesgeha', habitual: 'ahnesgesgoi', remote_past: 'uhnesgehvi', imperative: 'ahnesgvla', infinitive: 'uhnesgehdi'],
            [subject: 'PL3', object: '', present: 'anahnesgeha', habitual: 'anahnesgesgoi', remote_past: 'unahnesgehvi', imperative: 'anahnesgvla', infinitive: 'unahnesgehdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnesgeha', habitual: 'idahnesgesgoi', remote_past: 'igahnesgehvi', imperative: 'idahnesgvla', infinitive: 'igahnesgehdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnesgeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnesgeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganesgeha"
        "SG1" | "" | Tense.HABITUAL        | "ganesgesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnesgehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganesgvla"
        "SG1" | "" | Tense.INFINITIVE      | "agwahnesgehdi"
        "SG2" | "" | Tense.PRESENT         | "hahnesgeha"
        "SG2" | "" | Tense.HABITUAL        | "hahnesgesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnesgehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahnesgvla"
        "SG2" | "" | Tense.INFINITIVE      | "jahnesgehdi"
        "SG3" | "" | Tense.PRESENT         | "ahnesgeha"
        "SG3" | "" | Tense.HABITUAL        | "ahnesgesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnesgehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahnesgvla"
        "SG3" | "" | Tense.INFINITIVE      | "uhnesgehdi"
        "PL3" | "" | Tense.PRESENT         | "anahnesgeha"
        "PL3" | "" | Tense.HABITUAL        | "anahnesgesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnesgehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahnesgvla"
        "PL3" | "" | Tense.INFINITIVE      | "unahnesgehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahnesgeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahnesgesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnesgehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idahnesgvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahnesgehdi"
    }
}
