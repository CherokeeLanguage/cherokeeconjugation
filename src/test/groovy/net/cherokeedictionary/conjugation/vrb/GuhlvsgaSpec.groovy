package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GuhlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Covering (125)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'guhlvsga', habitual: 'guhlvsgoi', remote_past: 'agwuhlvnvi', imperative: 'guhlvvga', infinitive: 'agwuhlvdi'],
            [subject: 'SG2', object: '', present: 'huhlvsga', habitual: 'huhlvsgoi', remote_past: 'juhlvnvi', imperative: 'huhlvvga', infinitive: 'juhlvdi'],
            [subject: 'SG3', object: '', present: 'guhlvsga', habitual: 'guhlvsgoi', remote_past: 'uwuhlvnvi', imperative: 'guhlvvga', infinitive: 'uwuhlvdi'],
            [subject: 'PL3', object: '', present: 'anuhlvsga', habitual: 'anuhlvsgoi', remote_past: 'unuhlvnvi', imperative: 'anuhlvvga', infinitive: 'unuhlvdi'],
            [subject: 'PL1INCL', object: '', present: 'iduhlvsga', habitual: 'iduhlvsgoi', remote_past: 'iguhlvnvi', imperative: 'iduhlvvga', infinitive: 'iguhlvdi']
        ]
    ]

    @Unroll
    def "conjugating Guhlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Guhlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "guhlvsga"
        "SG1" | "" | Tense.HABITUAL        | "guhlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwuhlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guhlvvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwuhlvdi"
        "SG2" | "" | Tense.PRESENT         | "huhlvsga"
        "SG2" | "" | Tense.HABITUAL        | "huhlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "juhlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "huhlvvga"
        "SG2" | "" | Tense.INFINITIVE      | "juhlvdi"
        "SG3" | "" | Tense.PRESENT         | "guhlvsga"
        "SG3" | "" | Tense.HABITUAL        | "guhlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuhlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "guhlvvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwuhlvdi"
        "PL3" | "" | Tense.PRESENT         | "anuhlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anuhlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuhlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anuhlvvga"
        "PL3" | "" | Tense.INFINITIVE      | "unuhlvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iduhlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iduhlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguhlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iduhlvvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iguhlvdi"
    }
}
