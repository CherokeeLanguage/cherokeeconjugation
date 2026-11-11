package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyvhwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (long)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvwahtiha', habitual: 'jiyvwahtisgoi', remote_past: 'agiyvhwahtvhvi', imperative: 'jiyvwahta', infinitive: 'agiyvhwahtvhdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhwahtiha', habitual: 'hiyvhwahtisgoi', remote_past: 'jayvhwahtvhvi', imperative: 'hiyvhwahta', infinitive: 'jayvhwahtvhdi'],
            [subject: 'SG3', object: '', present: 'ayvhwahtiha', habitual: 'ayvhwahtisgoi', remote_past: 'uyvhwahtvhvi', imperative: 'ayvhwahta', infinitive: 'uyvhwahtvhdi'],
            [subject: 'PL3', object: '', present: 'aniyvhwahtiha', habitual: 'aniyvhwahtisgoi', remote_past: 'uniyvhwahtvhvi', imperative: 'aniyvhwahta', infinitive: 'uniyvhwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ayvhwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayvhwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvwahtiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvwahtisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyvhwahtvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyvwahta"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyvhwahtvhdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhwahtiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhwahtisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayvhwahtvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvhwahta"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayvhwahtvhdi"
        "SG3" | "" | Tense.PRESENT         | "ayvhwahtiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvhwahtisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhwahtvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvhwahta"
        "SG3" | "" | Tense.INFINITIVE      | "uyvhwahtvhdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvhwahtiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvhwahtisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhwahtvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvhwahta"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvhwahtvhdi"
    }
}
