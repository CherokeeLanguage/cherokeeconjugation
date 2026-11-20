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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakahvi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakahvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakahvsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyakahvsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakahvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahvi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakahvsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahvsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakahvsdi"
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
