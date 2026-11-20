// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73034 (entrya gahnega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinega'],
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'akinvsvi', imperative: 'wijinvga', infinitive: 'akihnvsdi'],
            [subject: 'SG2', object: '', present: 'hihnega', habitual: 'hihnegoi', remote_past: 'chanvsvi', imperative: 'hwihnvga', infinitive: 'jahnvsdi'],
            [subject: 'SG3', object: '', habitual: 'gahnegoi', imperative: 'hihnuga', infinitive: 'uhnvsdi', present: 'gahnega', remote_past: 'uhnvsvi'],
            [subject: 'PL3', object: '', present: 'anihnega', habitual: 'anihnegoi', remote_past: 'unahnvsvi', imperative: 'wanihnvga', infinitive: 'unihnvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "akihnvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihnega"
        "SG2" | "" | Tense.HABITUAL        | "hihnegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "chanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnvsdi"
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "akihnvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihnega"
        "PL3" | "" | Tense.HABITUAL        | "anihnegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnvsdi"
    }
}
