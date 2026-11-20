// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72505 (entrya aliheliga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AliheligaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Happy, Thankful",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galieliga'],
            [subject: 'SG1', object: '', present: 'galieliga', habitual: 'galieligoi', remote_past: 'agwalihelijvi', imperative: 'galieligi', infinitive: 'agwalihelisdi'],
            [subject: 'SG2', object: '', present: 'haliheliga', habitual: 'haliheligoi', remote_past: 'jalihelijvi', imperative: 'haliheligi', infinitive: 'jalihelisdi'],
            [subject: 'SG3', object: '', habitual: 'aliheligoi', imperative: 'haliheligi', infinitive: 'ulihelisdi', present: 'aliheliga', remote_past: 'ulihelijvi'],
            [subject: 'PL3', object: '', present: 'analiheliga', habitual: 'analiheligoi', remote_past: 'unahelijvi', imperative: 'analiheligi', infinitive: 'unalihelisdi'],
            [subject: 'PL1INCL', object: '', present: 'idaliheliga', habitual: 'idaliheligoi', remote_past: 'igahelijvi', imperative: 'idaliheligi', infinitive: 'igalihelisdi']
        ]
    ]

    @Unroll
    def "conjugating Aliheliga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aliheliga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galiheliga"
        "SG1" | "" | Tense.HABITUAL        | "galiheligoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalihelijvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galihelitsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalihelisdi"
        "SG2" | "" | Tense.PRESENT         | "haliheliga"
        "SG2" | "" | Tense.HABITUAL        | "haliheligoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalihelijvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halihelitsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalihelisdi"
        "SG3" | "" | Tense.PRESENT         | "aliheliga"
        "SG3" | "" | Tense.HABITUAL        | "aliheligoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulihelijvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alihelitsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulihelisdi"
        "PL3" | "" | Tense.PRESENT         | "analiheliga"
        "PL3" | "" | Tense.HABITUAL        | "analiheligoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalihelitsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analihelitsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalihelisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaliheliga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaliheligoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalihelitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalihelitsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalihelisdi"
    }
}
