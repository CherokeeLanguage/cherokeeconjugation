// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73036 (entrya gahnidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinidoha'],
            [subject: 'SG1', object: '', present: 'jinidoha', habitual: 'jinidohoi', remote_past: 'akinidolvi', imperative: 'jinida', infinitive: 'akinidasdi'],
            [subject: 'SG2', object: '', present: 'hihnidoha', habitual: 'hihnidohoi', remote_past: 'jahnidolvi', imperative: 'hihnida', infinitive: 'jahnidasdi'],
            [subject: 'SG3', object: '', habitual: 'gahnidohoi', imperative: 'hihnida', infinitive: 'uhnidasdi', present: 'gahnidoha', remote_past: 'uhnidolvi'],
            [subject: 'PL3', object: '', present: 'anihnidoha', habitual: 'anihnidohoi', remote_past: 'unihnidolvi', imperative: 'anihnida', infinitive: 'unihnidasdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanidasdi"
        "SG1" | "" | Tense.PRESENT         | "tsinidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninidasdi"
    }
}
