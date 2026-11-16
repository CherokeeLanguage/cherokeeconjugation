// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73976) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73976 (entrya uwaya) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwayaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquvya'],
            [subject: 'SG1', object: '', present: 'aquvya', habitual: 'agwvyoi', remote_past: 'agwvyvi', imperative: 'agwvyesdi', infinitive: 'agwvdisdi'],
            [subject: 'SG3', object: '', habitual: 'uwayoi', imperative: 'tsvyesdi', infinitive: '', present: 'uwaya', remote_past: 'uwayvi'],
            [subject: 'SG3', object: '', present: 'uwaya', habitual: 'uwayoi', remote_past: 'uwayvi', imperative: 'uwayesdi', infinitive: 'udisdi'],
            [subject: 'SG3', object: '', present: 'unvya', habitual: 'unvyoi', remote_past: 'unvyvi', imperative: 'unvyesdi', infinitive: 'unvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwaya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwaya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquvya"
        "SG1" | "" | Tense.HABITUAL        | "aquvyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquvyvi"
        "SG1" | "" | Tense.INFINITIVE      | "agidisdi"
        "SG3" | "" | Tense.PRESENT         | "uwaya"
        "SG3" | "" | Tense.HABITUAL        | "uwayoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwayvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwayvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "SG3" | "" | Tense.PRESENT         | "uwaya"
        "SG3" | "" | Tense.HABITUAL        | "uwayoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwayvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwayvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "SG3" | "" | Tense.PRESENT         | "uwaya"
        "SG3" | "" | Tense.HABITUAL        | "uwayoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwayvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwayvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
    }
}
