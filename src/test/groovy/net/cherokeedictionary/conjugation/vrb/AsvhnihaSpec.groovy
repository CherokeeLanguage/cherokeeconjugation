// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72650 (entrya asvhniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyasvhniha, gasvhniha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasvhniha', habitual: 'jiyasvhnihoi', remote_past: 'jiyasvhnilvi', imperative: 'jiyasvnhga', infinitive: 'jiyasvnsdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gasvhniha', habitual: 'gasvhnihoi', remote_past: 'agwasvhnilvi', imperative: 'gasvnhga', infinitive: 'agwasvnsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasvhniha', habitual: 'hiyasvhnihoi', remote_past: 'hiyasvhnilvi', imperative: 'hiyasvnhga', infinitive: 'hiyasvnsdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hasvhniha', habitual: 'hasvhnihoi', remote_past: 'jasvhnilvi', imperative: 'hasvnhga', infinitive: 'jasvnsdi'],
            [subject: 'SG3', object: '', habitual: 'asvhnihoi', imperative: 'hiyasvnhga, hasvnhga', infinitive: 'usvnsdi', present: 'asvhniha', remote_past: 'usvhnilvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anasvhniha', habitual: 'anasvhnihoi', remote_past: 'unasvhnilvi', imperative: 'anasvnhga', infinitive: 'unasvnsdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idasvhniha', habitual: 'idasvhnihoi', remote_past: 'igasvhnilvi', imperative: 'idasvnhga', infinitive: 'igasvnsdi']
        ]
    ]

    @Unroll
    def "conjugating Asvhniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asvhniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasvhniha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasvhnihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasvhnilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyasvnilvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyasvnsdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gasvhniha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gasvhnihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwasvhnilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gasvnilvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwasvnsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasvhniha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasvhnihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasvhnilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasvnilvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasvnsdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hasvhniha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hasvhnihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jasvhnilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hasvnilvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jasvnsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "asvniha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "asvnihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "usvnilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "asvnilvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "usvnisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anasvhniha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anasvhnihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unasvhnilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anasvnilvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unasvnsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idasvhniha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idasvhnihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igasvhnilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idasvnilvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igasvnsdi"
    }
}
