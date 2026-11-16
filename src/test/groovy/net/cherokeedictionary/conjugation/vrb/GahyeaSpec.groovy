// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73039 (entrya gahyea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (flexible)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyayea, jiyea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyea', habitual: '/', remote_past: 'jiyayea', imperative: 'jiyesgoi', infinitive: '/'],
            [subject: 'SG2', object: '', present: 'hihyea', habitual: '/', remote_past: 'hiyayea', imperative: 'hihyesgoi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'gahyesgoi', imperative: 'hiyayaga, hihyaga', infinitive: 'uwahyesdi', present: 'gahyea', remote_past: 'uwahyavi'],
            [subject: 'PL3', object: '', present: 'anihyea', habitual: 'anihyesgoi', remote_past: 'unahyavi', imperative: 'anihyaga', infinitive: 'unahyesdi']
        ]
    ]

    @Unroll
    def "conjugating Gahyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyea"
        // "SG1" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiwayavi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiwayavi"
        // "SG1" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "" | Tense.PRESENT         | "hiyea"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawayavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwayavi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "tsiyea"
        "SG1" | "" | Tense.HABITUAL        | "tsiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwayavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwayavi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwayesdi"
        "PL3" | "" | Tense.PRESENT         | "aniyea"
        "PL3" | "" | Tense.HABITUAL        | "aniyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwayavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwayavi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwayesdi"
    }
}
