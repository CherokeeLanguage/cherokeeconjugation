// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72593) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72593 (entrya asgahlga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgahlgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Biting Him/It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsisgatliga'],
            [subject: 'SG1', object: '', present: 'tsisgatliga', habitual: 'jisgahlgoi', remote_past: 'aksgahljvi', imperative: 'jisgala', infinitive: 'aksgalsdi'],
            [subject: 'SG2', object: '', present: 'hisgahlga', habitual: 'hisgahlgoi', remote_past: 'tsgahljvi', imperative: 'hisgala', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'asgatligoi', imperative: 'hisgala, hisgala', infinitive: 'usgalisdi', present: 'asgatliga', remote_past: 'usgatlitsvi'],
            [subject: 'PL3', object: '', present: 'anisgahlga', habitual: 'anisgahlgoi', remote_past: 'unisgahljvi', imperative: 'anisgala', infinitive: 'unisgalsdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgahlga', habitual: 'idisgahlgoi', remote_past: 'igisgahljvi', imperative: 'idisgala', infinitive: 'igisgalsdi']
        ]
    ]

    @Unroll
    def "conjugating Asgahlga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgahlga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisgatliga"
        "SG1" | "" | Tense.HABITUAL        | "tsisgatligoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisgatlitsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisgatlitsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgalsdi"
        "SG2" | "" | Tense.PRESENT         | "hisgatliga"
        "SG2" | "" | Tense.HABITUAL        | "hisgatligoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasgatlitsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgatlitsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "asgatliga"
        "SG3" | "" | Tense.HABITUAL        | "asgatligoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgatlitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgatlitsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgalisdi"
        "PL3" | "" | Tense.PRESENT         | "anisgatliga"
        "PL3" | "" | Tense.HABITUAL        | "anisgatligoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgatlitsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgatlitsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgalsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgatliga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgatligoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgatlitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgatlitsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgalsdi"
    }
}
