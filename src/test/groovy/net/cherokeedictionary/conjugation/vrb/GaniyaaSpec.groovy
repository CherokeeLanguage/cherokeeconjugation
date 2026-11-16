// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73137 (entrya ganiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaniyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiniyaa'],
            [subject: 'SG1', object: '', present: 'jiniyaa', habitual: 'jiniyasgoi', remote_past: 'aginiyvi', imperative: 'jiniya', infinitive: 'aginiyasdi'],
            [subject: 'SG2', object: '', present: 'hiniyaa', habitual: 'hiniyasgoi', remote_past: 'janiyvi', imperative: 'hiniya', infinitive: 'janiyasdi'],
            [subject: 'SG3', object: '', habitual: 'ganiyasgoi', imperative: 'hiniya', infinitive: 'uniyasdi', present: 'ganiyaa', remote_past: 'uniyvi'],
            [subject: 'PL3', object: '', present: 'aniniyaa', habitual: 'aniniyasgoi', remote_past: 'uniniyvi', imperative: 'aniniya', infinitive: 'uniniyasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiniyaa"
        "SG1" | "" | Tense.HABITUAL        | "tsiniyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiniyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hiniyaa"
        "SG2" | "" | Tense.HABITUAL        | "hiniyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaniyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiniyvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaniyasdi"
        "SG1" | "" | Tense.PRESENT         | "tsiniyaa"
        "SG1" | "" | Tense.HABITUAL        | "tsiniyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiniyvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginiyasdi"
        "PL3" | "" | Tense.PRESENT         | "aniniyaa"
        "PL3" | "" | Tense.HABITUAL        | "aniniyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniniyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniniyvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniniyasdi"
    }
}
