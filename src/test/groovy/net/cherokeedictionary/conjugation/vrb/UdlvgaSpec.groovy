// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73757 (entrya udlvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'akdlvga'],
            [subject: 'SG1', object: '', present: 'akdlvga', habitual: 'akdlvgoi', remote_past: 'akdlvgvi', imperative: 'akdlvgi', infinitive: 'akdlvisdi'],
            [subject: 'SG2', object: '', present: 'tsdlvga', habitual: 'tsdlvgoi', remote_past: 'tsdlvgvi', imperative: 'tsdlvgi', infinitive: 'tsdlvisdi'],
            [subject: 'SG3', object: '', habitual: 'udlvgoi', imperative: 'tsdlvgi', infinitive: 'udlvisdi', present: 'udlvga', remote_past: 'udlvgvi'],
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
        "SG1" | "" | Tense.PRESENT         | "agitlvga"
        "SG1" | "" | Tense.HABITUAL        | "agitlvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitlvgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agitlvgvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlvisdi"
        "SG2" | "" | Tense.PRESENT         | "tsatlvga"
        "SG2" | "" | Tense.HABITUAL        | "tsatlvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlvgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsatlvgvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlvisdi"
        "SG3" | "" | Tense.PRESENT         | "utlvga"
        "SG3" | "" | Tense.HABITUAL        | "utlvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utlvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlvisdi"
        "PL3" | "" | Tense.PRESENT         | "unitlvga"
        "PL3" | "" | Tense.HABITUAL        | "unitlvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitlvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unitlvgvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitlvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igitlvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igitlvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitlvgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igitlvgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitlvisdi"
    }
}
