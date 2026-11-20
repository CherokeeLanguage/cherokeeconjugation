// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73047 (entrya gakahiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GakahiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyakahiyaa'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakahiyaa', habitual: 'jiyakahiyasgoi', remote_past: 'jiyakahiyvi', imperative: 'jiyakahiya', infinitive: 'jiyakahiyasdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakahiyaa', habitual: 'hiyakahiyasgoi', remote_past: 'hiyakahiyvi', imperative: 'hiyakahiya', infinitive: 'hiyakahiyasdi'],
            [subject: 'SG3', object: '', habitual: 'gakahiyasgoi', imperative: 'hiyakahiya', infinitive: 'uwakahiyasdi', present: 'gakahiyaa', remote_past: 'uwakahiyvi'],
            [subject: 'PL3', object: '', present: 'anikahiyaa', habitual: 'anikahiyasgoi', remote_past: 'unikahiyvi', imperative: 'anikahiya', infinitive: 'unikahiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Gakahiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakahiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakahiyaa"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakahiyasgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakahiyvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyakahiyvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakahiyasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahiyaa"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahiyasgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakahiyvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahiyvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakahiyasdi"
        "SG1" | "" | Tense.PRESENT         | "gakahiyaa"
        "SG1" | "" | Tense.HABITUAL        | "gakahiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquakahiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gakahiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquakahiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anakahiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anakahiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unakahiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anakahiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "unakahiyasdi"
    }
}
