// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73265 (entrya goseha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GosehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Saying to Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyoseha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoseha', habitual: 'jiyosehoi', remote_past: 'jiyoselvi', imperative: 'jiyosi', infinitive: 'jiyosehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyoseha', habitual: 'hiyosehoi', remote_past: 'hiyoselvi', imperative: 'hiyosi', infinitive: 'hiyosehdi'],
            [subject: 'SG3', object: '', habitual: 'gosehoi', imperative: 'hiyosi', infinitive: 'uwosehdi', present: 'goseha', remote_past: 'uwoselvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anoseha', habitual: 'anosehoi', remote_past: 'unoselvi', imperative: 'anosi', infinitive: 'unosehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edoseha', habitual: 'edosehoi', remote_past: 'edoselvi', imperative: 'edosi', infinitive: 'edosehdi']
        ]
    ]

    @Unroll
    def "conjugating Goseha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Goseha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoseha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyosehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyoselvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyoselvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyosehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyoseha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyosehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyoselvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyoselvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyosehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "oseha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gosehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwoselvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "oselvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwosedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anoseha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anosehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unoselvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anoselvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unosehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edoseha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edosehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edoselvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edoselvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edosehdi"
    }
}
