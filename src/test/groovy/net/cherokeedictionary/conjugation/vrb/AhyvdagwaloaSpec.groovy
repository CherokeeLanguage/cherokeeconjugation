package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyvdagwaloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Thundering (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ahyvdagwaloa', habitual: 'ahyvdagwalosgoi', remote_past: 'uhyvdagwalovi', imperative: 'dvhyvdagwaloi', infinitive: 'uhyvdagwalosdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyvdagwaloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyvdagwaloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahyvdagwaloa"
        "SG3" | "" | Tense.HABITUAL        | "ahyvdagwalosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvdagwalovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvhyvdagwaloi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvdagwalosdi"
    }
}
