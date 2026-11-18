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
        // tio 18Nov26: IMMEDIATE_COMMAND wired via whole-form surfaceOverrides --
        // the Anidona'a box (VRB p.56 group) ATTESTS the imperative column for its
        // four congregation rows (ojidona'esdi / ijidona'esdi / ididona'esdi /
        // anidona'esdi) but has NO SG3 row at all, so there is no SG3 imperative
        // stem to compose from -- the rows are registered as book-final surfaces
        // (D14/D15 override pattern). CED carries ----- in the imperative column
        // (no anchor). VRB pp.18 footnote: /Danidoga/ if only two are standing,
        // /anidona/ if three or more -- this lexeme is the 3+ alternant.
        surfaceOverrides: [
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'ojidonaesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG2', obj: 'NONE', form: 'ijidonaesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL1INCL', obj: 'NONE', form: 'ididonaesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL3', obj: 'NONE', form: 'anidonaesdi']
        ],
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
        // tio 18Nov26: IMMEDIATE_COMMAND attested for the four congregation rows
        // (Anidona'a box, p.56); no SG3 row exists in the box.
        "SG1" | "" | Tense.IMMEDIATE_COMMAND | "ojidonaesdi"
        "SG2" | "" | Tense.IMMEDIATE_COMMAND | "ijidonaesdi"
        "PL1INCL" | "" | Tense.IMMEDIATE_COMMAND | "ididonaesdi"
        "PL3" | "" | Tense.IMMEDIATE_COMMAND | "anidonaesdi"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book prints Anidonaa only inside the Gadoga (Standing) box p.56; no infinitive column. yaml junk dropped.
    }
}
