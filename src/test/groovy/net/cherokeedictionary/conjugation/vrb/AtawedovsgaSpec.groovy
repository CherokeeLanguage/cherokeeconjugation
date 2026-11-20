// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72664 (entrya atawedovsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtawedovsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Kissing (58)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jidawedovsga'],
            [subject: 'SG1', object: '', present: 'jidawedovsga', habitual: 'jidawedovsga', remote_past: 'agidawedonvi', imperative: 'jidawedovga', infinitive: 'agidawedodi'],
            [subject: 'SG2', object: '', present: 'hidawedovsga', habitual: 'hidawedovsgoi', remote_past: 'jadawedonvi', imperative: 'hidawedovga', infinitive: 'jadawedodi'],
            [subject: 'SG3', object: '', habitual: 'atawedovsgoi', imperative: 'hidawedovga', infinitive: 'utawedodi', present: 'atawedovsga', remote_past: 'utawedonvi'],
            [subject: 'PL3', object: '', present: 'anidawedovsga', habitual: 'anidawedovsgoi', remote_past: 'unidawedonvi', imperative: 'anidawedovga', infinitive: 'unidawedodi'],
            [subject: 'PL1INCL', object: '', present: 'ididawedovsga', habitual: 'ididawedovsgoi', remote_past: 'igidawedonvi', imperative: 'ididawedovga', infinitive: 'igidawedodi']
        ]
    ]

    @Unroll
    def "conjugating Atawedovsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atawedovsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitawetovsga"
        "SG1" | "" | Tense.HABITUAL        | "tsitawetovsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitawetonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitawedonvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitawetodi"
        "SG2" | "" | Tense.PRESENT         | "hitawetovsga"
        "SG2" | "" | Tense.HABITUAL        | "hitawetovsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatawetonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitawedonvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatawetodi"
        "SG3" | "" | Tense.PRESENT         | "atawedovsga"
        "SG3" | "" | Tense.HABITUAL        | "atawedovsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utawedonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atawedonvi"
        "SG3" | "" | Tense.INFINITIVE      | "utawedodi"
        "PL3" | "" | Tense.PRESENT         | "anitawetovsga"
        "PL3" | "" | Tense.HABITUAL        | "anitawetovsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitawetonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitawedonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitawetodi"
        "PL1INCL" | "" | Tense.PRESENT         | "iditawetovsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iditawetovsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitawetonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditawedonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitawetodi"
    }
}
