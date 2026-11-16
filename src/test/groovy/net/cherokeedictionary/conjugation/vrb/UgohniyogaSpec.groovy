// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73787 (entrya ugohniyoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UgohniyogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Late",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agigohniyoga'],
            [subject: 'SG1', object: '', present: 'agigohniyoga', habitual: 'agigohniyogoi', remote_past: 'agigohniyojvi', imperative: 'agigohniyogi', infinitive: 'agigohniyosdi'],
            [subject: 'SG2', object: '', present: 'jagohniyoga', habitual: 'jagohniyogoi', remote_past: 'jagohniyojvi', imperative: 'jagohniyogi', infinitive: 'jagohniyosdi'],
            [subject: 'SG3', object: '', habitual: 'ugohniyogoi', imperative: 'jagohniyogi', infinitive: 'ugohniyosdi', present: 'ugohniyoga', remote_past: 'ugohniyojvi'],
            [subject: 'PL3', object: '', present: 'unigohniyoga', habitual: 'unigohniyogoi', remote_past: 'unigohniyojvi', imperative: 'unigohniyogi', infinitive: 'unigohniyosdi'],
            [subject: 'PL1INCL', object: '', present: 'igigohniyoga', habitual: 'igigohniyogoi', remote_past: 'igigohniyojvi', imperative: 'igigohniyogi', infinitive: 'igigohniyosdi']
        ]
    ]

    @Unroll
    def "conjugating Ugohniyoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ugohniyoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agigoniyoga"
        "SG1" | "" | Tense.HABITUAL        | "agigoniyogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigoniyotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agigoniyotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigoniyosdi"
        "SG2" | "" | Tense.PRESENT         | "tsagoniyoga"
        "SG2" | "" | Tense.HABITUAL        | "tsagoniyogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagoniyotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsagoniyotsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagoniyosdi"
        "SG3" | "" | Tense.PRESENT         | "ugoniyoga"
        "SG3" | "" | Tense.HABITUAL        | "ugoniyogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugoniyotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugoniyotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugoniyosdi"
        "PL3" | "" | Tense.PRESENT         | "unigoniyoga"
        "PL3" | "" | Tense.HABITUAL        | "unigoniyogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigoniyotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unigoniyotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigoniyosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igigoniyoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igigoniyogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigoniyotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igigoniyotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigoniyosdi"
    }
}
