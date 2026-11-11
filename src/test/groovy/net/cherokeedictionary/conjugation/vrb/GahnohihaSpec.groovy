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
            [subject: 'SG1', object: '', present: 'gahnohiha', habitual: 'gahnohihoi', remote_past: 'uhnolvi', imperative: 'wigahnoga', infinitive: 'uhnohisdi'],
            [subject: 'PL3', object: '', present: 'anihnohiha', habitual: 'anihnohihoi', remote_past: 'unihnolvi', imperative: 'wanihnoga', infinitive: 'unihnohisdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinoga"
        "SG1" | "" | Tense.INFINITIVE      | "agihnohisdi"
        "SG2" | "" | Tense.PRESENT         | "hihnohiha"
        "SG2" | "" | Tense.HABITUAL        | "hihnohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnoga"
        "SG2" | "" | Tense.INFINITIVE      | "jahnohisdi"
        "SG1" | "" | Tense.PRESENT         | "gahnohiha"
        "SG1" | "" | Tense.HABITUAL        | "gahnohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhnolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigahnoga"
        "SG1" | "" | Tense.INFINITIVE      | "uhnohisdi"
        "PL3" | "" | Tense.PRESENT         | "anihnohiha"
        "PL3" | "" | Tense.HABITUAL        | "anihnohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihnoga"
        "PL3" | "" | Tense.INFINITIVE      | "unihnohisdi"
    }
}
