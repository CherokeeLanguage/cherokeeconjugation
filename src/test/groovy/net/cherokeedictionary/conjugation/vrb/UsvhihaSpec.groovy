package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UsvhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going to Bed",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'aksvhiha', habitual: 'aksvhihoi', remote_past: 'aksvhlvi', imperative: 'aksvha', infinitive: 'aksvsdi'],
            [subject: 'SG3', object: '', present: 'tsvhiha', habitual: 'tsvhihoi', remote_past: 'tsvhlvi', imperative: 'tsvha', infinitive: 'tsvsdi'],
            [subject: 'SG3', object: '', present: 'usvhiha', habitual: 'usvhihoi', remote_past: 'usvhlvi', imperative: 'usvha', infinitive: 'usvsdi'],
            [subject: 'SG3', object: '', present: 'iksvhiha', habitual: 'iksvhihoi', remote_past: 'iksvhlvi', imperative: 'iksvha', infinitive: 'iksvsdi']
        ]
    ]

    @Unroll
    def "conjugating Usvhiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Usvhiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aksvhiha"
        "SG1" | "" | Tense.HABITUAL        | "aksvhihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksvhlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aksvha"
        "SG1" | "" | Tense.INFINITIVE      | "aksvsdi"
        "SG3" | "" | Tense.PRESENT         | "tsvhiha"
        "SG3" | "" | Tense.HABITUAL        | "tsvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "tsvhlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "tsvha"
        "SG3" | "" | Tense.INFINITIVE      | "tsvsdi"
        "SG3" | "" | Tense.PRESENT         | "usvhiha"
        "SG3" | "" | Tense.HABITUAL        | "usvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvhlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usvha"
        "SG3" | "" | Tense.INFINITIVE      | "usvsdi"
        "SG3" | "" | Tense.PRESENT         | "iksvhiha"
        "SG3" | "" | Tense.HABITUAL        | "iksvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "iksvhlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "iksvha"
        "SG3" | "" | Tense.INFINITIVE      | "iksvsdi"
    }
}
