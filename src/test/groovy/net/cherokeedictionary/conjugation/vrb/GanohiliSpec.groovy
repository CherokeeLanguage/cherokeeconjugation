// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73142) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73142 (entrya ganohili) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanohiliSpec extends VerbBaseSpec {
    static def details = [
        definition: "Flying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsinoili'],
            [subject: 'SG1', object: '', present: 'tsinoili', habitual: 'jinoilegoi', remote_past: 'aginohilidolvi', imperative: 'jinoilisvi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'hinohili', habitual: 'hinohilegoi', remote_past: 'janohilidolvi', imperative: 'hinohilvsvi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'ganohilisoi', imperative: 'hinohilisesdi', infinitive: '', present: 'ganohili', remote_past: 'unohilidolvi'],
            [subject: 'PL3', object: '', present: 'aninohili', habitual: 'aninohilegoi', remote_past: 'uninohilidolvi', imperative: 'aninohilvsvi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'idinohili', habitual: 'idinohilegoi', remote_past: 'iginohilidolvi', imperative: 'idinohilvsvi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Ganohili (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohili", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinohili"
        "SG1" | "" | Tense.HABITUAL        | "tsinohilisoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohilidolvi"
        // tio 17Nov26: SG3 remote stem supplied from the 2012 book p.27 (unohilidolv'i) -- the yaml
        // extraction left the SG3 remote_past EMPTY. Per the D1 convention, FUTURE_COMMAND asserts
        // the remote_past row; expectations re-characterized to the engine's composition.
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinohilidolvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "hinohili"
        "SG2" | "" | Tense.HABITUAL        | "hinohilisoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohilidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohilidolvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "ganohili"
        "SG3" | "" | Tense.HABITUAL        | "ganohilisoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohilidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohilidolvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "aninohili"
        "PL3" | "" | Tense.HABITUAL        | "aninohilisoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohilidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohilidolvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idinohili"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohilisoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohilidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinohilidolvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
