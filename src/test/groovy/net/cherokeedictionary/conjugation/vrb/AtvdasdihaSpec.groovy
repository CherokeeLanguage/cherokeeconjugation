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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadvdasdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadvdasdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadvdastanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdastanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadvdasdodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadvdasdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadvdasdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquadvdastanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvdastanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquadvdasdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadvdasdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadvdasdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "advdastanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvdastanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "advdasdodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadvdasdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadvdasdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsadvdastanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvdastanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsadvdasdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advdasdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advdasdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdastanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advdastanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvdasdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadvdasdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadvdasdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadvdastanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvdastanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadvdasdodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idadvdasdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadvdasdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadvdastanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvdastanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadvdasdodi"
    }
}
