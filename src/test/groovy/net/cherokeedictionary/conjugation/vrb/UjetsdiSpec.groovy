package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UjetsdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Grinning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwajetsdi', habitual: 'agwajetsdoi', remote_past: 'agwajetsdvi', imperative: 'agwajetsda', infinitive: 'agwajetsdohdi'],
            [subject: 'SG2', object: '', present: 'jajetsdi', habitual: 'jajetsdoi', remote_past: 'jajetsdvi', imperative: 'hajetsda', infinitive: '/'],
            [subject: 'SG3', object: '', present: 'ujetsdi', habitual: 'ujetsdoi', remote_past: 'ujetsdvi', imperative: 'ajetsda', infinitive: '/'],
            [subject: 'PL3', object: '', present: 'unajetsdi', habitual: 'unajetsdoi', remote_past: 'unajetsdvi', imperative: 'anajetsda', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'igajetsdi', habitual: 'igajetsdoi', remote_past: 'igajetsdvi', imperative: 'idajetsda', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Ujetsdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ujetsdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwajetsdi"
        "SG1" | "" | Tense.HABITUAL        | "agwajetsdoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajetsdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwajetsda"
        "SG1" | "" | Tense.INFINITIVE      | "agwajetsdohdi"
        "SG2" | "" | Tense.PRESENT         | "jajetsdi"
        "SG2" | "" | Tense.HABITUAL        | "jajetsdoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajetsdvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hajetsda"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "ujetsdi"
        "SG3" | "" | Tense.HABITUAL        | "ujetsdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujetsdvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajetsda"
        // "SG3" | "" | Tense.INFINITIVE      | "/"
        "PL3" | "" | Tense.PRESENT         | "unajetsdi"
        "PL3" | "" | Tense.HABITUAL        | "unajetsdoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajetsdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anajetsda"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "igajetsdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igajetsdoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajetsdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idajetsda"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
