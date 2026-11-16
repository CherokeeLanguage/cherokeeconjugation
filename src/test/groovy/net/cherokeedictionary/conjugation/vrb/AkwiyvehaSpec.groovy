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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyaquiyveha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyaquiyvehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyaquiyvelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyaquiyvelvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyaquiyvedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyaquiyveha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyaquiyvehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "aquiyvelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyaquiyvelvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "aquiyvedi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agaquiyveha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "aquiyvehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwaquiyvelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aquiyvelvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwaquiyvedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anaquiyveha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anaquiyvehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "anaquiyvelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anaquiyvelvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "anaquiyvedi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edaquiyveha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edaquiyvehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "aquiyvelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edaquiyvelvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "aquiyvedi"
    }
}
