package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'akinvsvi', imperative: 'wijinvga', infinitive: 'akihnvsdi'],
            [subject: 'SG2', object: '', present: 'hihnega', habitual: 'hihnegoi', remote_past: 'chanvsvi', imperative: 'hwihnvga', infinitive: 'jahnvsdi'],
            [subject: 'SG1', object: '', present: 'gahnega', habitual: 'gahnegoi', remote_past: 'uhnvsvi', imperative: 'wigahnvga', infinitive: 'uhnvsdi'],
            [subject: 'PL3', object: '', present: 'anihnega', habitual: 'anihnegoi', remote_past: 'unahnvsvi', imperative: 'wanihnvga', infinitive: 'unihnvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gahnega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahnega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijinvga"
        "SG1" | "" | Tense.INFINITIVE      | "akihnvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihnega"
        "SG2" | "" | Tense.HABITUAL        | "hihnegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "chanvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwihnvga"
        "SG2" | "" | Tense.INFINITIVE      | "jahnvsdi"
        "SG1" | "" | Tense.PRESENT         | "gahnega"
        "SG1" | "" | Tense.HABITUAL        | "gahnegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uhnvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigahnvga"
        "SG1" | "" | Tense.INFINITIVE      | "uhnvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihnega"
        "PL3" | "" | Tense.HABITUAL        | "anihnegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihnvga"
        "PL3" | "" | Tense.INFINITIVE      | "unihnvsdi"
    }
}
