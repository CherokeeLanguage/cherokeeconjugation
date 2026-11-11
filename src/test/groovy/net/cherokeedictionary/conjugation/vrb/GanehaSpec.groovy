package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinea', habitual: 'jineoi', remote_past: 'jinevi', imperative: 'jineesdi', infinitive: 'jinei'],
            [subject: 'SG2', object: '', present: 'hineha', habitual: 'hinehoi', remote_past: 'hinehvi', imperative: 'hinehesdi', infinitive: 'hinehi'],
            [subject: 'SG1', object: '', present: 'ganeha', habitual: 'ganehoi', remote_past: 'ganehvi', imperative: 'ganehesdi', infinitive: 'ganehi'],
            [subject: 'PL3', object: '', present: 'anineha', habitual: 'aninehoi', remote_past: 'aninehvi', imperative: 'aninehesdi', infinitive: 'aninehi']
        ]
    ]

    @Unroll
    def "conjugating Ganeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinea"
        "SG1" | "" | Tense.HABITUAL        | "jineoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jineesdi"
        "SG1" | "" | Tense.INFINITIVE      | "jinei"
        "SG2" | "" | Tense.PRESENT         | "hineha"
        "SG2" | "" | Tense.HABITUAL        | "hinehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehesdi"
        "SG2" | "" | Tense.INFINITIVE      | "hinehi"
        "SG1" | "" | Tense.PRESENT         | "ganeha"
        "SG1" | "" | Tense.HABITUAL        | "ganehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ganehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "ganehi"
        "PL3" | "" | Tense.PRESENT         | "anineha"
        "PL3" | "" | Tense.HABITUAL        | "aninehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "aninehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehesdi"
        "PL3" | "" | Tense.INFINITIVE      | "aninehi"
    }
}
