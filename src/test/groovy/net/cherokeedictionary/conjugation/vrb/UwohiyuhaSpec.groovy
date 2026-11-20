// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73996) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73996 (entrya uwohiyuha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwohiyuhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Believe, Confident, Faith",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aquohiyuha'],
            [subject: 'SG1', object: '', present: 'aquohiyuha', habitual: 'agwohiyusoi', remote_past: 'agwohiyusvi', imperative: 'agwohiyusesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'johiyuha', habitual: 'johiyusoi', remote_past: 'johiyusvi', imperative: 'johiyusesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'uwohiyusoi', imperative: 'tsohiyusesdi', infinitive: '', present: 'uwohiyuha', remote_past: 'uwohiyusvi'],
            [subject: 'PL3', object: '', present: 'unohiyuha', habitual: 'unohiyusoi', remote_past: 'unohiyusvi', imperative: 'unohiyusesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'igohiyuha', habitual: 'igohiyusoi', remote_past: 'igohiyusvi', imperative: 'igohiyusesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Uwohiyuha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwohiyuha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquohiyuha"
        "SG1" | "" | Tense.HABITUAL        | "agwohiyusoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwohiyusvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquohiyusvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "johiyuha"
        "SG2" | "" | Tense.HABITUAL        | "johiyusoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "johiyusvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsohiyusvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uwohiyuha"
        "SG3" | "" | Tense.HABITUAL        | "uwohiyusoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwohiyusvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwohiyusvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unohiyuha"
        "PL3" | "" | Tense.HABITUAL        | "unohiyusoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unohiyusvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unohiyusvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "igohiyuha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igohiyusoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igohiyusvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igohiyusvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
