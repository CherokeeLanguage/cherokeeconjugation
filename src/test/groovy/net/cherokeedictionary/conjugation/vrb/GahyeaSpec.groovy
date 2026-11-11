package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (flexible)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyea', habitual: '/', remote_past: 'jiyayea', imperative: 'jiyesgoi', infinitive: '/'],
            [subject: 'SG2', object: '', present: 'hihyea', habitual: '/', remote_past: 'hiyayea', imperative: 'hihyesgoi', infinitive: '/'],
            [subject: 'SG1', object: '', present: 'gahyea', habitual: 'gahyesgoi', remote_past: 'uwahyavi', imperative: 'gahyaga', infinitive: 'uwahyesdi'],
            [subject: 'PL3', object: '', present: 'anihyea', habitual: 'anihyesgoi', remote_past: 'unahyavi', imperative: 'anihyaga', infinitive: 'unahyesdi']
        ]
    ]

    @Unroll
    def "conjugating Gahyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyea"
        // "SG1" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyayea"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyesgoi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "" | Tense.PRESENT         | "hihyea"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "hiyayea"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihyesgoi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "gahyea"
        "SG1" | "" | Tense.HABITUAL        | "gahyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwahyavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gahyaga"
        "SG1" | "" | Tense.INFINITIVE      | "uwahyesdi"
        "PL3" | "" | Tense.PRESENT         | "anihyea"
        "PL3" | "" | Tense.HABITUAL        | "anihyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahyavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihyaga"
        "PL3" | "" | Tense.INFINITIVE      | "unahyesdi"
    }
}
