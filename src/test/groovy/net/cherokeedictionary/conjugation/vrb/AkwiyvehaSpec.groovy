// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72484 (entrya akwiyveha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkwiyvehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Paying (Him)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyagwiyveha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyagwiyveha', habitual: 'jiyagwiyvehoi', remote_past: 'jiyagwiyvelvi', imperative: 'jiyagwiyvsi', infinitive: 'jiyagwiyvehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyagwiyveha', habitual: 'hiyagwiyvehoi', remote_past: 'hiyakwiyvelvi', imperative: 'hiyagwiyvsi', infinitive: 'hiyakwiyvehdi'],
            [subject: 'SG3', object: '', habitual: 'akwiyvehoi', imperative: 'hiyagwiyvsi', infinitive: 'ukwiyvehdi', present: 'akwiyveha', remote_past: 'ukwiyvelvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anakwiyveha', habitual: 'anakwiyvehoi', remote_past: 'unakwiyvelvi', imperative: 'anakwiyvsi', infinitive: 'unakwiyvehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edakwiyveha', habitual: 'edakwiyvehoi', remote_past: 'edakwiyvelvi', imperative: 'edakwiyvsi', infinitive: 'egakwiyvehdi']
        ]
    ]

    @Unroll
    def "conjugating Akwiyveha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akwiyveha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyagwiyveha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyagwiyvehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyagwiyvelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyaquiyvelvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyagwiyvehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagwiyveha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagwiyvehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakwiyvelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyaquiyvelvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakwiyvehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agaquiyveha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "aquiyvehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwaquiyvelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aquiyvelvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwaquiyvedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anakwiyveha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anakwiyvehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unakwiyvelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anaquiyvelvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unakwiyvehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edakwiyveha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edakwiyvehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edakwiyvelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edaquiyvelvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "egakwiyvehdi"
    }
}
