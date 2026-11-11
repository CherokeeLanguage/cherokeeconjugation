package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlogilaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cloudy (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ulogila', habitual: 'ulogiloi', remote_past: 'ulogilvi', imperative: 'ulogilesdi', infinitive: 'X']
        ]
    ]

    @Unroll
    def "conjugating Ulogila (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulogila", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ulogila"
        "SG3" | "" | Tense.HABITUAL        | "ulogiloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulogilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulogilesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
