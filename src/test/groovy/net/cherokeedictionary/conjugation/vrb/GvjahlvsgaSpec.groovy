// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73301 (entrya gvjahlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GvjahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Frying It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gvjahlvsga'],
            [subject: 'SG1', object: '', present: 'gvjahlvsga', habitual: 'gvjahlvsgoi', remote_past: 'agwvjahlanvi', imperative: 'gvjahlvga', infinitive: 'agwvjahldi'],
            [subject: 'SG2', object: '', present: 'hvjahlvsga', habitual: 'hvjahlvsgoi', remote_past: 'jvjahlanvi', imperative: 'hvjahlvga', infinitive: 'jvjahldi'],
            [subject: 'SG3', object: '', habitual: 'gvjahlvsgoi', imperative: 'hvjahlvga', infinitive: 'uwvjahldi', present: 'gvjahlvsga', remote_past: 'uwvjahlanvi'],
            [subject: 'PL3', object: '', present: 'anvjahlvsga', habitual: 'anvjahlvsgoi', remote_past: 'unvjahlanvi', imperative: 'anvjahlvga', infinitive: 'unvjahldi'],
            [subject: 'PL1INCL', object: '', present: 'idvjahlvsga', habitual: 'idvjahlvsgoi', remote_past: 'igvjahlanvi', imperative: 'idvjahlvga', infinitive: 'igvjahldi']
        ]
    ]

    @Unroll
    def "conjugating Gvjahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gvjahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvjahlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gvjahlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvjahlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvtsatlanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwvjahldi"
        "SG2" | "" | Tense.PRESENT         | "hvjahlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hvjahlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvjahlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvtsatlanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jvjahldi"
        "SG3" | "" | Tense.PRESENT         | "gvjahlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gvjahlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwvjahlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vtsatlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvjahldi"
        "PL3" | "" | Tense.PRESENT         | "anvjahlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anvjahlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvjahlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvtsatlanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unvjahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvjahlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvjahlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvjahlanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvtsatlanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvjahldi"
    }
}
