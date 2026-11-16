package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjihlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he Losing (A Game) / Being Beaten (Game)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'vgwtlosga', habitual: 'vgwtlosgoi', remote_past: 'vgwtlosvi', imperative: 'vgwtlohi', infinitive: 'vgwtlohisdi'],
            [subject: 'SG2', object: '', present: 'ejahlosga', habitual: 'ejahlosgoi', remote_past: 'ejahlosvi', imperative: 'ejahlohi', infinitive: 'ejahlohisdi'],
            [subject: 'SG3', object: '', present: 'ajihlosga', habitual: 'ajihlosgoi', remote_past: 'ajihlosvi', imperative: 'ajihlohi', infinitive: 'ajihlohisdi'],
            [subject: 'PL3', object: '', present: 'gejihlosga', habitual: 'gejihlosgoi', remote_past: 'gejihlosvi', imperative: 'gejihlohi', infinitive: 'gejihlohisdi'],
            [subject: 'PL1INCL', object: '', present: 'egihlosga', habitual: 'egihlosgoi', remote_past: 'egihlosvi', imperative: 'egihlohi', infinitive: 'egihlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Ajihlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajihlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsitlosga"
        "SG1" | "" | Tense.HABITUAL        | "gatsitlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsitlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsitlosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsitlohisdi"
        "SG2" | "" | Tense.PRESENT         | "hatsitlosga"
        "SG2" | "" | Tense.HABITUAL        | "hatsitlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsitlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsitlosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsitlohisdi"
        "SG3" | "" | Tense.PRESENT         | "atsitlosga"
        "SG3" | "" | Tense.HABITUAL        | "atsitlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsitlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsitlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsitlohisdi"
        "PL3" | "" | Tense.PRESENT         | "anatsitlosga"
        "PL3" | "" | Tense.HABITUAL        | "anatsitlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsitlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsitlosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsitlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsitlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsitlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsitlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsitlosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsitlohisdi"
    }
}
