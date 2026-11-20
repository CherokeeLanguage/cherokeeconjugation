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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalihgeha"
        "SG1" | "" | Tense.HABITUAL        | "degalihgesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwahlihgehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatligehvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwahlihgehdi"
        "SG2" | "" | Tense.PRESENT         | "dehahlihgeha"
        "SG2" | "" | Tense.HABITUAL        | "dehahlihgesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejahlihgehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatligehvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijahlihgehdi"
        "SG3" | "" | Tense.PRESENT         | "dahlihgeha"
        "SG3" | "" | Tense.HABITUAL        | "dahlihgesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhlihgehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atligehvi"
        "SG3" | "" | Tense.INFINITIVE      | "juhlihgehdi"
        "PL3" | "" | Tense.PRESENT         | "danahlihgeha"
        "PL3" | "" | Tense.HABITUAL        | "danahlihgesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunahlihgehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatligehvi"
        "PL3" | "" | Tense.INFINITIVE      | "junahlihgehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedahlihgeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedahlihgesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degahlihgehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatligehvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digahlihgehdi"
    }
}
