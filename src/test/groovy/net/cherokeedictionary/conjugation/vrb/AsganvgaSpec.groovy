// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72596) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72596 (entrya asganvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsganvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Committing a Crime",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsisganvga'],
            [subject: 'SG1', object: '', present: 'tsisganvga', habitual: 'jisganvgoi', remote_past: 'aksganvjvi', imperative: 'jisganvgi', infinitive: 'aksganvysdi'],
            [subject: 'SG2', object: '', present: 'hisganvga', habitual: 'hisganvgoi', remote_past: 'tsganvjvi', imperative: 'hisganvgi', infinitive: 'tsganvysdi'],
            [subject: 'SG3', object: '', habitual: 'asganvgoi', imperative: 'hisganvgi', infinitive: 'usganvisdi', present: 'asganvga', remote_past: 'usganvtsvi'],
            [subject: 'PL3', object: '', present: 'anisganvga', habitual: 'anisganvgoi', remote_past: 'unisganvjvi', imperative: 'anisganvgi', infinitive: 'unisganvysdi'],
            [subject: 'PL1INCL', object: '', present: 'idisganvga', habitual: 'idisganvgoi', remote_past: 'igisganvjvi', imperative: 'idisganvgi', infinitive: 'igisganvysdi']
        ]
    ]

    @Unroll
    def "conjugating Asganvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asganvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisganvga"
        "SG1" | "" | Tense.HABITUAL        | "tsisganvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisganvtsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisganvtsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisganvisdi"
        "SG2" | "" | Tense.PRESENT         | "hisganvga"
        "SG2" | "" | Tense.HABITUAL        | "hisganvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasganvtsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisganvtsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasganvisdi"
        "SG3" | "" | Tense.PRESENT         | "asganvga"
        "SG3" | "" | Tense.HABITUAL        | "asganvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usganvtsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asganvtsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usganvisdi"
        "PL3" | "" | Tense.PRESENT         | "anisganvga"
        "PL3" | "" | Tense.HABITUAL        | "anisganvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisganvtsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisganvtsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisganvisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisganvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisganvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisganvtsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisganvtsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisganvisdi"
    }
}
