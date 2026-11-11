package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnesahyvdlaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cool (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'unesahyvdla', habitual: 'unesahyvdloi', remote_past: 'unesahyvdlvi', imperative: 'unesahyvdlesdi', infinitive: 'unesahyvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Unesahyvdla (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unesahyvdla", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "unesahyvdla"
        "SG3" | "" | Tense.HABITUAL        | "unesahyvdloi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unesahyvdlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unesahyvdlesdi"
        "SG3" | "" | Tense.INFINITIVE      | "unesahyvdisdi"
    }
}
