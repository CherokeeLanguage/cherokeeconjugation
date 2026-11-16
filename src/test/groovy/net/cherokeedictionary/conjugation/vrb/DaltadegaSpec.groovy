package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DaltadegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Jumping",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degalitadega', habitual: 'degalitadegoi', remote_past: 'dagwahltadinvsvi', imperative: 'digalitaduga', infinitive: 'digwahltadinvdi'],
            [subject: 'SG2', object: '', present: 'dehaltadega', habitual: 'dehaltadegoi', remote_past: 'dejahltadinvsvi', imperative: 'tahltaduga', infinitive: 'dijahltadinvdi'],
            [subject: 'SG3', object: '', present: 'daltadega', habitual: 'daltadegoi', remote_past: 'duhltadinvsvi', imperative: 'diltaduga', infinitive: 'juhltadinvdi'],
            [subject: 'PL3', object: '', present: 'danaltadega', habitual: 'danaltadegoi', remote_past: 'dunahltadinvsvi', imperative: 'dinahltaduga', infinitive: 'junahltadinvdi'],
            [subject: 'PL1INCL', object: '', present: 'dedaltadega', habitual: 'dedaltadegoi', remote_past: 'degahltadinvsvi', imperative: 'didaltaduga', infinitive: 'digahltadinvdi']
        ]
    ]

    @Unroll
    def "conjugating Daltadega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Daltadega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalitadega"
        "SG1" | "" | Tense.HABITUAL        | "degalitadegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualotadinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galotadinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilotadinvdi"
        "SG2" | "" | Tense.PRESENT         | "dehaltadega"
        "SG2" | "" | Tense.HABITUAL        | "dehaltadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalotadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halotadinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalotadinvdi"
        "SG3" | "" | Tense.PRESENT         | "daltadega"
        "SG3" | "" | Tense.HABITUAL        | "daltadegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulotadinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alotadinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulotadinvdi"
        "PL3" | "" | Tense.PRESENT         | "danaltadega"
        "PL3" | "" | Tense.HABITUAL        | "danaltadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalotadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analotadinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilotadinvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedaltadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedaltadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalotadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalotadinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilotadinvdi"
    }
}
