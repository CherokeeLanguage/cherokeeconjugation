// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72546 (entrya anadahlisiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnadahlisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They are Gathering (in a group)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ojadahlisiha'],
            [subject: 'SG1', object: '', present: 'anadahlisiha', habitual: 'anadahlisisgoi', remote_past: 'unadahlisahnvi', imperative: 'anadahlisa', infinitive: 'unadahlisohdi'],
            [subject: 'SG2', object: '', present: 'ijadahlisiha', habitual: 'ijadahlisisgoi', remote_past: 'ijadahlisahnvi', imperative: 'ijadahlisa', infinitive: 'ijadahlisohdi'],
            [subject: 'SG3', object: '', habitual: 'anadahlisisgoi', imperative: 'ijadahlisa', infinitive: 'unadahlisohdi', present: 'anadahlisiha', remote_past: 'unadahlisahnvi'],
            [subject: 'PL3', object: '', present: 'ojadahlisiha', habitual: 'ojadahlisisgoi', remote_past: 'ogadahlisahnvi', imperative: 'ojadahlisa', infinitive: 'ogadahlisohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadahlisiha', habitual: 'idadahlisisgoi', remote_past: 'igadahlisahnvi', imperative: 'idadahlisa', infinitive: 'igadahlisohdi']
        ]
    ]

    @Unroll
    def "conjugating Anadahlisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anadahlisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganadatlisiha"
        "SG1" | "" | Tense.HABITUAL        | "ganadatlisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanadatlisanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganadatlisanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanadatlisodi"
        "SG2" | "" | Tense.PRESENT         | "ijadahlisiha"
        "SG2" | "" | Tense.HABITUAL        | "ijadahlisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ijadahlisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanadatlisanvi"
        "SG2" | "" | Tense.INFINITIVE      | "ijadahlisohdi"
        "SG3" | "" | Tense.PRESENT         | "anadahlisiha"
        "SG3" | "" | Tense.HABITUAL        | "anadahlisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unadahlisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anadatlisanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unadahlisohdi"
        "PL3" | "" | Tense.PRESENT         | "ojadahlisiha"
        "PL3" | "" | Tense.HABITUAL        | "ojadahlisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "ogadahlisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananadatlisanvi"
        "PL3" | "" | Tense.INFINITIVE      | "ogadahlisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadahlisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadahlisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadahlisahnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanadatlisanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadahlisohdi"
    }
}
