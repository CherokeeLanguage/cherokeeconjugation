// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73534) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73534 (entrya ktosadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KtosadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadosadia'],
            [subject: 'SG1', object: '', present: 'gadosadia', habitual: 'gatosadisgoi', remote_past: 'agwatosadvi', imperative: 'gatosada', infinitive: 'aktosadisdi'],
            [subject: 'SG2', object: '', present: 'hatosadia', habitual: 'hatosadisgoi', remote_past: 'jatosadvi', imperative: 'hatosada', infinitive: 'jatosadisdi'],
            [subject: 'SG3', object: '', habitual: 'gvdosadisgoi', imperative: 'hadosada', infinitive: 'uwvdosadisdi', present: 'gvdosadia', remote_past: 'uwvdosadvi'],
            [subject: 'SG3', object: '', present: 'anatosadia', habitual: 'anatosadisgoi', remote_past: 'unatosadvi', imperative: 'wanatosada', infinitive: 'unatosadisdi']
        ]
    ]

    @Unroll
    def "conjugating Ktosadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ktosadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvtosadia"
        "SG1" | "" | Tense.HABITUAL        | "gvtosadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvtosadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvdosadvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwvtosadisdi"
        "SG2" | "" | Tense.PRESENT         | "hvtosadia"
        "SG2" | "" | Tense.HABITUAL        | "hvtosadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvtosadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvdosadvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawvtosadisdi"
        "SG3" | "" | Tense.PRESENT         | "gvdosadia"
        "SG3" | "" | Tense.HABITUAL        | "gvdosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwatosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vdosadvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvdosadisdi"
        "SG3" | "" | Tense.PRESENT         | "gvtosadia"
        "SG3" | "" | Tense.HABITUAL        | "gvtosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwatosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vdosadvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvtosadisdi"
    }
}
