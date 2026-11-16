// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73862) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73862 (entrya ukvhada) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UkvhadaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Foggy (It is)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agigvhada'],
            [subject: 'SG3', object: '', habitual: 'ugvhadoi', imperative: 'tsagvhadesdi', infinitive: '----', present: 'ugvhada', remote_past: 'ugvhadvi']
        ]
    ]

    @Unroll
    def "conjugating Ukvhada (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ukvhada", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ugvhada"
        "SG3" | "" | Tense.HABITUAL        | "ugvhadoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugvhadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugvhadvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
