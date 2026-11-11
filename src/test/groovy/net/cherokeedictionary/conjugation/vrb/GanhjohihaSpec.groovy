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
            [subject: 'SG1', object: '', present: 'ganhjohiha', habitual: 'ganhjohihoi', remote_past: 'unhjohlvi', imperative: 'wiganhjoga', infinitive: 'unhjohisdi'],
            [subject: 'PL3', object: '', present: 'aninhjohiha', habitual: 'aninhjohihoi', remote_past: 'uninhjohlvi', imperative: 'waninhjoga', infinitive: 'uninhjohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinejohiha"
        "SG1" | "" | Tense.HABITUAL        | "jinejohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinejoga"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinhjohiha"
        "SG2" | "" | Tense.HABITUAL        | "hiinhjohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhjohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinhjoga"
        "SG2" | "" | Tense.INFINITIVE      | "janhjohisdi"
        "SG1" | "" | Tense.PRESENT         | "ganhjohiha"
        "SG1" | "" | Tense.HABITUAL        | "ganhjohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unhjohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganhjoga"
        "SG1" | "" | Tense.INFINITIVE      | "unhjohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninhjohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninhjohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninhjohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninhjoga"
        "PL3" | "" | Tense.INFINITIVE      | "uninhjohisdi"
    }
}
