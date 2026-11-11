package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkwiyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Paying (It)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gagwiyiha', habitual: 'gagwiyisgoi', remote_past: 'akikwiyvhvi', imperative: 'gagwiya', infinitive: 'akikwiyhdi'],
            [subject: 'SG2', object: '', present: 'hakwiyiha', habitual: 'hakwiyisgoi', remote_past: 'jakwiyvhvi', imperative: 'hakwiya', infinitive: 'jakwiyhdi'],
            [subject: 'SG3', object: '', present: 'akwiyiha', habitual: 'akwiyisgoi', remote_past: 'ukwiyvhvi', imperative: 'akwiya', infinitive: 'ukwiyhdi'],
            [subject: 'PL3', object: '', present: 'anakwiyiha', habitual: 'anakwiyisgoi', remote_past: 'unikwiyvhvi', imperative: 'anakwiya', infinitive: 'unakwiyhdi'],
            [subject: 'PL1INCL', object: '', present: 'idakwiyiha', habitual: 'idakwiyisgoi', remote_past: 'igikwiyvhvi', imperative: 'idakwiya', infinitive: 'igakwiyhdi']
        ]
    ]

    @Unroll
    def "conjugating Akwiyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akwiyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gagwiyiha"
        "SG1" | "" | Tense.HABITUAL        | "gagwiyisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akikwiyvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gagwiya"
        "SG1" | "" | Tense.INFINITIVE      | "akikwiyhdi"
        "SG2" | "" | Tense.PRESENT         | "hakwiyiha"
        "SG2" | "" | Tense.HABITUAL        | "hakwiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jakwiyvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hakwiya"
        "SG2" | "" | Tense.INFINITIVE      | "jakwiyhdi"
        "SG3" | "" | Tense.PRESENT         | "akwiyiha"
        "SG3" | "" | Tense.HABITUAL        | "akwiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukwiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "akwiya"
        "SG3" | "" | Tense.INFINITIVE      | "ukwiyhdi"
        "PL3" | "" | Tense.PRESENT         | "anakwiyiha"
        "PL3" | "" | Tense.HABITUAL        | "anakwiyisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikwiyvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anakwiya"
        "PL3" | "" | Tense.INFINITIVE      | "unakwiyhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idakwiyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idakwiyisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikwiyvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idakwiya"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igakwiyhdi"
    }
}
