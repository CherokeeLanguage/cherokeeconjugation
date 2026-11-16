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
        "SG1" | "" | Tense.PRESENT         | "tsidoyi"
        "SG1" | "" | Tense.HABITUAL        | "gutsvsidi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidoyi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidoyi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyi"
        "SG2" | "" | Tense.PRESENT         | "hidoyi"
        "SG2" | "" | Tense.HABITUAL        | "hutsvsidi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadoyi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidoyi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayi"
        "SG3" | "" | Tense.PRESENT         | "doyi"
        "SG3" | "" | Tense.HABITUAL        | "utsvsidi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udoyi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadoyi"
        "SG3" | "" | Tense.INFINITIVE      | "uyi"
        "PL3" | "" | Tense.PRESENT         | "anidoyi"
        "PL3" | "" | Tense.HABITUAL        | "anutsvsidi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidoyi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidoyi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyi"
        "PL1INCL" | "" | Tense.PRESENT         | "ididoyi"
        "PL1INCL" | "" | Tense.HABITUAL        | "idutsvsidi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igidoyi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ididoyi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyi"
    }
}
