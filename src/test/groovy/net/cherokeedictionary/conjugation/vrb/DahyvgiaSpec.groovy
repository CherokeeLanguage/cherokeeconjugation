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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiyvgia"
        "SG1" | "" | Tense.HABITUAL        | "tsiyvgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyvgvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyvgvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyvgisdi"
        "SG2" | "" | Tense.PRESENT         | "hiyvgia"
        "SG2" | "" | Tense.HABITUAL        | "hiyvgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayvgvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyvgvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayvgisdi"
        "SG3" | "" | Tense.PRESENT         | "dayvgia"
        "SG3" | "" | Tense.HABITUAL        | "dayvgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gayvgvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvgisdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvgia"
        "PL3" | "" | Tense.HABITUAL        | "aniyvgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvgvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiyvgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiyvgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyvgvi"
        // "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiyvgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyvgisdi"
    }
}
