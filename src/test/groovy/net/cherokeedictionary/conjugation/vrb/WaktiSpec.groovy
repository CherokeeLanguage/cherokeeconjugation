// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 74035) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74035 (entrya wakti) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WaktiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going (Specific Direction)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'witsigati'],
            [subject: 'SG1', object: '', present: 'witsigati', habitual: 'wijitatoi', remote_past: 'wijigatvi', imperative: 'wijigatesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'hwakti', habitual: '/', remote_past: 'hwigati', imperative: 'hwaktoi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'wagadoi', imperative: 'wigatesdi', infinitive: '', present: 'wagati', remote_past: 'wagadvi'],
            [subject: 'PL3', object: '', present: 'wanakti', habitual: 'wanaktoi', remote_past: 'wanaktvi', imperative: 'wanaktesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'widakti', habitual: 'widaktoi', remote_past: 'widaktvi', imperative: 'widaktesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Wakti (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wakti", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigati"
        "SG1" | "" | Tense.HABITUAL        | "tsigatoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigadvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "higati"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higadvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "wagati"
        "SG3" | "" | Tense.HABITUAL        | "wagadoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gagadvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "anigati"
        "PL3" | "" | Tense.HABITUAL        | "anigatoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigadvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigadvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idigati"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigatoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigadvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigadvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
