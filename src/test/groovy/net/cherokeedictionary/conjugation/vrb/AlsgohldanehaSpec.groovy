// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72528 (entrya alsgohldaneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgohldanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Permitting Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyalisgohldaneha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalisgohldaneha', habitual: 'jiyalisgohldanehoi', remote_past: 'jiyalisgohldanelvi', imperative: 'jiyalisgohldasi', infinitive: 'jiyalisgohldanehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalisgohldaneha', habitual: 'hiyalisgohldanehoi', remote_past: 'hiyalisgohldanelvi', imperative: 'hiyalisgohldasi', infinitive: 'hiyalisgohldanehdi'],
            [subject: 'SG3', object: '', habitual: 'alsgohldanehoi', imperative: 'hiyalisgohldasi', infinitive: 'ulsgohldanehdi', present: 'alsgohldaneha', remote_past: 'ulsgohldanelvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'analsgohldaneha', habitual: 'analsgohldanehoi', remote_past: 'unalsgohldanelvi', imperative: 'analsgohldasi', infinitive: 'unalsgohldanehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edalsgohldaneha', habitual: 'edalsgohldanehoi', remote_past: 'edgalsgohldanelvi', imperative: 'edalsgohldasi', infinitive: 'edalsgohldanehdi']
        ]
    ]

    @Unroll
    def "conjugating Alsgohldaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgohldaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyalisgolodaneha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyalisgolodanehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyalisgolodanelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalisgolodanelvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyalisgolodanedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalisgolodaneha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalisgolodanehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "alisgolodanelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalisgolodanelvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "alisgolodanedi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agalisgolodaneha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "alisgolodanehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwalisgolodanelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "alisgolodanelvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwalisgolodanedi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "analisgolodaneha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "analisgolodanehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "analisgolodanelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "analisgolodanelvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "analisgolodanedi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edalisgolodaneha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edalisgolodanehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "alisgolodanelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edalisgolodanelvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "alisgolodanedi"
    }
}
