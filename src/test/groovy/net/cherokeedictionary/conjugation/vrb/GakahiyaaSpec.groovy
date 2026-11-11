package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GakahiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakahiyaa', habitual: 'jiyakahiyasgoi', remote_past: 'jiyakahiyvi', imperative: 'jiyakhiya', infinitive: 'jiyakahiyasdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakahiyaa', habitual: 'hiyakahiyasgoi', remote_past: 'hiyakahiyvi', imperative: 'hiyakahiya', infinitive: 'hiyakahiyasdi'],
            [subject: 'SG1', object: '', present: 'gakahiyaa', habitual: 'gakahiyasgoi', remote_past: 'uwakahiyvi', imperative: 'gakahiya', infinitive: 'uwakahiyasdi'],
            [subject: 'PL3', object: '', present: 'anikahiyaa', habitual: 'anikahiyasgoi', remote_past: 'unikahiyvi', imperative: 'anikahiya', infinitive: 'unikahiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Gakahiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakahiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakahiyaa"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakahiyasgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakahiyvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyakhiya"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakahiyasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahiyaa"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahiyasgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakahiyvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahiya"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakahiyasdi"
        "SG1" | "" | Tense.PRESENT         | "gakahiyaa"
        "SG1" | "" | Tense.HABITUAL        | "gakahiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwakahiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gakahiya"
        "SG1" | "" | Tense.INFINITIVE      | "uwakahiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anikahiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anikahiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikahiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikahiya"
        "PL3" | "" | Tense.INFINITIVE      | "unikahiyasdi"
    }
}
