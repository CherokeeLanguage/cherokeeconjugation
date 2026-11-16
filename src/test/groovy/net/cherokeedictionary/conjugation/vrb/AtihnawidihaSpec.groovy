package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtihnawidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatihnawidiha', habitual: 'jiyatihnawidisgoi', remote_past: 'jiyatihnawidvhvi', imperative: 'jiyatihnawida', infinitive: 'jiyatihnawitdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatihnawidiha', habitual: 'hiyatihnawidisgoi', remote_past: 'hiyatihnawidvhvi', imperative: 'hiyatihnawida', infinitive: 'hiyatihnawitdi'],
            [subject: 'SG3', object: '', present: 'atihnawidiha', habitual: 'atihnawidisgoi', remote_past: 'utihnawidvhvi', imperative: 'atihnawida', infinitive: 'utihnawitdi'],
            [subject: 'SG3', object: '', present: 'anhtihnawidiha', habitual: 'anhtihnawidisgoi', remote_past: 'unhtihnawidvhvi', imperative: 'anhtihnawida', infinitive: 'unhtihnawitdi']
        ]
    ]

    @Unroll
    def "conjugating Atihnawidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atihnawidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyatinawidiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyatinawidisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyatinawidvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyatinawidvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyatinawitidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatinawidiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatinawidisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "atinawidvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatinawidvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "atinawitidi"
        "SG3" | "" | Tense.PRESENT         | "atinawidiha"
        "SG3" | "" | Tense.HABITUAL        | "atinawidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utinawidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atinawidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "utinawitidi"
        "SG3" | "" | Tense.PRESENT         | "atinawidiha"
        "SG3" | "" | Tense.HABITUAL        | "atinawidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utinawidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atinawidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "utinawitidi"
    }
}
