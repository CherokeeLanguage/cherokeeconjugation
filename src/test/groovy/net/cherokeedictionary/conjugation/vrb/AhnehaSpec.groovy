// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72378 (entrya ahneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jineha'],
            [subject: 'SG1', object: '', present: 'jineha', habitual: 'jinehoi', remote_past: 'jinelvi', imperative: 'jihvsi', infinitive: 'jinehdi'],
            [subject: 'SG2', object: '', present: 'hihneha', habitual: 'hihnehoi', remote_past: 'hihnelvi', imperative: 'hihvsi', infinitive: 'hihnehdi'],
            [subject: 'SG3', object: '', habitual: 'ahnehoi', imperative: 'hivsi', infinitive: 'uhnehdi', present: 'ahneha', remote_past: 'uhnelvi'],
            [subject: 'PL3', object: '', present: 'anihneha', habitual: 'anihnehoi', remote_past: 'unihnelvi', imperative: 'anihvsi', infinitive: 'unihnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsineha"
        "SG1" | "" | Tense.HABITUAL        | "tsinehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginedi"
        "SG2" | "" | Tense.PRESENT         | "hineha"
        "SG2" | "" | Tense.HABITUAL        | "hinehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanedi"
        "SG3" | "" | Tense.PRESENT         | "aneha"
        "SG3" | "" | Tense.HABITUAL        | "anehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelvi"
        "SG3" | "" | Tense.INFINITIVE      | "unedi"
        "PL3" | "" | Tense.PRESENT         | "anineha"
        "PL3" | "" | Tense.HABITUAL        | "aninehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninelvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninedi"
    }
}
