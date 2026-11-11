package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AliheligaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Happy, Thankful",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galieliga', habitual: 'galieligoi', remote_past: 'agwalihelijvi', imperative: 'galieligi', infinitive: 'agwalihelisdi'],
            [subject: 'SG2', object: '', present: 'haliheliga', habitual: 'haliheligoi', remote_past: 'jalihelijvi', imperative: 'haliheligi', infinitive: 'jalihelisdi'],
            [subject: 'SG3', object: '', present: 'aliheliga', habitual: 'aliheligoi', remote_past: 'ulihelijvi', imperative: 'aliheligi', infinitive: 'ulihelisdi'],
            [subject: 'PL3', object: '', present: 'analiheliga', habitual: 'analiheligoi', remote_past: 'unahelijvi', imperative: 'analiheligi', infinitive: 'unalihelisdi'],
            [subject: 'PL1INCL', object: '', present: 'idaliheliga', habitual: 'idaliheligoi', remote_past: 'igahelijvi', imperative: 'idaliheligi', infinitive: 'igalihelisdi']
        ]
    ]

    @Unroll
    def "conjugating Aliheliga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aliheliga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galieliga"
        "SG1" | "" | Tense.HABITUAL        | "galieligoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalihelijvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galieligi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalihelisdi"
        "SG2" | "" | Tense.PRESENT         | "haliheliga"
        "SG2" | "" | Tense.HABITUAL        | "haliheligoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalihelijvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haliheligi"
        "SG2" | "" | Tense.INFINITIVE      | "jalihelisdi"
        "SG3" | "" | Tense.PRESENT         | "aliheliga"
        "SG3" | "" | Tense.HABITUAL        | "aliheligoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulihelijvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aliheligi"
        "SG3" | "" | Tense.INFINITIVE      | "ulihelisdi"
        "PL3" | "" | Tense.PRESENT         | "analiheliga"
        "PL3" | "" | Tense.HABITUAL        | "analiheligoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahelijvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analiheligi"
        "PL3" | "" | Tense.INFINITIVE      | "unalihelisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaliheliga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaliheligoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahelijvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaliheligi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalihelisdi"
    }
}
