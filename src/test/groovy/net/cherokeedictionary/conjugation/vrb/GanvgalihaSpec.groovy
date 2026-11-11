package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvgalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Brushing / Cleaning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvgalia', habitual: 'jinvgalisgoi', remote_past: 'aginvgalvhvi', imperative: 'jinvgala', infinitive: 'aginvgahldi'],
            [subject: 'SG2', object: '', present: 'hinvgaliha', habitual: 'hanvgalisgoi', remote_past: 'janvgalvhvi', imperative: 'hinvgala', infinitive: 'janvgahldi'],
            [subject: 'SG3', object: '', present: 'ganvgaliha', habitual: 'ganvgalisgoi', remote_past: 'unvgalvhvi', imperative: 'ganvgala', infinitive: 'unvgahldi'],
            [subject: 'PL3', object: '', present: 'aninvgaliha', habitual: 'aninvgalisgoi', remote_past: 'uninvgalvhvi', imperative: 'aninvgala', infinitive: 'uninvgahldi'],
            [subject: 'PL1INCL', object: '', present: 'idinvgaliha', habitual: 'idinvgalisgoi', remote_past: 'iginvgalvhvi', imperative: 'idinvgala', infinitive: 'iginvgahldi']
        ]
    ]

    @Unroll
    def "conjugating Ganvgaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvgaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvgalia"
        "SG1" | "" | Tense.HABITUAL        | "jinvgalisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvgalvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvgala"
        "SG1" | "" | Tense.INFINITIVE      | "aginvgahldi"
        "SG2" | "" | Tense.PRESENT         | "hinvgaliha"
        "SG2" | "" | Tense.HABITUAL        | "hanvgalisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvgalvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvgala"
        "SG2" | "" | Tense.INFINITIVE      | "janvgahldi"
        "SG3" | "" | Tense.PRESENT         | "ganvgaliha"
        "SG3" | "" | Tense.HABITUAL        | "ganvgalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvgalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvgala"
        "SG3" | "" | Tense.INFINITIVE      | "unvgahldi"
        "PL3" | "" | Tense.PRESENT         | "aninvgaliha"
        "PL3" | "" | Tense.HABITUAL        | "aninvgalisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvgalvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvgala"
        "PL3" | "" | Tense.INFINITIVE      | "uninvgahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvgaliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvgalisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvgalvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvgala"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvgahldi"
    }
}
