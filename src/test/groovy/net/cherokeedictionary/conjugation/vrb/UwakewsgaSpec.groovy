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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvgewisga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvgewisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvgewisvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvgewisvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvwagewisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "aquvgewisga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "aquvgewisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquvgewisvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquvgewisvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquvwagewisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tsvgewisga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tsvgewisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsvgewisvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsvgewisvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsvwagewisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "uwagewisga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "uwagewisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwagewisvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "uwagewisvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwawagewisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unagewisga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unagewisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unagewisvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unagewisvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unawagewisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igvgewisga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igvgewisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvgewisvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igvgewisvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvwagewisdi"
    }
}
