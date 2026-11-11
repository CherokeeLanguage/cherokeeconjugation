package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinjega', habitual: 'jinjegoi', remote_past: 'aginhjvsvi', imperative: 'wijinjvga', infinitive: 'aginhjvsdi'],
            [subject: 'SG2', object: '', present: 'hinhjega', habitual: 'hinhjegoi', remote_past: 'janhjvsvi', imperative: 'hwinhjvga', infinitive: 'janhjvsdi'],
            [subject: 'SG1', object: '', present: 'ganhjega', habitual: 'ganhjegoi', remote_past: 'unhjvsvi', imperative: 'wiganhjvga', infinitive: 'unhjvsdi'],
            [subject: 'PL3', object: '', present: 'aninhjega', habitual: 'aninhjegoi', remote_past: 'uninhjvsvi', imperative: 'waninhjvga', infinitive: 'uninhjvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinjega"
        "SG1" | "" | Tense.HABITUAL        | "jinjegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijinjvga"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinhjega"
        "SG2" | "" | Tense.HABITUAL        | "hinhjegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhjvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinhjvga"
        "SG2" | "" | Tense.INFINITIVE      | "janhjvsdi"
        "SG1" | "" | Tense.PRESENT         | "ganhjega"
        "SG1" | "" | Tense.HABITUAL        | "ganhjegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unhjvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganhjvga"
        "SG1" | "" | Tense.INFINITIVE      | "unhjvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninhjega"
        "PL3" | "" | Tense.HABITUAL        | "aninhjegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninhjvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninhjvga"
        "PL3" | "" | Tense.INFINITIVE      | "uninhjvsdi"
    }
}
