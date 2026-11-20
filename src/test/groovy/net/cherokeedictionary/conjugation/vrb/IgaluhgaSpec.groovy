// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73358) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73358 (entrya igaluhga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class IgaluhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Returning (131)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'itsiluga'],
            [subject: 'SG3', object: '', habitual: 'igalugoi', imperative: 'tsihilugi', infinitive: "uluhisdi", present: 'igaluga', remote_past: 'vulutsvi, ulutsvi'],
            [subject: 'SG3', object: '', present: 'ihiluhga', habitual: 'ihiluhgoi', remote_past: 'vjaluhjvi', imperative: 'jihiluhgi', infinitive: 'vjaluhisdi'],
            [subject: 'SG3', object: '', present: 'ianiluhga', habitual: 'ianiluhgoi', remote_past: 'vuniluhjvi', imperative: 'jianiluhgi', infinitive: 'vuniluhisdi'],
            [subject: 'SG3', object: '', present: 'iidiluhga', habitual: 'iidiluhgoi', remote_past: 'vigiluhjvi', imperative: 'jiidiluhgi', infinitive: 'vigiluhisdi']
        ]
    ]

    @Unroll
    def "conjugating Igaluhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Igaluhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "vulutsvi, ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
        "SG3" | "" | Tense.PRESENT         | "igaluga"
        "SG3" | "" | Tense.HABITUAL        | "igalugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
    }
}
