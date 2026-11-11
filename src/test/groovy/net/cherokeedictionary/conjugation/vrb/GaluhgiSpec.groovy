package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaluhgiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Arriving, Coming",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiluhgi', habitual: 'jiluhgoi', remote_past: 'agiluhjvi', imperative: 'jiluhga', infinitive: 'agiluhisdi'],
            [subject: 'SG2', object: '', present: 'hiluhgi', habitual: 'hiluhgoi', remote_past: 'jaluhjvi', imperative: 'hiluhga', infinitive: 'jaluhisdi'],
            [subject: 'SG3', object: '', present: 'galuhgi', habitual: 'galuhgoi', remote_past: 'uluhjvi', imperative: 'galuhga', infinitive: 'uluhisdi'],
            [subject: 'PL3', object: '', present: 'aniluhgi', habitual: 'aniluhgoi', remote_past: 'uniluhjvi', imperative: 'aniluhga', infinitive: 'uniluhisdi'],
            [subject: 'PL1INCL', object: '', present: 'idiluhgi', habitual: 'idiluhgoi', remote_past: 'igiluhjvi', imperative: 'idiluhga', infinitive: 'igiluhisdi']
        ]
    ]

    @Unroll
    def "conjugating Galuhgi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galuhgi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiluhgi"
        "SG1" | "" | Tense.HABITUAL        | "jiluhgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiluhjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiluhga"
        "SG1" | "" | Tense.INFINITIVE      | "agiluhisdi"
        "SG2" | "" | Tense.PRESENT         | "hiluhgi"
        "SG2" | "" | Tense.HABITUAL        | "hiluhgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaluhjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiluhga"
        "SG2" | "" | Tense.INFINITIVE      | "jaluhisdi"
        "SG3" | "" | Tense.PRESENT         | "galuhgi"
        "SG3" | "" | Tense.HABITUAL        | "galuhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uluhjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galuhga"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
        "PL3" | "" | Tense.PRESENT         | "aniluhgi"
        "PL3" | "" | Tense.HABITUAL        | "aniluhgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniluhjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniluhga"
        "PL3" | "" | Tense.INFINITIVE      | "uniluhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiluhgi"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiluhgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiluhjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiluhga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiluhisdi"
    }
}
