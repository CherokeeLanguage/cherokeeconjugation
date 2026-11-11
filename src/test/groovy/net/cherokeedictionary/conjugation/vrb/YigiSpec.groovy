package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class YigiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Is Not / Was / Will Be",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'tla', habitual: 'yigi', remote_past: 'gesoi', imperative: 'jigesvi', infinitive: 'gesesdi']
        ]
    ]

    @Unroll
    def "conjugating Yigi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Yigi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "tla"
        "SG3" | "" | Tense.HABITUAL        | "yigi"
        "SG3" | "" | Tense.REMOTE_PAST     | "gesoi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jigesvi"
        "SG3" | "" | Tense.INFINITIVE      | "gesesdi"
    }
}
