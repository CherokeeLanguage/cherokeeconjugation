// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73130 (entrya ganidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinidoha'],
            [subject: 'SG1', object: '', present: 'jinidoha', habitual: 'jinidohoi', remote_past: 'aginidolvi', imperative: 'jinida', infinitive: 'aginidasdi'],
            [subject: 'SG2', object: '', present: 'hinidoha', habitual: 'hinidohoi', remote_past: 'janidolvi', imperative: 'hinida', infinitive: 'janidasdi'],
            [subject: 'SG3', object: '', habitual: 'ganidohoi', imperative: 'hinada', infinitive: 'uwanidasdi', present: 'ganidoha', remote_past: 'uwanidolvi'],
            [subject: 'PL3', object: '', present: 'aninidoha', habitual: 'aninidohoi', remote_past: 'uninidolvi', imperative: 'aninida', infinitive: 'uninidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawanidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwanidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawanidasdi"
        "SG1" | "" | Tense.PRESENT         | "tsinidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwanidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwanidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwanidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwanidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwanidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwanidasdi"
    }
}
