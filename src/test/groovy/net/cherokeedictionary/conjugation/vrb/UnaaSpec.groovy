package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'aginaa', habitual: 'aginaoi', remote_past: 'aginavi', imperative: 'aginaesdi', infinitive: 'aginvdi'],
            [subject: 'SG2', object: '', present: 'janaa', habitual: 'janaoi', remote_past: 'janavi', imperative: 'janaesdi', infinitive: 'janvdi'],
            [subject: 'SG3', object: '', present: 'unaa', habitual: 'unaoi', remote_past: 'unavi', imperative: 'unaesdi', infinitive: 'unvdi'],
            [subject: 'PL3', object: '', present: 'uninaa', habitual: 'uninaoi', remote_past: 'uninavi', imperative: 'uninaesdi', infinitive: 'uninvdi']
        ]
    ]

    @Unroll
    def "conjugating Unaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginaa"
        "SG1" | "" | Tense.HABITUAL        | "aginaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginaesdi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvdi"
        "SG2" | "" | Tense.PRESENT         | "janaa"
        "SG2" | "" | Tense.HABITUAL        | "janaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "janaesdi"
        "SG2" | "" | Tense.INFINITIVE      | "janvdi"
        "SG3" | "" | Tense.PRESENT         | "unaa"
        "SG3" | "" | Tense.HABITUAL        | "unaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unaesdi"
        "SG3" | "" | Tense.INFINITIVE      | "unvdi"
        "PL3" | "" | Tense.PRESENT         | "uninaa"
        "PL3" | "" | Tense.HABITUAL        | "uninaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninaesdi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvdi"
    }
}
