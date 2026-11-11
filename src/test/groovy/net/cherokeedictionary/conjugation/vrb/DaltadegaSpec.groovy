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
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwahltadinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digalitaduga"
        "SG1" | "" | Tense.INFINITIVE      | "digwahltadinvdi"
        "SG2" | "" | Tense.PRESENT         | "dehaltadega"
        "SG2" | "" | Tense.HABITUAL        | "dehaltadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejahltadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tahltaduga"
        "SG2" | "" | Tense.INFINITIVE      | "dijahltadinvdi"
        "SG3" | "" | Tense.PRESENT         | "daltadega"
        "SG3" | "" | Tense.HABITUAL        | "daltadegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhltadinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "diltaduga"
        "SG3" | "" | Tense.INFINITIVE      | "juhltadinvdi"
        "PL3" | "" | Tense.PRESENT         | "danaltadega"
        "PL3" | "" | Tense.HABITUAL        | "danaltadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunahltadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinahltaduga"
        "PL3" | "" | Tense.INFINITIVE      | "junahltadinvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedaltadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedaltadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degahltadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didaltaduga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digahltadinvdi"
    }
}
