package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyega', habitual: 'jiyegoi', remote_past: 'akiyvsvi', imperative: 'wijiyvga', infinitive: 'akiyvsdi'],
            [subject: 'SG2', object: '', present: 'hihyega', habitual: 'hihyegoi', remote_past: 'chayvsvi', imperative: 'hwihyvga', infinitive: 'chayvsdi'],
            [subject: 'SG3', object: '', present: 'ahyega', habitual: 'ahyegoi', remote_past: 'uhyvsvi', imperative: 'wahyvga', infinitive: 'uhyvsdi'],
            [subject: 'PL3', object: '', present: 'anihyega', habitual: 'anihyegoi', remote_past: 'unihyvsvi', imperative: 'anihyvga', infinitive: 'unihyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyega"
        "SG1" | "" | Tense.HABITUAL        | "jiyegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijiyvga"
        "SG1" | "" | Tense.INFINITIVE      | "akiyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihyega"
        "SG2" | "" | Tense.HABITUAL        | "hihyegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "chayvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwihyvga"
        "SG2" | "" | Tense.INFINITIVE      | "chayvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahyega"
        "SG3" | "" | Tense.HABITUAL        | "ahyegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahyvga"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihyega"
        "PL3" | "" | Tense.HABITUAL        | "anihyegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihyvga"
        "PL3" | "" | Tense.INFINITIVE      | "unihyvsdi"
    }
}
