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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakahiyaa', habitual: 'jiyakahiyasgoi', remote_past: 'jiyakahiyvi', imperative: 'jiyakhiya', infinitive: 'jiyakahiyasdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakahiyaa', habitual: 'hiyakahiyasgoi', remote_past: 'hiyakahiyvi', imperative: 'hiyakahiya', infinitive: 'hiyakahiyasdi'],
            [subject: 'SG3', object: '', habitual: 'gakahiyasgoi', imperative: 'hiyakahiya', infinitive: 'uwakahiyasdi', present: 'gakahiyaa', remote_past: 'uwakahiyvi'],
            [subject: 'PL3', object: '', present: 'anikahiyaa', habitual: 'anikahiyasgoi', remote_past: 'unikahiyvi', imperative: 'anikahiya', infinitive: 'unikahiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Gakahiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakahiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyakahiyaa"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyakahiyasgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyakahiyvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyakahiyvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyakahiyasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakahiyaa"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakahiyasgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "akahiyvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakahiyvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "akahiyasdi"
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
