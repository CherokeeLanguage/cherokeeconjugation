// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73840) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73840 (entrya ujaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UjaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Inside",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquatsaa'],
            [subject: 'SG1', object: '', present: 'aquatsaa', habitual: 'agwajaoi', remote_past: 'agwajavi', imperative: 'agwajaesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jajaa', habitual: 'jajaoi', remote_past: 'jajavi', imperative: 'jajaesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'utsaoi', imperative: 'tsatsaesdi', infinitive: '', present: 'utsaa', remote_past: 'utsavi'],
            [subject: 'PL3', object: '', present: 'unajaa', habitual: 'unajaoi', remote_past: 'unajavi', imperative: 'unajaesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igajaa', habitual: 'igajaoi', remote_past: 'igajavi', imperative: 'igajaesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Ujaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ujaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquatsaa"
        "SG1" | "" | Tense.HABITUAL        | "aquatsaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquatsavi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "tsatsaa"
        "SG2" | "" | Tense.HABITUAL        | "tsatsaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsatsavi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "utsaa"
        "SG3" | "" | Tense.HABITUAL        | "utsaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utsavi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unatsaa"
        "PL3" | "" | Tense.HABITUAL        | "unatsaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unatsavi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igatsaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "igatsaoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igatsavi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
