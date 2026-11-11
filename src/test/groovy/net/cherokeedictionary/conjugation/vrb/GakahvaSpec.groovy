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
            [subject: 'SG1', object: '', present: 'gakahva', habitual: 'gakahvsgoi', remote_past: 'uwakahvsvi', imperative: 'wigakahvna', infinitive: 'uwakahvsdi'],
            [subject: 'PL3', object: '', present: 'anikahvi', habitual: 'anikahvsgoi', remote_past: 'unikahvsvi', imperative: 'wanikahvna', infinitive: 'unikahvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gakahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakahvi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakahvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakahvsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyakahvna"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakahvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahvi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakahvsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahvna"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakahvsdi"
        "SG1" | "" | Tense.PRESENT         | "gakahva"
        "SG1" | "" | Tense.HABITUAL        | "gakahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwakahvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigakahvna"
        "SG1" | "" | Tense.INFINITIVE      | "uwakahvsdi"
        "PL3" | "" | Tense.PRESENT         | "anikahvi"
        "PL3" | "" | Tense.HABITUAL        | "anikahvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikahvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanikahvna"
        "PL3" | "" | Tense.INFINITIVE      | "unikahvsdi"
    }
}
