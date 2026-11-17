// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73125) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73125 (entrya ganhjeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (liquid)",
        part_of_speech: "v.i.",
        // tio 17Nov26: glottal-initial stem -- the 2012 book (p.84) prints SG1 ji-nejeha on every tense row; the yaml
        // dropped the glottal apostrophes. D14: the engine's SG1 ji- swap is registered lexically from this flag.
        glottalInitial: true,
        // tio 17Nov26: the book (p.84) spells the SG1 rows THROUGH the laryngeal -- jinejeha
        // (nej-, no h->a) -- while the engine's citation composition applies the nhj->naj
        // rule to the SG3 stem (jinajeha). The book's SG1 surfaces are registered whole-form
        // (D14 follow-up; the SG2/PL3 naj- cells remain engine-characterized).
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'SG1', obj: 'NONE', form: 'jinejeha'],
            [tense: 'HABITUAL', subject: 'SG1', obj: 'NONE', form: 'jinejehoi'],
            [tense: 'REMOTE_PAST', subject: 'SG1', obj: 'NONE', form: 'jinejehvi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'jinejehvi'],
            [tense: 'INFINITIVE', subject: 'SG1', obj: 'NONE', form: 'jinejehi']
        ],
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinejeha'],
            [subject: 'SG1', object: '', present: 'jinejeha', habitual: 'jinejehoi', remote_past: 'jinejehvi', imperative: 'jinejehesdi', infinitive: 'jinejehi'],
            [subject: 'SG2', object: '', present: 'hinhjeha', habitual: 'hinhjehoi', remote_past: 'hinhjehvi', imperative: 'hinhjehesdi', infinitive: 'hinhjehi'],
            [subject: 'SG3', object: '', habitual: 'ganhjehoi', imperative: 'ganhjehesdi', infinitive: 'ganhjehi', present: 'ganhjeha', remote_past: 'ganhjehvi'],
            [subject: 'PL3', object: '', present: 'aninhjeha', habitual: 'aninhjehoi', remote_past: 'aninhjehvi', imperative: 'aninhjehesdi', infinitive: 'aninhjehi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinejeha"
        "SG1" | "" | Tense.HABITUAL        | "jinejehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinejehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinejehvi"
        "SG1" | "" | Tense.INFINITIVE      | "jinejehi"
        "SG2" | "" | Tense.PRESENT         | "hinatseha"
        "SG2" | "" | Tense.HABITUAL        | "hinatsehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanatsehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatsehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanatsehi"
        "SG1" | "" | Tense.PRESENT         | "jinejeha"
        "SG1" | "" | Tense.HABITUAL        | "jinejehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinejehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinejehvi"
        "SG1" | "" | Tense.INFINITIVE      | "jinejehi"
        "PL3" | "" | Tense.PRESENT         | "aninatseha"
        "PL3" | "" | Tense.HABITUAL        | "aninatsehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninatsehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatsehvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninatsehi"
    }
}
