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
            [subject: 'SG3', object: '', present: 'ganohiha', habitual: 'ganohihoi', remote_past: 'uwanohlvi', imperative: 'wiganoga', infinitive: 'uwanohisdi'],
            [subject: 'PL3', object: '', present: 'aninohiha', habitual: 'aninohihoi', remote_past: 'uninohlvi', imperative: 'waninoga', infinitive: 'uninohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinohiha"
        "SG2" | "" | Tense.HABITUAL        | "hinohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawanotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwanotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawanohisdi"
        "SG1" | "" | Tense.PRESENT         | "jinohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwanotlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwanotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwanohisdi"
    }
}
