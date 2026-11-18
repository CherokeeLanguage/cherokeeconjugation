// tio 18Nov26: NOT a yaml-junk/absent verb (earlier comment was WRONG) --
// Nani'a "There Are (#)" is Verb p.31 of the 2012 book with a full box. The
// yaml transcription dropped the glottal apostrophes (nani'a -> "Nania",
// nosdi'a -> "nosdia", ...), and header text ("There"/"Are") leaked into
// stem fields -- that corruption is what looked like wholesale absence.
// Citation re-aligned to CED cedEntries.csv id 73552 (entrya nania, syllabary
// ᎾᏂᎠ -- the glottal is unwritten between vowels, so the canonical
// romanization drops the apostrophe; DISCREPANCIES.md D9/D12).
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NaniaSpec extends VerbBaseSpec {
    static def details = [
        definition: "There Are (#)",
        part_of_speech: "v.i.",
        // tio 18Nov26: PRONOUN-LIMITED verb (VRB guide pp.18-19: verbs without
        // singular pronoun forms are listed by the "THEY" form). The p.31 box
        // has FIVE plural rows only -- nosdi'a (2 of us, DL1INCL), noji'a (# of
        // us, PL1INCL), nisdi'a (2 of you, DL2), niji'a (# of you, PL2),
        // nani'a (# of them, PL3) -- no SG1/SG2/SG3 rows exist. The SG3 row
        // below carries the CED citation (ᎾᏂᎠ, which IS the PL3 form) as the
        // stemmer feed, per the Anidonaa/Anina citation-row pattern. Remote is
        // book-X; the box has no infinitive column ("Pronoun Form" instead).
        // The plural rows are suppletive (noji-/niji- vs nani-), so only
        // citation-carrying cells are asserted; PL3 PRESENT surfaces as the
        // bare citation (the book prints nani'a, no ani- prefix).
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'PL3', obj: 'NONE', form: 'nania'],
            // tio 18Nov26: the engine's imperative composition prefixes a- onto
            // the plural citation stem (aniesdi) -- this verb has NO sg3 row, so
            // the composed form is spurious; the book prints nani'esdi.
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG3', obj: 'NONE', form: 'naniesdi']
        ],
        conjugations: [
            [subject: 'SG3', object: '', present: 'nania', habitual: 'nanioi', imperative: 'naniesdi', remote_past: '', infinitive: ''],
            [subject: 'DL1INCL', object: '', present: 'nosdia', habitual: 'nosdioi', imperative: 'nosdiesdi', remote_past: '', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'nojia', habitual: 'nojioi', imperative: 'nojiesdi', remote_past: '', infinitive: ''],
            [subject: 'DL2', object: '', present: 'nisdia', habitual: 'nisdioi', imperative: 'nisdiesdi', remote_past: '', infinitive: ''],
            [subject: 'PL2', object: '', present: 'nijia', habitual: 'nijioi', imperative: 'nijiesdi', remote_past: '', infinitive: ''],
            [subject: 'PL3', object: '', present: 'nania', habitual: 'nanioi', imperative: 'naniesdi', remote_past: '', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Nania (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nania", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        // tio 18Nov26: attested cells only -- SG3-row citation cells plus the
        // PL3 row. The other plural rows are suppletive data (wired, not
        // composed); REMOTE_PAST is book-X and the box has no infinitive
        // column, so FUTURE_COMMAND (D1: composes from remote) and INFINITIVE
        // are unattested (EXPECTED_GAPS).
        "SG3" | "" | Tense.PRESENT         | "nania"
        "SG3" | "" | Tense.HABITUAL        | "nanioi"
        "SG3" | "" | Tense.IMMEDIATE_COMMAND | "naniesdi"
        "PL3" | "" | Tense.PRESENT         | "nania"
    }
}
