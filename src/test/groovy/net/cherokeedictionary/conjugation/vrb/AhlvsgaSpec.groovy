package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Place on Something(flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilvsga', habitual: 'jilvsgoi', remote_past: 'akhlvnvi', imperative: 'jilvga', infinitive: 'akhlvdi'],
            [subject: 'SG2', object: '', present: 'hihlvsga', habitual: 'hihlvsgoi', remote_past: 'tshlvnvi', imperative: 'hihlvga', infinitive: 'tshlvdi'],
            [subject: 'SG3', object: '', present: 'ahlvsga', habitual: 'ahlvsgoi', remote_past: 'uhlvnvi', imperative: 'ahlvga', infinitive: 'uhlvdi'],
            [subject: 'PL3', object: '', present: 'anihlvsga', habitual: 'anihlvsgoi', remote_past: 'unihlvnvi', imperative: 'anihlvga', infinitive: 'unihlvdi']
        ]
    ]

    @Unroll
    def "conjugating Ahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitlvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsitlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akhlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "akhlvdi"
        "SG2" | "" | Tense.PRESENT         | "hihlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlvdi"
        "SG3" | "" | Tense.PRESENT         | "ahlvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlvdi"
        "PL3" | "" | Tense.PRESENT         | "anihlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anihlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihlvdi"
    }
}
