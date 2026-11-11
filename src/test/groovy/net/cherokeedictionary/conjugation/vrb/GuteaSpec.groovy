package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GuteaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Picking Him/It Up",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyutea', habitual: 'jiyutesgoi', remote_past: 'jiyutesvi', imperative: 'jiyutagi', infinitive: 'jiyutesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gutea', habitual: 'gutesgoi', remote_past: 'agwutesvi', imperative: 'gutagi', infinitive: 'agwutesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyutea', habitual: 'hiyutesgoi', remote_past: 'hiyutesvi', imperative: 'hiyutagi', infinitive: 'hiyutesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hutea', habitual: 'hutesgoi', remote_past: 'jutesvi', imperative: 'hutagi', infinitive: 'jutesdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'gutea', habitual: 'gutesgoi', remote_past: 'uwutesvi', imperative: 'gutagi', infinitive: 'uwutesdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anutea', habitual: 'anutesgoi', remote_past: 'unutesvi', imperative: 'anutagi', infinitive: 'unutesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idutea', habitual: 'idutesgoi', remote_past: 'igutesvi', imperative: 'idutagi', infinitive: 'igutesdi']
        ]
    ]

    @Unroll
    def "conjugating Gutea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gutea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyutea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyutesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyutesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyutagi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyutesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gutea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gutesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwutesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gutagi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwutesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyutea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyutesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyutesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyutagi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyutesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hutea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hutesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jutesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hutagi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jutesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gutea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gutesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwutesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "gutagi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwutesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anutea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anutesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unutesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anutagi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unutesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idutea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idutesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igutesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idutagi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igutesdi"
    }
}
