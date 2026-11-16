// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72285 (entrya adlvkwsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gadlvgwasga'],
            [subject: 'SG1', object: '', present: 'gadlvgwasga', habitual: 'gadlvgwasgoi', remote_past: 'akdlvkwsvi', imperative: 'gadlvgwa', infinitive: 'akdlvkwisdi'],
            [subject: 'SG2', object: '', present: 'hadlvkwsga', habitual: 'hadlvkwsgoi', remote_past: 'tsdlvkwsvi', imperative: 'hadlvkwa', infinitive: 'tsdlvkwisdi'],
            [subject: 'SG3', object: '', habitual: 'adlvkwsgoi', imperative: 'hadlvkwa', infinitive: 'udlvkwisdi', present: 'adlvkwsga', remote_past: 'udlvkwsvi'],
            [subject: 'SG3', object: '', present: 'idadlvkwsga', habitual: 'idadlvkwsgoi', remote_past: 'igadlvkwsvi', imperative: 'idadlvkwa', infinitive: 'igadlvkwisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlvkwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlvkwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatlvquvsga"
        "SG1" | "" | Tense.HABITUAL        | "gatlvquvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatlvquvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatlvquvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatlvquisdi"
        "SG2" | "" | Tense.PRESENT         | "hatlvquvsga"
        "SG2" | "" | Tense.HABITUAL        | "hatlvquvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlvquvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatlvquvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlvquisdi"
        "SG3" | "" | Tense.PRESENT         | "atlvquvsga"
        "SG3" | "" | Tense.HABITUAL        | "atlvquvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvquvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvquvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlvquisdi"
        "SG3" | "" | Tense.PRESENT         | "atlvquvsga"
        "SG3" | "" | Tense.HABITUAL        | "atlvquvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvquvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvquvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlvquisdi"
    }
}
