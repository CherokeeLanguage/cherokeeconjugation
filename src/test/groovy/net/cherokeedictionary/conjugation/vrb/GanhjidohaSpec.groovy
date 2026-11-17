// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73126 (entrya ganhjidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvjidoha'],
            [subject: 'SG1', object: '', present: 'jinvjidoha', habitual: 'jinvjidohoi', remote_past: 'aginhjidolvi', imperative: 'jinvjida', infinitive: 'aginhjidasdi'],
            [subject: 'SG2', object: '', present: 'hinhjidoha', habitual: 'hinhjidohoi', remote_past: 'janhjidolvi', imperative: 'hinhjida', infinitive: 'janhjidasdi'],
            [subject: 'SG3', object: '', habitual: 'ganhjidohoi', imperative: 'hinhjida', infinitive: 'unhjidasdi', present: 'ganhjidoha', remote_past: 'unhjidolvi'],
            [subject: 'PL3', object: '', present: 'aninhjidoha', habitual: 'aninhjidohoi', remote_past: 'uninhjidolvi', imperative: 'aninhjida', infinitive: 'uninhjidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinatsidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatsidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatsidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinatsidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinatsidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanatsidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatsidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanatsidasdi"
        "SG1" | "" | Tense.PRESENT         | "tsinatsidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatsidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatsidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninatsidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninatsidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninatsidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatsidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninatsidasdi"
    }
}
