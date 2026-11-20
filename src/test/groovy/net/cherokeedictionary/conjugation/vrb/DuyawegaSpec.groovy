// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72947 (entrya duyawega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DuyawegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Tired/Not Well",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dagiyawega'],
            [subject: 'SG1', object: '', present: 'dagiyawega', habitual: 'dagiyawegoi', remote_past: 'dagiyawejvi', imperative: 'digiyawegi', infinitive: 'digiyawesdi'],
            [subject: 'SG2', object: '', present: 'dejayawega', habitual: 'dejayawegoi', remote_past: 'dejayawejvi', imperative: 'dijayawegi', infinitive: 'dijayawesdi'],
            [subject: 'SG3', object: '', habitual: 'duyawegoi', imperative: 'dijayawegi', infinitive: 'juyawesdi', present: 'duyawega', remote_past: 'duyawejvi'],
            [subject: 'PL3', object: '', present: 'duniyawega', habitual: 'duniyawegoi', remote_past: 'duniyawejvi', imperative: 'juniyawegi', infinitive: 'juniyawesdi'],
            [subject: 'PL1INCL', object: '', present: 'degiyawega', habitual: 'degiyawegoi', remote_past: 'degiyawejvi', imperative: 'digiyawegi', infinitive: 'digiyawesdi']
        ]
    ]

    @Unroll
    def "conjugating Duyawega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Duyawega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dagiyawega"
        "SG1" | "" | Tense.HABITUAL        | "dagiyawegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagiyawejvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyawetsvi"
        "SG1" | "" | Tense.INFINITIVE      | "digiyawesdi"
        "SG2" | "" | Tense.PRESENT         | "dejayawega"
        "SG2" | "" | Tense.HABITUAL        | "dejayawegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejayawejvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayawetsvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijayawesdi"
        "SG3" | "" | Tense.PRESENT         | "duyawega"
        "SG3" | "" | Tense.HABITUAL        | "duyawegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duyawejvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "duyawetsvi"
        "SG3" | "" | Tense.INFINITIVE      | "juyawesdi"
        "PL3" | "" | Tense.PRESENT         | "duniyawega"
        "PL3" | "" | Tense.HABITUAL        | "duniyawegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "duniyawejvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyawetsvi"
        "PL3" | "" | Tense.INFINITIVE      | "juniyawesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "degiyawega"
        "PL1INCL" | "" | Tense.HABITUAL        | "degiyawegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degiyawejvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyawetsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digiyawesdi"
    }
}
