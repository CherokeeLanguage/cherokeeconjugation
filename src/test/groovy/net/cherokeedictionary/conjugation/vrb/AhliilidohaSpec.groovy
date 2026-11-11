package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhliilidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its Taking Time (22)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ahliilidoha', habitual: 'ahliilidohoi', remote_past: 'uhliilidolvi', imperative: 'dvhliilidoli', infinitive: 'uhliilidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahliilidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahliilidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahliilidoha"
        "SG3" | "" | Tense.HABITUAL        | "ahliilidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhliilidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvhliilidoli"
        "SG3" | "" | Tense.INFINITIVE      | "uhliilidasdi"
    }
}
