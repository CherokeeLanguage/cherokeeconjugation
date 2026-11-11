package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'agwanvsvi', imperative: 'wijinvga', infinitive: 'agwanvsdi'],
            [subject: 'SG2', object: '', present: 'hinega', habitual: 'hinegoi', remote_past: 'janvsvi', imperative: 'hwinvga', infinitive: 'janvsdi'],
            [subject: 'SG1', object: '', present: 'ganega', habitual: 'ganegoi', remote_past: 'uwanvsvi', imperative: 'wiganvga', infinitive: 'uwanvsdi'],
            [subject: 'PL3', object: '', present: 'aninega', habitual: 'aninegoi', remote_past: 'unanvsvi', imperative: 'aninvga', infinitive: 'unanvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijinvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwanvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinega"
        "SG2" | "" | Tense.HABITUAL        | "hinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwinvga"
        "SG2" | "" | Tense.INFINITIVE      | "janvsdi"
        "SG1" | "" | Tense.PRESENT         | "ganega"
        "SG1" | "" | Tense.HABITUAL        | "ganegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwanvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganvga"
        "SG1" | "" | Tense.INFINITIVE      | "uwanvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninega"
        "PL3" | "" | Tense.HABITUAL        | "aninegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvga"
        "PL3" | "" | Tense.INFINITIVE      | "unanvsdi"
    }
}
