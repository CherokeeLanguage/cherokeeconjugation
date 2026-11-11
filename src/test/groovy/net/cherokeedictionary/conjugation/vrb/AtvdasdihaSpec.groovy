package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvdasdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Listening to Him/It (61)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdasdiha', habitual: 'jiyatvdasdisgoi', remote_past: 'jiyatvdastanvi', imperative: 'jiyatvdasda', infinitive: 'jiyatvdasdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvdasdiha', habitual: 'hatvdasdisgoi', remote_past: 'agwatvdastanvi', imperative: 'gatvdasda', infinitive: 'agwatvdasdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdasdiha', habitual: 'hiyatvdasdisgoi', remote_past: 'hiyatvdastanvi', imperative: 'hiyatvdasda', infinitive: 'hiyatvdasdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvdasdiha', habitual: 'hatvdasdisgoi', remote_past: 'jatvdastanvi', imperative: 'hatvdasda', infinitive: 'jatvdasdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'atvdasdiha', habitual: 'atvdasdisgoi', remote_past: 'utvdastanvi', imperative: 'atvdasda', infinitive: 'utvdasdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvdasdiha', habitual: 'anatvdasdisgoi', remote_past: 'unatvdastanvi', imperative: 'anatvdasda', infinitive: 'unatvdasdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvdasdiha', habitual: 'idatvdasdisgoi', remote_past: 'igatvdastanvi', imperative: 'idatvdasda', infinitive: 'igatvdasdohdi']
        ]
    ]

    @Unroll
    def "conjugating Atvdasdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvdasdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdasdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdasdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdastanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatvdasda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvdasdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gatvdasdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "hatvdasdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwatvdastanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gatvdasda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwatvdasdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdasdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdasdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdastanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatvdasda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvdasdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvdasdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvdasdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jatvdastanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hatvdasda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jatvdasdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "atvdasdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "atvdasdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "utvdastanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "atvdasda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utvdasdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvdasdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvdasdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvdastanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anatvdasda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvdasdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idatvdasdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idatvdasdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igatvdastanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idatvdasda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igatvdasdohdi"
    }
}
