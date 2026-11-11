package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdisiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidisiyaa', habitual: 'jidisiyasgoi', remote_past: 'akdisiyvi', imperative: 'jidisiya', infinitive: 'akdisiyasdi'],
            [subject: 'SG2', object: '', present: 'hidisiyaa', habitual: 'hidisiyasgoi', remote_past: 'tsdisiyvi', imperative: 'hidisiya', infinitive: 'tsdisiyasdi'],
            [subject: 'SG3', object: '', present: 'adisiyaa', habitual: 'adisiyasgoi', remote_past: 'udisiyvi', imperative: 'adisiya', infinitive: 'udisiyasdi'],
            [subject: 'PL3', object: '', present: 'anidisiyaa', habitual: 'anidisaysgoi', remote_past: 'unidisiyvi', imperative: 'anidisiya', infinitive: 'unidisiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Adisiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adisiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidisiyaa"
        "SG1" | "" | Tense.HABITUAL        | "jidisiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdisiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jidisiya"
        "SG1" | "" | Tense.INFINITIVE      | "akdisiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hidisiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hidisiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdisiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidisiya"
        "SG2" | "" | Tense.INFINITIVE      | "tsdisiyasdi"
        "SG3" | "" | Tense.PRESENT         | "adisiyaa"
        "SG3" | "" | Tense.HABITUAL        | "adisiyasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udisiyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adisiya"
        "SG3" | "" | Tense.INFINITIVE      | "udisiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anidisiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anidisaysgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidisiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidisiya"
        "PL3" | "" | Tense.INFINITIVE      | "unidisiyasdi"
    }
}
