package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agiha', habitual: 'agihoi', remote_past: 'agihvi', imperative: 'agihesdi', infinitive: 'agihdi'],
            [subject: 'SG2', object: '', present: 'jaha', habitual: 'jahoi', remote_past: 'jahvi', imperative: 'jahesdi', infinitive: 'jahdi'],
            [subject: 'SG3', object: '', present: 'uha', habitual: 'uhoi', remote_past: 'uhvi', imperative: 'uhesdi', infinitive: 'uhdi'],
            [subject: 'PL3', object: '', present: 'uniha', habitual: 'unihoi', remote_past: 'unihvi', imperative: 'unihesdi', infinitive: 'unihdi']
        ]
    ]

    @Unroll
    def "conjugating Uha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiha"
        "SG1" | "" | Tense.HABITUAL        | "agihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agihesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agihdi"
        "SG2" | "" | Tense.PRESENT         | "jaha"
        "SG2" | "" | Tense.HABITUAL        | "jahoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jahesdi"
        "SG2" | "" | Tense.INFINITIVE      | "jahdi"
        "SG3" | "" | Tense.PRESENT         | "uha"
        "SG3" | "" | Tense.HABITUAL        | "uhoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhesdi"
        "SG3" | "" | Tense.INFINITIVE      | "uhdi"
        "PL3" | "" | Tense.PRESENT         | "uniha"
        "PL3" | "" | Tense.HABITUAL        | "unihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unihesdi"
        "PL3" | "" | Tense.INFINITIVE      | "unihdi"
    }
}
