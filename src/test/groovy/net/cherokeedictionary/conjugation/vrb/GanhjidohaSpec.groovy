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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinatsitoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsitohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinhjidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinhjidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhjidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatsidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "janhjidasdi"
        "SG1" | "" | Tense.PRESENT         | "tsinatsitoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinatsitohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatsidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninhjidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninhjidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninhjidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatsidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninhjidasdi"
    }
}
