package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktenohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking (Around)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jigatenoha', habitual: 'jigatenohoi', remote_past: 'agwaktenolvi', imperative: 'jigatenaga', infinitive: 'agwaktenasdi'],
            [subject: 'SG2', object: '', present: 'haktenoha', habitual: 'haktenohoi', remote_past: 'jaktenolvi', imperative: 'hiktenaga', infinitive: 'jaktenasdi'],
            [subject: 'SG3', object: '', present: 'aktenoha', habitual: 'aktenohoi', remote_past: 'uktenolvi', imperative: 'aktenaga', infinitive: 'uktenasdi'],
            [subject: 'PL3', object: '', present: 'anaktenoha', habitual: 'anaktenohoi', remote_past: 'unaktenolvi', imperative: 'anaktenaga', infinitive: 'unaktenasdi'],
            [subject: 'PL1INCL', object: '', present: 'idaktenoha', habitual: 'idaktenohoi', remote_past: 'igaktenolvi', imperative: 'idaktenaga', infinitive: 'igaktenasdi']
        ]
    ]

    @Unroll
    def "conjugating Aktenoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktenoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jigatenoha"
        "SG1" | "" | Tense.HABITUAL        | "jigatenohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwaktenolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jigatenaga"
        "SG1" | "" | Tense.INFINITIVE      | "agwaktenasdi"
        "SG2" | "" | Tense.PRESENT         | "haktenoha"
        "SG2" | "" | Tense.HABITUAL        | "haktenohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaktenolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiktenaga"
        "SG2" | "" | Tense.INFINITIVE      | "jaktenasdi"
        "SG3" | "" | Tense.PRESENT         | "aktenoha"
        "SG3" | "" | Tense.HABITUAL        | "aktenohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uktenolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aktenaga"
        "SG3" | "" | Tense.INFINITIVE      | "uktenasdi"
        "PL3" | "" | Tense.PRESENT         | "anaktenoha"
        "PL3" | "" | Tense.HABITUAL        | "anaktenohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaktenolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anaktenaga"
        "PL3" | "" | Tense.INFINITIVE      | "unaktenasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaktenoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaktenohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaktenolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaktenaga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaktenasdi"
    }
}
