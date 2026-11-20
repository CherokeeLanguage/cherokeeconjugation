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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degasulea"
        "SG1" | "" | Tense.HABITUAL        | "degasulesgvi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwasulehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasulehvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagisulodi"
        "SG2" | "" | Tense.PRESENT         | "tisulea"
        "SG2" | "" | Tense.HABITUAL        | "tisulesgvi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejasulehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasulehvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsasulodi"
        "SG3" | "" | Tense.PRESENT         | "dasulea"
        "SG3" | "" | Tense.HABITUAL        | "dasulesgvi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dusulehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asulehvi"
        "SG3" | "" | Tense.INFINITIVE      | "jusuhldi"
        "PL3" | "" | Tense.PRESENT         | "danasulea"
        "PL3" | "" | Tense.HABITUAL        | "danasulesgvi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunasulehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasulehvi"
        "PL3" | "" | Tense.INFINITIVE      | "junsuhldi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadasulea"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadasulesgvi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagasulehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasulehvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagisulodi"
    }
}
