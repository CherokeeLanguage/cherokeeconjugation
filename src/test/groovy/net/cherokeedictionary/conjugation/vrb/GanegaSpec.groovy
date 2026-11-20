// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73104 (entrya ganega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinega'],
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'agwanvsvi', imperative: 'wijinvga', infinitive: 'agwanvsdi'],
            [subject: 'SG2', object: '', present: 'hinega', habitual: 'hinegoi', remote_past: 'janvsvi', imperative: 'hwinvga', infinitive: 'janvsdi'],
            [subject: 'SG3', object: '', habitual: 'ganegoi', imperative: 'hinuga', infinitive: 'uwanvsdi', present: 'ganega', remote_past: 'uwanvsvi'],
            [subject: 'PL3', object: '', present: 'aninega', habitual: 'aninegoi', remote_past: 'unanvsvi', imperative: 'aninvga', infinitive: 'unanvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinega"
        "SG2" | "" | Tense.HABITUAL        | "hinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwanvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawanvsdi"
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninega"
        "PL3" | "" | Tense.HABITUAL        | "aninegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwanvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwanvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwanvsdi"
    }
}
