package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnidonaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Standing, They Are (Congregation)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ojidonaa', habitual: 'ojidonaoi', remote_past: 'x', imperative: 'ojidonaesdi', infinitive: 'x']
        ]
    ]

    @Unroll
    def "conjugating Anidonaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anidonaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ojidonaa"
        "SG3" | "" | Tense.HABITUAL        | "ojidonaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "x"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ojidonaesdi"
        "SG3" | "" | Tense.INFINITIVE      | "x"
    }
}
