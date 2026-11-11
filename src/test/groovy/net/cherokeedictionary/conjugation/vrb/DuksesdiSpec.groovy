package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DuksesdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Studying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dagwaksesdi', habitual: 'dagwaksesdoi', remote_past: 'dagwaksestanvi', imperative: 'digaksesda', infinitive: 'digwaksesdohdi'],
            [subject: 'SG2', object: '', present: 'dejaksesdi', habitual: 'dejaksesdoi', remote_past: 'dejaksestanvi', imperative: 'taksesda', infinitive: 'dijaksesdohdi'],
            [subject: 'SG3', object: '', present: 'duksesdi', habitual: 'duksesdoi', remote_past: 'duksestanvi', imperative: 'diksesda', infinitive: 'juksesdohdi'],
            [subject: 'PL3', object: '', present: 'dunaksesdi', habitual: 'dunakesdoi', remote_past: 'dunakestanvi', imperative: 'dinaksesda', infinitive: 'junaksesdohdi'],
            [subject: 'PL1INCL', object: '', present: 'degaksesdi', habitual: 'degaksesdoi', remote_past: 'degaksestanvi', imperative: 'dijaksesda', infinitive: 'digaksesdohdi']
        ]
    ]

    @Unroll
    def "conjugating Duksesdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Duksesdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dagwaksesdi"
        "SG1" | "" | Tense.HABITUAL        | "dagwaksesdoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwaksestanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digaksesda"
        "SG1" | "" | Tense.INFINITIVE      | "digwaksesdohdi"
        "SG2" | "" | Tense.PRESENT         | "dejaksesdi"
        "SG2" | "" | Tense.HABITUAL        | "dejaksesdoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejaksestanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "taksesda"
        "SG2" | "" | Tense.INFINITIVE      | "dijaksesdohdi"
        "SG3" | "" | Tense.PRESENT         | "duksesdi"
        "SG3" | "" | Tense.HABITUAL        | "duksesdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duksestanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "diksesda"
        "SG3" | "" | Tense.INFINITIVE      | "juksesdohdi"
        "PL3" | "" | Tense.PRESENT         | "dunaksesdi"
        "PL3" | "" | Tense.HABITUAL        | "dunakesdoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunakestanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinaksesda"
        "PL3" | "" | Tense.INFINITIVE      | "junaksesdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "degaksesdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "degaksesdoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degaksestanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "dijaksesda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digaksesdohdi"
    }
}
