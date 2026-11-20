package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NadvnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Doing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'nigadvneha', habitual: 'nigadvnehoi', remote_past: 'nagwadvnelvi', imperative: 'nigadvga', infinitive: 'yagwadvhdi'],
            [subject: 'SG2', object: '', present: 'hnadvneha', habitual: 'hnadvnehoi', remote_past: 'nijadvnelvi', imperative: 'hnadvga', infinitive: 'yijadvhdi'],
            [subject: 'SG3', object: '', present: 'nadvneha', habitual: 'nadvnehoi', remote_past: 'nudvnelvi', imperative: 'nadvga', infinitive: 'yudvhdi'],
            [subject: 'PL3', object: '', present: 'nandvneha', habitual: 'nandvnehoi', remote_past: 'nun(a)dvnelvi', imperative: 'nan(a)dvga', infinitive: 'yunadvhdi'],
            [subject: 'PL1INCL', object: '', present: 'nidadvneha', habitual: 'nidadvnehoi', remote_past: 'nigadvnelvi', imperative: 'nidadvga', infinitive: 'yigadvhdi']
        ]
    ]

    @Unroll
    def "conjugating Nadvneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nadvneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "nigadvneha"
        "SG1" | "" | Tense.HABITUAL        | "nigadvnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "nagwadvnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnelvi"
        "SG1" | "" | Tense.INFINITIVE      | "yagwadvhdi"
        "SG2" | "" | Tense.PRESENT         | "hnadvneha"
        "SG2" | "" | Tense.HABITUAL        | "hnadvnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "nijadvnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvnelvi"
        "SG2" | "" | Tense.INFINITIVE      | "yijadvhdi"
        "SG3" | "" | Tense.PRESENT         | "nadvneha"
        "SG3" | "" | Tense.HABITUAL        | "nadvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nudvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advnelvi"
        "SG3" | "" | Tense.INFINITIVE      | "yudvhdi"
        "PL3" | "" | Tense.PRESENT         | "nandvneha"
        "PL3" | "" | Tense.HABITUAL        | "nandvnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "nun(a)dvnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadvnelvi"
        "PL3" | "" | Tense.INFINITIVE      | "yunadvhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "nidadvneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "nidadvnehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "nigadvnelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadvnelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "yigadvhdi"
    }
}
