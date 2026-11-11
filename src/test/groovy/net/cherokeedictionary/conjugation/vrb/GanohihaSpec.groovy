package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinohiha', habitual: 'jinohihoi', remote_past: 'aginohlvi', imperative: 'jinoga', infinitive: 'aginohisdi'],
            [subject: 'SG2', object: '', present: 'hinohiha', habitual: 'hinohihoi', remote_past: 'janohlvi', imperative: 'hinoga', infinitive: 'janohisdi'],
            [subject: 'SG1', object: '', present: 'ganohiha', habitual: 'ganohihoi', remote_past: 'uwanohlvi', imperative: 'wiganoga', infinitive: 'uwanohisdi'],
            [subject: 'PL3', object: '', present: 'aninohiha', habitual: 'aninohihoi', remote_past: 'uninohlvi', imperative: 'waninoga', infinitive: 'uninohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinoga"
        "SG1" | "" | Tense.INFINITIVE      | "aginohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinohiha"
        "SG2" | "" | Tense.HABITUAL        | "hinohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinoga"
        "SG2" | "" | Tense.INFINITIVE      | "janohisdi"
        "SG1" | "" | Tense.PRESENT         | "ganohiha"
        "SG1" | "" | Tense.HABITUAL        | "ganohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwanohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganoga"
        "SG1" | "" | Tense.INFINITIVE      | "uwanohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninoga"
        "PL3" | "" | Tense.INFINITIVE      | "uninohisdi"
    }
}
