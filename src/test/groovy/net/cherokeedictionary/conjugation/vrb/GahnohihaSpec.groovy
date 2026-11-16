package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinohiha', habitual: 'jinohihoi', remote_past: 'agihnolvi', imperative: 'jinoga', infinitive: 'agihnohisdi'],
            [subject: 'SG2', object: '', present: 'hihnohiha', habitual: 'hihnohihoi', remote_past: 'jahnolvi', imperative: 'hihnoga', infinitive: 'jahnohisdi'],
            [subject: 'SG3', object: '', present: 'gahnohiha', habitual: 'gahnohihoi', remote_past: 'uhnolvi', imperative: 'wigahnoga', infinitive: 'uhnohisdi'],
            [subject: 'PL3', object: '', present: 'anihnohiha', habitual: 'anihnohihoi', remote_past: 'unihnolvi', imperative: 'wanihnoga', infinitive: 'unihnohisdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinohiha"
        "SG2" | "" | Tense.HABITUAL        | "hinohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanohisdi"
        "SG1" | "" | Tense.PRESENT         | "tsinohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninohisdi"
    }
}
