package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shooting",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoiha', habitual: 'jiyoihoi', remote_past: 'agiyohlvi', imperative: 'jiyoa', infinitive: 'agiyosdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyohiha', habitual: 'hiyohihoi', remote_past: 'jayohlvi', imperative: 'hiyoa', infinitive: '/'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayohiha', habitual: 'ayohihoi', remote_past: 'uyohlvi', imperative: 'ayoha', infinitive: 'uyosdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyohiha', habitual: 'aniyohihoi', remote_past: 'uniyohlvi', imperative: 'aniyoha', infinitive: 'uniyosdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyohiha', habitual: 'idiyohihoi', remote_past: 'igiyohlvi', imperative: 'idiyoha', infinitive: 'igiyosdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyoihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyohlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyoa"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyosdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyohiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayohlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyoa"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayohiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyohlvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayoha"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyosdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyohiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyohlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyoha"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyosdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyohiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyohihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyohlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyoha"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyosdi"
    }
}
