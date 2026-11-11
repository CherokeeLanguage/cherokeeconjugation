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
            [subject: 'SG1', object: 'SG3AN', present: 'dejiyadlilosdiha', habitual: 'dejiyadlilosdisgoi', remote_past: 'dejiyahlilostanvi', imperative: 'dijiyadlilosda', infinitive: ''],
            [subject: 'SG1', object: 'SG3IN', present: 'degadlilosdiha', habitual: 'degadlilosdisgoi', remote_past: 'dagwahlilostanvi', imperative: 'digadlilosda', infinitive: ''],
            [subject: 'SG2', object: 'SG3AN', present: 'dehiyadlilosdiha', habitual: 'dehiyadlilosdisgoi', remote_past: 'dehiyahlilostanvi', imperative: 'tiyadlilosda', infinitive: ''],
            [subject: 'SG2', object: 'SG3IN', present: 'dehahlilosdiha', habitual: 'dehahlilosdisgoi', remote_past: 'dejahlilostanvi', imperative: 'tahlilosda', infinitive: ''],
            [subject: 'SG3', object: 'SG3IN', present: 'dahlilosdiha', habitual: 'dahlilosdisgoi', remote_past: 'duhlilostanvi', imperative: 'dihlilosda', infinitive: 'juhlilosdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'danahlilosdiha', habitual: 'danahlilosdisgoi', remote_past: 'dunahlilostanvi', imperative: 'dinahlilosda', infinitive: 'junahlilosdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'dedahlilosdiha', habitual: 'dedahlilosdisgoi', remote_past: 'degahlilostanvi', imperative: 'didahlilosda', infinitive: 'digahlilosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dahlilosdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahlilosdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "dejiyadlilosdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "dejiyadlilosdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "dejiyahlilostanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "dijiyadlilosda"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "X"
        "SG1" | "SG3IN" | Tense.PRESENT         | "degadlilosdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "degadlilosdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "dagwahlilostanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "digadlilosda"
        // "SG1" | "SG3IN" | Tense.INFINITIVE      | "X"
        "SG2" | "SG3AN" | Tense.PRESENT         | "dehiyadlilosdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "dehiyadlilosdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "dehiyahlilostanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "tiyadlilosda"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "X"
        "SG2" | "SG3IN" | Tense.PRESENT         | "dehahlilosdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "dehahlilosdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "dejahlilostanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tahlilosda"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "X"
        "SG3" | "SG3IN" | Tense.PRESENT         | "dahlilosdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "dahlilosdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "duhlilostanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "dihlilosda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "juhlilosdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "danahlilosdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "danahlilosdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "dunahlilostanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "dinahlilosda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "junahlilosdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "dedahlilosdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "dedahlilosdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "degahlilostanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "didahlilosda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "digahlilosdohdi"
    }
}
