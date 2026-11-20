// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72796 (entrya danadlosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanadlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Meeting (They Are)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dojadlosga'],
            [subject: 'SG1', object: '', present: 'dojadlosga', habitual: 'dojadlosgoi', remote_past: 'dogadlosvi', imperative: 'jojadlohi', infinitive: 'I'],
            [subject: 'SG2', object: '', present: 'desdadlosga', habitual: 'desdadlosgoi', remote_past: 'desdadlosvi', imperative: 'disdadlohi', infinitive: 'You'],
            [subject: 'SG3', object: '', habitual: 'danadlosgoi', imperative: 'dijadlohi', infinitive: 'junadlohisdi', present: 'danadlosga', remote_past: 'dunadlosvi'],
            [subject: 'PL3', object: '', present: 'dedadlosga', habitual: 'dedadlosgoi', remote_past: 'degadlosvi', imperative: 'didadlohi', infinitive: 'You,'],
            [subject: 'PL1INCL', object: '', present: 'danadlosga', habitual: 'danadlosgoi', remote_past: 'dunadlosvi', imperative: 'dinadlohi', infinitive: 'They']
        ]
    ]

    @Unroll
    def "conjugating Danadlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danadlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dojadlosga"
        "SG1" | "" | Tense.HABITUAL        | "dojadlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dogadlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganatlosvi"
        "SG1" | "" | Tense.INFINITIVE      | "I"
        "SG2" | "" | Tense.PRESENT         | "desdadlosga"
        "SG2" | "" | Tense.HABITUAL        | "desdadlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "desdadlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanatlosvi"
        "SG2" | "" | Tense.INFINITIVE      | "You"
        "SG3" | "" | Tense.PRESENT         | "danadlosga"
        "SG3" | "" | Tense.HABITUAL        | "danadlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunadlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anatlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "junadlohisdi"
        "PL3" | "" | Tense.PRESENT         | "dedadlosga"
        "PL3" | "" | Tense.HABITUAL        | "dedadlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "degadlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananatlosvi"
        "PL3" | "" | Tense.INFINITIVE      | "You,"
        "PL1INCL" | "" | Tense.PRESENT         | "danadlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "danadlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dunadlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanatlosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "They"
    }
}
