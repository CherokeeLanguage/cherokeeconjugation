package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Lying Down",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvga', habitual: 'jinvgoi', remote_past: 'x', imperative: 'jinvgesdi', infinitive: 'x']
        ]
    ]

    @Unroll
    def "conjugating Ganhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvga"
        "SG1" | "" | Tense.HABITUAL        | "jinvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvgesdi"
        "SG1" | "" | Tense.INFINITIVE      | "x"
    }
}
