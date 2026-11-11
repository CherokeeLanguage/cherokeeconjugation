package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NaniaSpec extends VerbBaseSpec {
    static def details = [
        definition: "There Are (#)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'nosdia', habitual: 'nosdioi', remote_past: 'X', imperative: 'nosdiesdi', infinitive: 'There'],
            [subject: 'SG2', object: '', present: 'nojia', habitual: 'nojioi', remote_past: 'nojiesdi', imperative: 'There', infinitive: 'Are'],
            [subject: 'SG3', object: '', present: 'nisdia', habitual: 'nisdioi', remote_past: 'nisdiesdi', imperative: 'There', infinitive: 'Are'],
            [subject: 'PL3', object: '', present: 'nijia', habitual: 'nijioi', remote_past: 'nijiesdi', imperative: 'There', infinitive: 'Are'],
            [subject: 'PL1INCL', object: '', present: 'nania', habitual: 'nanioi', remote_past: 'naniesdi', imperative: 'There', infinitive: 'Are']
        ]
    ]

    @Unroll
    def "conjugating Nania (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nania", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "nosdia"
        "SG1" | "" | Tense.HABITUAL        | "nosdioi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "X"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "nosdiesdi"
        "SG1" | "" | Tense.INFINITIVE      | "There"
        "SG2" | "" | Tense.PRESENT         | "nojia"
        "SG2" | "" | Tense.HABITUAL        | "nojioi"
        "SG2" | "" | Tense.REMOTE_PAST     | "nojiesdi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "There"
        "SG2" | "" | Tense.INFINITIVE      | "Are"
        "SG3" | "" | Tense.PRESENT         | "nisdia"
        "SG3" | "" | Tense.HABITUAL        | "nisdioi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nisdiesdi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "There"
        "SG3" | "" | Tense.INFINITIVE      | "Are"
        "PL3" | "" | Tense.PRESENT         | "nijia"
        "PL3" | "" | Tense.HABITUAL        | "nijioi"
        "PL3" | "" | Tense.REMOTE_PAST     | "nijiesdi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "There"
        "PL3" | "" | Tense.INFINITIVE      | "Are"
        "PL1INCL" | "" | Tense.PRESENT         | "nania"
        "PL1INCL" | "" | Tense.HABITUAL        | "nanioi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "naniesdi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "There"
        "PL1INCL" | "" | Tense.INFINITIVE      | "Are"
    }
}
