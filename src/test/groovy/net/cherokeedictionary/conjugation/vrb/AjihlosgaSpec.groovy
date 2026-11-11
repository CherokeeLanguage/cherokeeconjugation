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
        "SG1" | "" | Tense.PRESENT         | "vgwtlosga"
        "SG1" | "" | Tense.HABITUAL        | "vgwtlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "vgwtlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "vgwtlohi"
        "SG1" | "" | Tense.INFINITIVE      | "vgwtlohisdi"
        "SG2" | "" | Tense.PRESENT         | "ejahlosga"
        "SG2" | "" | Tense.HABITUAL        | "ejahlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ejahlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "ejahlohi"
        "SG2" | "" | Tense.INFINITIVE      | "ejahlohisdi"
        "SG3" | "" | Tense.PRESENT         | "ajihlosga"
        "SG3" | "" | Tense.HABITUAL        | "ajihlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ajihlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajihlohi"
        "SG3" | "" | Tense.INFINITIVE      | "ajihlohisdi"
        "PL3" | "" | Tense.PRESENT         | "gejihlosga"
        "PL3" | "" | Tense.HABITUAL        | "gejihlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "gejihlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "gejihlohi"
        "PL3" | "" | Tense.INFINITIVE      | "gejihlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "egihlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "egihlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "egihlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "egihlohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "egihlohisdi"
    }
}
