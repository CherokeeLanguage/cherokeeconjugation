package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hearing",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvgia', habitual: 'jiyatvgisgoi', remote_past: 'jiyatvganvi', imperative: 'jiyatvgvga', infinitive: 'jiyatvgodi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvgia', habitual: 'gatvgisgoi', remote_past: 'aktvganvi', imperative: 'gatvgvga', infinitive: 'aktvgodi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvgia', habitual: 'hiyatvgisgoi', remote_past: 'hiyatvganvi', imperative: 'hiyatvgvga', infinitive: 'hiyatvgodi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvgia', habitual: 'hatvgisgoi', remote_past: 'tstvganvi', imperative: 'hatvgvga', infinitive: 'tstvgodi'],
            [subject: 'SG3', object: 'SG3IN', present: 'atvgia', habitual: 'atvgisgoi', remote_past: 'utvganvi', imperative: 'atvgvga', infinitive: 'utvgodi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvgia', habitual: 'anatvgisgoi', remote_past: 'unatvganvi', imperative: 'anatvgvga', infinitive: 'unatvgodi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvgia', habitual: 'idatvgisgoi', remote_past: 'iktvganvi', imperative: 'idatvgvga', infinitive: 'iktvgodi']
        ]
    ]

    @Unroll
    def "conjugating Atvgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvgia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvgisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvganvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatvgvga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvgodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gatvgia"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gatvgisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aktvganvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gatvgvga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aktvgodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvgia"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvgisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvganvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatvgvga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvgodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvgia"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvgisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tstvganvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hatvgvga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tstvgodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "atvgia"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "atvgisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "utvganvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "atvgvga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utvgodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvgia"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvgisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvganvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anatvgvga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvgodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idatvgia"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idatvgisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iktvganvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idatvgvga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iktvgodi"
    }
}
