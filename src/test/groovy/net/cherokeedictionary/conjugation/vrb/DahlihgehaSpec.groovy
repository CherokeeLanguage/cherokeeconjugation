// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72750 (entrya dahlihgeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DahlihgehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Rocking (68)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degalihgeha'],
            [subject: 'SG1', object: '', present: 'degalihgeha', habitual: 'degalihgesgoi', remote_past: 'dagwahlihgehvi', imperative: 'digalihgvla', infinitive: 'digwahlihgehdi'],
            [subject: 'SG2', object: '', present: 'dehahlihgeha', habitual: 'dehahlihgesgoi', remote_past: 'dejahlihgehvi', imperative: 'tahlihgvla', infinitive: 'dijahlihgehdi'],
            [subject: 'SG3', object: '', habitual: 'dahlihgesgoi', imperative: 'tahlihgvla', infinitive: 'juhlihgehdi', present: 'dahlihgeha', remote_past: 'duhlihgehvi'],
            [subject: 'PL3', object: '', present: 'danahlihgeha', habitual: 'danahlihgesgoi', remote_past: 'dunahlihgehvi', imperative: 'dinahlihgvla', infinitive: 'junahlihgehdi'],
            [subject: 'PL1INCL', object: '', present: 'dedahlihgeha', habitual: 'dedahlihgesgoi', remote_past: 'degahlihgehvi', imperative: 'didahlihgvla', infinitive: 'digahlihgehdi']
        ]
    ]

    @Unroll
    def "conjugating Dahlihgeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahlihgeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatligeha"
        "SG1" | "" | Tense.HABITUAL        | "gatligesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatligehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatligehvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitligedi"
        "SG2" | "" | Tense.PRESENT         | "hatligeha"
        "SG2" | "" | Tense.HABITUAL        | "hatligesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatligehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatligehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatligedi"
        "SG3" | "" | Tense.PRESENT         | "datligeha"
        "SG3" | "" | Tense.HABITUAL        | "datligesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utligehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atligehvi"
        "SG3" | "" | Tense.INFINITIVE      | "utligedi"
        "PL3" | "" | Tense.PRESENT         | "anatligeha"
        "PL3" | "" | Tense.HABITUAL        | "anatligesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatligehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatligehvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitligedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatligeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatligesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatligehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatligehvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitligedi"
    }
}
