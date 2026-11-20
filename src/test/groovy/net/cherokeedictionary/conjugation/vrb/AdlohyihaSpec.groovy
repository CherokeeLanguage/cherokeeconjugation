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
            [subject: 'SG1', object: '', present: 'gadloyiha', habitual: 'gadloyihoi', remote_past: 'agwadlohyilvi', imperative: 'gadlohga', infinitive: 'agwadloyisdi'],
            [subject: 'SG2', object: '', present: 'hadloyiha', habitual: 'hadlohyihoi', remote_past: 'jadlohyilvi', imperative: 'hadlohga', infinitive: 'jadloyisdi'],
            [subject: 'SG3', object: '', habitual: 'adlohyihoi', imperative: 'hadloyhga', infinitive: 'udloyisdi', present: 'adlohyiha', remote_past: 'udlohyilvi'],
            [subject: 'PL3', object: '', present: 'anadlohyiha', habitual: 'anadlohyihoi', remote_past: 'unadlohyilvi', imperative: 'anadlohga', infinitive: 'unadloyisdi'],
            [subject: 'PL1INCL', object: '', present: 'idadlohyiha', habitual: 'idadlohyihoi', remote_past: 'igadlohyilvi', imperative: 'idadlohga', infinitive: 'igadloyisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlohyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlohyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadloyiha"
        "SG1" | "" | Tense.HABITUAL        | "gadloyihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadlohyilvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatloyilvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadloyisdi"
        "SG2" | "" | Tense.PRESENT         | "hadloyiha"
        "SG2" | "" | Tense.HABITUAL        | "hadlohyihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadlohyilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatloyilvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadloyisdi"
        "SG3" | "" | Tense.PRESENT         | "adlohyiha"
        "SG3" | "" | Tense.HABITUAL        | "adlohyihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlohyilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atloyilvi"
        "SG3" | "" | Tense.INFINITIVE      | "udloyisdi"
        "PL3" | "" | Tense.PRESENT         | "anadlohyiha"
        "PL3" | "" | Tense.HABITUAL        | "anadlohyihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlohyilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatloyilvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadloyisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadlohyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadlohyihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlohyilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatloyilvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadloyisdi"
    }
}
