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
            [subject: 'SG1', object: '', present: 'degastayesga', habitual: 'degastayesgoi', remote_past: 'dagwastayesvi', imperative: 'digastayehi', infinitive: 'digwastayehisdi'],
            [subject: 'SG2', object: '', present: 'dehastayesga', habitual: 'dehastayesgoi', remote_past: 'dejastayesvi', imperative: 'tastayehi', infinitive: 'dijastayehisdi'],
            [subject: 'SG3', object: '', present: 'dastayesga', habitual: 'dastayesgoi', remote_past: 'dustayesvi', imperative: 'distayehi', infinitive: 'justayehisdi'],
            [subject: 'PL3', object: '', present: 'danastayesga', habitual: 'danastayesgoi', remote_past: 'dunastayesvi', imperative: 'dinastayehi', infinitive: 'junastayehisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedastayesga', habitual: 'dedastayesgoi', remote_past: 'degastayesvi', imperative: 'didastayehi', infinitive: 'digastayehisdi']
        ]
    ]

    @Unroll
    def "conjugating Dastayesga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dastayesga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degastayesga"
        "SG1" | "" | Tense.HABITUAL        | "degastayesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwastayesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digastayehi"
        "SG1" | "" | Tense.INFINITIVE      | "digwastayehisdi"
        "SG2" | "" | Tense.PRESENT         | "dehastayesga"
        "SG2" | "" | Tense.HABITUAL        | "dehastayesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejastayesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tastayehi"
        "SG2" | "" | Tense.INFINITIVE      | "dijastayehisdi"
        "SG3" | "" | Tense.PRESENT         | "dastayesga"
        "SG3" | "" | Tense.HABITUAL        | "dastayesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dustayesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "distayehi"
        "SG3" | "" | Tense.INFINITIVE      | "justayehisdi"
        "PL3" | "" | Tense.PRESENT         | "danastayesga"
        "PL3" | "" | Tense.HABITUAL        | "danastayesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunastayesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinastayehi"
        "PL3" | "" | Tense.INFINITIVE      | "junastayehisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedastayesga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedastayesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degastayesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didastayehi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digastayehisdi"
    }
}
