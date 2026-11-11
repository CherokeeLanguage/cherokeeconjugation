package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwotlaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sitting/At Home",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwotla', habitual: 'agwotloi', remote_past: 'agwotlvi', imperative: 'agwotlesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'jotla', habitual: 'jotloi', remote_past: 'jotlvi', imperative: 'jotlesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'uwotla', habitual: 'uwotloi', remote_past: 'uwotlvi', imperative: 'uwotlesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'dunotla', habitual: '/', remote_past: 'anina', imperative: 'dunotloi', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'degotla', habitual: '/', remote_past: 'idina', imperative: 'degotloi', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Uwotla (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwotla", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwotla"
        "SG1" | "" | Tense.HABITUAL        | "agwotloi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwotlesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "jotla"
        "SG2" | "" | Tense.HABITUAL        | "jotloi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jotlesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "uwotla"
        "SG3" | "" | Tense.HABITUAL        | "uwotloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwotlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwotlesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "dunotla"
        // "PL3" | "" | Tense.HABITUAL        | "/"
        "PL3" | "" | Tense.REMOTE_PAST     | "anina"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dunotloi"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "degotla"
        // "PL1INCL" | "" | Tense.HABITUAL        | "/"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "idina"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "degotloi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
