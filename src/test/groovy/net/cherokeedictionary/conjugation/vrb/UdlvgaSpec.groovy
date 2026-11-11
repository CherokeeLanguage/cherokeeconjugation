package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdlvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sick",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'akdlvga', habitual: 'akdlvgoi', remote_past: 'akdlvgvi', imperative: 'akdlvgi', infinitive: 'akdlvisdi'],
            [subject: 'SG2', object: '', present: 'tsdlvga', habitual: 'tsdlvgoi', remote_past: 'tsdlvgvi', imperative: 'tsdlvgi', infinitive: 'tsdlvisdi'],
            [subject: 'SG3', object: '', present: 'udlvga', habitual: 'udlvgoi', remote_past: 'udlvgvi', imperative: 'udlvgi', infinitive: 'udlvisdi'],
            [subject: 'PL3', object: '', present: 'dunidlvga', habitual: 'dunidlvgoi', remote_past: 'dunidlvgvi', imperative: 'junidlvgi', infinitive: 'junidlvisdi'],
            [subject: 'PL1INCL', object: '', present: 'degidlvga', habitual: 'degidlvgoi', remote_past: 'degidlvgvi', imperative: 'digidlvgi', infinitive: 'digidlvisdi']
        ]
    ]

    @Unroll
    def "conjugating Udlvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udlvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akdlvga"
        "SG1" | "" | Tense.HABITUAL        | "akdlvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdlvgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "akdlvgi"
        "SG1" | "" | Tense.INFINITIVE      | "akdlvisdi"
        "SG2" | "" | Tense.PRESENT         | "tsdlvga"
        "SG2" | "" | Tense.HABITUAL        | "tsdlvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdlvgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsdlvgi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdlvisdi"
        "SG3" | "" | Tense.PRESENT         | "udlvga"
        "SG3" | "" | Tense.HABITUAL        | "udlvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udlvgi"
        "SG3" | "" | Tense.INFINITIVE      | "udlvisdi"
        "PL3" | "" | Tense.PRESENT         | "dunidlvga"
        "PL3" | "" | Tense.HABITUAL        | "dunidlvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunidlvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "junidlvgi"
        "PL3" | "" | Tense.INFINITIVE      | "junidlvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "degidlvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "degidlvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degidlvgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "digidlvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digidlvisdi"
    }
}
