// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72693 (entrya atvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Growing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadvsga'],
            [subject: 'SG1', object: '', present: 'gadvsga', habitual: 'gadvsgoi', remote_past: 'agwatvsvi', imperative: 'gadvhi', infinitive: 'agwatvhisdi'],
            [subject: 'SG2', object: '', present: 'hatvsga', habitual: 'hatvsgoi', remote_past: 'jatvsvi', imperative: 'hatvhi', infinitive: 'jatvhisdi'],
            [subject: 'SG3', object: '', habitual: 'atvsgoi', imperative: 'hatvhi', infinitive: 'utvhisdi', present: 'atvsga', remote_past: 'utvsvi'],
            [subject: 'PL3', object: '', present: 'anatvsga', habitual: 'anatvsgoi', remote_past: 'unatvsvi', imperative: 'anatvhi', infinitive: 'unatvhisdi'],
            [subject: 'PL1INCL', object: '', present: 'idatvsga', habitual: 'idatvsgoi', remote_past: 'igatvsvi', imperative: 'idatvhi', infinitive: 'igatvhisdi']
        ]
    ]

    @Unroll
    def "conjugating Atvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatvhisdi"
        "SG2" | "" | Tense.PRESENT         | "hatvsga"
        "SG2" | "" | Tense.HABITUAL        | "hatvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatvhisdi"
        "SG3" | "" | Tense.PRESENT         | "atvsga"
        "SG3" | "" | Tense.HABITUAL        | "atvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advsvi"
        "SG3" | "" | Tense.INFINITIVE      | "utvhisdi"
        "PL3" | "" | Tense.PRESENT         | "anatvsga"
        "PL3" | "" | Tense.HABITUAL        | "anatvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatvhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatvhisdi"
    }
}
