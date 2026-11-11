package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanoseaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Telling Him/Her",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinosea', habitual: 'jinosehoi', remote_past: 'jinoselvi', imperative: 'jinohisi', infinitive: 'jinosehdi'],
            [subject: 'SG2', object: '', present: 'hinosea', habitual: 'hinosehoi', remote_past: 'hinoselvi', imperative: 'hinohisi', infinitive: 'hinosehdi'],
            [subject: 'SG3', object: '', present: 'ganosea', habitual: 'ganosehoi', remote_past: 'unoselvi', imperative: 'ganohisi', infinitive: 'unosehdi'],
            [subject: 'PL3', object: '', present: 'aninosea', habitual: 'aninosehoi', remote_past: 'uninoselvi', imperative: 'aninohisi', infinitive: 'uninosehdi'],
            [subject: 'PL1INCL', object: '', present: 'edinosea', habitual: 'edinosehoi', remote_past: 'edinoselvi', imperative: 'edinohisi', infinitive: 'edinosehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganosea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganosea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinosea"
        "SG1" | "" | Tense.HABITUAL        | "jinosehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinoselvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinohisi"
        "SG1" | "" | Tense.INFINITIVE      | "jinosehdi"
        "SG2" | "" | Tense.PRESENT         | "hinosea"
        "SG2" | "" | Tense.HABITUAL        | "hinosehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinoselvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohisi"
        "SG2" | "" | Tense.INFINITIVE      | "hinosehdi"
        "SG3" | "" | Tense.PRESENT         | "ganosea"
        "SG3" | "" | Tense.HABITUAL        | "ganosehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unoselvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohisi"
        "SG3" | "" | Tense.INFINITIVE      | "unosehdi"
        "PL3" | "" | Tense.PRESENT         | "aninosea"
        "PL3" | "" | Tense.HABITUAL        | "aninosehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninoselvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohisi"
        "PL3" | "" | Tense.INFINITIVE      | "uninosehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edinosea"
        "PL1INCL" | "" | Tense.HABITUAL        | "edinosehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edinoselvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edinohisi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edinosehdi"
    }
}
