// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73509) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73509 (entrya kdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Using",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gvdiha'],
            [subject: 'SG1', object: '', present: 'gvdiha', habitual: 'gvdisgoi', remote_past: 'aktanvi', imperative: 'gvda', infinitive: 'akhdohdi'],
            [subject: 'SG2', object: '', present: 'hvdiha', habitual: 'hvdisgoi', remote_past: 'jvtanvi', imperative: '/', infinitive: 'tstanvi'],
            [subject: 'SG3', object: '', habitual: 'gvdisgoi', imperative: 'hvda', infinitive: 'uwvdodi', present: 'gvdiha', remote_past: 'uwvtanvi'],
            [subject: 'PL3', object: '', present: 'anvdiha', habitual: 'anvdisgoi', remote_past: 'unvtanvi', imperative: 'anvhda', infinitive: 'unvhdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idvdiha', habitual: 'idvdisgoi', remote_past: 'iktanvi', imperative: 'idvhda', infinitive: 'ikhdohdi']
        ]
    ]

    @Unroll
    def "conjugating Kdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvdiha"
        "SG1" | "" | Tense.HABITUAL        | "gvdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvtanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwvdodi"
        "SG2" | "" | Tense.PRESENT         | "hvdiha"
        "SG2" | "" | Tense.HABITUAL        | "hvdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvtanvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "hvtanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawvdodi"
        "SG3" | "" | Tense.PRESENT         | "gvdiha"
        "SG3" | "" | Tense.HABITUAL        | "gvdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwatanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vtanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwvdodi"
        "PL3" | "" | Tense.PRESENT         | "anvdiha"
        "PL3" | "" | Tense.HABITUAL        | "anvdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvtanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwvdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvtanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvtanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwvdodi"
    }
}
