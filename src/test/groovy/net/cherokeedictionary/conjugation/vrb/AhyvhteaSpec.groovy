// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72418 (entrya ahyvhtea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyvhteaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Kicking (Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyayvhtea, gayvhtea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyayhtea', habitual: 'jiyayhtesgoi', remote_past: 'jiyayhtesvi', imperative: 'jiyayhtagi', infinitive: 'jiyayhtesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gayvhtea', habitual: 'gayvhtesgoi', remote_past: 'agwahyvhtesvi', imperative: 'gayvhtagi', infinitive: 'agwahyvhtesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyayvhtea', habitual: 'hiyahyvhtesgoi', remote_past: 'hiyahyvhtesvi', imperative: 'hiyayhtagi', infinitive: 'hiyahyvhtesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hayvhtea', habitual: 'hahyvhtesgoi', remote_past: 'jahyvhtesvi', imperative: 'hahyvhtagi', infinitive: 'jahyvhtesdi'],
            [subject: 'SG3', object: '', habitual: 'ahyvhtesgoi', imperative: 'hiyayhtagi, hahyvhtagi', infinitive: 'uhyvhtesdi', present: 'ahyvhtea', remote_past: 'uhyvhtesvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anayvhtea', habitual: 'anahyvhtesgoi', remote_past: 'unahyvhtesvi', imperative: 'anahyvhtagi', infinitive: 'unahyvhtesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idayvhtea', habitual: 'idahyvhtesgoi', remote_past: 'igahyvhtesvi', imperative: 'idahyvhtagi', infinitive: 'igahyvhtesdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyvhtea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyvhtea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyayhtea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyayhtesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyayhtesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyayvtesvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvtesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gayvhtea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gayvhtesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwahyvhtesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gayvtesvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agiyvtesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyayvhtea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyahyvhtesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyahyvhtesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyayvtesvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvtesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hayvhtea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hahyvhtesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jahyvhtesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hayvtesvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jahyvhtesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ayvtea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ayvtesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uyvtesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ayvtesvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uyvtesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anayvhtea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anahyvhtesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unahyvhtesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anayvtesvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uniyvtesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idayvhtea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idahyvhtesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igahyvhtesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idayvtesvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igiyvtesdi"
    }
}
