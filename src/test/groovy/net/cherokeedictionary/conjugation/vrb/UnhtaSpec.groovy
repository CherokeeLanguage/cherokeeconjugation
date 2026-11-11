package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnhtaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Know",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwanhta', habitual: 'agwanhtoi', remote_past: 'agwanhtvi', imperative: 'agwantesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'janhta', habitual: 'janhtoi', remote_past: 'janhtvi', imperative: 'jantesdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'unhta', habitual: 'unhtoi', remote_past: 'unhtvi', imperative: 'untesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'unanhta', habitual: 'unanhtoi', remote_past: 'unanhtvi', imperative: 'unantesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'iganhta', habitual: 'iganhtoi', remote_past: 'iganhtvi', imperative: 'igantesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Unhta (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unhta", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwanhta"
        "SG1" | "" | Tense.HABITUAL        | "agwanhtoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwanhtvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwantesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "janhta"
        "SG2" | "" | Tense.HABITUAL        | "janhtoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhtvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jantesdi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "unhta"
        "SG3" | "" | Tense.HABITUAL        | "unhtoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unhtvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "untesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unanhta"
        "PL3" | "" | Tense.HABITUAL        | "unanhtoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanhtvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unantesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "iganhta"
        "PL1INCL" | "" | Tense.HABITUAL        | "iganhtoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganhtvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igantesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
