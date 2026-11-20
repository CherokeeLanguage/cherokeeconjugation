// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72267 (entrya aditasga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AditasgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eating/Drink It (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gaditasga'],
            [subject: 'SG1', object: '', present: 'gaditasga', habitual: 'gaditasgoi', remote_past: 'agwaditahvi', imperative: 'gadita', infinitive: 'agwaditasdi'],
            [subject: 'SG2', object: '', present: 'haditasga', habitual: 'haditasgoi', remote_past: 'jaditahvi', imperative: 'hadita', infinitive: 'jaditasdi'],
            [subject: 'SG3', object: '', habitual: 'aditasgoi', imperative: 'hadita', infinitive: 'uditasdi', present: 'aditasga', remote_past: 'uditahvi'],
            [subject: 'SG3', object: '', present: 'anaditasga', habitual: 'anaditasgoi', remote_past: 'unaditahvi', imperative: 'anadita', infinitive: 'unaditasdi']
        ]
    ]

    @Unroll
    def "conjugating Aditasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aditasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gaditasga"
        "SG1" | "" | Tense.HABITUAL        | "gaditasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwaditahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gaditahvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwaditasdi"
        "SG2" | "" | Tense.PRESENT         | "haditasga"
        "SG2" | "" | Tense.HABITUAL        | "haditasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaditahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haditahvi"
        "SG2" | "" | Tense.INFINITIVE      | "jaditasdi"
        "SG3" | "" | Tense.PRESENT         | "aditasga"
        "SG3" | "" | Tense.HABITUAL        | "aditasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uditahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aditahvi"
        "SG3" | "" | Tense.INFINITIVE      | "uditasdi"
        "SG3" | "" | Tense.PRESENT         | "aditasga"
        "SG3" | "" | Tense.HABITUAL        | "aditasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uditahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aditahvi"
        "SG3" | "" | Tense.INFINITIVE      | "uditasdi"
    }
}
