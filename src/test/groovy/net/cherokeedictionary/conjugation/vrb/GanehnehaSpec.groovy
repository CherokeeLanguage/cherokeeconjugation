// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73111 (entrya ganehneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jineneha'],
            [subject: 'SG1', object: '', present: 'jineneha', habitual: 'jinenehoi', remote_past: 'jinehnelvi', imperative: 'jinevsi', infinitive: 'jinehnehdi'],
            [subject: 'SG2', object: '', present: 'hinehneha', habitual: 'hinehnehoi', remote_past: 'hinehnelvi', imperative: 'hinehvsi', infinitive: 'hinehnehdi'],
            [subject: 'SG3', object: '', habitual: 'ganehnehoi', imperative: 'hinevsi', infinitive: 'unehnedi', present: 'ganehneha', remote_past: 'unehnelvi'],
            [subject: 'PL3', object: '', present: 'aninehneha', habitual: 'aninehnehoi', remote_past: 'uninehnelvi', imperative: 'aninehvsi', infinitive: 'unehnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineneha"
        "SG1" | "" | Tense.HABITUAL        | "jinenehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinehnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinenelvi"
        "SG1" | "" | Tense.INFINITIVE      | "jinehnehdi"
        "SG2" | "" | Tense.PRESENT         | "hinehneha"
        "SG2" | "" | Tense.HABITUAL        | "hinehnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinehnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinenelvi"
        "SG2" | "" | Tense.INFINITIVE      | "hinehnehdi"
        "SG1" | "" | Tense.PRESENT         | "jineneha"
        "SG1" | "" | Tense.HABITUAL        | "jinenehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinehnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinenelvi"
        "SG1" | "" | Tense.INFINITIVE      | "jinehnehdi"
        "PL3" | "" | Tense.PRESENT         | "aninehneha"
        "PL3" | "" | Tense.HABITUAL        | "aninehnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninenelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unehnehdi"
    }
}
