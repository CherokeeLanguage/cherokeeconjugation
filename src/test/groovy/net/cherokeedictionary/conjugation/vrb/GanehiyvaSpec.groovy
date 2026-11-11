package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehiyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jineiyva', habitual: 'jineiyvsgoi', remote_past: 'aginehiyvsvi', imperative: 'jineiyvna', infinitive: 'aginehiyvsdi'],
            [subject: 'SG2', object: '', present: 'hinehiyva', habitual: 'hinehiyvsgoi', remote_past: 'janehiyvsvi', imperative: 'hinehiyvna', infinitive: 'janehiyvsdi'],
            [subject: 'SG1', object: '', present: 'ganehiyva', habitual: 'ganehiyvsgoi', remote_past: 'unehiyvsvi', imperative: 'wiganehiyvna', infinitive: 'unehiyvsdi'],
            [subject: 'PL3', object: '', present: 'aninehiyva', habitual: 'aninehiyvsgoi', remote_past: 'uninehiyvsvi', imperative: 'waninehiyvna', infinitive: 'uninehiyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehiyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehiyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineiyva"
        "SG1" | "" | Tense.HABITUAL        | "jineiyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jineiyvna"
        "SG1" | "" | Tense.INFINITIVE      | "aginehiyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinehiyva"
        "SG2" | "" | Tense.HABITUAL        | "hinehiyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehiyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehiyvna"
        "SG2" | "" | Tense.INFINITIVE      | "janehiyvsdi"
        "SG1" | "" | Tense.PRESENT         | "ganehiyva"
        "SG1" | "" | Tense.HABITUAL        | "ganehiyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unehiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganehiyvna"
        "SG1" | "" | Tense.INFINITIVE      | "unehiyvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninehiyva"
        "PL3" | "" | Tense.HABITUAL        | "aninehiyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehiyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninehiyvna"
        "PL3" | "" | Tense.INFINITIVE      | "uninehiyvsdi"
    }
}
