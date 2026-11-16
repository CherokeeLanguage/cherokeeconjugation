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
        "SG1" | "" | Tense.PRESENT         | "gasulea"
        "SG1" | "" | Tense.HABITUAL        | "gasulesgvi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquasulehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasulehvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisulodi"
        "SG2" | "" | Tense.PRESENT         | "hasulea"
        "SG2" | "" | Tense.HABITUAL        | "hasulesgvi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasulehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasulehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasulodi"
        "SG3" | "" | Tense.PRESENT         | "dasulea"
        "SG3" | "" | Tense.HABITUAL        | "dasulesgvi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usulehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asulehvi"
        "SG3" | "" | Tense.INFINITIVE      | "usulodi"
        "PL3" | "" | Tense.PRESENT         | "anasulea"
        "PL3" | "" | Tense.HABITUAL        | "anasulesgvi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unasulehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasulehvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisulodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasulea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasulesgvi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasulehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasulehvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisulodi"
    }
}
