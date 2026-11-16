// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72283 (entrya adlohyiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdlohyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Crying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadloyiha'],
            [subject: 'SG1', object: '', present: 'gadloyiha', habitual: 'gadloyihoi', remote_past: 'agwadlohyilvi', imperative: 'gadlohga', infinitive: 'agwadloysdi'],
            [subject: 'SG2', object: '', present: 'hadloyiha', habitual: 'hadlohyihoi', remote_past: 'jadlohyilvi', imperative: 'hadlohga', infinitive: 'jadloysdi'],
            [subject: 'SG3', object: '', habitual: 'adlohyihoi', imperative: 'hadloyhga', infinitive: 'udloysdi', present: 'adlohyiha', remote_past: 'udlohyilvi'],
            [subject: 'PL3', object: '', present: 'anadlohyiha', habitual: 'anadlohyihoi', remote_past: 'unadlohyilvi', imperative: 'anadlohga', infinitive: 'unadloysdi'],
            [subject: 'PL1INCL', object: '', present: 'idadlohyiha', habitual: 'idadlohyihoi', remote_past: 'igadlohyilvi', imperative: 'idadlohga', infinitive: 'igadloysdi']
        ]
    ]

    @Unroll
    def "conjugating Adlohyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlohyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatloyiha"
        "SG1" | "" | Tense.HABITUAL        | "gatloyihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatloyilvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatloyilvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadloysdi"
        "SG2" | "" | Tense.PRESENT         | "hatloyiha"
        "SG2" | "" | Tense.HABITUAL        | "hatloyihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatloyilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatloyilvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadloysdi"
        "SG3" | "" | Tense.PRESENT         | "atloyiha"
        "SG3" | "" | Tense.HABITUAL        | "atloyihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utloyilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atloyilvi"
        "SG3" | "" | Tense.INFINITIVE      | "udloysdi"
        "PL3" | "" | Tense.PRESENT         | "anatloyiha"
        "PL3" | "" | Tense.HABITUAL        | "anatloyihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatloyilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatloyilvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadloysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatloyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatloyihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatloyilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatloyilvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadloysdi"
    }
}
