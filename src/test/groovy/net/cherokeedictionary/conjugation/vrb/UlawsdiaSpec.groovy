package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlawsdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Staying With Someone",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilawsdia', habitual: 'jilawsdisgoi', remote_past: 'jilawstanvi', imperative: 'jilawsda', infinitive: 'jiyalawsdohdi'],
            [subject: 'SG2', object: '', present: 'hilawsdia', habitual: 'hilawsdisgoi', remote_past: 'hilawstanvi', imperative: 'hilawsda', infinitive: 'hiyalawsdohdi'],
            [subject: 'SG3', object: '', present: 'ulawsdia', habitual: 'ulawsdisgoi', remote_past: 'ulawstanvi', imperative: 'ulawsda', infinitive: 'ulawsdohdi'],
            [subject: 'PL3', object: '', present: 'dunalawsdia', habitual: 'dunalawsdisgoi', remote_past: 'dunalawstanvi', imperative: 'junalawsda', infinitive: 'junalawsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'digalawsdia', habitual: 'digalawsdisgoi', remote_past: 'digalawstanvi', imperative: 'digalawsda', infinitive: 'digalawsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ulawsdia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulawsdia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agilawvsdia"
        "SG1" | "" | Tense.HABITUAL        | "agilawvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilawvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agilawvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilawvsdodi"
        "SG2" | "" | Tense.PRESENT         | "tsalawvsdia"
        "SG2" | "" | Tense.HABITUAL        | "tsalawvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalawvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalawvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalawvsdodi"
        "SG3" | "" | Tense.PRESENT         | "ulawvsdia"
        "SG3" | "" | Tense.HABITUAL        | "ulawvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulawvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulawvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulawvsdodi"
        "PL3" | "" | Tense.PRESENT         | "unilawvsdia"
        "PL3" | "" | Tense.HABITUAL        | "unilawvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilawvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unilawvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilawvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "igilawvsdia"
        "PL1INCL" | "" | Tense.HABITUAL        | "igilawvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilawvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igilawvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilawvsdodi"
    }
}
