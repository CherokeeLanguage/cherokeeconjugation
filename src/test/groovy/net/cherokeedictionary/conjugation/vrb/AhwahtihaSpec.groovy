package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiwahtiha', habitual: 'jiwahtisgoi', remote_past: 'agihwahtvhvi', imperative: 'jiwahta', infinitive: 'agihwahtvhdi'],
            [subject: 'SG2', object: '', present: 'hihwahtiha', habitual: 'hihwahtisgoi', remote_past: 'jahwahtvhvi', imperative: 'hihwahta', infinitive: 'jahwahtvhdi'],
            [subject: 'SG3', object: '', present: 'ahwahtiha', habitual: 'ahwahtisgoi', remote_past: 'uhwahtvhvi', imperative: 'ahwahta', infinitive: 'uhwahtvhdi'],
            [subject: 'PL3', object: '', present: 'anihwahtiha', habitual: 'anihwahtisgoi', remote_past: 'unihwahtvhvi', imperative: 'anihwahta', infinitive: 'unihwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwahtiha"
        "SG1" | "" | Tense.HABITUAL        | "jiwahtisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihwahtvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiwahta"
        "SG1" | "" | Tense.INFINITIVE      | "agihwahtvhdi"
        "SG2" | "" | Tense.PRESENT         | "hihwahtiha"
        "SG2" | "" | Tense.HABITUAL        | "hihwahtisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahwahtvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihwahta"
        "SG2" | "" | Tense.INFINITIVE      | "jahwahtvhdi"
        "SG3" | "" | Tense.PRESENT         | "ahwahtiha"
        "SG3" | "" | Tense.HABITUAL        | "ahwahtisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwahtvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahwahta"
        "SG3" | "" | Tense.INFINITIVE      | "uhwahtvhdi"
        "PL3" | "" | Tense.PRESENT         | "anihwahtiha"
        "PL3" | "" | Tense.HABITUAL        | "anihwahtisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwahtvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihwahta"
        "PL3" | "" | Tense.INFINITIVE      | "unihwahtvhdi"
    }
}
