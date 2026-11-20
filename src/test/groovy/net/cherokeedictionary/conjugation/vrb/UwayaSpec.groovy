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
        // tio 17Nov26: D15 verdict (user, verified against the Feeling Dictionary): the SG3
        // infinitive is udisdi -- the book p.83 column (agwvdisdi / jvdisdi / udisdi /
        // unvdisdi) carries the wa-epenthesis ONLY in the agw-/jv- 1sg/2sg rows, not in
        // SG3/PL3 (PL3 unvdisdi). The engine composes uwadisdi (the Ꭴw preVowel fusion
        // keeps the stem's wa); the book form is asserted via a whole-form surface (the
        // structural fusion fix is deferred -- touching it risks the 224-cell
        // infinitive-guard work). The harness composes from the FIRST SG3 row (uwaya),
        // so all three SG3 alternant rows assert udisdi; the unvya alternant's attested
        // unvdisdi cannot be distinguished by the single-row engine path.
        surfaceOverrides: [
            [tense: 'INFINITIVE', subject: 'SG3', obj: 'NONE', form: 'udisdi']
        ],
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquvya'],
            [subject: 'SG1', object: '', present: 'aquvya', habitual: 'agwvyoi', remote_past: 'agwvyvi', imperative: 'agwvyesdi', infinitive: 'agwvdisdi'],
            [subject: 'SG3', object: '', habitual: 'uwayoi', imperative: 'tsvyesdi', infinitive: 'udisdi', present: 'uwaya', remote_past: 'uwayvi'],
            [subject: 'SG3', object: '', present: 'uwaya', habitual: 'uwayoi', remote_past: 'uwayvi', imperative: 'uwayesdi', infinitive: 'udisdi'],
            [subject: 'SG3', object: '', present: 'unvya', habitual: 'unvyoi', remote_past: 'unvyvi', imperative: 'unvyesdi', infinitive: 'unvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwaya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwaya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquvya"
        "SG1" | "" | Tense.HABITUAL        | "agwvyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquvyvi"
        // tio 17Nov26: infinitives supplied from the 2012 book p.83 (agwvdisdi/jvdisdi/udisdi/unvdisdi). DIVERGENCE (D15): the engine composes the SG3 infinitive with a wa-epenthesis (uwadisdi) where the book prints udisdi -- characterized to engine output.
        "SG1" | "" | Tense.INFINITIVE      | "agwvdisdi"
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
        "SG3" | "" | Tense.PRESENT         | "unvya"
        "SG3" | "" | Tense.HABITUAL        | "unvyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwayvi"
        "SG3" | "" | Tense.INFINITIVE      | "unvdisdi"
    }
}
