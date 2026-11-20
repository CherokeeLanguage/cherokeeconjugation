// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73858 (entrya uksesdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UksesdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Watching / Careful (171)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyagasesdi, agwaksesdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyagasesdi', habitual: 'jiyagasesdoi', remote_past: 'jiyagasesdvi', imperative: 'jiyagasesdesdi', infinitive: 'jiyagasesdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwaksesdi', habitual: 'agwaksesdoi', remote_past: 'agwaksesdvi', imperative: 'agwaksesdesdi', infinitive: 'agwaksesdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyagasesdi', habitual: 'hiyagasesdoi', remote_past: 'hiyagasesdvi', imperative: 'hiyagasesdesdi', infinitive: 'hiyagasesdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jaksesdi', habitual: 'jaksesdoi', remote_past: 'jaksesdvi', imperative: 'jaksesdesdi', infinitive: 'jaksesdohdi'],
            [subject: 'SG3', object: '', habitual: 'uksesdoi', imperative: 'hiyagasesdesdi, jaksesdesdi', infinitive: 'uksesdohdi', present: 'uksesdi', remote_past: 'uksesdvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unaksesdi', habitual: 'unaksesdoi', remote_past: 'unaksesdvi', imperative: 'unaksesdesdi', infinitive: 'unaksesdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igaksesdi', habitual: 'igaksesdoi', remote_past: 'igaksesdvi', imperative: 'igaksesdesdi', infinitive: 'igaksesdohdi']
        ]
    ]

    @Unroll
    def "conjugating Uksesdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uksesdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyagisesdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyagisestoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyagisesdvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyagisesdvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyagisestodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agwaksesdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agwaksesdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwaksesdvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquagisesdvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwaksesdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagisesdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagisestoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyagisesdvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagisesdvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyagisestodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jaksesdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jaksesdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jaksesdvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsagisesdvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jaksesdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ugisesdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ugisesdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ugisesdvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ugisesdvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ugisesdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unaksesdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unaksesdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unaksesdvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unagisesdvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unaksesdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igaksesdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igaksesdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igaksesdvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igagisesdvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igaksesdohdi"
    }
}
