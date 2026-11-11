package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyogiSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Breaking",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ayogi', habitual: 'ayogoi', remote_past: 'uyojvi', imperative: 'dvyoji', infinitive: 'uyoysdi']
        ]
    ]

    @Unroll
    def "conjugating Ayogi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayogi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ayogi"
        "SG3" | "" | Tense.HABITUAL        | "ayogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvyoji"
        "SG3" | "" | Tense.INFINITIVE      | "uyoysdi"
    }
}
