package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UditlegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hot (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'uditlega', habitual: 'uditlegoi', remote_past: 'uditlegvi', imperative: 'uditlegesdi', infinitive: 'uganawohisdi']
        ]
    ]

    @Unroll
    def "conjugating Uditlega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uditlega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "uditlega"
        "SG3" | "" | Tense.HABITUAL        | "uditlegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uditlegvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uditlegesdi"
        "SG3" | "" | Tense.INFINITIVE      | "uganawohisdi"
    }
}
