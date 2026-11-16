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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinequoa"
        "SG1" | "" | Tense.HABITUAL        | "tsinequosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginequovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinequovi"
        "SG1" | "" | Tense.INFINITIVE      | "aginequosdi"
        "SG2" | "" | Tense.PRESENT         | "hinequoa"
        "SG2" | "" | Tense.HABITUAL        | "hinequosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanequovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinequovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanequosdi"
        "SG3" | "" | Tense.PRESENT         | "kanequoa"
        "SG3" | "" | Tense.HABITUAL        | "kanequosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unequovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganequovi"
        "SG3" | "" | Tense.INFINITIVE      | "unequosdi"
        "PL3" | "" | Tense.PRESENT         | "aninequoa"
        "PL3" | "" | Tense.HABITUAL        | "aninequosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninequovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninequovi"
        "PL3" | "" | Tense.INFINITIVE      | "uninequosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinequoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinequosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginequovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinequovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginequosdi"
    }
}
