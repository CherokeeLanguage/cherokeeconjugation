package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsehehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Showing Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyaseheha', habitual: 'jiyasehehoi', remote_past: 'jiyasehelvi', imperative: 'jiysehisi', infinitive: 'jiyasehehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyaseheha', habitual: 'hiyasehehoi', remote_past: 'hiyasehelvi', imperative: 'hiyasehisi', infinitive: 'hiyasehehdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'aseheha', habitual: 'asehehoi', remote_past: 'usehelvi', imperative: 'asehisi', infinitive: 'usehehdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anaseheha', habitual: 'anasehehoi', remote_past: 'unasehelvi', imperative: 'anasehisi', infinitive: 'unasehehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edaseheha', habitual: 'edasehehoi', remote_past: 'edasehelvi', imperative: 'edasehisi', infinitive: 'edasehehdi']
        ]
    ]

    @Unroll
    def "conjugating Aseheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aseheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyaseheha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasehehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasehelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiysehisi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyasehehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyaseheha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasehehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasehelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasehisi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasehehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "aseheha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "asehehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "usehelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "asehisi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "usehehdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anaseheha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anasehehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unasehelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anasehisi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unasehehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edaseheha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edasehehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edasehelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edasehisi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edasehehdi"
    }
}
