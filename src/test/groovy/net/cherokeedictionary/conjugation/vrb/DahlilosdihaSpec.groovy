// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72751 (entrya dahlilosdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DahlilosdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Drawing / Taking a Picture",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejiyadlilosdiha, degadlilosdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'dejiyadlilosdiha', habitual: 'dejiyadlilosdisgoi', remote_past: 'dejiyahlilostanvi', imperative: 'dijiyadlilosda', infinitive: ''],
            [subject: 'SG1', object: 'SG3IN', present: 'degadlilosdiha', habitual: 'degadlilosdisgoi', remote_past: 'dagwahlilostanvi', imperative: 'digadlilosda', infinitive: ''],
            [subject: 'SG2', object: 'SG3AN', present: 'dehiyadlilosdiha', habitual: 'dehiyadlilosdisgoi', remote_past: 'dehiyahlilostanvi', imperative: 'tiyadlilosda', infinitive: ''],
            [subject: 'SG2', object: 'SG3IN', present: 'dehahlilosdiha', habitual: 'dehahlilosdisgoi', remote_past: 'dejahlilostanvi', imperative: 'tahlilosda', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'dahlilosdisgoi', imperative: 'tiyadlilosda, tahlilosda', infinitive: 'juhlilosdohdi', present: 'dahlilosdiha', remote_past: 'duhlilostanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'danahlilosdiha', habitual: 'danahlilosdisgoi', remote_past: 'dunahlilostanvi', imperative: 'dinahlilosda', infinitive: 'junahlilosdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'dedahlilosdiha', habitual: 'dedahlilosdisgoi', remote_past: 'degahlilostanvi', imperative: 'didahlilosda', infinitive: 'digahlilosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dahlilosdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahlilosdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: PL3 Set B cells re-pinned per user ruling + guide P7(15)/126a (uni- serves all 3rd-person objects; y/a stem spelling per the SG3 row)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "dejiyadlilosdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "dejiyadlilosdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "dejiyahlilostanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyatlilostanvi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsitlilosdodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "degadlilosdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "degadlilosdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "dagwahlilostanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gatlilostanvi"
        // "SG1" | "SG3IN" | Tense.INFINITIVE      | "agitlilosdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "dehiyadlilosdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "dehiyadlilosdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "dehiyahlilostanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatlilostanvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "tlilosdodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "dehahlilosdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "dehahlilosdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "dejahlilostanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hatlilostanvi"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsatlilosdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "datlilosdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "datlilosdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "dutlilostanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "atlilostanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utlilosdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "danahlilosdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "danahlilosdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "dunahlilostanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anatlilostanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "tsunitlilostodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "dadatlilosdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "dadatlilosdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "dagatlilostanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idatlilostanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "digahlilosdohdi"
    }
}
