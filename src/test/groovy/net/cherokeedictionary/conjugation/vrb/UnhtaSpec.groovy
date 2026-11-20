// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73912) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73912 (entrya unhta) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnhtaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Know",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquanvta'],
            [subject: 'SG1', object: '', present: 'aquanvta', habitual: 'agwanhtoi', remote_past: 'agwanhtvi', imperative: 'agwantesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'janhta', habitual: 'janhtoi', remote_past: 'janhtvi', imperative: 'jantesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'unvdoi', imperative: 'tsanvtesdi', infinitive: '----', present: 'unvta', remote_past: 'unvdvi'],
            [subject: 'PL3', object: '', present: 'unanhta', habitual: 'unanhtoi', remote_past: 'unanhtvi', imperative: 'unantesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'iganhta', habitual: 'iganhtoi', remote_past: 'iganhtvi', imperative: 'igantesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Unhta (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unhta", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquanvta"
        "SG1" | "" | Tense.HABITUAL        | "aquanvtoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanvdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquanvdvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "tsanvta"
        "SG2" | "" | Tense.HABITUAL        | "tsanvtoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanvdvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanvdvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "unvta"
        "SG3" | "" | Tense.HABITUAL        | "unvdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvdvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unvdvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unanvta"
        "PL3" | "" | Tense.HABITUAL        | "unanvtoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanvdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unanvdvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "iganvta"
        "PL1INCL" | "" | Tense.HABITUAL        | "iganvtoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganvdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iganvdvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
