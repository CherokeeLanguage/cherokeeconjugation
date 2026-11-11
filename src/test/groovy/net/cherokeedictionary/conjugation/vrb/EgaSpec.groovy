package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class EgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gega', habitual: 'gegoi', remote_past: 'agwenvsvi', imperative: 'gena', infinitive: 'agwenvsdi'],
            [subject: 'SG2', object: '', present: 'hega', habitual: 'hegoi', remote_past: 'jenvsvi', imperative: 'hena', infinitive: 'jenvsdi'],
            [subject: 'SG3', object: '', present: 'ega', habitual: 'egoi', remote_past: 'uwenvsvi', imperative: 'ena', infinitive: 'uwenvsdi'],
            [subject: 'PL3', object: '', present: 'anega', habitual: 'anegoi', remote_past: 'unenvsvi', imperative: 'anena', infinitive: 'unenvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idega', habitual: 'idegoi', remote_past: 'igenvsvi', imperative: 'idena', infinitive: 'igenvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gega"
        "SG1" | "" | Tense.HABITUAL        | "gegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwenvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gena"
        "SG1" | "" | Tense.INFINITIVE      | "agwenvsdi"
        "SG2" | "" | Tense.PRESENT         | "hega"
        "SG2" | "" | Tense.HABITUAL        | "hegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jenvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hena"
        "SG2" | "" | Tense.INFINITIVE      | "jenvsdi"
        "SG3" | "" | Tense.PRESENT         | "ega"
        "SG3" | "" | Tense.HABITUAL        | "egoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwenvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ena"
        "SG3" | "" | Tense.INFINITIVE      | "uwenvsdi"
        "PL3" | "" | Tense.PRESENT         | "anega"
        "PL3" | "" | Tense.HABITUAL        | "anegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unenvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anena"
        "PL3" | "" | Tense.INFINITIVE      | "unenvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igenvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idena"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igenvsdi"
    }
}
