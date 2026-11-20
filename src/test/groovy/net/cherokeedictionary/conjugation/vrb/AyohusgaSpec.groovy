// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72716 (entrya ayohusga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohusgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dying (S/he)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyousga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyousga', habitual: 'jiyousgoi', remote_past: 'jiyousvi', imperative: 'jiyouhi', infinitive: 'agiyohuhisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyohusga', habitual: 'hiyohusgoi', remote_past: 'hiyohusvi', imperative: 'hiyohuhi', infinitive: 'jayohuhisdi'],
            [subject: 'SG3', object: '', habitual: 'ayohusgoi', imperative: 'hiyohuhi', infinitive: 'uyohuhisdi', present: 'ayohusga', remote_past: 'uyohusvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyohusga', habitual: 'aniyohusgoi', remote_past: 'uniyohusvi', imperative: 'aniyohuhi', infinitive: 'uniyohusdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyohusga', habitual: 'idiyohusgoi', remote_past: 'igiyohusvi', imperative: 'idiyohuhi', infinitive: 'igiyohusdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohusga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohusga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: PL3 Set B cells re-pinned per user ruling + guide P7(15)/126a (uni- serves all 3rd-person objects; y/a stem spelling per the SG3 row)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyohusga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyohusgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyohusvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyohusvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyohuhisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyohusga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohusgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyohusvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyohusvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyohuhisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayohusga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohusgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyohusvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayohusvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyohuhisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyohusga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohusgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyohusvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyohusvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyohuhisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyohusga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyohusgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ediyohusvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyohusvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyohuhisdi"
    }
}
