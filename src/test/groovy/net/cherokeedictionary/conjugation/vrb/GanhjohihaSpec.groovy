package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bring (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinejohiha', habitual: 'jinejohihoi', remote_past: 'aginhjohlvi', imperative: 'jinejoga', infinitive: 'aginhjohisdi'],
            [subject: 'SG2', object: '', present: 'hinhjohiha', habitual: 'hiinhjohihoi', remote_past: 'janhjohlvi', imperative: 'hinhjoga', infinitive: 'janhjohisdi'],
            [subject: 'SG3', object: '', present: 'ganhjohiha', habitual: 'ganhjohihoi', remote_past: 'unhjohlvi', imperative: 'wiganhjoga', infinitive: 'unhjohisdi'],
            [subject: 'PL3', object: '', present: 'aninhjohiha', habitual: 'aninhjohihoi', remote_past: 'uninhjohlvi', imperative: 'waninhjoga', infinitive: 'uninhjohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinatsohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatsotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatsohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinatsohiha"
        "SG2" | "" | Tense.HABITUAL        | "hinatsohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanatsotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatsotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanatsohisdi"
        "SG1" | "" | Tense.PRESENT         | "tsinatsohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatsotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatsohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninatsohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninatsohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninatsotlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatsotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninatsohisdi"
    }
}
