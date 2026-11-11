package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdloysgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Off",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadloysga', habitual: 'gadloysgoi', remote_past: 'akdloysvi', imperative: 'gadlohi', infinitive: 'akdlohisdi'],
            [subject: 'SG2', object: '', present: 'hadloysga', habitual: 'hadloysgoi', remote_past: 'tsdloysvi', imperative: 'hadlohi', infinitive: 'tsdlohisdi'],
            [subject: 'SG3', object: '', present: 'adloysga', habitual: 'adloysgoi', remote_past: 'udloysvi', imperative: 'adlohi', infinitive: 'udlohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idadloysga', habitual: 'idadloysgoi', remote_past: 'igadloysvi', imperative: 'idadlohi', infinitive: 'igadlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Adloysga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adloysga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadloysga"
        "SG1" | "" | Tense.HABITUAL        | "gadloysgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdloysvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadlohi"
        "SG1" | "" | Tense.INFINITIVE      | "akdlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadloysga"
        "SG2" | "" | Tense.HABITUAL        | "hadloysgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdloysvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadlohi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdlohisdi"
        "SG3" | "" | Tense.PRESENT         | "adloysga"
        "SG3" | "" | Tense.HABITUAL        | "adloysgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udloysvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adlohi"
        "SG3" | "" | Tense.INFINITIVE      | "udlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadloysga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadloysgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadloysvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadlohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlohisdi"
    }
}
