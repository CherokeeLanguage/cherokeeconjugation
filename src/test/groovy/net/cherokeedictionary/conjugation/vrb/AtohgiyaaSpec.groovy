// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72675 (entrya atohgiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtohgiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Racing / Running for Office",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gatohgiyaa'],
            [subject: 'SG1', object: '', present: 'gatohgiyaa', habitual: 'gatohgiyasgoi', remote_past: 'agwatohgiyvi', imperative: 'gatohgiya', infinitive: 'agwatohgiyasdi'],
            [subject: 'SG2', object: '', present: 'hatohgiyaa', habitual: 'hatohgiyasgoi', remote_past: 'jatohgiyvi', imperative: 'hatohgiya', infinitive: 'jatohgiyasdi'],
            [subject: 'SG3', object: '', habitual: 'atohgiyasgoi', imperative: 'hatohgiya', infinitive: 'utohgiyasdi', present: 'atohgiyaa', remote_past: 'utohgiyvi'],
            [subject: 'PL3', object: '', present: 'anatohgiyaa', habitual: 'anatohgiyasgoi', remote_past: 'unatohgiyvi', imperative: 'anatohgiya', infinitive: 'unatohgiyasdi'],
            [subject: 'PL1INCL', object: '', present: 'idatohgiyaa', habitual: 'idatohgiyasgoi', remote_past: 'igatohgiyvi', imperative: 'idatohgiya', infinitive: 'igatohgiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Atohgiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atohgiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatohgiyaa"
        "SG1" | "" | Tense.HABITUAL        | "gatohgiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatohgiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadogiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatohgiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hatohgiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hatohgiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatohgiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadogiyvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatohgiyasdi"
        "SG3" | "" | Tense.PRESENT         | "atohgiyaa"
        "SG3" | "" | Tense.HABITUAL        | "atohgiyasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utohgiyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adogiyvi"
        "SG3" | "" | Tense.INFINITIVE      | "utohgiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anatohgiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anatohgiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatohgiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadogiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatohgiyasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatohgiyaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatohgiyasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatohgiyvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadogiyvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatohgiyasdi"
    }
}
