// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72410) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72410 (entrya ahyoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for Him",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyoha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoha', habitual: 'jiyohoi', remote_past: 'jiyalvi', imperative: 'jiyga', infinitive: 'jiysdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hihyoha', habitual: 'hihyohoi', remote_past: 'hiyalvi', imperative: 'hiyhga', infinitive: 'hiysdi'],
            [subject: 'SG3', object: '', habitual: 'ayohoi', imperative: 'hiyoga', infinitive: 'uyasdi', present: 'ayoha', remote_past: 'uyalvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anihyoha', habitual: 'anihyohoi', remote_past: 'unihyalvi', imperative: 'aniyhga', infinitive: 'uniysdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edihyoha', habitual: 'edihyohoi', remote_past: 'edihyalvi', imperative: 'ediyhga', infinitive: 'ediysdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: PL3 Set B cells re-pinned per user ruling + guide P7(15)/126a (uni- serves all 3rd-person objects; y/a stem spelling per the SG3 row)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyohoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyalvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hihyoha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hihyohoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayoha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyalvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayalvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyasdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anihyoha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anihyohoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unihyalvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyalvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyasdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edihyoha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edihyohoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edihyalvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyalvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyasdi"
    }
}
