package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtihnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatihneha', habitual: 'jiyatihnehoi', remote_past: 'x', imperative: 'x', infinitive: 'jiyatihnvdi']
        ]
    ]

    @Unroll
    def "conjugating Atihneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atihneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatihneha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatihnehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "x"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "x"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatihnvdi"
    }
}
