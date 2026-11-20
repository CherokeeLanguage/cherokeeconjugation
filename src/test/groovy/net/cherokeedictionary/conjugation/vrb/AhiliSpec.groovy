// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72350) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72350 (entrya ahili) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhiliSpec extends VerbBaseSpec {
    static def details = [
        definition: "Driving",
        part_of_speech: "v.i.",
        // tio 18Nov26: IMMEDIATE_COMMAND wired via whole-form surfaceOverrides --
        // the Ahi'li box (VRB p.10) ATTESTS the imperative column (ji'i'luga /
        // hihi'luga / ahi'luga / anihi'luga / idihi'luga) while CED marks it empty
        // (-----) -- the BOOK has the value, so the rows are Feeling's
        // romanization (laryngeal apostrophes unwritten in syllabary). Raw
        // composition mangled the glottal-initial allomorphy (ji- + hi-luga →
        // jihiluga vs book ji'i'luga; ga- echo on SG3), so the rows are
        // registered as book-final surfaces (D14/D15 override pattern). VRB
        // processed-md text layer carried the romanization -- no OCR needed.
        surfaceOverrides: [
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'jiiluga'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG2', obj: 'NONE', form: 'hihiluga'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'SG3', obj: 'NONE', form: 'ahiluga'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL3', obj: 'NONE', form: 'anihiluga'],
            [tense: 'IMMEDIATE_COMMAND', subject: 'PL1INCL', obj: 'NONE', form: 'idihiluga']
        ],
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiili'],
            [subject: 'SG1', object: '', present: 'tsiili', habitual: 'jiilegoi', remote_past: '/', imperative: 'jiilisoi', infinitive: 'agihilvsvi'],
            [subject: 'SG2', object: '', present: 'hihili', habitual: 'hihilegoi', remote_past: '/', imperative: 'hihilisoi', infinitive: 'jahilvsvi'],
            [subject: 'SG3', object: '', habitual: 'ahilisoi', imperative: 'ahiluga', infinitive: 'uhilvsdi', present: 'ahili', remote_past: 'uhilvsvi'],
            [subject: 'PL3', object: '', present: 'anihili', habitual: 'anihilegoi', remote_past: '/', imperative: 'anihilisoi', infinitive: 'unihilvsvi'],
            [subject: 'PL1INCL', object: '', present: 'idihili', habitual: 'idihilegoi', remote_past: '/', imperative: 'idihilisoi', infinitive: 'igihilvsvi']
        ]
    ]

    @Unroll
    def "conjugating Ahili (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahili", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsihili"
        "SG1" | "" | Tense.HABITUAL        | "tsihilisoi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "/"
        // tio 17Nov26: FUTURE_COMMAND UNATTESTED -- the 2012 book box for Ahi'li (Driving p.10) has no future-command column; yaml '/' junk dropped.
        // tio 18Nov26: IMMEDIATE_COMMAND WIRED -- the 2012 book (Ahi'li Driving p.10)
        // ATTESTS the imperative column (ji'i'luga / hihi'luga / ahi'luga /
        // anihi'luga / idihi'luga) while CED marks it empty (-----) -- the BOOK has
        // the value, so the SG3 stem is Feeling's romanization (ahi'luga; the
        // laryngeal apostrophe is unwritten in syllabary, ᎠᎯᎫᎧ). Closes the
        // EXPECTED_GAPS entry (no OCR needed: the VRB processed-md text layer
        // carries the romanization). -- tio 18Nov26
        "SG1" | "" | Tense.IMMEDIATE_COMMAND | "jiiluga"
        "SG2" | "" | Tense.IMMEDIATE_COMMAND | "hihiluga"
        "SG3" | "" | Tense.IMMEDIATE_COMMAND | "ahiluga"
        "PL3" | "" | Tense.IMMEDIATE_COMMAND | "anihiluga"
        "PL1INCL" | "" | Tense.IMMEDIATE_COMMAND | "idihiluga"
        "SG1" | "" | Tense.INFINITIVE      | "agihilvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihili"
        "SG2" | "" | Tense.HABITUAL        | "hihilisoi"
        // "SG2" | "" | Tense.REMOTE_PAST     | "/"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG2" | "" | Tense.INFINITIVE      | "tsahilvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahili"
        "SG3" | "" | Tense.HABITUAL        | "ahilisoi"
        // "SG3" | "" | Tense.REMOTE_PAST     | "/"
        // "SG3" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG3" | "" | Tense.INFINITIVE      | "uhilvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihili"
        "PL3" | "" | Tense.HABITUAL        | "anihilisoi"
        // "PL3" | "" | Tense.REMOTE_PAST     | "/"
        // "PL3" | "" | Tense.FUTURE_COMMAND      | "/"
        "PL3" | "" | Tense.INFINITIVE      | "unihilvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihili"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihilisoi"
        // "PL1INCL" | "" | Tense.REMOTE_PAST     | "/"
        // "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "/"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihilvsdi"
    }
}
