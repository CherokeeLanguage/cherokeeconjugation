package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyvdladiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cold (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'uhyvdladi', habitual: 'uhyvdloi', remote_past: 'uhyvdlvi', imperative: 'uhyvdlesdi', infinitive: 'uhyvdladisdi']
        ]
    ]

    @Unroll
    def "conjugating Uhyvdladi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyvdladi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "uhyvdladi"
        "SG3" | "" | Tense.HABITUAL        | "uhyvdloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvdlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhyvdlesdi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvdladisdi"
    }
}
