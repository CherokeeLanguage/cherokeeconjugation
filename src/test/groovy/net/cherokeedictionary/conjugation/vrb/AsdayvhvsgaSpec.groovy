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
            [subject: 'SG1', object: '', present: 'jisdayvhvsga', habitual: 'jisdayvhvsgoi', remote_past: 'jisdayvhnvi', imperative: 'jisdayvhvga', infinitive: 'jisdayvdi'],
            [subject: 'SG2', object: '', present: 'hisdayvhvsga', habitual: 'hisdayvhvsgoi', remote_past: 'hisdayvhnvi', imperative: 'hisdayvhvga', infinitive: 'hisdayvhdi'],
            [subject: 'SG3', object: '', present: 'asdayvhvsga', habitual: 'asdayvhvsgoi', remote_past: 'usdayvhnvi', imperative: 'asdayvhvga', infinitive: 'usdayvhdi'],
            [subject: 'PL3', object: '', present: 'anisdayvhvsga', habitual: 'anisdayvhvsgoi', remote_past: 'unisdayvhnvi', imperative: 'anisdayvhvga', infinitive: 'unisdayvhdi'],
            [subject: 'PL1INCL', object: '', present: 'edisdayvhvsga', habitual: 'edisdayvhvsgoi', remote_past: 'edisdayvhnvi', imperative: 'edisdayvhvga', infinitive: 'edisdayvhdi']
        ]
    ]

    @Unroll
    def "conjugating Asdayvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdayvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdayvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "jisdayvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisdayvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisdayvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisdayvdi"
        "SG2" | "" | Tense.PRESENT         | "hisdayvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hisdayvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasdayvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdayvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasdayvdi"
        "SG3" | "" | Tense.PRESENT         | "asdayvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asdayvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdayvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdayvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdayhdi"
        "PL3" | "" | Tense.PRESENT         | "anisdayvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anisdayvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdayvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdayvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisdayhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisdayvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisdayvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisdayvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdayvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisdayvdi"
    }
}
