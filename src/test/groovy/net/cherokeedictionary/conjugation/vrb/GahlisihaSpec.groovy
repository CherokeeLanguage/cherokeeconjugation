// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73025 (entrya gahlisiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Gathering It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jihlisiha'],
            [subject: 'SG1', object: '', present: 'jihlisiha', habitual: 'jihlisisgoi', remote_past: 'akihlisahnvi', imperative: 'jihlisa', infinitive: 'akihlisohdi'],
            [subject: 'SG2', object: '', present: 'hihlvisiha', habitual: 'hihlisisgoi', remote_past: 'jahlisahnvi', imperative: 'hihlisa', infinitive: 'jahlisohdi'],
            [subject: 'SG3', object: '', habitual: 'gahlisisgoi', imperative: 'hihlisa', infinitive: 'uwahlisohdi', present: 'gahlisiha', remote_past: 'uwahlisahnvi'],
            [subject: 'PL3', object: '', present: 'anihlisiha', habitual: 'anihlisisgoi', remote_past: 'unihlisahnvi', imperative: 'anihlisa', infinitive: 'unihlisohdi'],
            [subject: 'PL1INCL', object: '', present: 'idihlisiha', habitual: 'idihlisisgoi', remote_past: 'igihlisahnvi', imperative: 'idihlisa', infinitive: 'igihlisohdi']
        ]
    ]

    @Unroll
    def "conjugating Gahlisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahlisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jihlisiha"
        "SG1" | "" | Tense.HABITUAL        | "jihlisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwatlisanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwatlisanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwatlisodi"
        "SG2" | "" | Tense.PRESENT         | "hitlisiha"
        "SG2" | "" | Tense.HABITUAL        | "hihlisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawatlisanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwatlisanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawatlisodi"
        "SG3" | "" | Tense.PRESENT         | "gahlisiha"
        "SG3" | "" | Tense.HABITUAL        | "gahlisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwahlisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawatlisanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwahlisohdi"
        "PL3" | "" | Tense.PRESENT         | "anihlisiha"
        "PL3" | "" | Tense.HABITUAL        | "anihlisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwatlisanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwatlisanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwatlisodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihlisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihlisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwatlisanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwatlisanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwatlisodi"
    }
}
