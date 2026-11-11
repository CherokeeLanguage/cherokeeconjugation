package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwanvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hurrying (182)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwvnvga', habitual: 'agwvnvgoi', remote_past: 'agwvnvgvi', imperative: 'agwvnvgi', infinitive: 'agwvnvsdi'],
            [subject: 'SG2', object: '', present: 'jvnvga', habitual: 'jvnvgoi', remote_past: 'jvnvgvi', imperative: 'jvnvgi', infinitive: 'jvnvsdi'],
            [subject: 'SG3', object: '', present: 'uwanvga', habitual: 'uwanvgoi', remote_past: 'uwanvgvi', imperative: 'uwanvgi', infinitive: 'uwanvsdi'],
            [subject: 'PL3', object: '', present: 'unvnvga', habitual: 'unvnvgoi', remote_past: 'unvnvgvi', imperative: 'unvnvgi', infinitive: 'unvnvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igvnvga', habitual: 'igvnvgoi', remote_past: 'igvnvgvi', imperative: 'igvnvgi', infinitive: 'igvnvsdi']
        ]
    ]

    @Unroll
    def "conjugating Uwanvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwanvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwvnvga"
        "SG1" | "" | Tense.HABITUAL        | "agwvnvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvnvgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwvnvgi"
        "SG1" | "" | Tense.INFINITIVE      | "agwvnvsdi"
        "SG2" | "" | Tense.PRESENT         | "jvnvga"
        "SG2" | "" | Tense.HABITUAL        | "jvnvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvnvgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jvnvgi"
        "SG2" | "" | Tense.INFINITIVE      | "jvnvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwanvga"
        "SG3" | "" | Tense.HABITUAL        | "uwanvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwanvgi"
        "SG3" | "" | Tense.INFINITIVE      | "uwanvsdi"
        "PL3" | "" | Tense.PRESENT         | "unvnvga"
        "PL3" | "" | Tense.HABITUAL        | "unvnvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvnvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unvnvgi"
        "PL3" | "" | Tense.INFINITIVE      | "unvnvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igvnvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igvnvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnvgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igvnvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvnvsdi"
    }
}
