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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyayvtea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyayvtesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyayvtesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyayvtesvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvtesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gayvtea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gayvtesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquayvtesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gayvtesvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agiyvtesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyayvtea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyayvtesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "ayvtesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyayvtesvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yvtesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hayvtea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hayvtesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsayvtesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hayvtesvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsayvtesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ayvtea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ayvtesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uyvtesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ayvtesvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uyvtesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anayvtea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anayvtesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unayvtesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anayvtesvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uniyvtesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idayvtea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idayvtesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igayvtesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idayvtesvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igiyvtesdi"
    }
}
