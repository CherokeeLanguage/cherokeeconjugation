package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnagalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lightning (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'anagaliha', habitual: 'anagalisgoi', remote_past: 'unagalvhvi', imperative: 'dvnagalvhi', infinitive: 'x']
        ]
    ]

    @Unroll
    def "conjugating Anagaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anagaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "anagaliha"
        "SG3" | "" | Tense.HABITUAL        | "anagalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unagalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvnagalvhi"
        "SG3" | "" | Tense.INFINITIVE      | "x"
    }
}
