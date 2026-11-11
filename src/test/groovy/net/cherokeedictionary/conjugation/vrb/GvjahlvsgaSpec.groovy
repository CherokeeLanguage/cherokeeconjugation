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
            [subject: 'SG1', object: '', present: 'gvjahlvsga', habitual: 'gvjahlvsgoi', remote_past: 'agwvjahlanvi', imperative: 'gvjahlvga', infinitive: 'agwvjahldi'],
            [subject: 'SG2', object: '', present: 'hvjahlvsga', habitual: 'hvjahlvsgoi', remote_past: 'jvjahlanvi', imperative: 'hvjahlvga', infinitive: 'jvjahldi'],
            [subject: 'SG3', object: '', present: 'gvjahlvsga', habitual: 'gvjahlvsgoi', remote_past: 'uwvjahlanvi', imperative: 'gvjahlvga', infinitive: 'uwvjahldi'],
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
        "SG1" | "" | Tense.PRESENT         | "gvjahlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gvjahlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvjahlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvjahlvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwvjahldi"
        "SG2" | "" | Tense.PRESENT         | "hvjahlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hvjahlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvjahlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvjahlvga"
        "SG2" | "" | Tense.INFINITIVE      | "jvjahldi"
        "SG3" | "" | Tense.PRESENT         | "gvjahlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gvjahlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwvjahlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gvjahlvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwvjahldi"
        "PL3" | "" | Tense.PRESENT         | "anvjahlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anvjahlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvjahlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvjahlvga"
        "PL3" | "" | Tense.INFINITIVE      | "unvjahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvjahlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvjahlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvjahlanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvjahlvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvjahldi"
    }
}
