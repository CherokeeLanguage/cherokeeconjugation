package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwahleaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Catching It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisgwahlea', habitual: 'jisgwahlesgoi', remote_past: 'aksgwahlesvi', imperative: 'jisgwahlagi', infinitive: 'aksgwahlesdi'],
            [subject: 'SG2', object: '', present: 'hisgwahlea', habitual: 'hisgwahlesgoi', remote_past: 'tsgwahlesvi', imperative: 'hisgwahlagi', infinitive: 'tsgwahlesdi'],
            [subject: 'SG3', object: '', present: 'asgwahlea', habitual: 'asgwahlesgoi', remote_past: 'usgwahlesvi', imperative: 'asgwahlagi', infinitive: 'usgwahlesdi'],
            [subject: 'PL3', object: '', present: 'anisgwahlea', habitual: 'anisgwahlesgoi', remote_past: 'unisgwahlesvi', imperative: 'anisgwahlagi', infinitive: 'unisgwahlesdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwahlea', habitual: 'idisgwahlesgoi', remote_past: 'iksgwahlesvi', imperative: 'idisgwahlagi', infinitive: 'iksgwahlesdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwahlea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwahlea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgwahlea"
        "SG1" | "" | Tense.HABITUAL        | "jisgwahlesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgwahlesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisgwahlagi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgwahlesdi"
        "SG2" | "" | Tense.PRESENT         | "hisgwahlea"
        "SG2" | "" | Tense.HABITUAL        | "hisgwahlesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsgwahlesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgwahlagi"
        "SG2" | "" | Tense.INFINITIVE      | "tsgwahlesdi"
        "SG3" | "" | Tense.PRESENT         | "asgwahlea"
        "SG3" | "" | Tense.HABITUAL        | "asgwahlesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgwahlesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgwahlagi"
        "SG3" | "" | Tense.INFINITIVE      | "usgwahlesdi"
        "PL3" | "" | Tense.PRESENT         | "anisgwahlea"
        "PL3" | "" | Tense.HABITUAL        | "anisgwahlesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgwahlesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgwahlagi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgwahlesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgwahlea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgwahlesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksgwahlesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgwahlagi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksgwahlesdi"
    }
}
