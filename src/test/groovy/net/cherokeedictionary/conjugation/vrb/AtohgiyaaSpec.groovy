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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadogiyaa"
        "SG1" | "" | Tense.HABITUAL        | "gadogiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadogiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadogiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadogiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hadogiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hadogiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadogiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadogiyvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadogiyasdi"
        "SG3" | "" | Tense.PRESENT         | "adogiyaa"
        "SG3" | "" | Tense.HABITUAL        | "adogiyasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udogiyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adogiyvi"
        "SG3" | "" | Tense.INFINITIVE      | "udogiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anadogiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anadogiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadogiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadogiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadogiyasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadogiyaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadogiyasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadogiyvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadogiyvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadogiyasdi"
    }
}
