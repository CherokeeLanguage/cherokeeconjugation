// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73061) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73061 (entrya galiga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaligaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Burning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'galigoi', imperative: '', infinitive: '', present: 'galiga', remote_past: 'ulitsvi']
        ]
    ]

    @Unroll
    def "conjugating Galiga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galiga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiliga"
        "SG1" | "" | Tense.HABITUAL        | "tsiligoi"
        // tio 17Nov26: the SG1 remote/future-command/infinitive rows are yaml fabrications (the 2012 book box, Galiga Burning p.75, has only the SG3 box); dropped.
        // "SG1" | "" | Tense.REMOTE_PAST     | "agilitsvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilitsvi"
        // "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
