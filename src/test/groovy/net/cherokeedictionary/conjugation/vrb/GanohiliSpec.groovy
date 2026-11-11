package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanohiliSpec extends VerbBaseSpec {
    static def details = [
        definition: "Flying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinoili', habitual: 'jinoilegoi', remote_past: 'aginohilidolvi', imperative: 'jinoilisvi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'hinohili', habitual: 'hinohilegoi', remote_past: 'janohilidolvi', imperative: 'hinohilvsvi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'ganohili', habitual: 'ganohilegoi', remote_past: 'unohilidolvi', imperative: 'ganohilvsvi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'aninohili', habitual: 'aninohilegoi', remote_past: 'uninohilidolvi', imperative: 'aninohilvsvi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'idinohili', habitual: 'idinohilegoi', remote_past: 'iginohilidolvi', imperative: 'idinohilvsvi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Ganohili (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohili", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinoili"
        "SG1" | "" | Tense.HABITUAL        | "jinoilegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohilidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinoilisvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "hinohili"
        "SG2" | "" | Tense.HABITUAL        | "hinohilegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohilidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohilvsvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "ganohili"
        "SG3" | "" | Tense.HABITUAL        | "ganohilegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohilidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohilvsvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "aninohili"
        "PL3" | "" | Tense.HABITUAL        | "aninohilegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohilidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohilvsvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idinohili"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohilegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohilidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinohilvsvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
