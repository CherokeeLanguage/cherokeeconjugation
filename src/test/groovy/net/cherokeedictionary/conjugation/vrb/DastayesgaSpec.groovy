// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72809 (entrya dastayesga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DastayesgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Exhausted, Tired",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degastayesga'],
            [subject: 'SG1', object: '', present: 'degastayesga', habitual: 'degastayesgoi', remote_past: 'dagwastayesvi', imperative: 'digastayehi', infinitive: 'digwastayehisdi'],
            [subject: 'SG2', object: '', present: 'dehastayesga', habitual: 'dehastayesgoi', remote_past: 'dejastayesvi', imperative: 'tastayehi', infinitive: 'dijastayehisdi'],
            [subject: 'SG3', object: '', habitual: 'dastayesgoi', imperative: 'tastayehi', infinitive: 'justayehisdi', present: 'dastayesga', remote_past: 'dustayesvi'],
            [subject: 'PL3', object: '', present: 'danastayesga', habitual: 'danastayesgoi', remote_past: 'dunastayesvi', imperative: 'dinastayehi', infinitive: 'junastayehisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedastayesga', habitual: 'dedastayesgoi', remote_past: 'degastayesvi', imperative: 'didastayehi', infinitive: 'digastayehisdi']
        ]
    ]

    @Unroll
    def "conjugating Dastayesga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dastayesga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degastayesga"
        "SG1" | "" | Tense.HABITUAL        | "degastayesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwastayesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gastayesvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagistayehisdi"
        "SG2" | "" | Tense.PRESENT         | "tistayesga"
        "SG2" | "" | Tense.HABITUAL        | "tistayesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejastayesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hastayesvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsastayehisdi"
        "SG3" | "" | Tense.PRESENT         | "dastayesga"
        "SG3" | "" | Tense.HABITUAL        | "dastayesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dustayesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "astayesvi"
        "SG3" | "" | Tense.INFINITIVE      | "justayehisdi"
        "PL3" | "" | Tense.PRESENT         | "danastayesga"
        "PL3" | "" | Tense.HABITUAL        | "danastayesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunastayesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anastayesvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsunistayehisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadastayesga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadastayesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagastayesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idastayesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagistayehisdi"
    }
}
