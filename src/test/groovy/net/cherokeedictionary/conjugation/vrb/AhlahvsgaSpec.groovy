package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhlahvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Place on Something (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilahvsga', habitual: 'jilahvsgoi', remote_past: 'akhlanvi', imperative: 'jilahvga', infinitive: 'akhlodi'],
            [subject: 'SG2', object: '', present: 'hihlahvsga', habitual: 'hihlahvsgoi', remote_past: 'tshlanvi', imperative: 'hihlahvga', infinitive: 'tshlodi'],
            [subject: 'SG3', object: '', present: 'ahlahvsga', habitual: 'ahlahvsgoi', remote_past: 'uhlanvi', imperative: 'ahlahvga', infinitive: 'uhlodi'],
            [subject: 'SG3', object: '', present: 'anahlahvsga', habitual: 'anahlahvsgoi', remote_past: 'unihlanvi', imperative: 'anahlahvga', infinitive: 'unihlodi']
        ]
    ]

    @Unroll
    def "conjugating Ahlahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilahvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akhlanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilahvga"
        "SG1" | "" | Tense.INFINITIVE      | "akhlodi"
        "SG2" | "" | Tense.PRESENT         | "hihlahvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihlahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tshlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlahvga"
        "SG2" | "" | Tense.INFINITIVE      | "tshlodi"
        "SG3" | "" | Tense.PRESENT         | "ahlahvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahlahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahlahvga"
        "SG3" | "" | Tense.INFINITIVE      | "uhlodi"
        "SG3" | "" | Tense.PRESENT         | "anahlahvsga"
        "SG3" | "" | Tense.HABITUAL        | "anahlahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unihlanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anahlahvga"
        "SG3" | "" | Tense.INFINITIVE      | "unihlodi"
    }
}
