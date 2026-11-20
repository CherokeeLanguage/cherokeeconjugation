package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinva', habitual: 'jinvsgoi', remote_past: 'agnvsvi', imperative: 'jinvna', infinitive: 'aginvsdi'],
            [subject: 'SG2', object: '', present: 'hinva', habitual: 'hinvsgoi', remote_past: 'janvsvi', imperative: 'hinvna', infinitive: 'janvsdi'],
            [subject: 'SG3', object: '', present: 'ganva', habitual: 'ganvsgoi', remote_past: 'unvsvi', imperative: 'wiganvna', infinitive: 'unvsdi'],
            [subject: 'PL3', object: '', present: 'aninva', habitual: 'aninvsgoi', remote_past: 'uninvsvi', imperative: 'waninvna', infinitive: 'uninvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinva"
        "SG1" | "" | Tense.HABITUAL        | "jinvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agnvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinva"
        "SG2" | "" | Tense.HABITUAL        | "hinvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "janvsdi"
        "SG1" | "" | Tense.PRESENT         | "jinva"
        "SG1" | "" | Tense.HABITUAL        | "jinvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agnvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninva"
        "PL3" | "" | Tense.HABITUAL        | "aninvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvsdi"
    }
}
