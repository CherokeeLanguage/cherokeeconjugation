// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73965) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73965 (entrya uwakewsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwakewsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Forget",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquvgewisga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvkewsga', habitual: 'jiyvkewsgoi', remote_past: 'jiyvkewsvi', imperative: 'jiyvkewa', infinitive: 'jiyvkehwisdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwvkewsga', habitual: 'agwvkewsgoi', remote_past: 'agwvkewsvi', imperative: 'agwvkewa', infinitive: 'agwvkehwisdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jvkewsga', habitual: 'jvkewsgoi', remote_past: 'jvkewsvi', imperative: 'wijvkewa', infinitive: 'jvkehwisdi'],
            [subject: 'SG3', object: '', habitual: 'uwagewisgoi', imperative: 'witsvgewa', infinitive: 'uwagewisdi', present: 'uwagewisga', remote_past: 'uwagewisvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unvkewsga', habitual: 'unvkewsgoi', remote_past: 'unvkewsvi', imperative: 'wunvkewa', infinitive: 'unvkehwisdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igvkewsga', habitual: 'igvkewsgoi', remote_past: 'igvkewsvi', imperative: 'wigvkewa', infinitive: 'igvkehwisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwakewsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwakewsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvkewsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvkewsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyvkewsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvgewisvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyvkehwisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agwvkewsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agwvkewsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwvkewsvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquvgewisvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwvkehwisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jvkewsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jvkewsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jvkewsvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsvgewisvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jvkehwisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "uwagewisga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "uwagewisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwagewisvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "uwagewisvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwawagewisdi"
        // D16 (17Nov26): PL3 un- + v-stem composes Ꮕ (nv) per the book PL3 row
        // (unvkewsga / unvkewsvi; CED canonical parse-back gewis-).
        "PL3" | "SG3IN" | Tense.PRESENT         | "unvkewsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unvkewsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unvkewsvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unvgewisvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvkehwisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igvkewsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igvkewsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvkewsvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igvgewisvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvkehwisdi"
    }
}
