package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DoyiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Ujvsidiha Restroom (Going To)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'doyi', habitual: 'agwajvsidi', remote_past: 'doyi', imperative: 'agwajvsidisoi', infinitive: 'doyi'],
            [subject: 'SG2', object: '', present: 'doyi', habitual: 'jajvsidi', remote_past: 'doyi', imperative: 'jajvsidisoi', infinitive: 'doyi'],
            [subject: 'SG3', object: '', present: 'doyi', habitual: 'ujvsidi', remote_past: 'doyi', imperative: 'ujvsidisoi', infinitive: 'doyi'],
            [subject: 'PL3', object: '', present: 'doyi', habitual: 'unajvsidi', remote_past: 'doyi', imperative: 'unajvsidisoi', infinitive: 'doyi'],
            [subject: 'PL1INCL', object: '', present: 'doyi', habitual: 'igajvsidi', remote_past: 'doyi', imperative: 'igajvsidisoi', infinitive: 'doyi']
        ]
    ]

    @Unroll
    def "conjugating Doyi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Doyi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "doyi"
        "SG1" | "" | Tense.HABITUAL        | "agwajvsidi"
        "SG1" | "" | Tense.REMOTE_PAST     | "doyi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwajvsidisoi"
        "SG1" | "" | Tense.INFINITIVE      | "doyi"
        "SG2" | "" | Tense.PRESENT         | "doyi"
        "SG2" | "" | Tense.HABITUAL        | "jajvsidi"
        "SG2" | "" | Tense.REMOTE_PAST     | "doyi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jajvsidisoi"
        "SG2" | "" | Tense.INFINITIVE      | "doyi"
        "SG3" | "" | Tense.PRESENT         | "doyi"
        "SG3" | "" | Tense.HABITUAL        | "ujvsidi"
        "SG3" | "" | Tense.REMOTE_PAST     | "doyi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ujvsidisoi"
        "SG3" | "" | Tense.INFINITIVE      | "doyi"
        "PL3" | "" | Tense.PRESENT         | "doyi"
        "PL3" | "" | Tense.HABITUAL        | "unajvsidi"
        "PL3" | "" | Tense.REMOTE_PAST     | "doyi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unajvsidisoi"
        "PL3" | "" | Tense.INFINITIVE      | "doyi"
        "PL1INCL" | "" | Tense.PRESENT         | "doyi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igajvsidi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "doyi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igajvsidisoi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "doyi"
    }
}
