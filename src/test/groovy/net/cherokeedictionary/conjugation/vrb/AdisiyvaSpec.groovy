package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdisiyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidisiyva', habitual: 'jidisiyvsgoi', remote_past: 'agidisiyvsvi', imperative: 'jidisiyvna', infinitive: 'agidisiyvsdi'],
            [subject: 'SG2', object: '', present: 'hidisiyva', habitual: 'hidisiyvsgoi', remote_past: 'jadisiyvsvi', imperative: 'hidisiyvna', infinitive: 'jadisiyvsdi'],
            [subject: 'SG3', object: '', present: 'adisiyva', habitual: 'adisiyvsgoi', remote_past: 'udisiyvsvi', imperative: 'wadisiyvna', infinitive: 'udisiyvsdi'],
            [subject: 'PL3', object: '', present: 'anidisiyva', habitual: 'anidisiyvsgoi', remote_past: 'unidisiyvsvi', imperative: 'wanidisiyvna', infinitive: 'unidisiyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adisiyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adisiyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidisiyva"
        "SG1" | "" | Tense.HABITUAL        | "jidisiyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidisiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jidisiyvna"
        "SG1" | "" | Tense.INFINITIVE      | "agidisiyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hidisiyva"
        "SG2" | "" | Tense.HABITUAL        | "hidisiyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadisiyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidisiyvna"
        "SG2" | "" | Tense.INFINITIVE      | "jadisiyvsdi"
        "SG3" | "" | Tense.PRESENT         | "adisiyva"
        "SG3" | "" | Tense.HABITUAL        | "adisiyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udisiyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wadisiyvna"
        "SG3" | "" | Tense.INFINITIVE      | "udisiyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anidisiyva"
        "PL3" | "" | Tense.HABITUAL        | "anidisiyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidisiyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanidisiyvna"
        "PL3" | "" | Tense.INFINITIVE      | "unidisiyvsdi"
    }
}
