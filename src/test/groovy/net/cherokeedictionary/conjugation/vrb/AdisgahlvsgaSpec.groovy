// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72264 (entrya adisgahlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdisgahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Hiding",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadisgahlvsga'],
            [subject: 'SG1', object: '', present: 'gadisgahlvsga', habitual: 'gadisgahlvsgoi', remote_past: 'agwadisgahlanvi', imperative: 'gadisgahlvga', infinitive: 'agwadisgahldi'],
            [subject: 'SG2', object: '', present: 'hadisgahlvsga', habitual: 'hadisgahlvsgoi', remote_past: 'jadisgahlanvi', imperative: 'hadisgahlvga', infinitive: 'jadisgahldi'],
            [subject: 'SG3', object: '', habitual: 'adisgahlvsgoi', imperative: 'hadisgahlvga', infinitive: 'udisgahldi', present: 'adisgahlvsga', remote_past: 'udisgahlanvi'],
            [subject: 'PL3', object: '', present: 'anadisgahlvsga', habitual: 'anadisgahlvsgoi', remote_past: 'unadisgahlanvi', imperative: 'anadisgahlvga', infinitive: 'unadisgahldi'],
            [subject: 'PL1INCL', object: '', present: 'idadisgahlvsga', habitual: 'idadisgahlvsgoi', remote_past: 'igadisgahlanvi', imperative: 'idadisgahlvga', infinitive: 'igadisgahldi']
        ]
    ]

    @Unroll
    def "conjugating Adisgahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adisgahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadisgatlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadisgatlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadisgatlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadisgatlanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadisgalodi"
        "SG2" | "" | Tense.PRESENT         | "hadisgatlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadisgatlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadisgatlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadisgatlanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadisgalodi"
        "SG3" | "" | Tense.PRESENT         | "adisgatlvsga"
        "SG3" | "" | Tense.HABITUAL        | "adisgatlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udisgatlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adisgatlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisgalodi"
        "PL3" | "" | Tense.PRESENT         | "anadisgatlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadisgatlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadisgatlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadisgatlanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadisgalodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadisgatlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadisgatlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadisgatlanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadisgatlanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadisgalodi"
    }
}
