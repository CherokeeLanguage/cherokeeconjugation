package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GakanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakaneha', habitual: 'jiyakanehoi', remote_past: 'jiyakanelvi', imperative: 'jiyakasi', infinitive: 'jiyakanehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakaneha', habitual: 'hiyakanehoi', remote_past: 'hiyakanelvi', imperative: 'hiyakasi', infinitive: 'hiyakanehdi'],
            [subject: 'SG1', object: '', present: 'gakaneha', habitual: 'gakanehoi', remote_past: 'uwakanelvi', imperative: 'wigakasi', infinitive: 'uwakanehdi'],
            [subject: 'PL3', object: '', present: 'anikaneha', habitual: 'anikanehoi', remote_past: 'unikanelvi', imperative: 'wanikasi', infinitive: 'unikanehdi']
        ]
    ]

    @Unroll
    def "conjugating Gakaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakaneha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakanehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakanelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyakasi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakanehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakaneha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakanehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakanelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakasi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakanehdi"
        "SG1" | "" | Tense.PRESENT         | "gakaneha"
        "SG1" | "" | Tense.HABITUAL        | "gakanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwakanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigakasi"
        "SG1" | "" | Tense.INFINITIVE      | "uwakanehdi"
        "PL3" | "" | Tense.PRESENT         | "anikaneha"
        "PL3" | "" | Tense.HABITUAL        | "anikanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanikasi"
        "PL3" | "" | Tense.INFINITIVE      | "unikanehdi"
    }
}
