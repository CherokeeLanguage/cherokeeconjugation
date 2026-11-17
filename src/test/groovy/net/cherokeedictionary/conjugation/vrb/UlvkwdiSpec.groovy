// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73892) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73892 (entrya ulvkwdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlvkwdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Like (It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsilvquodi, agilvquodi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jilvgwodi', habitual: 'jilvgwodoi', remote_past: 'jilvgwotanvi', imperative: 'jilvgwoda', infinitive: 'jilvgwodohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agilvkwdi', habitual: 'agilvkwdoi', remote_past: 'agilvkwtanvi', imperative: 'jilvkwda', infinitive: 'agilvkwdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hilvgwodi', habitual: 'hilvgwodoi', remote_past: 'hilvgwotanvi', imperative: 'hilvgwoda', infinitive: 'hilvgwodohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jalvkwdi', habitual: 'jalvkwdoi', remote_past: 'jalvkwtanvi', imperative: 'hilvkwda', infinitive: 'jalvkwdohdi'],
            [subject: 'SG3', object: '', habitual: 'ulvquodoi', imperative: 'hilvquoda, hilvquoda', infinitive: 'ulvquododi', present: 'ulvquodi', remote_past: 'ulvquodvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unilvkwdi', habitual: 'unilvkwdoi', remote_past: 'unilvkwtanvi', imperative: 'unilvkwda', infinitive: 'unilvkwdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igilvkwdi', habitual: 'igilvkwdoi', remote_past: 'igilvkwtanvi', imperative: 'igilvkwda', infinitive: 'igilvkwdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ulvkwdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulvkwdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsilvquodi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsilvquodoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsilvquodvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsilvquodvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsilvquododi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agilvquodi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agilvquodoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agilvquodvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agilvquodvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agilvquododi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "lvquodi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "lvquodoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "lvquodvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "lvquodvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "lvquododi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tsalvquodi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tsalvquodoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsalvquodvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsalvquodvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsalvquododi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ulvquodi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ulvquodoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ulvquodvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ulvquodvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ulvquododi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unilvquodi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unilvquodoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unilvquodvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unilvquodvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unilvquododi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igilvquodi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igilvquodoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igilvquodvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igilvquodvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igilvquododi"
    }
}
