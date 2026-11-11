package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdalenihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Beginning/Starting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'adaleniha', habitual: 'adalenisgoi', remote_past: 'udalenvhvi', imperative: 'dvdalenvhi', infinitive: 'udalenhdi']
        ]
    ]

    @Unroll
    def "conjugating Adaleniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adaleniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "adaleniha"
        "SG3" | "" | Tense.HABITUAL        | "adalenisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udalenvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvdalenvhi"
        "SG3" | "" | Tense.INFINITIVE      | "udalenhdi"
    }
}
