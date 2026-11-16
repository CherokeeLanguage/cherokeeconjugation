// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73155 (entrya ganugoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanugogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Exiting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinugoga'],
            [subject: 'SG1', object: '', present: 'jinugoga', habitual: 'jinugogoi', remote_past: 'aginugojvi', imperative: 'jinugoi', infinitive: 'aginugisdi'],
            [subject: 'SG2', object: '', present: 'hinugoga', habitual: 'hinugogoi', remote_past: 'janugojvi', imperative: 'hinugoi', infinitive: 'janugisdi'],
            [subject: 'SG3', object: '', habitual: 'ganugogoi', imperative: 'hinugoi', infinitive: 'unugosdi', present: 'ganugoga', remote_past: 'unugojvi'],
            [subject: 'PL3', object: '', present: 'aninugoga', habitual: 'aninugogoi', remote_past: 'uninugojvi', imperative: 'aninugoi', infinitive: 'uninugisdi'],
            [subject: 'PL1INCL', object: '', present: 'idinugoga', habitual: 'idinugogoi', remote_past: 'iginugojvi', imperative: 'idinugoi', infinitive: 'iginugisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganugoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganugoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinugoga"
        "SG1" | "" | Tense.HABITUAL        | "tsinugogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginugotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinugotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginugosdi"
        "SG2" | "" | Tense.PRESENT         | "hinugoga"
        "SG2" | "" | Tense.HABITUAL        | "hinugogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanugotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinugotsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanugosdi"
        "SG3" | "" | Tense.PRESENT         | "ganugoga"
        "SG3" | "" | Tense.HABITUAL        | "ganugogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unugotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganugotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unugosdi"
        "PL3" | "" | Tense.PRESENT         | "aninugoga"
        "PL3" | "" | Tense.HABITUAL        | "aninugogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninugotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninugotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninugosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinugoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinugogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginugotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinugotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginugosdi"
    }
}
