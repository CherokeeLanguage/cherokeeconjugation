package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdlvkwsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Bragging",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadlvgwasga', habitual: 'gadlvgwasgoi', remote_past: 'akdlvkwsvi', imperative: 'gadlvgwa', infinitive: 'akdlvkwisdi'],
            [subject: 'SG2', object: '', present: 'hadlvkwsga', habitual: 'hadlvkwsgoi', remote_past: 'tsdlvkwsvi', imperative: 'hadlvkwa', infinitive: 'tsdlvkwisdi'],
            [subject: 'SG3', object: '', present: 'adlvkwsga', habitual: 'adlvkwsgoi', remote_past: 'udlvkwsvi', imperative: 'adlvkwa', infinitive: 'udlvkwisdi'],
            [subject: 'SG3', object: '', present: 'idadlvkwsga', habitual: 'idadlvkwsgoi', remote_past: 'igadlvkwsvi', imperative: 'idadlvkwa', infinitive: 'igadlvkwisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlvkwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlvkwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadlvgwasga"
        "SG1" | "" | Tense.HABITUAL        | "gadlvgwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdlvkwsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadlvgwa"
        "SG1" | "" | Tense.INFINITIVE      | "akdlvkwisdi"
        "SG2" | "" | Tense.PRESENT         | "hadlvkwsga"
        "SG2" | "" | Tense.HABITUAL        | "hadlvkwsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdlvkwsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadlvkwa"
        "SG2" | "" | Tense.INFINITIVE      | "tsdlvkwisdi"
        "SG3" | "" | Tense.PRESENT         | "adlvkwsga"
        "SG3" | "" | Tense.HABITUAL        | "adlvkwsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlvkwsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adlvkwa"
        "SG3" | "" | Tense.INFINITIVE      | "udlvkwisdi"
        "SG3" | "" | Tense.PRESENT         | "idadlvkwsga"
        "SG3" | "" | Tense.HABITUAL        | "idadlvkwsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "igadlvkwsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "idadlvkwa"
        "SG3" | "" | Tense.INFINITIVE      | "igadlvkwisdi"
    }
}
