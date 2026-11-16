package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GakahvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakahvi', habitual: 'jiyakahvsgoi', remote_past: 'jiyakahvsvi', imperative: 'jiyakahvna', infinitive: 'jiyakahvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakahvi', habitual: 'hiyakahvsgoi', remote_past: 'hiyakahvsvi', imperative: 'hiyakahvna', infinitive: 'hiyakahvsdi'],
            [subject: 'SG3', object: '', present: 'gakahva', habitual: 'gakahvsgoi', remote_past: 'uwakahvsvi', imperative: 'wigakahvna', infinitive: 'uwakahvsdi'],
            [subject: 'PL3', object: '', present: 'anikahvi', habitual: 'anikahvsgoi', remote_past: 'unikahvsvi', imperative: 'wanikahvna', infinitive: 'unikahvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gakahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyakahva"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyakahvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyakahvsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyakahvsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyakahvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahva"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "akahvsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahvsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "akahvsdi"
        "SG1" | "" | Tense.PRESENT         | "gakahva"
        "SG1" | "" | Tense.HABITUAL        | "gakahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquakahvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gakahvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquakahvsdi"
        "PL3" | "" | Tense.PRESENT         | "anakahva"
        "PL3" | "" | Tense.HABITUAL        | "anakahvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unakahvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anakahvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unakahvsdi"
    }
}
