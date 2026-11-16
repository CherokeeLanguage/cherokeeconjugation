// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73794) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73794 (entrya uha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agiha'],
            [subject: 'SG1', object: '', present: 'agiha', habitual: 'agihoi', remote_past: 'agihvi', imperative: 'agihesdi', infinitive: 'agihdi'],
            [subject: 'SG2', object: '', present: 'jaha', habitual: 'jahoi', remote_past: 'jahvi', imperative: 'jahesdi', infinitive: 'jahdi'],
            [subject: 'SG3', object: '', habitual: 'uhoi', imperative: 'tsahesdi', infinitive: '', present: 'uha', remote_past: 'uhvi'],
            [subject: 'PL3', object: '', present: 'uniha', habitual: 'unihoi', remote_past: 'unihvi', imperative: 'unihesdi', infinitive: 'unihdi']
        ]
    ]

    @Unroll
    def "conjugating Uha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiha"
        "SG1" | "" | Tense.HABITUAL        | "agihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agihvi"
        "SG1" | "" | Tense.INFINITIVE      | "agidi"
        "SG2" | "" | Tense.PRESENT         | "tsaha"
        "SG2" | "" | Tense.HABITUAL        | "tsahoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsahvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadi"
        "SG3" | "" | Tense.PRESENT         | "uha"
        "SG3" | "" | Tense.HABITUAL        | "uhoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhvi"
        "SG3" | "" | Tense.INFINITIVE      | "udi"
        "PL3" | "" | Tense.PRESENT         | "uniha"
        "PL3" | "" | Tense.HABITUAL        | "unihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unihvi"
        "PL3" | "" | Tense.INFINITIVE      | "unidi"
    }
}
