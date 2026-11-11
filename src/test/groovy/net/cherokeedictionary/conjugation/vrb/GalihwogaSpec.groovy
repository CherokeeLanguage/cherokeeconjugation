package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalihwogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Dying (Animal/Plant)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galihwoga', habitual: 'galihwogoi', remote_past: 'ulihwojvi', imperative: 'dagalihwoji', infinitive: 'ulihwosdi']
        ]
    ]

    @Unroll
    def "conjugating Galihwoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galihwoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galihwoga"
        "SG1" | "" | Tense.HABITUAL        | "galihwogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ulihwojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dagalihwoji"
        "SG1" | "" | Tense.INFINITIVE      | "ulihwosdi"
    }
}
