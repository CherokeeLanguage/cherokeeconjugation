// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72284) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72284 (entrya adloysga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gatloisga'],
            [subject: 'SG1', object: '', present: 'gatloisga', habitual: 'gadloysgoi', remote_past: 'akdloysvi', imperative: 'gadlohi', infinitive: 'akdlohisdi'],
            [subject: 'SG2', object: '', present: 'hadloysga', habitual: 'hadloysgoi', remote_past: 'tsdloysvi', imperative: 'hadlohi', infinitive: 'tsdlohisdi'],
            [subject: 'SG3', object: '', habitual: 'atloisgoi', imperative: 'hatlohi', infinitive: 'utlohisdi', present: 'atloisga', remote_past: 'utloisvi'],
            [subject: 'PL1INCL', object: '', present: 'idadloysga', habitual: 'idadloysgoi', remote_past: 'igadloysvi', imperative: 'idadlohi', infinitive: 'igadlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Adloysga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adloysga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatloisga"
        "SG1" | "" | Tense.HABITUAL        | "gadloysgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdloysvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatloisvi"
        "SG1" | "" | Tense.INFINITIVE      | "akdlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadloysga"
        "SG2" | "" | Tense.HABITUAL        | "hadloysgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdloysvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatloisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdlohisdi"
        "SG3" | "" | Tense.PRESENT         | "atloisga"
        "SG3" | "" | Tense.HABITUAL        | "atloisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utloisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atloisvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadloysga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadloysgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadloysvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatloisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlohisdi"
    }
}
