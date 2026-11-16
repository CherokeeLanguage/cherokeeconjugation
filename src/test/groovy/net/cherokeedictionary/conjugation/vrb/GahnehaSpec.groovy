// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73035) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73035 (entrya gahneha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsineha, tsineha'],
            [subject: 'SG1', object: '', present: 'jineha', habitual: 'jinehoi', remote_past: 'jinehvi', imperative: 'jinehesdi', infinitive: 'jinehi'],
            [subject: 'SG2', object: '', present: 'hihneha', habitual: 'hihnehoi', remote_past: 'hihnehvi', imperative: 'hihnehesdi', infinitive: 'hihnehi'],
            [subject: 'SG3', object: '', habitual: 'ganehoi', imperative: 'hinehesdi', infinitive: '', present: 'ganeha', remote_past: ''],
            [subject: 'PL3', object: '', present: 'anihneha', habitual: 'anihnehoi', remote_past: 'anihnehvi', imperative: 'anihnehesdi', infinitive: 'anihnehi']
        ]
    ]

    @Unroll
    def "conjugating Gahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsineha"
        "SG1" | "" | Tense.HABITUAL        | "tsinehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsine"
        "SG1" | "" | Tense.INFINITIVE      | "aginehi"
        "SG2" | "" | Tense.PRESENT         | "hineha"
        "SG2" | "" | Tense.HABITUAL        | "hinehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hine"
        "SG2" | "" | Tense.INFINITIVE      | "tsanehi"
        "SG1" | "" | Tense.PRESENT         | "tsineha"
        "SG1" | "" | Tense.HABITUAL        | "tsinehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsine"
        "SG1" | "" | Tense.INFINITIVE      | "aginehi"
        "PL3" | "" | Tense.PRESENT         | "anineha"
        "PL3" | "" | Tense.HABITUAL        | "aninehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anine"
        "PL3" | "" | Tense.INFINITIVE      | "uninehi"
    }
}
