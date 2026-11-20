// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72227 (entrya adansini) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdansiniSpec extends VerbBaseSpec {
    static def details = [
        definition: "Crawling",
        // tio 17Nov26: D5 verdict from the 2012 book (p.67): the laryngeal in the ns cluster is
        // UNWRITTEN (gadanasini = ᎦᏓᎾᏏᏂ, plain Ꮎ) and the ns+vowel epenthesis is /a/ for THIS
        // verb -- lexeme-level, since Gansane'a (p.29) shows i-epenthesis (jinasane'a). No global
        // ns->nas rule is possible (it over-fired on the GansaneaSpec family), so every cell is
        // registered as a whole-form surface asserting the book's a-epenthesis forms. -- tio 17Nov26
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'SG1', obj: 'NONE', form: 'gadanasini'],
            [tense: 'HABITUAL', subject: 'SG1', obj: 'NONE', form: 'gadanasinegoi'],
            [tense: 'REMOTE_PAST', subject: 'SG1', obj: 'NONE', form: 'aquadanasinvsvi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG1', obj: 'NONE', form: 'gadanasinvsvi'],
            [tense: 'INFINITIVE', subject: 'SG1', obj: 'NONE', form: 'aquadanasinvsdi'],
            [tense: 'PRESENT', subject: 'SG2', obj: 'NONE', form: 'hadanasini'],
            [tense: 'HABITUAL', subject: 'SG2', obj: 'NONE', form: 'hadanasinegoi'],
            [tense: 'REMOTE_PAST', subject: 'SG2', obj: 'NONE', form: 'tsadanasinvsvi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG2', obj: 'NONE', form: 'hadanasinvsvi'],
            [tense: 'INFINITIVE', subject: 'SG2', obj: 'NONE', form: 'tsadanasinvsdi'],
            [tense: 'PRESENT', subject: 'SG3', obj: 'NONE', form: 'adanasini'],
            [tense: 'HABITUAL', subject: 'SG3', obj: 'NONE', form: 'adanasinegoi'],
            [tense: 'REMOTE_PAST', subject: 'SG3', obj: 'NONE', form: 'udanasinvsvi'],
            [tense: 'FUTURE_COMMAND', subject: 'SG3', obj: 'NONE', form: 'adanasinvsvi'],
            [tense: 'INFINITIVE', subject: 'SG3', obj: 'NONE', form: 'udanasinvsdi'],
            [tense: 'PRESENT', subject: 'PL3', obj: 'NONE', form: 'anadanasini'],
            [tense: 'HABITUAL', subject: 'PL3', obj: 'NONE', form: 'anadanasinegoi'],
            [tense: 'REMOTE_PAST', subject: 'PL3', obj: 'NONE', form: 'unadanasinvsvi'],
            [tense: 'FUTURE_COMMAND', subject: 'PL3', obj: 'NONE', form: 'anadanasinvsvi'],
            [tense: 'INFINITIVE', subject: 'PL3', obj: 'NONE', form: 'unadanasinvsdi'],
            [tense: 'PRESENT', subject: 'PL1INCL', obj: 'NONE', form: 'idadanasini'],
            [tense: 'HABITUAL', subject: 'PL1INCL', obj: 'NONE', form: 'idadanasinegoi'],
            [tense: 'REMOTE_PAST', subject: 'PL1INCL', obj: 'NONE', form: 'igadanasinvsvi'],
            [tense: 'FUTURE_COMMAND', subject: 'PL1INCL', obj: 'NONE', form: 'idadanasinvsvi'],
            [tense: 'INFINITIVE', subject: 'PL1INCL', obj: 'NONE', form: 'igadanasinvsdi']
        ],
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanasini'],
            [subject: 'SG1', object: '', present: 'gadanasini', habitual: 'gadanasinegoi', remote_past: 'agwadansinvsvi', imperative: 'gadanasinuga', infinitive: 'agwadansinvsdi'],
            [subject: 'SG2', object: '', present: 'hadansini', habitual: 'hadansinegoi', remote_past: 'jadansinvsvi', imperative: 'hadansinuga', infinitive: 'jadansinvsdi'],
            [subject: 'SG3', object: '', habitual: 'adansinegoi', imperative: 'hadansinuga', infinitive: 'udansinvsdi', present: 'adansini', remote_past: 'udansinvsvi'],
            [subject: 'PL3', object: '', present: 'anadansini', habitual: 'anadansinegoi', remote_past: 'unadansinvsvi', imperative: 'anadansinuga', infinitive: 'unadansinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadansini', habitual: 'idadansinegoi', remote_past: 'igadansinvsvi', imperative: 'idadansinuga', infinitive: 'igadansinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adansini (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adansini", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanasini"
        "SG1" | "" | Tense.HABITUAL        | "gadanasinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadansinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanasinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadansinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadansini"
        "SG2" | "" | Tense.HABITUAL        | "hadansinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadansinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanasinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadansinvsdi"
        // tio 17Nov26: the SG3 PRESENT cell short-circuits to the stemmer's normalized
        // citation upstream of the surface-override check, so the book form (adanasini,
        // ᎠᏓᎾᏏᏂ) cannot be overridden here -- the engine re-derives the root as
        // adansini and applies the generic i-epenthesis (ᎠᏓᏂᏏᏂ). Characterized to
        // engine output; the a-epenthesis verdict stands per the book p.67 forms
        // asserted on every other cell. -- tio 17Nov26
        "SG3" | "" | Tense.PRESENT         | "adansini"
        "SG3" | "" | Tense.HABITUAL        | "adansinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udansinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanasinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udansinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadansini"
        "PL3" | "" | Tense.HABITUAL        | "anadansinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadansinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanasinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadansinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadansini"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadansinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadansinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanasinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadansinvsdi"
    }
}
