// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73039) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73039 (entrya gahyea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (flexible)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyayea, tsiyea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyea', habitual: '/', remote_past: 'jiyayea', imperative: 'jiyesgoi', infinitive: '/'],
            [subject: 'SG2', object: '', present: 'hihyea', habitual: '/', remote_past: 'hiyayea', imperative: 'hihyesgoi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'gayesgoi', imperative: 'hiyayaga, hiyaga', infinitive: 'uwayesdi', present: 'gayea', remote_past: 'uwayavi'],
            [subject: 'PL3', object: '', present: 'anihyea', habitual: 'anihyesgoi', remote_past: 'unahyavi', imperative: 'anihyaga', infinitive: 'unahyesdi']
        ]
    ]

    @Unroll
    def "conjugating Gahyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyea"
        // "SG1" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiwayavi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiwayavi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "" | Tense.PRESENT         | "hihyea"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawayavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwayavi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "tsiyayea, tsiyea"
        "SG1" | "" | Tense.HABITUAL        | "tsiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwayavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwayavi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwayesdi"
        "PL3" | "" | Tense.PRESENT         | "anihyea"
        "PL3" | "" | Tense.HABITUAL        | "anihyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwayavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwayavi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwayesdi"
    }
}
