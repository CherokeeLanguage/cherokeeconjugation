package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyohiha', habitual: 'jiyohihoi', remote_past: 'agihyohlvi', imperative: 'jiyoga', infinitive: 'akiyohisdi'],
            [subject: 'SG2', object: '', present: 'hihyohiha', habitual: 'hihyohihoo', remote_past: 'jahyohlvi', imperative: 'hihyoga', infinitive: 'jahyohisdi'],
            [subject: 'SG3', object: '', present: 'ahyohiha', habitual: 'ahyohihoi', remote_past: 'uhyohlvi', imperative: 'wahyoga', infinitive: 'uhyohisdi'],
            [subject: 'PL3', object: '', present: 'anihyohiha', habitual: 'anihyohihoi', remote_past: 'unihyohlvi', imperative: 'wanihyoga', infinitive: 'unihyohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyohiha"
        "SG1" | "" | Tense.HABITUAL        | "jiyohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihyohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiyoga"
        "SG1" | "" | Tense.INFINITIVE      | "akiyohisdi"
        "SG2" | "" | Tense.PRESENT         | "hihyohiha"
        "SG2" | "" | Tense.HABITUAL        | "hihyohihoo"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahyohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihyoga"
        "SG2" | "" | Tense.INFINITIVE      | "jahyohisdi"
        "SG3" | "" | Tense.PRESENT         | "ahyohiha"
        "SG3" | "" | Tense.HABITUAL        | "ahyohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyohlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahyoga"
        "SG3" | "" | Tense.INFINITIVE      | "uhyohisdi"
        "PL3" | "" | Tense.PRESENT         | "anihyohiha"
        "PL3" | "" | Tense.HABITUAL        | "anihyohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihyohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihyoga"
        "PL3" | "" | Tense.INFINITIVE      | "unihyohisdi"
    }
}
