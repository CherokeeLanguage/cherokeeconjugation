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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyayhtea', habitual: 'jiyayhtesgoi', remote_past: 'jiyayhtesvi', imperative: 'jiyayhtagi', infinitive: 'jiyayhtesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gayvhtea', habitual: 'gayvhtesgoi', remote_past: 'agwahyvhtesvi', imperative: 'gayvhtagi', infinitive: 'agwahyvhtesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyayvhtea', habitual: 'hiyahyvhtesgoi', remote_past: 'hiyahyvhtesvi', imperative: 'hiyayhtagi', infinitive: 'hiyahyvhtesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hayvhtea', habitual: 'hahyvhtesgoi', remote_past: 'jahyvhtesvi', imperative: 'hahyvhtagi', infinitive: 'jahyvhtesdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'ayvhtea', habitual: 'ahyvhtesgoi', remote_past: 'uhyvhtesvi', imperative: 'ahyvhtagi', infinitive: 'uhyvhtesdi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyayhtea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyayhtesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyayhtesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyayhtagi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyayhtesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gayvhtea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gayvhtesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwahyvhtesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gayvhtagi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwahyvhtesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyayvhtea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyahyvhtesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyahyvhtesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyayhtagi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyahyvhtesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hayvhtea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hahyvhtesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jahyvhtesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hahyvhtagi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jahyvhtesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ayvhtea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ahyvhtesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uhyvhtesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ahyvhtagi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uhyvhtesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anayvhtea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anahyvhtesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unahyvhtesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anahyvhtagi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unahyvhtesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idayvhtea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idahyvhtesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igahyvhtesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idahyvhtagi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igahyvhtesdi"
    }
}
