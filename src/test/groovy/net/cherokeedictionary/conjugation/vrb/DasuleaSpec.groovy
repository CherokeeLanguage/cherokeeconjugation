package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasuleaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Washing His/Her Hands",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degasulea', habitual: 'degasulesgvi', remote_past: 'dagwasulehvi', imperative: 'digasuli', infinitive: 'diksuhldi'],
            [subject: 'SG2', object: '', present: 'dehasulea', habitual: 'dehasulesgvi', remote_past: 'dejasulehvi', imperative: 'tasuli', infinitive: 'ditsuhldi'],
            [subject: 'SG3', object: '', present: 'dasulea', habitual: 'dasulesgvi', remote_past: 'dusulehvi', imperative: 'disuli', infinitive: 'jusuhldi'],
            [subject: 'PL3', object: '', present: 'danasulea', habitual: 'danasulesgvi', remote_past: 'dunasulehvi', imperative: 'dinasuli', infinitive: 'junsuhldi'],
            [subject: 'PL1INCL', object: '', present: 'dedasulea', habitual: 'dedasulesgvi', remote_past: 'degasulehvi', imperative: 'didasuli', infinitive: 'digasuhldi']
        ]
    ]

    @Unroll
    def "conjugating Dasulea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasulea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degasulea"
        "SG1" | "" | Tense.HABITUAL        | "degasulesgvi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwasulehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digasuli"
        "SG1" | "" | Tense.INFINITIVE      | "diksuhldi"
        "SG2" | "" | Tense.PRESENT         | "dehasulea"
        "SG2" | "" | Tense.HABITUAL        | "dehasulesgvi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejasulehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tasuli"
        "SG2" | "" | Tense.INFINITIVE      | "ditsuhldi"
        "SG3" | "" | Tense.PRESENT         | "dasulea"
        "SG3" | "" | Tense.HABITUAL        | "dasulesgvi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dusulehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "disuli"
        "SG3" | "" | Tense.INFINITIVE      | "jusuhldi"
        "PL3" | "" | Tense.PRESENT         | "danasulea"
        "PL3" | "" | Tense.HABITUAL        | "danasulesgvi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunasulehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinasuli"
        "PL3" | "" | Tense.INFINITIVE      | "junsuhldi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedasulea"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedasulesgvi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degasulehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didasuli"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digasuhldi"
    }
}
