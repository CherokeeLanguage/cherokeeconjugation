package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GutihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Snowing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gutiha', habitual: 'gutihoi', remote_past: 'uwutahnvi', imperative: 'dagutahni', infinitive: 'uwutodi']
        ]
    ]

    @Unroll
    def "conjugating Gutiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gutiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gutiha"
        "SG1" | "" | Tense.HABITUAL        | "gutihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwutahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dagutahni"
        "SG1" | "" | Tense.INFINITIVE      | "uwutodi"
    }
}
