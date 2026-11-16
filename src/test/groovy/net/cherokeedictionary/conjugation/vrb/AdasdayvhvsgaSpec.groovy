// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72232 (entrya adasdayvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdasdayvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cooking (Meal, Place)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadasdayvhvsga'],
            [subject: 'SG1', object: '', present: 'gadasdayvhvsga', habitual: 'gadasdayvhvsgoi', remote_past: 'agwadasdayvhnvi', imperative: 'gadasdayvhvga', infinitive: 'agwadasdayhdi'],
            [subject: 'SG2', object: '', present: 'hadasdayvhvsga', habitual: 'hadasdayvhvsgoi', remote_past: 'jadasdayvhnvi', imperative: 'hadasdayvhvga', infinitive: 'jadasdayhdi'],
            [subject: 'SG3', object: '', habitual: 'adasdayvhvsgoi', imperative: 'hadasdayvhvga', infinitive: 'udasdayhdi', present: 'adasdayvhvsga', remote_past: 'udasdayvhnvi'],
            [subject: 'PL3', object: '', present: 'anadasdayvhvsga', habitual: 'anadasdayvhvsgoi', remote_past: 'unadasdayvhnvi', imperative: 'anadasdayvhvga', infinitive: 'unadasdayhdi'],
            [subject: 'PL1INCL', object: '', present: 'idadasdayvhvsga', habitual: 'idadasdayvhvsgoi', remote_past: 'igadasdayvhnvi', imperative: 'idadasdayvhvga', infinitive: 'igadasdayhdi']
        ]
    ]

    @Unroll
    def "conjugating Adasdayvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adasdayvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadasdayvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadasdayvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadasdayvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadasdayvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadasdayhdi"
        "SG2" | "" | Tense.PRESENT         | "hadasdayvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadasdayvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadasdayvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadasdayvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadasdayhdi"
        "SG3" | "" | Tense.PRESENT         | "adasdayvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "adasdayvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udasdayvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adasdayvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "udasdayhdi"
        "PL3" | "" | Tense.PRESENT         | "anadasdayvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadasdayvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadasdayvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadasdayvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadasdayhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadasdayvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadasdayvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadasdayvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadasdayvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadasdayhdi"
    }
}
