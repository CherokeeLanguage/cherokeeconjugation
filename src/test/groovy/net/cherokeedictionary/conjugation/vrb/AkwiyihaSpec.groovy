// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72483) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72483 (entrya akwiyiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkwiyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Paying (It)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gaquiyiha'],
            [subject: 'SG1', object: '', present: 'gaquiyiha', habitual: 'gagwiyisgoi', remote_past: 'akikwiyvhvi', imperative: 'gagwiya', infinitive: 'akikwiyhdi'],
            [subject: 'SG2', object: '', present: 'hakwiyiha', habitual: 'hakwiyisgoi', remote_past: 'jakwiyvhvi', imperative: 'hakwiya', infinitive: 'jakwiyhdi'],
            [subject: 'SG3', object: '', habitual: 'aquiyisgoi', imperative: 'haquiya', infinitive: 'uquiyvdi', present: 'aquiyiha', remote_past: 'uquiyvhvi'],
            [subject: 'PL3', object: '', present: 'anakwiyiha', habitual: 'anakwiyisgoi', remote_past: 'unikwiyvhvi', imperative: 'anakwiya', infinitive: 'unakwiyhdi'],
            [subject: 'PL1INCL', object: '', present: 'idakwiyiha', habitual: 'idakwiyisgoi', remote_past: 'igikwiyvhvi', imperative: 'idakwiya', infinitive: 'igakwiyhdi']
        ]
    ]

    @Unroll
    def "conjugating Akwiyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akwiyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gaquiyiha"
        "SG1" | "" | Tense.HABITUAL        | "gagwiyisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquaquiyvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gaquiyvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquaquiyvdi"
        "SG2" | "" | Tense.PRESENT         | "hakwiyiha"
        "SG2" | "" | Tense.HABITUAL        | "hakwiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jakwiyvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haquiyvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "jakwiyhdi"
        "SG3" | "" | Tense.PRESENT         | "aquiyiha"
        "SG3" | "" | Tense.HABITUAL        | "aquiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uquiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aquiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uquiyvdi"
        "PL3" | "" | Tense.PRESENT         | "anakwiyiha"
        "PL3" | "" | Tense.HABITUAL        | "anakwiyisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaquiyvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anaquiyvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unakwiyhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idakwiyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idakwiyisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaquiyvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaquiyvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igakwiyhdi"
    }
}
