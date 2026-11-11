package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class LONGSpec extends VerbBaseSpec {
    static def details = [
        definition: "– SAME AS NEUTRAL",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gohosga', habitual: 'gohosgoi', remote_past: 'uwohosvi', imperative: 'wigohohi', infinitive: 'uwohohisdi']
        ]
    ]

    @Unroll
    def "conjugating LONG (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("LONG", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gohosga"
        "SG1" | "" | Tense.HABITUAL        | "gohosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwohosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigohohi"
        "SG1" | "" | Tense.INFINITIVE      | "uwohohisdi"
    }
}
