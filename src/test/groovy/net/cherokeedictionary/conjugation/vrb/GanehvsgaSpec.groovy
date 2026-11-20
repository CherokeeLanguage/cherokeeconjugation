package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinevsga', habitual: 'jinevsgoi', remote_past: 'aginehnvi', imperative: 'jinevga', infinitive: 'aginehdi'],
            [subject: 'SG2', object: '', present: 'hinehvsga', habitual: 'hinehvsgoi', remote_past: 'janehnvi', imperative: 'hinehvga', infinitive: 'janehdi'],
            [subject: 'SG3', object: '', present: 'ganehvsga', habitual: 'ganehvsgoi', remote_past: 'unehnvi', imperative: 'wiganehvga', infinitive: 'unehdi'],
            [subject: 'PL3', object: '', present: 'aninehvsga', habitual: 'aninehvsgoi', remote_past: 'uninehnvi', imperative: 'waninehvga', infinitive: 'uninehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinevsga"
        "SG1" | "" | Tense.HABITUAL        | "jinevsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinenvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehdi"
        "SG2" | "" | Tense.PRESENT         | "hinehvsga"
        "SG2" | "" | Tense.HABITUAL        | "hinehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinenvi"
        "SG2" | "" | Tense.INFINITIVE      | "janehdi"
        "SG1" | "" | Tense.PRESENT         | "jinevsga"
        "SG1" | "" | Tense.HABITUAL        | "jinevsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinenvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehdi"
        "PL3" | "" | Tense.PRESENT         | "aninehvsga"
        "PL3" | "" | Tense.HABITUAL        | "aninehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninenvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninehdi"
    }
}
