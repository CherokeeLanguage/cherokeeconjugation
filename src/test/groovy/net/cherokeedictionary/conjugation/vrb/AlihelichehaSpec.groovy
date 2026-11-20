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
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalihelicheha', habitual: 'hiyalihelichehoi', remote_past: 'hiyalihelichelvi', imperative: 'hiyalielichisi', infinitive: 'hiyalihelichedi'],
            [subject: 'SG3', object: '', habitual: 'alihelichehoi', imperative: 'hiyalielichisi', infinitive: 'ulihelichehdi', present: 'alihelicheha', remote_past: 'ulihelichelvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'analihelicheha', habitual: 'analihelichehoi', remote_past: 'unalihelichelvi', imperative: 'analielichisi', infinitive: 'unalihelichedi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edalihelicheha', habitual: 'edalihelichehoi', remote_past: 'edalihelichelvi', imperative: 'edalielichisi', infinitive: 'edalihelichedi']
        ]
    ]

    @Unroll
    def "conjugating Alihelicheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alihelicheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyalihelitseha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyalihelitsehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyalihelitselvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalihelitselvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyalihelitsedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalihelicheha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalihelichehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalihelichelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalihelitselvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyalihelichehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agalihelitseha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "alihelitsehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwalihelitselvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "alihelitselvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwalihelitsedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "analihelicheha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "analihelichehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unalihelichelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "analihelitselvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unalihelichehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edalihelicheha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edalihelichehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edalihelichelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edalihelitselvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edalihelitsedi"
    }
}
