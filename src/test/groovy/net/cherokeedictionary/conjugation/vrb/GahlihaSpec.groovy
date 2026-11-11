package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sleeping",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiliha', habitual: 'jilihoi', remote_past: 'X', imperative: 'jilvna', infinitive: 'agihlvnhdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'hihliha', habitual: 'hihlihoi', remote_past: 'hihlvna', imperative: 'jahlvnhdi', infinitive: ''],
            [subject: 'SG2', object: 'SG3IN', present: 'gahliha', habitual: 'gahlihoi', remote_past: 'gahlvna', imperative: 'uhlvnhdi', infinitive: ''],
            [subject: 'SG3', object: 'SG3IN', present: 'anihliha', habitual: 'anihlihoi', remote_past: 'anihlvna', imperative: 'unihlvnhdi', infinitive: ''],
            [subject: 'PL3', object: 'SG3IN', present: 'idihliha', habitual: 'idihlihoi', remote_past: 'idihlvna', imperative: 'igihlvnhdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Gahliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiliha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jilihoi"
        // "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "X"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jilvna"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agihlvnhdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "hihliha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "hihlihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "hihlvna"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "jahlvnhdi"
        // "SG1" | "SG3IN" | Tense.INFINITIVE      | "X"
        "SG2" | "SG3IN" | Tense.PRESENT         | "gahliha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "gahlihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "gahlvna"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "uhlvnhdi"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "X"
        "SG3" | "SG3IN" | Tense.PRESENT         | "anihliha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "anihlihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "anihlvna"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unihlvnhdi"
        // "SG3" | "SG3IN" | Tense.INFINITIVE      | "X"
        "PL3" | "SG3IN" | Tense.PRESENT         | "idihliha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "idihlihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "idihlvna"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "igihlvnhdi"
        // "PL3" | "SG3IN" | Tense.INFINITIVE      | "X"
    }
}
