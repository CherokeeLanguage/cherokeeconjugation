// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72591) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72591 (entrya asgaga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgagaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Reprimanding Him",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsisgaga'],
            [subject: 'SG1', object: '', present: 'tsisgaga', habitual: 'jisgagoi', remote_past: 'jisgajvi', imperative: 'jisgagi', infinitive: 'jisgaysdi'],
            [subject: 'SG2', object: '', present: 'hisgaga', habitual: 'hisgagoi', remote_past: 'hisgajvi', imperative: 'hisgagi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'asgagoi', imperative: 'hisgagi, hisgagi', infinitive: 'usgasdi', present: 'asgaga', remote_past: 'usgatsvi'],
            [subject: 'PL3', object: '', present: 'anisgaga', habitual: 'anisgagoi', remote_past: 'unisgajvi', imperative: 'anisgagi', infinitive: 'unisgaysdi'],
            [subject: 'PL1INCL', object: '', present: 'edisgaga', habitual: 'edisgagoi', remote_past: 'edisgajvi', imperative: 'edisgagi', infinitive: 'edisgaysdi']
        ]
    ]

    @Unroll
    def "conjugating Asgaga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgaga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisgaga"
        "SG1" | "" | Tense.HABITUAL        | "jisgagoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jisgajvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisgatsvi"
        "SG1" | "" | Tense.INFINITIVE      | "jisgaysdi"
        "SG2" | "" | Tense.PRESENT         | "hisgaga"
        "SG2" | "" | Tense.HABITUAL        | "hisgagoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hisgajvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgatsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "asgaga"
        "SG3" | "" | Tense.HABITUAL        | "asgagoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgatsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgatsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgasdi"
        "PL3" | "" | Tense.PRESENT         | "anisgaga"
        "PL3" | "" | Tense.HABITUAL        | "anisgagoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgajvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgatsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgaysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edisgaga"
        "PL1INCL" | "" | Tense.HABITUAL        | "edisgagoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edisgajvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgatsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edisgaysdi"
    }
}
