// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73827 (entrya uhyoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agihyoha'],
            [subject: 'SG1', object: '', present: 'agihyoha', habitual: 'agihyohoi', remote_past: 'agihyalvi', imperative: 'agiyhga', infinitive: 'agiysdi'],
            [subject: 'SG2', object: '', present: 'jahyhoha', habitual: 'jahyohoi', remote_past: 'jahyalvi', imperative: 'jayhga', infinitive: 'jaysdi'],
            [subject: 'SG3', object: '', habitual: 'uhyohoi', imperative: 'jayhga', infinitive: 'uysdi', present: 'uhyoha', remote_past: 'uhyalvi'],
            [subject: 'PL3', object: '', present: 'unihyoha', habitual: 'unihyohoi', remote_past: 'unihyalvi', imperative: 'uniyhga', infinitive: 'uniysdi'],
            [subject: 'PL1INCL', object: '', present: 'igihyoha', habitual: 'igihyohoi', remote_past: 'igihyalvi', imperative: 'igiyhga', infinitive: 'igiysdi']
        ]
    ]

    @Unroll
    def "conjugating Uhyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiyoha"
        "SG1" | "" | Tense.HABITUAL        | "agiyohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyalvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyalvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiysdi"
        "SG2" | "" | Tense.PRESENT         | "tsayoha"
        "SG2" | "" | Tense.HABITUAL        | "tsayohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayalvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayalvi"
        "SG2" | "" | Tense.INFINITIVE      | "jaysdi"
        "SG3" | "" | Tense.PRESENT         | "uyoha"
        "SG3" | "" | Tense.HABITUAL        | "uyohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyalvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyalvi"
        "SG3" | "" | Tense.INFINITIVE      | "uysdi"
        "PL3" | "" | Tense.PRESENT         | "uniyoha"
        "PL3" | "" | Tense.HABITUAL        | "uniyohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyalvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyalvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiyoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiyohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyalvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyalvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiysdi"
    }
}
