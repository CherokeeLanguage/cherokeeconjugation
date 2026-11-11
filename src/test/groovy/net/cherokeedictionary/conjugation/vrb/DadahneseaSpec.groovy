package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DadahneseaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Conjuring",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degadanesea', habitual: 'degadanesesgoi', remote_past: 'dagwadahnesavi', imperative: 'digadanesaga', infinitive: 'digwadahnesesdi'],
            [subject: 'SG2', object: '', present: 'dehadahnesea', habitual: 'dehadahnesesgoi', remote_past: 'dejadahnesavi', imperative: 'tadahnesaga', infinitive: 'dijadahnesesdi'],
            [subject: 'SG3', object: '', present: 'dadahnesea', habitual: 'dadahnesesgoi', remote_past: 'dudahnesavi', imperative: 'didahnesaga', infinitive: 'judahnesesdi'],
            [subject: 'PL3', object: '', present: 'danadahnesea', habitual: 'danadahnesesgoi', remote_past: 'dunadahnesavi', imperative: 'dinadahnesaga', infinitive: 'junadahnesesdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadahnesea', habitual: 'dedadahnesesgoi', remote_past: 'degadahnesavi', imperative: 'didadahnesaga', infinitive: 'digadahnesesdi']
        ]
    ]

    @Unroll
    def "conjugating Dadahnesea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dadahnesea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degadanesea"
        "SG1" | "" | Tense.HABITUAL        | "degadanesesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwadahnesavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digadanesaga"
        "SG1" | "" | Tense.INFINITIVE      | "digwadahnesesdi"
        "SG2" | "" | Tense.PRESENT         | "dehadahnesea"
        "SG2" | "" | Tense.HABITUAL        | "dehadahnesesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejadahnesavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tadahnesaga"
        "SG2" | "" | Tense.INFINITIVE      | "dijadahnesesdi"
        "SG3" | "" | Tense.PRESENT         | "dadahnesea"
        "SG3" | "" | Tense.HABITUAL        | "dadahnesesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dudahnesavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "didahnesaga"
        "SG3" | "" | Tense.INFINITIVE      | "judahnesesdi"
        "PL3" | "" | Tense.PRESENT         | "danadahnesea"
        "PL3" | "" | Tense.HABITUAL        | "danadahnesesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunadahnesavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinadahnesaga"
        "PL3" | "" | Tense.INFINITIVE      | "junadahnesesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedadahnesea"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedadahnesesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degadahnesavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didadahnesaga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digadahnesesdi"
    }
}
