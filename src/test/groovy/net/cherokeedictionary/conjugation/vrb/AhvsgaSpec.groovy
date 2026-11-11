package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (neutral) (26)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jivsga', habitual: 'jivsgoi', remote_past: 'agihnvi', imperative: 'jivga', infinitive: 'agihdi'],
            [subject: 'SG2', object: '', present: 'hihvsga', habitual: 'hihvsgoi', remote_past: 'jahnvi', imperative: 'hihvga', infinitive: 'jahdi'],
            [subject: 'SG3', object: '', present: 'ahvsga', habitual: 'ahvsgoi', remote_past: 'uhnvi', imperative: 'wahvga', infinitive: 'uhdi'],
            [subject: 'PL3', object: '', present: 'anihvsga', habitual: 'anihvsgoi', remote_past: 'unihnvi', imperative: 'wanihvga', infinitive: 'unihdi']
        ]
    ]

    @Unroll
    def "conjugating Ahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jivsga"
        "SG1" | "" | Tense.HABITUAL        | "jivsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jivga"
        "SG1" | "" | Tense.INFINITIVE      | "agihdi"
        "SG2" | "" | Tense.PRESENT         | "hihvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihvga"
        "SG2" | "" | Tense.INFINITIVE      | "jahdi"
        "SG3" | "" | Tense.PRESENT         | "ahvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahvga"
        "SG3" | "" | Tense.INFINITIVE      | "uhdi"
        "PL3" | "" | Tense.PRESENT         | "anihvsga"
        "PL3" | "" | Tense.HABITUAL        | "anihvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihvga"
        "PL3" | "" | Tense.INFINITIVE      | "unihdi"
    }
}
