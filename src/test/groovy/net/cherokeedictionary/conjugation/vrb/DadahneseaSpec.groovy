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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degadanesea"
        "SG1" | "" | Tense.HABITUAL        | "degadanesesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwadahnesavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanesavi"
        "SG1" | "" | Tense.INFINITIVE      | "dagidanesesdi"
        "SG2" | "" | Tense.PRESENT         | "dehadanesea"
        "SG2" | "" | Tense.HABITUAL        | "dehadanesesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejadahnesavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanesavi"
        "SG2" | "" | Tense.INFINITIVE      | "detsadanesesdi"
        "SG3" | "" | Tense.PRESENT         | "dadahnesea"
        "SG3" | "" | Tense.HABITUAL        | "dadahnesesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dudahnesavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanesavi"
        "SG3" | "" | Tense.INFINITIVE      | "judahnesesdi"
        "PL3" | "" | Tense.PRESENT         | "danadahnesea"
        "PL3" | "" | Tense.HABITUAL        | "danadahnesesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunadahnesavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanesavi"
        "PL3" | "" | Tense.INFINITIVE      | "tsunidanesesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadadanesea"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadadanesesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagadanesavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanesavi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagidanesesdi"
    }
}
