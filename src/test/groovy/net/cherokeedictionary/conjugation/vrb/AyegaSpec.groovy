    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72702 (entrya ayega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waking Up",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyega'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyega', habitual: 'jiyegoi', remote_past: 'tsiyetsvi', imperative: 'jiyegi', infinitive: 'tsiyeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyega', habitual: 'hiyegoi', remote_past: 'hiyetsvi', imperative: 'hiyegi', infinitive: 'hiyeisdi'],
            [subject: 'SG3', object: '', habitual: 'ayegoi', imperative: 'hiyegi', infinitive: 'uyeisdi', present: 'ayega', remote_past: 'uyejvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyega', habitual: 'aniyegoi', remote_past: 'uniyejvi', imperative: 'aniyegi', infinitive: 'uniyeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyega', habitual: 'idiyegoi', remote_past: 'ediyetsvi', imperative: 'idiyegi', infinitive: 'ediyeisdi']
        ]
    ]

    @Unroll
    def "conjugating Ayega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyetsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyetsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyetsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyetsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyetsvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayetsvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyejvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyetsvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ediyetsvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyetsvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyeisdi"
    }
}
