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
                [subject: 'SG1', object: '', present: 'jisgaga'],
            [subject: 'SG1', object: '', present: 'jisgaga', habitual: 'jisgagoi', remote_past: 'jisgajvi', imperative: 'jisgagi', infinitive: 'jisgaysdi'],
            [subject: 'SG2', object: '', present: 'hisgaga', habitual: 'hisgagoi', remote_past: 'hisgajvi', imperative: 'hisgagi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'asgagoi', imperative: 'hisgagi, hisgagi', infinitive: 'usgasdi', present: 'asgaga', remote_past: 'usgajvi'],
            [subject: 'PL3', object: '', present: 'anisgaga', habitual: 'anisgagoi', remote_past: 'unisgajvi', imperative: 'anisgagi', infinitive: 'unisgaysdi'],
            [subject: 'PL1INCL', object: '', present: 'edisgaga', habitual: 'edisgagoi', remote_past: 'edisgajvi', imperative: 'edisgagi', infinitive: 'edisgaysdi']
        ]
    ]

    @Unroll
    def "conjugating Asgaga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgaga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisgaga"
        "SG1" | "" | Tense.HABITUAL        | "tsisgagoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisgatsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisgatsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisgasdi"
        "SG2" | "" | Tense.PRESENT         | "hisgaga"
        "SG2" | "" | Tense.HABITUAL        | "hisgagoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasgatsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgatsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "asgaga"
        "SG3" | "" | Tense.HABITUAL        | "asgagoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgatsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgatsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgasdi"
        "PL3" | "" | Tense.PRESENT         | "anisgaga"
        "PL3" | "" | Tense.HABITUAL        | "anisgagoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgatsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgatsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgaga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgagoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgatsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgatsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgasdi"
    }
}
