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
        "SG1" | "" | Tense.PRESENT         | "tsiyohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsiyohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyohisdi"
        "SG2" | "" | Tense.PRESENT         | "hiyohiha"
        "SG2" | "" | Tense.HABITUAL        | "hiyohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayohisdi"
        "SG3" | "" | Tense.PRESENT         | "ayohiha"
        "SG3" | "" | Tense.HABITUAL        | "ayohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyotlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayotlvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyohisdi"
        "PL3" | "" | Tense.PRESENT         | "aniyohiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyotlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyohisdi"
    }
}
