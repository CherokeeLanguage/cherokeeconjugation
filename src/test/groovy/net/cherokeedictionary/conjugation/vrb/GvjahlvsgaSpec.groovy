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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvtsatlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gvtsatlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvtsatlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvtsatlanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwvtsalodi"
        "SG2" | "" | Tense.PRESENT         | "hvtsatlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hvtsatlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvtsatlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvtsatlanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawvtsalodi"
        "SG3" | "" | Tense.PRESENT         | "gvtsatlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gvtsatlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwatsatlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vtsatlanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvtsalodi"
        "PL3" | "" | Tense.PRESENT         | "anvtsatlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anvtsatlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsatlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvtsatlanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwvtsalodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvtsatlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvtsatlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvtsatlanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvtsatlanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwvtsalodi"
    }
}
