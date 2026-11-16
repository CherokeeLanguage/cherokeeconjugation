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
                [subject: 'SG1', object: '', present: 'jilvgwodi, agilvkwdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jilvgwodi', habitual: 'jilvgwodoi', remote_past: 'jilvgwotanvi', imperative: 'jilvgwoda', infinitive: 'jilvgwodohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agilvkwdi', habitual: 'agilvkwdoi', remote_past: 'agilvkwtanvi', imperative: 'jilvkwda', infinitive: 'agilvkwdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hilvgwodi', habitual: 'hilvgwodoi', remote_past: 'hilvgwotanvi', imperative: 'hilvgwoda', infinitive: 'hilvgwodohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jalvkwdi', habitual: 'jalvkwdoi', remote_past: 'jalvkwtanvi', imperative: 'hilvkwda', infinitive: 'jalvkwdohdi'],
            [subject: 'SG3', object: '', habitual: 'ulvkwdoi', imperative: 'hilvgwoda, hilvkwda', infinitive: 'ulvkwdohdi', present: 'ulvkwdi', remote_past: 'ulvkwdvi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsilvquedi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsilvquedoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsilvquedvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsilvquedvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsilvquedodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agilvquedi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agilvquedoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agilvquedvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agilvquedvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agilvquedodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "lvquedi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "lvquedoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "lvquedvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "lvquedvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "lvquedodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tsalvquedi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tsalvquedoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsalvquedvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsalvquedvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsalvquedodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ulvquedi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ulvquedoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ulvquedvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ulvquedvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ulvquedodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unilvquedi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unilvquedoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unilvquedvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unilvquedvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unilvquedodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igilvquedi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igilvquedoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igilvquedvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igilvquedvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igilvquedodi"
    }
}
