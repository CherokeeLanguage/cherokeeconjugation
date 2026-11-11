package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyahtvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Frosting (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ahyahtvhvsga', habitual: 'ahyahtvhvsgoi', remote_past: 'uhyatvhnvi', imperative: 'dvhyatvhni', infinitive: 'uhyahtvdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyahtvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyahtvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahyahtvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahyahtvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyatvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvhyatvhni"
        "SG3" | "" | Tense.INFINITIVE      | "uhyahtvdi"
    }
}
