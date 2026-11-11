package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalulogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lacking / Missing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiluloga', habitual: 'jilulogoi', remote_past: 'agilulojvi', imperative: 'jilulogi', infinitive: 'agilulosdi'],
            [subject: 'SG2', object: '', present: 'hiluloga', habitual: 'hilulogoi', remote_past: 'jalulojvi', imperative: 'hilulogi', infinitive: 'jalulosdi'],
            [subject: 'SG3', object: '', present: 'galuloga', habitual: 'galulogoi', remote_past: 'ululojvi', imperative: 'galulogi', infinitive: 'ululosdi'],
            [subject: 'PL3', object: '', present: 'aniluloga', habitual: 'anilulogoi', remote_past: 'unilulojvi', imperative: 'anilulogi', infinitive: 'unilulosdi'],
            [subject: 'PL1INCL', object: '', present: 'idiluloga', habitual: 'idilugoi', remote_past: 'igilulojvi', imperative: 'idilulogi', infinitive: 'igilulosdi']
        ]
    ]

    @Unroll
    def "conjugating Galuloga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galuloga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiluloga"
        "SG1" | "" | Tense.HABITUAL        | "jilulogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilulojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilulogi"
        "SG1" | "" | Tense.INFINITIVE      | "agilulosdi"
        "SG2" | "" | Tense.PRESENT         | "hiluloga"
        "SG2" | "" | Tense.HABITUAL        | "hilulogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalulojvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilulogi"
        "SG2" | "" | Tense.INFINITIVE      | "jalulosdi"
        "SG3" | "" | Tense.PRESENT         | "galuloga"
        "SG3" | "" | Tense.HABITUAL        | "galulogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ululojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galulogi"
        "SG3" | "" | Tense.INFINITIVE      | "ululosdi"
        "PL3" | "" | Tense.PRESENT         | "aniluloga"
        "PL3" | "" | Tense.HABITUAL        | "anilulogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilulojvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilulogi"
        "PL3" | "" | Tense.INFINITIVE      | "unilulosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiluloga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilugoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilulojvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilulogi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilulosdi"
    }
}
