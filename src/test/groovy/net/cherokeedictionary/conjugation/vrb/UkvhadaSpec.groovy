package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UkvhadaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Foggy (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ukvhada', habitual: 'ukvhadoi', remote_past: 'ukvhadvi', imperative: 'ukvhadesdi', infinitive: 'X']
        ]
    ]

    @Unroll
    def "conjugating Ukvhada (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ukvhada", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ukvhada"
        "SG3" | "" | Tense.HABITUAL        | "ukvhadoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukvhadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ukvhadesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
