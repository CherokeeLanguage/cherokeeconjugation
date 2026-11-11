package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinewahtiha', habitual: 'jinehwahtisgoi', remote_past: 'aginehwahtvhvi', imperative: 'jinehwahta', infinitive: 'aginehwahtvhdi'],
            [subject: 'SG2', object: '', present: 'hinehwahtiha', habitual: 'hinehwahtisgoi', remote_past: 'janehwahtvhvi', imperative: 'hinehwahta', infinitive: 'janehwahtvhdi'],
            [subject: 'SG1', object: '', present: 'ganehwahtiha', habitual: 'ganehwahtisgoi', remote_past: 'unehwahtvhvi', imperative: 'ganehwahta', infinitive: 'unehwahtvhdi'],
            [subject: 'PL3', object: '', present: 'aninehwahtiha', habitual: 'aninehwahtisgoi', remote_past: 'uninehwahtvhvi', imperative: 'aninehwahta', infinitive: 'uninehwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinewahtiha"
        "SG1" | "" | Tense.HABITUAL        | "jinehwahtisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehwahtvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinehwahta"
        "SG1" | "" | Tense.INFINITIVE      | "aginehwahtvhdi"
        "SG2" | "" | Tense.PRESENT         | "hinehwahtiha"
        "SG2" | "" | Tense.HABITUAL        | "hinehwahtisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehwahtvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehwahta"
        "SG2" | "" | Tense.INFINITIVE      | "janehwahtvhdi"
        "SG1" | "" | Tense.PRESENT         | "ganehwahtiha"
        "SG1" | "" | Tense.HABITUAL        | "ganehwahtisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unehwahtvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehwahta"
        "SG1" | "" | Tense.INFINITIVE      | "unehwahtvhdi"
        "PL3" | "" | Tense.PRESENT         | "aninehwahtiha"
        "PL3" | "" | Tense.HABITUAL        | "aninehwahtisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehwahtvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehwahta"
        "PL3" | "" | Tense.INFINITIVE      | "uninehwahtvhdi"
    }
}
