    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72725 (entrya ayvhwahtiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyvhwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (long)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyvwahtiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvwahtiha', habitual: 'jiyvwahtisgoi', remote_past: 'tsiyvwadvhvi', imperative: 'jiyvwahta', infinitive: 'tsiyvwadvdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhwahtiha', habitual: 'hiyvhwahtisgoi', remote_past: 'hiyvwadvhvi', imperative: 'hiyvhwahta', infinitive: 'hiyvwadvdi'],
            [subject: 'SG3', object: '', habitual: 'ayvhwahtisgoi', imperative: 'hiyvhwahta', infinitive: 'uyvhwahtvhdi', present: 'ayvhwahtiha', remote_past: 'uyvhwahtvhvi'],
            [subject: 'PL3', object: '', present: 'aniyvhwahtiha', habitual: 'aniyvhwahtisgoi', remote_past: 'uniyvhwahtvhvi', imperative: 'aniyvhwahta', infinitive: 'uniyvhwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ayvhwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayvhwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvwahtiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvwahtisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvwadvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvwadvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvwadvdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhwahtiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhwahtisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvwadvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvwadvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvwadvdi"
        "SG3" | "" | Tense.PRESENT         | "ayvhwahtiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvhwahtisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhwahtvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvwadvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvhwahtvhdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvhwahtiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvhwahtisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhwahtvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvwadvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvhwahtvhdi"
    }
}
