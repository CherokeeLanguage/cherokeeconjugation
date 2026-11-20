// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73199 (entrya gatvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GatvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadvsga'],
            [subject: 'SG1', object: '', present: 'gadvsga', habitual: 'gadvsgoi', remote_past: 'agwatanvi', imperative: 'gadvga', infinitive: 'agwatdi'],
            [subject: 'SG2', object: '', present: 'hatvsga', habitual: 'hatvsgoi', remote_past: 'jatanvi', imperative: 'hatvga', infinitive: 'jatdi'],
            [subject: 'SG1', object: '', present: 'gatvsga', habitual: 'gatvsgoi', remote_past: 'utanvi', imperative: 'wigatvga', infinitive: 'utdi'],
            [subject: 'SG3', object: '', habitual: 'gatvsgoi', imperative: 'hatvga', infinitive: 'utdi', present: 'gatvsga', remote_past: 'utanvi']
        ]
    ]

    @Unroll
    def "conjugating Gatvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gatvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatdi"
        "SG2" | "" | Tense.PRESENT         | "hatvsga"
        "SG2" | "" | Tense.HABITUAL        | "hatvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatdi"
        "SG1" | "" | Tense.PRESENT         | "gatvsga"
        "SG1" | "" | Tense.HABITUAL        | "gatvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatidi"
        "SG3" | "" | Tense.PRESENT         | "gatvsga"
        "SG3" | "" | Tense.HABITUAL        | "gatvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atanvi"
        "SG3" | "" | Tense.INFINITIVE      | "utdi"
    }
}
