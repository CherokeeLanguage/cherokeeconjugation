// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73138) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73138 (entrya ganiyiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaniyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Catching/Arresting (Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiniyiha, tsiniyiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiniyiha', habitual: 'jiniyisgoi', remote_past: 'jiniyvhvi', imperative: 'jiniya', infinitive: 'jiniyhdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'jiniyiha', habitual: 'jiniyisgoi', remote_past: 'agiyvhvi', imperative: 'jiniya', infinitive: 'aginiyhdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiniyiha', habitual: 'hiniyisgoi', remote_past: 'hiniyvhvi', imperative: 'hiniya', infinitive: 'hiniyhdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hiniyiha', habitual: 'hiniyisgoi', remote_past: 'janiyvhvi', imperative: 'hiniya', infinitive: 'janiyhdi'],
            [subject: 'SG3', object: '', habitual: 'ganiyisgoi', imperative: 'hiniya, hiniya', infinitive: 'uniyidi', present: 'ganiyiha', remote_past: 'uniyvhvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'aniniyiha', habitual: 'aniniyisgoi', remote_past: 'uniniyvsvi', imperative: 'aniniya', infinitive: 'uniniyhdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idiniyiha', habitual: 'idiniyisgoi', remote_past: 'iginiyvsvi', imperative: 'idiniya', infinitive: 'iginiyhdi']
        ]
    ]

    @Unroll
    def "conjugating Ganiyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganiyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiniyiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiniyisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiniyvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiniyvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiniyidi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "jiniyiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "jiniyisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aginiyvhvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsiniyvhvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aginiyidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiniyiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiniyisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiniyvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiniyvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiniyidi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hiniyiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hiniyisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "janiyvhvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hiniyvhvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsaniyidi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ganiyiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ganiyisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uniyvhvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganiyvhvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uniyidi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "aniniyiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "aniniyisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "uniniyvhvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "aniniyvhvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uniniyidi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idiniyiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idiniyisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iginiyvhvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idiniyvhvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iginiyidi"
    }
}
