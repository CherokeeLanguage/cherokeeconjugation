// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72488 (entrya alasgaliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlasgalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Playing Ball",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galasgaliha'],
            [subject: 'SG1', object: '', present: 'galasgaliha', habitual: 'galasgalisgoi', remote_past: 'agwalasgalvhvi', imperative: 'galasgala', infinitive: 'agwalasgahldi'],
            [subject: 'SG2', object: '', present: 'halasgaliha', habitual: 'halasgalisgoi', remote_past: 'jalasgalvhvi', imperative: 'halasgala', infinitive: 'jalasgahldi'],
            [subject: 'SG3', object: '', habitual: 'alasgalisgoi', imperative: 'halasgala', infinitive: 'ulasgahldi', present: 'alasgaliha', remote_past: 'ulasgalvhvi'],
            [subject: 'PL3', object: '', present: 'analasgaliha', habitual: 'analasgalisgoi', remote_past: 'unalasgalvhvi', imperative: 'analasgala', infinitive: 'unalasgahldi'],
            [subject: 'PL1INCL', object: '', present: 'idalasgaliha', habitual: 'idalasgalisgoi', remote_past: 'igalasgalvhvi', imperative: 'idalasgala', infinitive: 'igalasgahldi']
        ]
    ]

    @Unroll
    def "conjugating Alasgaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alasgaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galasgaliha"
        "SG1" | "" | Tense.HABITUAL        | "galasgalisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualasgalvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galasgalvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualasgalodi"
        "SG2" | "" | Tense.PRESENT         | "halasgaliha"
        "SG2" | "" | Tense.HABITUAL        | "halasgalisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalasgalvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halasgalvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalasgalodi"
        "SG3" | "" | Tense.PRESENT         | "alasgaliha"
        "SG3" | "" | Tense.HABITUAL        | "alasgalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulasgalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alasgalvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulasgalodi"
        "PL3" | "" | Tense.PRESENT         | "analasgaliha"
        "PL3" | "" | Tense.HABITUAL        | "analasgalisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalasgalvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analasgalvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalasgalodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalasgaliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalasgalisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalasgalvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalasgalvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalasgalodi"
    }
}
