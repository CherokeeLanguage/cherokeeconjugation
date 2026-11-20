// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73079 (entrya galosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fall from Elevated Position (living)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jilosga'],
            [subject: 'SG1', object: '', present: 'jilosga', habitual: 'jilosgoi', remote_past: 'agilosvi', imperative: 'jilohi', infinitive: 'agilohisdi'],
            [subject: 'SG2', object: '', present: 'hilosga', habitual: 'hilosgoi', remote_past: 'jalosvi', imperative: 'hilohi', infinitive: 'jalohisdi'],
            [subject: 'SG3', object: '', habitual: 'galosgoi', imperative: 'hilohi', infinitive: 'ulohisdi', present: 'galosga', remote_past: 'ulosvi'],
            [subject: 'PL3', object: '', present: 'anilosga', habitual: 'anilosgoi', remote_past: 'unilosvi', imperative: 'wanilohi', infinitive: 'unilohisdi']
        ]
    ]

    @Unroll
    def "conjugating Galosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilosga"
        "SG1" | "" | Tense.HABITUAL        | "jilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilohisdi"
        "SG2" | "" | Tense.PRESENT         | "hilosga"
        "SG2" | "" | Tense.HABITUAL        | "hilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilosvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalohisdi"
        "SG1" | "" | Tense.PRESENT         | "jilosga"
        "SG1" | "" | Tense.HABITUAL        | "jilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilohisdi"
        "PL3" | "" | Tense.PRESENT         | "anilosga"
        "PL3" | "" | Tense.HABITUAL        | "anilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilohisdi"
    }
}
