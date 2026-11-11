package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Standing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidoga', habitual: 'jidogoi', remote_past: 'x', imperative: 'wijidogesdi', infinitive: 'X'],
            [subject: 'PL3', object: '', present: 'danidoga', habitual: '/', remote_past: 'anidonaa', imperative: 'danidogoi', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'dedidoga', habitual: '/', remote_past: 'ididonaa', imperative: 'dedidogoi', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Gadoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidoga"
        "SG1" | "" | Tense.HABITUAL        | "jidogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijidogesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "danidoga"
        // "PL3" | "" | Tense.HABITUAL        | "/"
        "PL3" | "" | Tense.REMOTE_PAST     | "anidonaa"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "danidogoi"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "dedidoga"
        // "PL1INCL" | "" | Tense.HABITUAL        | "/"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "ididonaa"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "dedidogoi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
