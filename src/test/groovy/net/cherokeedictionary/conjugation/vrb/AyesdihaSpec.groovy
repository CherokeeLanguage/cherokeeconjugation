package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyesdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waking Him Up",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyesdiha', habitual: 'jiyesdisgoi', remote_past: 'jiyestanvi', imperative: 'jiyesda', infinitive: 'jiyesdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyesdiha', habitual: 'hiyesdisgoi', remote_past: 'hiyestanvi', imperative: 'hiyesda', infinitive: 'hiyesdohdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayesdiha', habitual: 'ayesdisgoi', remote_past: 'uyestanvi', imperative: 'ayesda', infinitive: 'uyesdohdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anayesdiha', habitual: 'anayesdisgoi', remote_past: 'unayestanvi', imperative: 'unayesda', infinitive: 'unayesdohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edayesdiha', habitual: 'edayesdisgoi', remote_past: 'edayestanvi', imperative: 'edayesda', infinitive: 'edayesdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ayesdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayesdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyesdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyesdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyestanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyesda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyesdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyesdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyesdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyestanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyesda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyesdohdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayesdiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayesdisgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyestanvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayesda"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyesdohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anayesdiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anayesdisgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unayestanvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "unayesda"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unayesdohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edayesdiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edayesdisgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edayestanvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edayesda"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edayesdohdi"
    }
}
