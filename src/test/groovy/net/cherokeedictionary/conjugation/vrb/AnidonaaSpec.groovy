// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72556) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72556 (entrya anidonaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnidonaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Standing, They Are (Congregation)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'otsidonaa'],
            [subject: 'SG3', object: '', habitual: 'anidonaoi', imperative: '', infinitive: '', present: 'anidonaa', remote_past: 'anidonavi']
        ]
    ]

    @Unroll
    def "conjugating Anidonaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anidonaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "anidonaa"
        "SG3" | "" | Tense.HABITUAL        | "anidonaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unidonavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anidonavi"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book prints Anidonaa only inside the Gadoga (Standing) box p.56; no infinitive column. yaml junk dropped.
    }
}
