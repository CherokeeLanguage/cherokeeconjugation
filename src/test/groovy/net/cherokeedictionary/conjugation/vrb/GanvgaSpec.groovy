package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Falling from Standing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvga', habitual: 'jinvgoi', remote_past: 'aginvjvi', imperative: 'jinvgi', infinitive: 'aginvsdi'],
            [subject: 'SG2', object: '', present: 'hinvga', habitual: 'hinvgoi', remote_past: 'janvjvi', imperative: 'hinvgi', infinitive: 'janvsdi'],
            [subject: 'SG3', object: '', present: 'ganvga', habitual: 'ganvgoi', remote_past: 'unvjvi', imperative: 'ganvgi', infinitive: 'unvsdi'],
            [subject: 'PL3', object: '', present: 'aninvga', habitual: 'aninvgoi', remote_past: 'uninvjvi', imperative: 'aninvgi', infinitive: 'uninvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinvga', habitual: 'idinvgoi', remote_past: 'iginvjvi', imperative: 'idinvgi', infinitive: 'iginvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvga"
        "SG1" | "" | Tense.HABITUAL        | "jinvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvgi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinvga"
        "SG2" | "" | Tense.HABITUAL        | "hinvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvgi"
        "SG2" | "" | Tense.INFINITIVE      | "janvsdi"
        "SG3" | "" | Tense.PRESENT         | "ganvga"
        "SG3" | "" | Tense.HABITUAL        | "ganvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvgi"
        "SG3" | "" | Tense.INFINITIVE      | "unvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninvga"
        "PL3" | "" | Tense.HABITUAL        | "aninvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvgi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvsdi"
    }
}
