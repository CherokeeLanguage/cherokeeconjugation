package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdayvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Cooking Him/Her a Meal",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisdayvhvsga', habitual: 'jisdayvhvsgoi', remote_past: 'jisdayvhnvi', imperative: 'jisdayvhvga', infinitive: 'jisdaydi'],
            [subject: 'SG2', object: '', present: 'hisdayvhvsga', habitual: 'hisdayvhvsgoi', remote_past: 'hisdayvhnvi', imperative: 'hisdayvhvga', infinitive: 'hisdayhdi'],
            [subject: 'SG3', object: '', present: 'asdayvhvsga', habitual: 'asdayvhvsgoi', remote_past: 'usdayvhnvi', imperative: 'asdayvhvga', infinitive: 'usdayhdi'],
            [subject: 'PL3', object: '', present: 'anisdayvhvsga', habitual: 'anisdayvhvsgoi', remote_past: 'unisdayvhnvi', imperative: 'anisdayvhvga', infinitive: 'unisdayhdi'],
            [subject: 'PL1INCL', object: '', present: 'edisdayvhvsga', habitual: 'edisdayvhvsgoi', remote_past: 'edisdayvhnvi', imperative: 'edisdayvhvga', infinitive: 'edisdayhdi']
        ]
    ]

    @Unroll
    def "conjugating Asdayvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdayvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdayvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "jisdayvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jisdayvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisdayvhvga"
        "SG1" | "" | Tense.INFINITIVE      | "jisdaydi"
        "SG2" | "" | Tense.PRESENT         | "hisdayvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hisdayvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hisdayvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdayvhvga"
        "SG2" | "" | Tense.INFINITIVE      | "hisdayhdi"
        "SG3" | "" | Tense.PRESENT         | "asdayvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asdayvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdayvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdayvhvga"
        "SG3" | "" | Tense.INFINITIVE      | "usdayhdi"
        "PL3" | "" | Tense.PRESENT         | "anisdayvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anisdayvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdayvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdayvhvga"
        "PL3" | "" | Tense.INFINITIVE      | "unisdayhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edisdayvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "edisdayvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edisdayvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edisdayvhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edisdayhdi"
    }
}
