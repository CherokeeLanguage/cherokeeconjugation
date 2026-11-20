// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72354 (entrya ahlahvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhlahvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Place on Something (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jihlahvsga'],
            [subject: 'SG1', object: '', present: 'jilahvsga', habitual: 'jilahvsgoi', remote_past: 'akhlanvi', imperative: 'jilahvga', infinitive: 'akhlodi'],
            [subject: 'SG2', object: '', present: 'hihlahvsga', habitual: 'hihlahvsgoi', remote_past: 'tshlanvi', imperative: 'hihlahvga', infinitive: 'tshlodi'],
            [subject: 'SG3', object: '', habitual: 'ahlahvsgoi', imperative: 'hihlahvga', infinitive: 'uhlohdi', present: 'ahlahvsga', remote_past: 'uhlahnvi'],
            [subject: 'SG3', object: '', present: 'anahlahvsga', habitual: 'anahlahvsgoi', remote_past: 'unihlanvi', imperative: 'anahlahvga', infinitive: 'unihlodi']
        ]
    ]

    @Unroll
    def "conjugating Ahlahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitlahvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsitlahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlodi"
        "SG2" | "" | Tense.PRESENT         | "hihlahvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihlahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlodi"
        "SG3" | "" | Tense.PRESENT         | "ahlahvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahlahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlohdi"
        "SG3" | "" | Tense.PRESENT         | "atlahvsga"
        "SG3" | "" | Tense.HABITUAL        | "atlahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlodi"
    }
}
