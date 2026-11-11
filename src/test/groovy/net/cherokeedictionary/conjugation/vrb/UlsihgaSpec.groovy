package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlsihgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dark (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ulsihga', habitual: 'ulsihgoi', remote_past: 'ulsihgvi', imperative: 'ulsihgesdi', infinitive: 'X']
        ]
    ]

    @Unroll
    def "conjugating Ulsihga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulsihga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ulsihga"
        "SG3" | "" | Tense.HABITUAL        | "ulsihgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsihgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulsihgesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
    }
}
