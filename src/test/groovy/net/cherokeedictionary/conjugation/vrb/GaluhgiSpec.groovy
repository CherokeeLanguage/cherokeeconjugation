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
        "SG1" | "" | Tense.PRESENT         | "tsilugi"
        "SG1" | "" | Tense.HABITUAL        | "tsilugoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilutsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilutsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiluhisdi"
        "SG2" | "" | Tense.PRESENT         | "hilugi"
        "SG2" | "" | Tense.HABITUAL        | "hilugoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalutsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilutsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaluhisdi"
        "SG3" | "" | Tense.PRESENT         | "galugi"
        "SG3" | "" | Tense.HABITUAL        | "galugoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulutsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galutsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uluhisdi"
        "PL3" | "" | Tense.PRESENT         | "anilugi"
        "PL3" | "" | Tense.HABITUAL        | "anilugoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilutsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilutsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniluhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilugi"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilugoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilutsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilutsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiluhisdi"
    }
}
