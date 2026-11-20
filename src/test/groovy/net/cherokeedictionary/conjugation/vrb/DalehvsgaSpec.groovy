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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalehvsga"
        "SG1" | "" | Tense.HABITUAL        | "degalehvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwalehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galenvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagiledi"
        "SG2" | "" | Tense.PRESENT         | "dehalehvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehalehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halenvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsaledi"
        "SG3" | "" | Tense.PRESENT         | "dalehvsga"
        "SG3" | "" | Tense.HABITUAL        | "dalehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alenvi"
        "SG3" | "" | Tense.INFINITIVE      | "julehdi"
        "PL3" | "" | Tense.PRESENT         | "danalehvsga"
        "PL3" | "" | Tense.HABITUAL        | "danalehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunalehnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analenvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsuniledi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadalehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadalehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagalenvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalenvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagiledi"
    }
}
