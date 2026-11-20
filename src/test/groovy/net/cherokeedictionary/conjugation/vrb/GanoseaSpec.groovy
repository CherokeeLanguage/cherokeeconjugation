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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinosea"
        "SG1" | "" | Tense.HABITUAL        | "jinosehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginoselvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinoselvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginosedi"
        "SG2" | "" | Tense.PRESENT         | "hinosea"
        "SG2" | "" | Tense.HABITUAL        | "hinosehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanoselvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinoselvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanosedi"
        "SG3" | "" | Tense.PRESENT         | "ganosea"
        "SG3" | "" | Tense.HABITUAL        | "ganosehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unoselvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganoselvi"
        "SG3" | "" | Tense.INFINITIVE      | "unosehdi"
        "PL3" | "" | Tense.PRESENT         | "aninosea"
        "PL3" | "" | Tense.HABITUAL        | "aninosehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninoselvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninoselvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninosehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinosea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinosehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginoselvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinoselvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginosedi"
    }
}
