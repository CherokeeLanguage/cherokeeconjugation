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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajelvsga"
        "SG1" | "" | Tense.HABITUAL        | "gajelvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajelvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatselvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwajehldi"
        "SG2" | "" | Tense.PRESENT         | "hajelvsga"
        "SG2" | "" | Tense.HABITUAL        | "hajelvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajelvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatselvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jajehldi"
        "SG3" | "" | Tense.PRESENT         | "ajelvsga"
        "SG3" | "" | Tense.HABITUAL        | "ajelvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujelvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atselvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "ujehldi"
        "PL3" | "" | Tense.PRESENT         | "anajelvsga"
        "PL3" | "" | Tense.HABITUAL        | "anajelvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajelvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatselvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unajehldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajelvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajelvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajelvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatselvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajehldi"
    }
}
