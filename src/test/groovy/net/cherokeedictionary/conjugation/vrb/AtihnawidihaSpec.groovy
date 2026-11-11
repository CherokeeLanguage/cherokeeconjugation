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
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatihnawidiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatihnawidisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatihnawidvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatihnawida"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatihnawitdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatihnawidiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatihnawidisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatihnawidvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatihnawida"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatihnawitdi"
        "SG3" | "" | Tense.PRESENT         | "atihnawidiha"
        "SG3" | "" | Tense.HABITUAL        | "atihnawidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utihnawidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atihnawida"
        "SG3" | "" | Tense.INFINITIVE      | "utihnawitdi"
        "SG3" | "" | Tense.PRESENT         | "anhtihnawidiha"
        "SG3" | "" | Tense.HABITUAL        | "anhtihnawidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unhtihnawidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anhtihnawida"
        "SG3" | "" | Tense.INFINITIVE      | "unhtihnawitdi"
    }
}
