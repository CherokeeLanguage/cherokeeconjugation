// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73478 (entrya kanehgwoa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanehgwoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Accumulating, Increasing It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinehgwoa'],
            [subject: 'SG1', object: '', present: 'jinehgwoa', habitual: 'jinehgwosgoi', remote_past: 'akihnehgwovi', imperative: 'jinehgwoja', infinitive: 'akihnehgwosdi'],
            [subject: 'SG2', object: '', present: 'hinehgwoa', habitual: 'hinehgwosgoi', remote_past: 'jahnehgwovi', imperative: 'hihnehgwoja', infinitive: 'jahnehgwosdi'],
            [subject: 'SG3', object: '', habitual: 'kanehgwosgoi', imperative: 'hihnehgwoja', infinitive: 'uhnehgwosdi', present: 'kanehgwoa', remote_past: 'uhnehgwovi'],
            [subject: 'PL3', object: '', present: 'aninehgwoa', habitual: 'aninehgwosgoi', remote_past: 'unihnehgwovi', imperative: 'anihnehgwoja', infinitive: 'unihnehgwosdi'],
            [subject: 'PL1INCL', object: '', present: 'idinehgwoa', habitual: 'idinehgwosgoi', remote_past: 'igihnehgwovi', imperative: 'idihnehgwoja', infinitive: 'igihnehgwosdi']
        ]
    ]

    @Unroll
    def "conjugating Kanehgwoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanehgwoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinehgwoa"
        "SG1" | "" | Tense.HABITUAL        | "jinehgwosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akihnehgwovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinequovi"
        "SG1" | "" | Tense.INFINITIVE      | "akihnehgwosdi"
        "SG2" | "" | Tense.PRESENT         | "hinehgwoa"
        "SG2" | "" | Tense.HABITUAL        | "hinehgwosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnehgwovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinequovi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnehgwosdi"
        "SG3" | "" | Tense.PRESENT         | "kanehgwoa"
        "SG3" | "" | Tense.HABITUAL        | "kanehgwosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnehgwovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganequovi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnehgwosdi"
        "PL3" | "" | Tense.PRESENT         | "aninehgwoa"
        "PL3" | "" | Tense.HABITUAL        | "aninehgwosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnehgwovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninequovi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnehgwosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinehgwoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinehgwosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnehgwovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinequovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnehgwosdi"
    }
}
