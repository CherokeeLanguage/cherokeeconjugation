package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Parting With Him/Her in Death",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvdega', habitual: 'jiyvdegoi', remote_past: 'akdejvi', imperative: 'jiyvdegi', infinitive: 'akdeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvdega', habitual: 'hiyvdegoi', remote_past: 'tsdejvi', imperative: 'hiyvdegi', infinitive: 'tsdeisdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'kdega', habitual: 'kdegoi', remote_past: 'uwadejvi', imperative: 'kdegi', infinitive: 'uwadeisdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'andega', habitual: 'andegoi', remote_past: 'undejvi', imperative: 'andegi', infinitive: 'undeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idvdega', habitual: 'idvdegoi', remote_past: 'ikdegjvi', imperative: 'idvdegi', infinitive: 'ikdeisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvdega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvdegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "akdejvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyvdegi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "akdeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvdega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvdegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "tsdejvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvdegi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "tsdeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "kdega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "kdegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwadejvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "kdegi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwadeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "andega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "andegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "undejvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "andegi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "undeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idvdega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idvdegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ikdegjvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idvdegi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ikdeisdi"
    }
}
