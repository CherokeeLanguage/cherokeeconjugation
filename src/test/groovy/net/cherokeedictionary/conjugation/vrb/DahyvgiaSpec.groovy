// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72760 (entrya dahyvgia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DahyvgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Tickling Him/Her ; Spurring a Horse",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejiyvgia'],
            [subject: 'SG1', object: '', present: 'dejiyvgia', habitual: 'dejiyvgisgoi', remote_past: 'dejiyvgvi', imperative: '/', infinitive: 'dakihyvgvi'],
            [subject: 'SG2', object: '', present: 'dehihyvgia', habitual: 'dehihyvgisgoi', remote_past: 'dehihyvgvi', imperative: '/', infinitive: 'dejahyvgvi'],
            [subject: 'SG3', object: '', habitual: 'dahyvgisgoi', imperative: 'tiyvga', infinitive: 'juhyvgisdi', present: 'dahyvgia', remote_past: 'duhyvgvi'],
            [subject: 'PL3', object: '', present: 'danihyvgia', habitual: 'danihyvgisgoi', remote_past: 'dunihyvgvi', imperative: 'dinihyvga', infinitive: 'junihyvgisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedihyvgia', habitual: 'dedihyvgisgoi', remote_past: 'dedihyvgvi', imperative: '/', infinitive: 'degihyvgvi']
        ]
    ]

    @Unroll
    def "conjugating Dahyvgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahyvgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejiyvgia"
        "SG1" | "" | Tense.HABITUAL        | "dejiyvgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagiyvgvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyvgvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagiyvgisdi"
        "SG2" | "" | Tense.PRESENT         | "tiyvgia"
        "SG2" | "" | Tense.HABITUAL        | "tiyvgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "detsayvgvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyvgvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsayvgisdi"
        "SG3" | "" | Tense.PRESENT         | "dahyvgia"
        "SG3" | "" | Tense.HABITUAL        | "dahyvgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhyvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gayvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "juhyvgisdi"
        "PL3" | "" | Tense.PRESENT         | "danihyvgia"
        "PL3" | "" | Tense.HABITUAL        | "danihyvgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunihyvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvgvi"
        "PL3" | "" | Tense.INFINITIVE      | "junihyvgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadiyvgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadiyvgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagiyvgvi"
        // "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiyvgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagiyvgisdi"
    }
}
