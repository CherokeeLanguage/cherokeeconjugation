// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72265 (entrya adisiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdisiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jidisiyaa'],
            [subject: 'SG1', object: '', present: 'jidisiyaa', habitual: 'jidisiyasgoi', remote_past: 'akdisiyvi', imperative: 'jidisiya', infinitive: 'akdisiyasdi'],
            [subject: 'SG2', object: '', present: 'hidisiyaa', habitual: 'hidisiyasgoi', remote_past: 'tsdisiyvi', imperative: 'hidisiya', infinitive: 'tsdisiyasdi'],
            [subject: 'SG3', object: '', habitual: 'adisiyasgoi', imperative: 'hidisiya', infinitive: 'udisiyasdi', present: 'adisiyaa', remote_past: 'udisiyvi'],
            [subject: 'PL3', object: '', present: 'anidisiyaa', habitual: 'anidisaysgoi', remote_past: 'unidisiyvi', imperative: 'anidisiya', infinitive: 'unidisiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Adisiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adisiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidisiyaa"
        "SG1" | "" | Tense.HABITUAL        | "jidisiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdisiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidisiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "akdisiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hidisiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hidisiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdisiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidisiyvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdisiyasdi"
        "SG3" | "" | Tense.PRESENT         | "adisiyaa"
        "SG3" | "" | Tense.HABITUAL        | "adisiyasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udisiyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adisiyvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anidisiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anidisaysgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidisiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidisiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "unidisiyasdi"
    }
}
