// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73109) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73109 (entrya ganeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (long)",
        part_of_speech: "v.i.",
        // tio 17Nov26: glottal-initial stem -- the 2012 book (p.84) prints SG1 ji-ne'a on every tense row; the yaml
        // dropped the glottal apostrophes. D14: the engine's SG1 ji- swap is registered lexically from this flag.
        glottalInitial: true,
        // tio 17Nov26: the book (p.84) drops the stem's h after the ji- allomorph on the
        // LONG verb only (jine'o'i / jine'v'i / jine'i; flexible/liquid keep ji'neho'i /
        // jinejeho'i) -- a lexeme-level laryngeal variance no prefix rule expresses, so the
        // SG1 cells are registered as whole-form surfaces (D14 follow-up).
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'SG1', obj: 'NONE', form: 'jinea'],
            [tense: 'HABITUAL', subject: 'SG1', obj: 'NONE', form: 'jineoi'],
            [tense: 'REMOTE_PAST', subject: 'SG1', obj: 'NONE', form: 'jinevi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'jinevi'],
            [tense: 'INFINITIVE', subject: 'SG1', obj: 'NONE', form: 'jinei']
        ],
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinea'],
            [subject: 'SG1', object: '', present: 'jinea', habitual: 'jineoi', remote_past: 'jinevi', imperative: 'jineesdi', infinitive: 'jinei'],
            [subject: 'SG2', object: '', present: 'hineha', habitual: 'hinehoi', remote_past: 'hinehvi', imperative: 'hinehesdi', infinitive: 'hinehi'],
            [subject: 'SG3', object: '', habitual: 'ganehoi', imperative: 'ganehesdi', infinitive: 'ganehi', present: 'ganeha', remote_past: 'ganehvi'],
            [subject: 'PL3', object: '', present: 'anineha', habitual: 'aninehoi', remote_past: 'aninehvi', imperative: 'aninehesdi', infinitive: 'aninehi']
        ]
    ]

    @Unroll
    def "conjugating Ganeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinea"
        "SG1" | "" | Tense.HABITUAL        | "jineoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinevi"
        "SG1" | "" | Tense.INFINITIVE      | "jinei"
        "SG2" | "" | Tense.PRESENT         | "hineha"
        "SG2" | "" | Tense.HABITUAL        | "hinehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanehi"
        "SG1" | "" | Tense.PRESENT         | "jinea"
        "SG1" | "" | Tense.HABITUAL        | "jineoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinevi"
        "SG1" | "" | Tense.INFINITIVE      | "jinei"
        "PL3" | "" | Tense.PRESENT         | "anineha"
        "PL3" | "" | Tense.HABITUAL        | "aninehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninehi"
    }
}
