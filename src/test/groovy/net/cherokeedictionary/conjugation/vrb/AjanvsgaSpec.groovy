// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72427 (entrya ajanvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjanvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Dressing Up",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gajanvsga'],
            [subject: 'SG1', object: '', present: 'gajanvsga', habitual: 'gajanvsgoi', remote_past: 'agwajanvhnvi', imperative: 'gajanvna', infinitive: 'agwajanvhdi'],
            [subject: 'SG2', object: '', present: 'hajanvsga', habitual: 'hajanvsgoi', remote_past: 'jajanvhnvi', imperative: 'hajanvna', infinitive: 'jajanvhdi'],
            [subject: 'SG3', object: '', habitual: 'ajanvsgoi', imperative: 'hajanvna', infinitive: 'ujanvhdi', present: 'ajanvsga', remote_past: 'ujanvhnvi'],
            [subject: 'PL3', object: '', present: 'anajanvsga', habitual: 'anajanvsgoi', remote_past: 'unajanvhnvi', imperative: 'anajanvna', infinitive: 'unajanvhdi'],
            [subject: 'PL1INCL', object: '', present: 'idajanvsga', habitual: 'idajanvsgoi', remote_past: 'igajanvhnvi', imperative: 'idajanvna', infinitive: 'igajanvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ajanvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajanvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajanvsga"
        "SG1" | "" | Tense.HABITUAL        | "gajanvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajanvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsanvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwajanvhdi"
        "SG2" | "" | Tense.PRESENT         | "hajanvsga"
        "SG2" | "" | Tense.HABITUAL        | "hajanvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajanvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsanvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jajanvhdi"
        "SG3" | "" | Tense.PRESENT         | "ajanvsga"
        "SG3" | "" | Tense.HABITUAL        | "ajanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujanvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsanvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "ujanvhdi"
        "PL3" | "" | Tense.PRESENT         | "anajanvsga"
        "PL3" | "" | Tense.HABITUAL        | "anajanvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajanvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsanvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unajanvhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajanvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajanvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajanvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsanvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajanvhdi"
    }
}
