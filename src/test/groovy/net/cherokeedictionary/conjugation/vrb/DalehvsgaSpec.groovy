// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72786 (entrya dalehvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DalehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Up (From Sitting) (73)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degalevsga'],
            [subject: 'SG1', object: '', present: 'degalevsga', habitual: 'degalevsgoi', remote_past: 'dagwalehnvi', imperative: 'digalevga', infinitive: 'digwalehdi'],
            [subject: 'SG2', object: '', present: 'dehalehvsga', habitual: 'dehalehvsgoi', remote_past: 'dejalehnvi', imperative: 'talehvga', infinitive: 'dijalehdi'],
            [subject: 'SG3', object: '', habitual: 'dalehvsgoi', imperative: 'talehvga', infinitive: 'julehdi', present: 'dalehvsga', remote_past: 'dulehnvi'],
            [subject: 'PL3', object: '', present: 'danalehvsga', habitual: 'danalehvsgoi', remote_past: 'dunalehnvi', imperative: 'dinalehvga', infinitive: 'junalehdi'],
            [subject: 'PL1INCL', object: '', present: 'dedalehvsga', habitual: 'dedalehvsgoi', remote_past: 'degalehnvi', imperative: 'didalehvga', infinitive: 'digalehdi']
        ]
    ]

    @Unroll
    def "conjugating Dalehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dalehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galehvsga"
        "SG1" | "" | Tense.HABITUAL        | "galehvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualenvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galenvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiledi"
        "SG2" | "" | Tense.PRESENT         | "halehvsga"
        "SG2" | "" | Tense.HABITUAL        | "halehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalenvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halenvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaledi"
        "SG3" | "" | Tense.PRESENT         | "dalehvsga"
        "SG3" | "" | Tense.HABITUAL        | "dalehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulenvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alenvi"
        "SG3" | "" | Tense.INFINITIVE      | "uledi"
        "PL3" | "" | Tense.PRESENT         | "analehvsga"
        "PL3" | "" | Tense.HABITUAL        | "analehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalenvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analenvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniledi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalenvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalenvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiledi"
    }
}
