// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72689 (entrya atvdasdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyatvdasdiha, gatvdasdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdasdiha', habitual: 'jiyatvdasdisgoi', remote_past: 'jiyatvdastanvi', imperative: 'jiyatvdasda', infinitive: 'jiyatvdasdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvdasdiha', habitual: 'hatvdasdisgoi', remote_past: 'agwatvdastanvi', imperative: 'gatvdasda', infinitive: 'agwatvdasdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdasdiha', habitual: 'hiyatvdasdisgoi', remote_past: 'hiyatvdastanvi', imperative: 'hiyatvdasda', infinitive: 'hiyatvdasdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvdasdiha', habitual: 'hatvdasdisgoi', remote_past: 'jatvdastanvi', imperative: 'hatvdasda', infinitive: 'jatvdasdohdi'],
            [subject: 'SG3', object: '', habitual: 'atvdasdisgoi', imperative: 'hiyatvdasda, hatvdasda', infinitive: 'utvdasdohdi', present: 'atvdasdiha', remote_past: 'utvdastanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvdasdiha', habitual: 'anatvdasdisgoi', remote_past: 'unatvdastanvi', imperative: 'anatvdasda', infinitive: 'unatvdasdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvdasdiha', habitual: 'idatvdasdisgoi', remote_past: 'igatvdastanvi', imperative: 'idatvdasda', infinitive: 'igatvdasdohdi']
        ]
    ]

    @Unroll
    def "conjugating Atvdasdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvdasdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdasdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdasdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdastanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdastanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvdasdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gatvdasdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "hatvdasdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwatvdastanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvdastanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwatvdasdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdasdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdasdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdastanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvdastanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvdasdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvdasdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvdasdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jatvdastanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvdastanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jatvdasdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advdasdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advdasdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdastanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advdastanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvdasdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvdasdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvdasdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvdastanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvdastanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvdasdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idatvdasdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idatvdasdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igatvdastanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvdastanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igatvdasdohdi"
    }
}
