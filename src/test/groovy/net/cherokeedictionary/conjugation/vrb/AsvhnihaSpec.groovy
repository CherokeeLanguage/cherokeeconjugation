package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsvhnihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Touching (Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasvhniha', habitual: 'jiyasvhnihoi', remote_past: 'jiyasvhnilvi', imperative: 'jiyasvnhga', infinitive: 'jiyasvnsdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gasvhniha', habitual: 'gasvhnihoi', remote_past: 'agwasvhnilvi', imperative: 'gasvnhga', infinitive: 'agwasvnsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasvhniha', habitual: 'hiyasvhnihoi', remote_past: 'hiyasvhnilvi', imperative: 'hiyasvnhga', infinitive: 'hiyasvnsdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hasvhniha', habitual: 'hasvhnihoi', remote_past: 'jasvhnilvi', imperative: 'hasvnhga', infinitive: 'jasvnsdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'asvhniha', habitual: 'asvhnihoi', remote_past: 'usvhnilvi', imperative: 'asvnhga', infinitive: 'usvnsdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anasvhniha', habitual: 'anasvhnihoi', remote_past: 'unasvhnilvi', imperative: 'anasvnhga', infinitive: 'unasvnsdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idasvhniha', habitual: 'idasvhnihoi', remote_past: 'igasvhnilvi', imperative: 'idasvnhga', infinitive: 'igasvnsdi']
        ]
    ]

    @Unroll
    def "conjugating Asvhniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asvhniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasvhniha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasvhnihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasvhnilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyasvnhga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyasvnsdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gasvhniha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gasvhnihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwasvhnilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gasvnhga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwasvnsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasvhniha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasvhnihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasvhnilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasvnhga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasvnsdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hasvhniha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hasvhnihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jasvhnilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hasvnhga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jasvnsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "asvhniha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "asvhnihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "usvhnilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "asvnhga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "usvnsdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anasvhniha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anasvhnihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unasvhnilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anasvnhga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unasvnsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idasvhniha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idasvhnihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igasvhnilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idasvnhga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igasvnsdi"
    }
}
