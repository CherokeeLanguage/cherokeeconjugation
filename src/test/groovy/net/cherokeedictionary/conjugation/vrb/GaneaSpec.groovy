package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaneaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinea', habitual: 'jinesgoi', remote_past: 'aginesvi', imperative: 'jinaga', infinitive: 'aginesdi'],
            [subject: 'SG2', object: '', present: 'hinea', habitual: 'hinesgoi', remote_past: 'janesvi', imperative: 'hwinaga', infinitive: 'janesdi'],
            [subject: 'SG1', object: '', present: 'ganea', habitual: 'ganesgoi', remote_past: 'unesvi', imperative: 'wiganaga', infinitive: 'unesdi'],
            [subject: 'PL3', object: '', present: 'aninea', habitual: 'aninesgoi', remote_past: 'uninesvi', imperative: 'waninaga', infinitive: 'uninesdi']
        ]
    ]

    @Unroll
    def "conjugating Ganea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinea"
        "SG1" | "" | Tense.HABITUAL        | "jinesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinaga"
        "SG1" | "" | Tense.INFINITIVE      | "aginesdi"
        "SG2" | "" | Tense.PRESENT         | "hinea"
        "SG2" | "" | Tense.HABITUAL        | "hinesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinaga"
        "SG2" | "" | Tense.INFINITIVE      | "janesdi"
        "SG1" | "" | Tense.PRESENT         | "ganea"
        "SG1" | "" | Tense.HABITUAL        | "ganesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganaga"
        "SG1" | "" | Tense.INFINITIVE      | "unesdi"
        "PL3" | "" | Tense.PRESENT         | "aninea"
        "PL3" | "" | Tense.HABITUAL        | "aninesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waninaga"
        "PL3" | "" | Tense.INFINITIVE      | "uninesdi"
    }
}
