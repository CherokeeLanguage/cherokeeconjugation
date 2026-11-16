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
        "SG1" | "" | Tense.PRESENT         | "aquagisesdi"
        "SG1" | "" | Tense.HABITUAL        | "aquagisesdoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquagisestanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquagisestanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigisesdodi"
        "SG2" | "" | Tense.PRESENT         | "tsagisesdi"
        "SG2" | "" | Tense.HABITUAL        | "tsagisesdoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagisestanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsagisestanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagisesdodi"
        "SG3" | "" | Tense.PRESENT         | "dugisesdi"
        "SG3" | "" | Tense.HABITUAL        | "dugisesdoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dugisestanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dugisestanvi"
        "SG3" | "" | Tense.INFINITIVE      | "dugisesdodi"
        "PL3" | "" | Tense.PRESENT         | "unagisesdi"
        "PL3" | "" | Tense.HABITUAL        | "unagisesdoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unagisestanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unagisestanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigisesdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "igagisesdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igagisesdoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igagisestanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igagisestanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigisesdodi"
    }
}
