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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvwidiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvwidisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvwidvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvwidvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvwitidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvwidiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvwidisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yvwidvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvwidvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yvwitidi"
        "SG3" | "" | Tense.PRESENT         | "ayvwidiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvwidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvwidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvwidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvwitidi"
        "PL3" | "" | Tense.PRESENT         | "aniyvwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvwidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvwitidi"
    }
}
