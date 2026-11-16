// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73905) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73905 (entrya uneguja) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnegujaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Mean",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aginegutsa'],
            [subject: 'SG1', object: '', present: 'aginegutsa', habitual: 'aginegujoi', remote_past: 'aginegujvi', imperative: 'aginegujesdi', infinitive: 'x'],
            [subject: 'SG2', object: '', present: 'janeguja', habitual: 'janegujoi', remote_past: 'janegujvi', imperative: 'janegujesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'unegutsoi', imperative: 'tsanegutsesdi', infinitive: '----', present: 'unegutsa', remote_past: 'unegutsvi'],
            [subject: 'PL3', object: '', present: 'unineguja', habitual: 'uninegujoi', remote_past: 'uninegujvi', imperative: 'uninegujesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igineguja', habitual: 'iginegujoi', remote_past: 'iginegujvi', imperative: 'iginegujesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uneguja (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uneguja", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginegutsa"
        "SG1" | "" | Tense.HABITUAL        | "aginegutsoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginegutsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginegutsvi"
        "SG1" | "" | Tense.INFINITIVE      | "x"
        "SG2" | "" | Tense.PRESENT         | "tsanegutsa"
        "SG2" | "" | Tense.HABITUAL        | "tsanegutsoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanegutsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanegutsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "unegutsa"
        "SG3" | "" | Tense.HABITUAL        | "unegutsoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unegutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unegutsvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "uninegutsa"
        "PL3" | "" | Tense.HABITUAL        | "uninegutsoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninegutsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninegutsvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "iginegutsa"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginegutsoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginegutsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginegutsvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
