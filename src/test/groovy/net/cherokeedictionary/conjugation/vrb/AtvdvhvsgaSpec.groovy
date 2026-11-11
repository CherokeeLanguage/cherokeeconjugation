package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvdvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Asking",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdvhvsga', habitual: 'jiyatvdvhvsgoi', remote_past: 'jiyatvdvhnvi', imperative: 'jiyatvdvhvga', infinitive: 'jiyatvtdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvdvhvsga', habitual: 'gatvdvhvsgoi', remote_past: 'agwatvdvhnvi', imperative: 'gatvdvhvga', infinitive: 'agwatvtdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdvhvsga', habitual: 'hiyatvdvhvsgoi', remote_past: 'hiyatvdvhnvi', imperative: 'hiyatvdvhvga', infinitive: 'hiyatvtdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvdvhvsga', habitual: 'hatvdvhvsgoi', remote_past: 'jatvdvhnvi', imperative: 'hatvdvhvga', infinitive: 'jatvtdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'atvdvhvsga', habitual: 'atvdvhvsgoi', remote_past: 'utvdvhnvi', imperative: 'atvdvhvga', infinitive: 'utvtdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvdvhvsga', habitual: 'anatvdvhvsgoi', remote_past: 'unatvdvhnvi', imperative: 'anatvdvhvga', infinitive: 'unatvtdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvdvhvsga', habitual: 'idatvdvhvsgoi', remote_past: 'igatvdvhnvi', imperative: 'idatvdvhvga', infinitive: 'igatvtdi']
        ]
    ]

    @Unroll
    def "conjugating Atvdvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvdvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdvhvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdvhvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdvhnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatvdvhvga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvtdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gatvdvhvsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gatvdvhvsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwatvdvhnvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gatvdvhvga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwatvtdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdvhvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdvhvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdvhnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatvdvhvga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvtdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvdvhvsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvdvhvsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jatvdvhnvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hatvdvhvga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jatvtdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "atvdvhvsga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "atvdvhvsgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "utvdvhnvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "atvdvhvga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utvtdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvdvhvsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvdvhvsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvdvhnvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anatvdvhvga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvtdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idatvdvhvsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idatvdvhvsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igatvdvhnvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idatvdvhvga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igatvtdi"
    }
}
