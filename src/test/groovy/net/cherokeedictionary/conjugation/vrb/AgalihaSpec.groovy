package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shining (Moon/Sun Is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'agaliha', habitual: 'agalisgoi', remote_past: 'ugalisvi', imperative: 'dvgalisi', infinitive: 'ugalihisdi']
        ]
    ]

    @Unroll
    def "conjugating Agaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "agaliha"
        "SG3" | "" | Tense.HABITUAL        | "agalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugalisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvgalisi"
        "SG3" | "" | Tense.INFINITIVE      | "ugalihisdi"
    }
}
