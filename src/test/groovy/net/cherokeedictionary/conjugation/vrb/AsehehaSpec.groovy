// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72586 (entrya aseheha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsehehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Showing Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyaseheha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyaseheha', habitual: 'jiyasehehoi', remote_past: 'jiyasehelvi', imperative: 'jiysehisi', infinitive: 'jiyasehehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyaseheha', habitual: 'hiyasehehoi', remote_past: 'hiyasehelvi', imperative: 'hiyasehisi', infinitive: 'hiyasehehdi'],
            [subject: 'SG3', object: '', habitual: 'asehehoi', imperative: 'hiyasehisi', infinitive: 'usehehdi', present: 'aseheha', remote_past: 'usehelvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anaseheha', habitual: 'anasehehoi', remote_past: 'unasehelvi', imperative: 'anasehisi', infinitive: 'unasehehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edaseheha', habitual: 'edasehehoi', remote_past: 'edasehelvi', imperative: 'edasehisi', infinitive: 'edasehehdi']
        ]
    ]

    @Unroll
    def "conjugating Aseheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aseheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyaseheha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyasehehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyasehelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyasehelvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyasehedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyaseheha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasehehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "asehelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasehelvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "asehedi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agaseheha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "asehehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwasehelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "asehelvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwasehedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anaseheha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anasehehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "anasehelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anasehelvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "anasehedi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edaseheha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edasehehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "asehelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edasehelvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "asehedi"
    }
}
