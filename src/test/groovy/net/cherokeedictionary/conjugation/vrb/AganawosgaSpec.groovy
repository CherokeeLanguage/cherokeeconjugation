package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AganawosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Warm (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'aganawosga', habitual: 'aganawosgoi', remote_past: 'aganawosgvi', imperative: 'dvganawosi', infinitive: 'uganawosdi']
        ]
    ]

    @Unroll
    def "conjugating Aganawosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aganawosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "aganawosga"
        "SG3" | "" | Tense.HABITUAL        | "aganawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "aganawosgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvganawosi"
        "SG3" | "" | Tense.INFINITIVE      | "uganawosdi"
    }
}
