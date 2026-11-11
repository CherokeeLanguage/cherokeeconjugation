package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwanigosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Amazed",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisgwanigosga', habitual: 'jisgwanigosgoi', remote_past: 'aksgwanigosvi', imperative: 'jisgwanigohi', infinitive: 'aksgwanigohisdi'],
            [subject: 'SG2', object: '', present: 'hisgwanigosga', habitual: 'hisgwanigosgoi', remote_past: 'tsgwanigosvi', imperative: 'hisgwanigohi', infinitive: 'tsgwanigohisdi'],
            [subject: 'SG3', object: '', present: 'asgwanigosga', habitual: 'asgwanigosgoi', remote_past: 'usgwanigosvi', imperative: 'asgwanigohi', infinitive: 'usgwanigohisdi'],
            [subject: 'PL3', object: '', present: 'anisgwanigosga', habitual: 'anisgwanigosgoi', remote_past: 'unisgwanigosvi', imperative: 'anisgwanigohi', infinitive: 'unisgwanigohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwanigosga', habitual: 'idisgwanigosgoi', remote_past: 'igisgwanigosvi', imperative: 'idisgwanigohi', infinitive: 'igisgwanigohisdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwanigosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwanigosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgwanigosga"
        "SG1" | "" | Tense.HABITUAL        | "jisgwanigosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgwanigosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisgwanigohi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgwanigohisdi"
        "SG2" | "" | Tense.PRESENT         | "hisgwanigosga"
        "SG2" | "" | Tense.HABITUAL        | "hisgwanigosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsgwanigosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgwanigohi"
        "SG2" | "" | Tense.INFINITIVE      | "tsgwanigohisdi"
        "SG3" | "" | Tense.PRESENT         | "asgwanigosga"
        "SG3" | "" | Tense.HABITUAL        | "asgwanigosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgwanigosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgwanigohi"
        "SG3" | "" | Tense.INFINITIVE      | "usgwanigohisdi"
        "PL3" | "" | Tense.PRESENT         | "anisgwanigosga"
        "PL3" | "" | Tense.HABITUAL        | "anisgwanigosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgwanigosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgwanigohi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgwanigohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgwanigosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgwanigosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgwanigosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgwanigohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgwanigohisdi"
    }
}
