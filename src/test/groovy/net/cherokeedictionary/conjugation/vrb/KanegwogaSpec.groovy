package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanegwogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its Increasing/Accumulating (140)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'kanegwoga', habitual: 'kanegwogoi', remote_past: 'uhnehgwojvi', imperative: 'hihnehgwogi', infinitive: 'uhnehgwoisdi']
        ]
    ]

    @Unroll
    def "conjugating Kanegwoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanegwoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "kanegwoga"
        "SG3" | "" | Tense.HABITUAL        | "kanegwogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnehgwojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "hihnehgwogi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnehgwoisdi"
    }
}
