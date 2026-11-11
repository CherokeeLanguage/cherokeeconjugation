package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Raising/Lifting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisaldia', habitual: 'jisaldisgoi', remote_past: 'aksaldanvi', imperative: 'jisaldvga', infinitive: 'aksaldodi'],
            [subject: 'SG2', object: '', present: 'hisaladia', habitual: 'hisaladisgoi', remote_past: 'tsaladanvi', imperative: 'hisaladvga', infinitive: 'tsaladodi'],
            [subject: 'SG3', object: '', present: 'asaladia', habitual: 'asaladisgoi', remote_past: 'usaladanvi', imperative: 'asaladvga', infinitive: 'usaladodi'],
            [subject: 'PL3', object: '', present: 'anisaladia', habitual: 'anisaladisgoi', remote_past: 'unisaladanvi', imperative: 'anisaladvga', infinitive: 'unisaladodi'],
            [subject: 'PL1INCL', object: '', present: 'idisaladia', habitual: 'idisaladisgoi', remote_past: 'iksaladanvi', imperative: 'idisaladvga', infinitive: 'iksaladodi']
        ]
    ]

    @Unroll
    def "conjugating Asaladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asaladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisaldia"
        "SG1" | "" | Tense.HABITUAL        | "jisaldisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksaldanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisaldvga"
        "SG1" | "" | Tense.INFINITIVE      | "aksaldodi"
        "SG2" | "" | Tense.PRESENT         | "hisaladia"
        "SG2" | "" | Tense.HABITUAL        | "hisaladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaladanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisaladvga"
        "SG2" | "" | Tense.INFINITIVE      | "tsaladodi"
        "SG3" | "" | Tense.PRESENT         | "asaladia"
        "SG3" | "" | Tense.HABITUAL        | "asaladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usaladanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asaladvga"
        "SG3" | "" | Tense.INFINITIVE      | "usaladodi"
        "PL3" | "" | Tense.PRESENT         | "anisaladia"
        "PL3" | "" | Tense.HABITUAL        | "anisaladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisaladanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisaladvga"
        "PL3" | "" | Tense.INFINITIVE      | "unisaladodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisaladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisaladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksaladanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisaladvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksaladodi"
    }
}
