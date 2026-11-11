package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtihnohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatihnohiha', habitual: 'jiyatihnohihoi', remote_past: 'jiyatihnohihlvi', imperative: 'jiyatihnoga', infinitive: 'jiyatihnohisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatihnohiha', habitual: 'hiyatihnohihoi', remote_past: 'hiyatihnohihlvi', imperative: 'hiyatihnoga', infinitive: 'hiyatihnohisdi'],
            [subject: 'SG3', object: '', present: 'atihnohiha', habitual: 'atihnohihoi', remote_past: 'utihnohihlvi', imperative: 'watihnoga', infinitive: 'utihnohisdi'],
            [subject: 'SG3', object: '', present: 'anatihnohiha', habitual: 'anatihnohihoi', remote_past: 'unatihnohihlvi', imperative: 'wanatihnoga', infinitive: 'unatihnohisdi']
        ]
    ]

    @Unroll
    def "conjugating Atihnohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atihnohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatihnohiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatihnohihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatihnohihlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatihnoga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatihnohisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatihnohiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatihnohihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatihnohihlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatihnoga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatihnohisdi"
        "SG3" | "" | Tense.PRESENT         | "atihnohiha"
        "SG3" | "" | Tense.HABITUAL        | "atihnohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utihnohihlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "watihnoga"
        "SG3" | "" | Tense.INFINITIVE      | "utihnohisdi"
        "SG3" | "" | Tense.PRESENT         | "anatihnohiha"
        "SG3" | "" | Tense.HABITUAL        | "anatihnohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unatihnohihlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanatihnoga"
        "SG3" | "" | Tense.INFINITIVE      | "unatihnohisdi"
    }
}
