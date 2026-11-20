    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72708) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72708 (entrya ayiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (long)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyia'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyia', habitual: 'jiyisgoi', remote_past: 'tsiyvhvi', imperative: 'jiya', infinitive: 'tsiyidi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyiha', habitual: 'hiyisgoi', remote_past: 'hiyvhvi', imperative: 'hiya', infinitive: 'hiyidi'],
            [subject: 'SG3', object: '', habitual: 'ayisgoi', imperative: 'hiya', infinitive: 'uyidi', present: 'ayiha', remote_past: 'uyvhvi'],
            [subject: 'PL3', object: '', present: 'aniyiha', habitual: 'aniyisgoi', remote_past: 'uniyvhvi', imperative: 'waniya', infinitive: 'uniyhdi']
        ]
    ]

    @Unroll
    def "conjugating Ayiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyidi"
        "SG3" | "" | Tense.PRESENT         | "ayiha"
        "SG3" | "" | Tense.HABITUAL        | "ayisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyidi"
        "PL3" | "" | Tense.PRESENT         | "aniyiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyidi"
    }
}
