package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsganvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Committing a Crime",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisganvga', habitual: 'jisganvgoi', remote_past: 'aksganvjvi', imperative: 'jisganvgi', infinitive: 'aksganvysdi'],
            [subject: 'SG2', object: '', present: 'hisganvga', habitual: 'hisganvgoi', remote_past: 'tsganvjvi', imperative: 'hisganvgi', infinitive: 'tsganvysdi'],
            [subject: 'SG3', object: '', present: 'asganvga', habitual: 'asganvgoi', remote_past: 'usganvjvi', imperative: 'asganvgi', infinitive: 'usganvysdi'],
            [subject: 'PL3', object: '', present: 'anisganvga', habitual: 'anisganvgoi', remote_past: 'unisganvjvi', imperative: 'anisganvgi', infinitive: 'unisganvysdi'],
            [subject: 'PL1INCL', object: '', present: 'idisganvga', habitual: 'idisganvgoi', remote_past: 'igisganvjvi', imperative: 'idisganvgi', infinitive: 'igisganvysdi']
        ]
    ]

    @Unroll
    def "conjugating Asganvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asganvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisganvga"
        "SG1" | "" | Tense.HABITUAL        | "jisganvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksganvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisganvgi"
        "SG1" | "" | Tense.INFINITIVE      | "aksganvysdi"
        "SG2" | "" | Tense.PRESENT         | "hisganvga"
        "SG2" | "" | Tense.HABITUAL        | "hisganvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsganvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisganvgi"
        "SG2" | "" | Tense.INFINITIVE      | "tsganvysdi"
        "SG3" | "" | Tense.PRESENT         | "asganvga"
        "SG3" | "" | Tense.HABITUAL        | "asganvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usganvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asganvgi"
        "SG3" | "" | Tense.INFINITIVE      | "usganvysdi"
        "PL3" | "" | Tense.PRESENT         | "anisganvga"
        "PL3" | "" | Tense.HABITUAL        | "anisganvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisganvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisganvgi"
        "PL3" | "" | Tense.INFINITIVE      | "unisganvysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisganvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisganvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisganvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisganvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisganvysdi"
    }
}
