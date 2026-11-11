package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanagalenihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They are Separating (74)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'desdagaleniha', habitual: 'desdagalenisgoi', remote_past: 'deginagalenvhvi', imperative: 'disdagalena', infinitive: 'disdagalenhdi'],
            [subject: 'SG2', object: '', present: 'dojagaleniha', habitual: 'dojagalenisgoi', remote_past: 'doganagalenvhvi', imperative: 'jojagalena', infinitive: 'jojagalenhdi'],
            [subject: 'SG3', object: '', present: 'danagaleniha', habitual: 'danagalenisgoi', remote_past: 'dunagalenvhvi', imperative: 'dinagalena', infinitive: 'junagalenhdi'],
            [subject: 'PL3', object: '', present: 'dejagaleniha', habitual: 'dejagalenisgoi', remote_past: 'dejagalenvhvi', imperative: 'dijagalena', infinitive: 'dijagalenhdi'],
            [subject: 'PL1INCL', object: '', present: 'dedagaleniha', habitual: 'dedagalenisgoi', remote_past: 'degagalenvhvi', imperative: 'didagalena', infinitive: 'didagalenhdi']
        ]
    ]

    @Unroll
    def "conjugating Danagaleniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danagaleniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "desdagaleniha"
        "SG1" | "" | Tense.HABITUAL        | "desdagalenisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "deginagalenvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "disdagalena"
        "SG1" | "" | Tense.INFINITIVE      | "disdagalenhdi"
        "SG2" | "" | Tense.PRESENT         | "dojagaleniha"
        "SG2" | "" | Tense.HABITUAL        | "dojagalenisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "doganagalenvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jojagalena"
        "SG2" | "" | Tense.INFINITIVE      | "jojagalenhdi"
        "SG3" | "" | Tense.PRESENT         | "danagaleniha"
        "SG3" | "" | Tense.HABITUAL        | "danagalenisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunagalenvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dinagalena"
        "SG3" | "" | Tense.INFINITIVE      | "junagalenhdi"
        "PL3" | "" | Tense.PRESENT         | "dejagaleniha"
        "PL3" | "" | Tense.HABITUAL        | "dejagalenisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dejagalenvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dijagalena"
        "PL3" | "" | Tense.INFINITIVE      | "dijagalenhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedagaleniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedagalenisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degagalenvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didagalena"
        "PL1INCL" | "" | Tense.INFINITIVE      | "didagalenhdi"
    }
}
