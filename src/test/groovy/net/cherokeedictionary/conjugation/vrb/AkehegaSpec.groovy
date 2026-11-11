package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkehegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Chasing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'akehega', habitual: 'akehegoi', remote_past: 'ukehvsvi', imperative: 'akehuga', infinitive: 'ukehvsdi'],
            [subject: 'PL3', object: '', present: 'anikehega', habitual: 'anikehegoi', remote_past: 'unikehvsvi', imperative: 'anikehuga', infinitive: 'unikehvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idikehega', habitual: 'idikehegoi', remote_past: 'igikehvsvi', imperative: 'idikehuga', infinitive: 'igikehvsdi']
        ]
    ]

    @Unroll
    def "conjugating Akehega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akehega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akehega"
        "SG1" | "" | Tense.HABITUAL        | "akehegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ukehvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "akehuga"
        "SG1" | "" | Tense.INFINITIVE      | "ukehvsdi"
        "PL3" | "" | Tense.PRESENT         | "anikehega"
        "PL3" | "" | Tense.HABITUAL        | "anikehegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikehvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikehuga"
        "PL3" | "" | Tense.INFINITIVE      | "unikehvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idikehega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idikehegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikehvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idikehuga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igikehvsdi"
    }
}
