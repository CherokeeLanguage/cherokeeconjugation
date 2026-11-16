package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AliidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Exchanging/Trading It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galiidia', habitual: 'galiidisgoi', remote_past: 'agwaliidvi', imperative: 'galiida', infinitive: 'agwaliidisdi'],
            [subject: 'SG2', object: '', present: 'haliidia', habitual: 'haliidisgoi', remote_past: 'jaliidvi', imperative: 'haliida', infinitive: 'jaliidisdi'],
            [subject: 'SG3', object: '', present: 'aliidia', habitual: 'aliidisgoi', remote_past: 'uliidvi', imperative: 'aliida', infinitive: 'uliidisdi'],
            [subject: 'PL3', object: '', present: 'analiidia', habitual: 'analiidisgoi', remote_past: 'unaliidvi', imperative: 'analiida', infinitive: 'unaliidisdi'],
            [subject: 'PL1INCL', object: '', present: 'idaliidia', habitual: 'idaliidisgoi', remote_past: 'igaliidvi', imperative: 'idaliida', infinitive: 'igaliidisdi']
        ]
    ]

    @Unroll
    def "conjugating Aliidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aliidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galiidia"
        "SG1" | "" | Tense.HABITUAL        | "galiidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualiidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galiidvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualiidisdi"
        "SG2" | "" | Tense.PRESENT         | "haliidia"
        "SG2" | "" | Tense.HABITUAL        | "haliidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaliidvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haliidvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaliidisdi"
        "SG3" | "" | Tense.PRESENT         | "aliidia"
        "SG3" | "" | Tense.HABITUAL        | "aliidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uliidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aliidvi"
        "SG3" | "" | Tense.INFINITIVE      | "uliidisdi"
        "PL3" | "" | Tense.PRESENT         | "analiidia"
        "PL3" | "" | Tense.HABITUAL        | "analiidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaliidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analiidvi"
        "PL3" | "" | Tense.INFINITIVE      | "unaliidisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaliidia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaliidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaliidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaliidvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaliidisdi"
    }
}
