// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72504 (entrya alihelicheha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyalielicheha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalielicheha', habitual: 'jiyalielichehoi', remote_past: 'jiyalielichelvi', imperative: 'jiyalielichisi', infinitive: 'jiyalielichedi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalihelicheha', habitual: 'hiyalihelichehoi', remote_past: 'hiyalihelichelvi', imperative: 'hiyalielichisi', infinitive: 'hiyalihelichehdi'],
            [subject: 'SG3', object: '', habitual: 'alihelichehoi', imperative: 'hiyalielichisi', infinitive: 'ulihelichehdi', present: 'alihelicheha', remote_past: 'ulihelichelvi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyalihelitseha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyalihelitsehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyalihelitselvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalihelitselvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyalihelitsedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalihelitseha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalihelitsehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "alihelitselvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalihelitselvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "alihelitsedi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agalihelitseha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "alihelitsehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwalihelitselvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "alihelitselvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwalihelitsedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "analihelitseha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "analihelitsehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "analihelitselvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "analihelitselvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "analihelitsedi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edalihelitseha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edalihelitsehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "alihelitselvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edalihelitselvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "alihelitsedi"
    }
}
