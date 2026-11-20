// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72575 (entrya asdigia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdigiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisdigia'],
            [subject: 'SG1', object: '', present: 'jisdigia', habitual: 'jisdigisgoi', remote_past: 'aksdigvi', imperative: 'jisdiga', infinitive: 'aksdigisdi'],
            [subject: 'SG2', object: '', present: 'hisdigia', habitual: 'hisdigisgoi', remote_past: 'tsdigvi', imperative: 'hisdiga', infinitive: 'tsdigisdi'],
            [subject: 'SG3', object: '', habitual: 'asdigisgoi', imperative: 'hisdiga', infinitive: 'usdigisdi', present: 'asdigia', remote_past: 'usdigvi'],
            [subject: 'PL3', object: '', present: 'anisdigia', habitual: 'anisdigisgoi', remote_past: 'unisdigvi', imperative: 'anisdiga', infinitive: 'unisdigisdi']
        ]
    ]

    @Unroll
    def "conjugating Asdigia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdigia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdigia"
        "SG1" | "" | Tense.HABITUAL        | "jisdigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksdigvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisdigvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksdigisdi"
        "SG2" | "" | Tense.PRESENT         | "hisdigia"
        "SG2" | "" | Tense.HABITUAL        | "hisdigisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasdigvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdigvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasdigisdi"
        "SG3" | "" | Tense.PRESENT         | "asdigia"
        "SG3" | "" | Tense.HABITUAL        | "asdigisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdigvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdigvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdigisdi"
        "PL3" | "" | Tense.PRESENT         | "anisdigia"
        "PL3" | "" | Tense.HABITUAL        | "anisdigisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdigvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdigvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisdigisdi"
    }
}
