// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73894 (entrya unaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aginaa'],
            [subject: 'SG1', object: '', present: 'aginaa', habitual: 'aginaoi', remote_past: 'aginavi', imperative: 'aginaesdi', infinitive: 'aginvdi'],
            [subject: 'SG2', object: '', present: 'janaa', habitual: 'janaoi', remote_past: 'janavi', imperative: 'janaesdi', infinitive: 'janvdi'],
            [subject: 'SG3', object: '', habitual: 'unaoi', imperative: 'janaesdi', infinitive: '----', present: 'unaa', remote_past: 'unavi'],
            [subject: 'PL3', object: '', present: 'uninaa', habitual: 'uninaoi', remote_past: 'uninavi', imperative: 'uninaesdi', infinitive: 'uninvdi']
        ]
    ]

    @Unroll
    def "conjugating Unaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginaa"
        "SG1" | "" | Tense.HABITUAL        | "aginaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginavi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvdi"
        "SG2" | "" | Tense.PRESENT         | "tsanaa"
        "SG2" | "" | Tense.HABITUAL        | "tsanaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanavi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanvdi"
        "SG3" | "" | Tense.PRESENT         | "unaa"
        "SG3" | "" | Tense.HABITUAL        | "unaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unavi"
        "SG3" | "" | Tense.INFINITIVE      | "unvdi"
        "PL3" | "" | Tense.PRESENT         | "uninaa"
        "PL3" | "" | Tense.HABITUAL        | "uninaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninavi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvdi"
    }
}
