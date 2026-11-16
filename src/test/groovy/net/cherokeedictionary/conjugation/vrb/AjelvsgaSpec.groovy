// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72431 (entrya ajelvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjelvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Acting Like Him/Her",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gajelvsga'],
            [subject: 'SG1', object: '', present: 'gajelvsga', habitual: 'gajelvsgoi', remote_past: 'agwajelvhnvi', imperative: 'gajvelvna', infinitive: 'agwajehldi'],
            [subject: 'SG2', object: '', present: 'hajelvsga', habitual: 'hajelvsgoi', remote_past: 'jajelvhnvi', imperative: 'hajelvna', infinitive: 'jajehldi'],
            [subject: 'SG3', object: '', habitual: 'ajelvsgoi', imperative: 'hajelvna', infinitive: 'ujehldi', present: 'ajelvsga', remote_past: 'ujelvhnvi'],
            [subject: 'PL3', object: '', present: 'anajelvsga', habitual: 'anajelvsgoi', remote_past: 'unajelvhnvi', imperative: 'anajelvna', infinitive: 'unajehldi'],
            [subject: 'PL1INCL', object: '', present: 'idajelvsga', habitual: 'idajelvsgoi', remote_past: 'igajelvhnvi', imperative: 'idajelvna', infinitive: 'igajehldi']
        ]
    ]

    @Unroll
    def "conjugating Ajelvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajelvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatselvsga"
        "SG1" | "" | Tense.HABITUAL        | "gatselvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatselvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatselvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatselodi"
        "SG2" | "" | Tense.PRESENT         | "hatselvsga"
        "SG2" | "" | Tense.HABITUAL        | "hatselvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatselvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatselvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatselodi"
        "SG3" | "" | Tense.PRESENT         | "atselvsga"
        "SG3" | "" | Tense.HABITUAL        | "atselvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utselvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atselvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "utselodi"
        "PL3" | "" | Tense.PRESENT         | "anatselvsga"
        "PL3" | "" | Tense.HABITUAL        | "anatselvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatselvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatselvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatselodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatselvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatselvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatselvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatselvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatselodi"
    }
}
