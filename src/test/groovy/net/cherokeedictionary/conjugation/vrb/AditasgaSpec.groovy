package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AditasgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eating/Drink It (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gaditasga', habitual: 'gaditasgoi', remote_past: 'agwaditahvi', imperative: 'gadita', infinitive: 'agwaditasdi'],
            [subject: 'SG2', object: '', present: 'haditasga', habitual: 'haditasgoi', remote_past: 'jaditahvi', imperative: 'hadita', infinitive: 'jaditasdi'],
            [subject: 'SG3', object: '', present: 'aditasga', habitual: 'aditasgoi', remote_past: 'uditahvi', imperative: 'adita', infinitive: 'uditasdi'],
            [subject: 'SG3', object: '', present: 'anaditasga', habitual: 'anaditasgoi', remote_past: 'unaditahvi', imperative: 'anadita', infinitive: 'unaditasdi']
        ]
    ]

    @Unroll
    def "conjugating Aditasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aditasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gaditasga"
        "SG1" | "" | Tense.HABITUAL        | "gaditasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwaditahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadita"
        "SG1" | "" | Tense.INFINITIVE      | "agwaditasdi"
        "SG2" | "" | Tense.PRESENT         | "haditasga"
        "SG2" | "" | Tense.HABITUAL        | "haditasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaditahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadita"
        "SG2" | "" | Tense.INFINITIVE      | "jaditasdi"
        "SG3" | "" | Tense.PRESENT         | "aditasga"
        "SG3" | "" | Tense.HABITUAL        | "aditasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uditahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adita"
        "SG3" | "" | Tense.INFINITIVE      | "uditasdi"
        "SG3" | "" | Tense.PRESENT         | "anaditasga"
        "SG3" | "" | Tense.HABITUAL        | "anaditasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unaditahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anadita"
        "SG3" | "" | Tense.INFINITIVE      | "unaditasdi"
    }
}
