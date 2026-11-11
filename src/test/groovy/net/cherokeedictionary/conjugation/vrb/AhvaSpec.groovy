package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (neutral) (26)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiva', habitual: 'jivsgoi', remote_past: 'agihvsvi', imperative: 'jivna', infinitive: 'akvsdi'],
            [subject: 'SG2', object: '', present: 'hihva', habitual: 'hihvsgoi', remote_past: 'jahvsvi', imperative: 'hihvna', infinitive: 'jahvsdi'],
            [subject: 'SG3', object: '', present: 'ahva', habitual: 'ahvsgoi', remote_past: 'uhvsvi', imperative: 'wahvna', infinitive: 'uvhsdi'],
            [subject: 'PL3', object: '', present: 'anihva', habitual: 'anihvsgoi', remote_past: 'unihvsi', imperative: 'wanihvna', infinitive: 'unihvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiva"
        "SG1" | "" | Tense.HABITUAL        | "jivsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jivna"
        "SG1" | "" | Tense.INFINITIVE      | "akvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihva"
        "SG2" | "" | Tense.HABITUAL        | "hihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihvna"
        "SG2" | "" | Tense.INFINITIVE      | "jahvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahva"
        "SG3" | "" | Tense.HABITUAL        | "ahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahvna"
        "SG3" | "" | Tense.INFINITIVE      | "uvhsdi"
        "PL3" | "" | Tense.PRESENT         | "anihva"
        "PL3" | "" | Tense.HABITUAL        | "anihvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihvsi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihvna"
        "PL3" | "" | Tense.INFINITIVE      | "unihvsdi"
    }
}
