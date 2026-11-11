package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanehldihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Playing (with Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'dejiyanehldiha', habitual: 'dejiyanehldisgoi', remote_past: 'dejiyanehltanvi', imperative: 'dijiyanehlda', infinitive: 'dijiyanehldohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'deganehldiha', habitual: 'deganehldisgoi', remote_past: 'dagwanehltanvi', imperative: 'diganehlda', infinitive: 'digwanehldohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'dehiyanehldiha', habitual: 'dehiyanehldisgoi', remote_past: 'dehiyanehltanvi', imperative: 'tiyanehlda', infinitive: 'tiyanehldohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'dehanehldiha', habitual: 'dehanehldisgoi', remote_past: 'dejanehltanvi', imperative: 'tanehlda', infinitive: 'dijanehldohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'danehldiha', habitual: 'danehldisgoi', remote_past: 'dunehltanvi', imperative: 'dinehlda', infinitive: 'junehldohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'dananehldiha', habitual: 'dananehldisgoi', remote_past: 'dunanehltanvi', imperative: 'dinanehlda', infinitive: 'junanehldohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'dedanehldiha', habitual: 'dedanehldisgoi', remote_past: 'deganehltanvi', imperative: 'didanehlda', infinitive: 'diganehldohdi']
        ]
    ]

    @Unroll
    def "conjugating Danehldiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danehldiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "dejiyanehldiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "dejiyanehldisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "dejiyanehltanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "dijiyanehlda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "dijiyanehldohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "deganehldiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "deganehldisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "dagwanehltanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "diganehlda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "digwanehldohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "dehiyanehldiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "dehiyanehldisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "dehiyanehltanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "tiyanehlda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "tiyanehldohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "dehanehldiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "dehanehldisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "dejanehltanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tanehlda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "dijanehldohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "danehldiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "danehldisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "dunehltanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "dinehlda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "junehldohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "dananehldiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "dananehldisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "dunanehltanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "dinanehlda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "junanehldohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "dedanehldiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "dedanehldisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "deganehltanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "didanehlda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "diganehldohdi"
    }
}
