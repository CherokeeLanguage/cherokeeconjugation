package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Smells",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'asvga', habitual: 'asvgoi', remote_past: 'asvgvi', imperative: 'asvgesdi', infinitive: 'It']
        ]
    ]

    @Unroll
    def "conjugating Asvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "asvga"
        "SG3" | "" | Tense.HABITUAL        | "asvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "asvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asvgesdi"
        "SG3" | "" | Tense.INFINITIVE      | "It"
    }
}
