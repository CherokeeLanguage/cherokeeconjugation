// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73048 (entrya gakaneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GakanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (living)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyakaneha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakaneha', habitual: 'jiyakanehoi', remote_past: 'jiyakanelvi', imperative: 'jiyakasi', infinitive: 'jiyakanehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakaneha', habitual: 'hiyakanehoi', remote_past: 'hiyakanelvi', imperative: 'hiyakasi', infinitive: 'hiyakanehdi'],
            [subject: 'SG3', object: '', habitual: 'gakanehoi', imperative: 'hiyakasi', infinitive: 'uwakanehdi', present: 'gakaneha', remote_past: 'uwakanelvi'],
            [subject: 'PL3', object: '', present: 'anikaneha', habitual: 'anikanehoi', remote_past: 'unikanelvi', imperative: 'wanikasi', infinitive: 'unikanehdi']
        ]
    ]

    @Unroll
    def "conjugating Gakaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gakaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyakaneha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyakanehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyakanelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyakanelvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyakanedi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakaneha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakanehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "akanelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakanelvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "akanedi"
        "SG1" | "" | Tense.PRESENT         | "gakaneha"
        "SG1" | "" | Tense.HABITUAL        | "gakanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquakanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gakanelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquakanedi"
        "PL3" | "" | Tense.PRESENT         | "anakaneha"
        "PL3" | "" | Tense.HABITUAL        | "anakanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unakanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anakanelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unakanedi"
    }
}
