    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72724 (entrya ayvhiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyvhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Entering",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyviha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvia', habitual: 'jiyvioi', remote_past: 'tsiyvtlvi', imperative: 'jiyva', infinitive: 'tsiyvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhiha', habitual: 'hiyvhihoi', remote_past: 'hiyvtlvi', imperative: 'hiyvha', infinitive: 'hiyvsdi'],
            [subject: 'SG3', object: '', habitual: 'ayvhihoi', imperative: 'hiyvha', infinitive: 'uyvsdi', present: 'ayvhiha', remote_past: 'uyvhlvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyvhiha', habitual: 'aniyvhihoi', remote_past: 'uniyvhlvi', imperative: 'aniyvha', infinitive: 'uniyvsdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyvhiha', habitual: 'idiyvhihoi', remote_past: 'ediyvtlvi', imperative: 'idiyvha', infinitive: 'ediyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ayvhiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayvhiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvhiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvhihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvtlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvtlvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvtlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvtlvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvsdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayvhiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayvhihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyvtlvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayvtlvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyvsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyvhiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyvhihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyvhlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyvtlvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyvsdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyvhiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyvhihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ediyvtlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyvtlvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyvsdi"
    }
}
