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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadisgahlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadisgahlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadisgahlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadisgatlanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadisgahldi"
        "SG2" | "" | Tense.PRESENT         | "hadisgahlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadisgahlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadisgahlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadisgatlanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadisgahldi"
        "SG3" | "" | Tense.PRESENT         | "adisgahlvsga"
        "SG3" | "" | Tense.HABITUAL        | "adisgahlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udisgahlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adisgatlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisgahldi"
        "PL3" | "" | Tense.PRESENT         | "anadisgahlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anadisgahlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadisgahlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadisgatlanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadisgahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadisgahlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadisgahlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadisgahlanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadisgatlanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadisgahldi"
    }
}
