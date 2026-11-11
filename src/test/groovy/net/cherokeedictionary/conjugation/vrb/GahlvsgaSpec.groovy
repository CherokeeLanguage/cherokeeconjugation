package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilvsga', habitual: 'jilvsgoi', remote_past: 'agihlvanvi', imperative: 'jilvga', infinitive: 'agihldi'],
            [subject: 'SG2', object: '', present: 'hihlvsga', habitual: 'hihlvsgoi', remote_past: 'jahlanvi', imperative: 'hihlvga', infinitive: 'jahldi'],
            [subject: 'SG1', object: '', present: 'gahlvsga', habitual: 'gahlvsgoi', remote_past: 'uhlanvi', imperative: 'wigahlvga', infinitive: 'uhldi'],
            [subject: 'PL3', object: '', present: 'anihlvsga', habitual: 'anihlvsgoi', remote_past: 'unihlanvi', imperative: 'wanihlvga', infinitive: 'unihldi']
        ]
    ]

    @Unroll
    def "conjugating Gahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihlvanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilvga"
        "SG1" | "" | Tense.INFINITIVE      | "agihldi"
        "SG2" | "" | Tense.PRESENT         | "hihlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlvga"
        "SG2" | "" | Tense.INFINITIVE      | "jahldi"
        "SG1" | "" | Tense.PRESENT         | "gahlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gahlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigahlvga"
        "SG1" | "" | Tense.INFINITIVE      | "uhldi"
        "PL3" | "" | Tense.PRESENT         | "anihlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anihlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihlvga"
        "PL3" | "" | Tense.INFINITIVE      | "unihldi"
    }
}
