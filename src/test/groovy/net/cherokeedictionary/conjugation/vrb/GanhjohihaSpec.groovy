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
        "SG1" | "" | Tense.PRESENT         | "tsinitsohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinitsohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginitsotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinitsotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginitsohisdi"
        "SG2" | "" | Tense.PRESENT         | "hinitsohiha"
        "SG2" | "" | Tense.HABITUAL        | "hinitsohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanitsotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinitsotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanitsohisdi"
        "SG1" | "" | Tense.PRESENT         | "tsinitsohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinitsohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginitsotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinitsotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginitsohisdi"
        "PL3" | "" | Tense.PRESENT         | "aninitsohiha"
        "PL3" | "" | Tense.HABITUAL        | "aninitsohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninitsotlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninitsotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninitsohisdi"
    }
}
