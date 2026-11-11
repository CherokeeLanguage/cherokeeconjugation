package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyhwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (long)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvwidiha', habitual: 'jiyvwidisgoi', remote_past: 'agiyvhwidvhvi', imperative: 'jiyvwida', infinitive: 'agiyvhwitdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhwidiha', habitual: 'hiyvhwidisgoi', remote_past: 'jayvhwidvhvi', imperative: 'hiyvhwida', infinitive: 'jayvhwitdi'],
            [subject: 'SG3', object: '', present: 'ayvhwidiha', habitual: 'ayvhwidisgoi', remote_past: 'uyvhwidvhvi', imperative: 'ayvhwida', infinitive: 'uyvhwitdi'],
            [subject: 'PL3', object: '', present: 'aniyvhwidiha', habitual: 'aniyvhwidisgoi', remote_past: 'uniyvhwidvhvi', imperative: 'aniyvhwida', infinitive: 'uniyvhwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ayhwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayhwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvwidiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvwidisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyvhwidvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyvwida"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyvhwitdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhwidiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhwidisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayvhwidvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvhwida"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayvhwitdi"
        "SG3" | "" | Tense.PRESENT         | "ayvhwidiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvhwidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhwidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvhwida"
        "SG3" | "" | Tense.INFINITIVE      | "uyvhwitdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvhwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvhwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvhwida"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvhwitdi"
    }
}
