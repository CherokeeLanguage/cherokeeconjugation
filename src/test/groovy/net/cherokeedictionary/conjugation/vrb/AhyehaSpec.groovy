package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyeha', habitual: 'jiyehoi', remote_past: 'jiyehvi', imperative: 'jiyehesdi', infinitive: 'jiyehi'],
            [subject: 'SG2', object: '', present: 'hihyeha', habitual: 'hihyehoi', remote_past: 'hihyehvi', imperative: 'hihyehesdi', infinitive: 'hihyehi'],
            [subject: 'SG3', object: '', present: 'ahyeha', habitual: 'ahyehoi', remote_past: 'ahyehvi', imperative: 'ahyehesdi', infinitive: 'gahyehi'],
            [subject: 'PL3', object: '', present: 'anihyeha', habitual: 'anihyehoi', remote_past: 'anihyehvi', imperative: 'anihyehesdi', infinitive: 'anihyehi']
        ]
    ]

    @Unroll
    def "conjugating Ahyeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyeha"
        "SG1" | "" | Tense.HABITUAL        | "jiyehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jiyehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiyehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "jiyehi"
        "SG2" | "" | Tense.PRESENT         | "hihyeha"
        "SG2" | "" | Tense.HABITUAL        | "hihyehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihyehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihyehesdi"
        "SG2" | "" | Tense.INFINITIVE      | "hihyehi"
        "SG3" | "" | Tense.PRESENT         | "ahyeha"
        "SG3" | "" | Tense.HABITUAL        | "ahyehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ahyehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahyehesdi"
        "SG3" | "" | Tense.INFINITIVE      | "gahyehi"
        "PL3" | "" | Tense.PRESENT         | "anihyeha"
        "PL3" | "" | Tense.HABITUAL        | "anihyehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "anihyehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihyehesdi"
        "PL3" | "" | Tense.INFINITIVE      | "anihyehi"
    }
}
