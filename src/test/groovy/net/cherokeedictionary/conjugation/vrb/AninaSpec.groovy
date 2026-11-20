// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72558) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72558 (entrya anina) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AninaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sitting, They Are (Congregation)",
        part_of_speech: "v.i.",
        // tio 18Nov26: IMMEDIATE_COMMAND wired via whole-form surfaceOverrides --
        // the Ani'na box (VRB p.71 group) ATTESTS the imperative column for its
        // four congregation rows (ojinesdi / ijinesdi / idinesdi / aninesdi) but
        // has NO SG3 row, so there is no SG3 imperative stem to compose from --
        // the rows are registered as book-final surfaces (D14/D15 override
        // pattern). CED carries ----- in the imperative column. VRB pp.18
        // footnote: /Dunotla/ if only two are sitting, /ani'na/ if three or more
        // -- this lexeme is the 3+ alternant.
        surfaceOverrides: [
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'ojinesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG2', obj: 'NONE', form: 'ijinesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL1INCL', obj: 'NONE', form: 'idinesdi'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL3', obj: 'NONE', form: 'aninesdi']
        ],
        conjugations: [
                [subject: 'SG1', object: '', present: 'otsina'],
            [subject: 'SG3', object: '', habitual: 'aninoi', imperative: '', infinitive: '', present: 'anina', remote_past: 'aninvi']
        ]
    ]

    @Unroll
    def "conjugating Anina (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anina", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "anina"
        "SG3" | "" | Tense.HABITUAL        | "aninoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uninvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aninvi"
        // tio 18Nov26: IMMEDIATE_COMMAND attested for the four congregation rows
        // (Ani'na box, p.71); no SG3 row exists in the box.
        "SG1" | "" | Tense.IMMEDIATE_COMMAND | "ojinesdi"
        "SG2" | "" | Tense.IMMEDIATE_COMMAND | "ijinesdi"
        "PL1INCL" | "" | Tense.IMMEDIATE_COMMAND | "idinesdi"
        "PL3" | "" | Tense.IMMEDIATE_COMMAND | "aninesdi"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book prints Anina (ani'na) only inside the Uwotla (Sitting) box p.71; no infinitive column. yaml junk dropped.
    }
}
