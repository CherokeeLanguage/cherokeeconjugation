package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GawehlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Joking / Teasing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiwehliha', habitual: 'jiwehlisgoi', remote_past: 'agiwehlvhnvi', imperative: 'jiwehlvha', infinitive: 'agiwehlvhdi'],
            [subject: 'SG2', object: '', present: 'hiwehliha', habitual: 'hiwehlisgoi', remote_past: 'jawehlvhnvi', imperative: 'hiwehlvha', infinitive: 'jawehlvhdi'],
            [subject: 'SG3', object: '', present: 'gawehliha', habitual: 'gawehlisgoi', remote_past: 'uwehlvhnvi', imperative: 'gawehlvha', infinitive: 'uwehlvhdi'],
            [subject: 'PL3', object: '', present: 'aniwehliha', habitual: 'aniwehlisgoi', remote_past: 'uniwehlvhnvi', imperative: 'aniwehlvha', infinitive: 'uniwehlvhdi'],
            [subject: 'PL1INCL', object: '', present: 'idiwehliha', habitual: 'idiwehlisgoi', remote_past: 'igiwehlvhnvi', imperative: 'idiwehlvha', infinitive: 'igiwehlvhdi']
        ]
    ]

    @Unroll
    def "conjugating Gawehliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gawehliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwehliha"
        "SG1" | "" | Tense.HABITUAL        | "jiwehlisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwehlvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiwehlvha"
        "SG1" | "" | Tense.INFINITIVE      | "agiwehlvhdi"
        "SG2" | "" | Tense.PRESENT         | "hiwehliha"
        "SG2" | "" | Tense.HABITUAL        | "hiwehlisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawehlvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwehlvha"
        "SG2" | "" | Tense.INFINITIVE      | "jawehlvhdi"
        "SG3" | "" | Tense.PRESENT         | "gawehliha"
        "SG3" | "" | Tense.HABITUAL        | "gawehlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehlvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawehlvha"
        "SG3" | "" | Tense.INFINITIVE      | "uwehlvhdi"
        "PL3" | "" | Tense.PRESENT         | "aniwehliha"
        "PL3" | "" | Tense.HABITUAL        | "aniwehlisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwehlvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwehlvha"
        "PL3" | "" | Tense.INFINITIVE      | "uniwehlvhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwehliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwehlisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwehlvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwehlvha"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwehlvhdi"
    }
}
