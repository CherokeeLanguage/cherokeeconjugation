package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlihelichehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Appreciative/Thanking Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalielicheha', habitual: 'jiyalielichehoi', remote_past: 'jiyalielichelvi', imperative: 'jiyalielichisi', infinitive: 'jiyalielichedi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalihelicheha', habitual: 'hiyalihelichehoi', remote_past: 'hiyalihelichelvi', imperative: 'hiyalielichisi', infinitive: 'hiyalihelichehdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'alihelicheha', habitual: 'alihelichehoi', remote_past: 'ulihelichelvi', imperative: 'alielichisi', infinitive: 'ulihelichehdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'analihelicheha', habitual: 'analihelichehoi', remote_past: 'unalihelichelvi', imperative: 'analielichisi', infinitive: 'unalihelichehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edalihelicheha', habitual: 'edalihelichehoi', remote_past: 'edalihelichelvi', imperative: 'edalielichisi', infinitive: 'edalihelichechdi']
        ]
    ]

    @Unroll
    def "conjugating Alihelicheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alihelicheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyalielicheha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyalielichehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyalielichelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyalielichisi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyalielichedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalihelicheha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalihelichehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalihelichelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalielichisi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyalihelichehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "alihelicheha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "alihelichehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "ulihelichelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "alielichisi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "ulihelichehdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "analihelicheha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "analihelichehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unalihelichelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "analielichisi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unalihelichehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edalihelicheha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edalihelichehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edalihelichelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edalielichisi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edalihelichechdi"
    }
}
