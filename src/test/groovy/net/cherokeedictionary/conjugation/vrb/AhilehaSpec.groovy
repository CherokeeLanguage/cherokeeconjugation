package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhilehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he Has a Vehicle",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiileha', habitual: 'jiilehoi', remote_past: 'x', imperative: 'x', infinitive: 'agihilvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ahileha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahileha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiileha"
        "SG1" | "" | Tense.HABITUAL        | "jiilehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "x"
        "SG1" | "" | Tense.INFINITIVE      | "agihilvsdi"
    }
}
