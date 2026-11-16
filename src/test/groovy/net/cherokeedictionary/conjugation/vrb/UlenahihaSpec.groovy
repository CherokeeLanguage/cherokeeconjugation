// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73867 (entrya ulenahiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlenahihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Losing His Way",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwalenahiha'],
            [subject: 'SG1', object: '', present: 'agwalenahiha', habitual: 'agwalenahihoi', remote_past: 'agwalenahlvi', imperative: 'agwalenaga', infinitive: 'agwalenasdi'],
            [subject: 'SG2', object: '', present: 'jalenahiha', habitual: 'jalenahihoi', remote_past: 'jalenahlvi', imperative: 'jalenaga', infinitive: 'jalenasdi'],
            [subject: 'SG3', object: '', habitual: 'ulenahihoi', imperative: 'jalenaga', infinitive: 'ulenasdi', present: 'ulenahiha', remote_past: 'ulenahlvi'],
            [subject: 'PL3', object: '', present: 'unalenahiha', habitual: 'unalenahihoi', remote_past: 'unalenahlvi', imperative: 'unalenaga', infinitive: 'unalenasdi'],
            [subject: 'PL1INCL', object: '', present: 'igalenahiha', habitual: 'igalenahihoi', remote_past: 'igalenahlvi', imperative: 'igalenaga', infinitive: 'igalenasdi']
        ]
    ]

    @Unroll
    def "conjugating Ulenahiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulenahiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aqualenahiha"
        "SG1" | "" | Tense.HABITUAL        | "aqualenahihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualenatlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aqualenatlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualenasdi"
        "SG2" | "" | Tense.PRESENT         | "tsalenahiha"
        "SG2" | "" | Tense.HABITUAL        | "tsalenahihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalenatlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalenatlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalenasdi"
        "SG3" | "" | Tense.PRESENT         | "ulenahiha"
        "SG3" | "" | Tense.HABITUAL        | "ulenahihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulenatlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulenatlvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulenasdi"
        "PL3" | "" | Tense.PRESENT         | "unalenahiha"
        "PL3" | "" | Tense.HABITUAL        | "unalenahihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalenatlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unalenatlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalenasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igalenahiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igalenahihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalenatlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igalenatlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalenasdi"
    }
}
