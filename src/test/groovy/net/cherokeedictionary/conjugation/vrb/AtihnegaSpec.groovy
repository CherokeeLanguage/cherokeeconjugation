package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtihnegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatihnega', habitual: 'jiyatihnegoi', remote_past: 'jiyatihnvsvi', imperative: 'wijiyatihnuga', infinitive: 'jiyatihnvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatihnega', habitual: 'hiyatihnegoi', remote_past: 'hiyatihnvsvi', imperative: 'hwiyatihnuga', infinitive: 'hiyatihnvsdi'],
            [subject: 'SG3', object: '', present: 'atihnega', habitual: 'atihnegoi', remote_past: 'utihnvsvi', imperative: 'watihnuga', infinitive: 'utihnvsdi']
        ]
    ]

    @Unroll
    def "conjugating Atihnega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atihnega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyatinega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyatinegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyatinvsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyatinvsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyatinvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatinega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatinegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "atinvsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatinvsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "atinvsdi"
        "SG3" | "" | Tense.PRESENT         | "atinega"
        "SG3" | "" | Tense.HABITUAL        | "atinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "utinvsdi"
    }
}
