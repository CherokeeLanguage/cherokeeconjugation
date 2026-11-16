// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72739 (entrya dadahnesea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'degadanesea'],
            [subject: 'SG1', object: '', present: 'degadanesea', habitual: 'degadanesesgoi', remote_past: 'dagwadahnesavi', imperative: 'digadanesaga', infinitive: 'digwadahnesesdi'],
            [subject: 'SG2', object: '', present: 'dehadahnesea', habitual: 'dehadahnesesgoi', remote_past: 'dejadahnesavi', imperative: 'tadahnesaga', infinitive: 'dijadahnesesdi'],
            [subject: 'SG3', object: '', habitual: 'dadahnesesgoi', imperative: 'tadahnesaga', infinitive: 'judahnesesdi', present: 'dadahnesea', remote_past: 'dudahnesavi'],
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
        "SG1" | "" | Tense.PRESENT         | "gadanesea"
        "SG1" | "" | Tense.HABITUAL        | "gadanesesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanesavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanesavi"
        "SG1" | "" | Tense.INFINITIVE      | "agidanesesdi"
        "SG2" | "" | Tense.PRESENT         | "hadanesea"
        "SG2" | "" | Tense.HABITUAL        | "hadanesesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanesavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanesavi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanesesdi"
        "SG3" | "" | Tense.PRESENT         | "dadanesea"
        "SG3" | "" | Tense.HABITUAL        | "dadanesesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanesavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanesavi"
        "SG3" | "" | Tense.INFINITIVE      | "udanesesdi"
        "PL3" | "" | Tense.PRESENT         | "anadanesea"
        "PL3" | "" | Tense.HABITUAL        | "anadanesesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanesavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanesavi"
        "PL3" | "" | Tense.INFINITIVE      | "unidanesesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanesea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanesesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanesavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanesavi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igidanesesdi"
    }
}
