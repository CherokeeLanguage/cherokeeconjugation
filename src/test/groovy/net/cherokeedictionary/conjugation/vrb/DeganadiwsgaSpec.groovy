package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DeganadiwsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Crossing It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejinadiwsga', habitual: 'dejinadiwsgoi', remote_past: 'daginadiwsvi', imperative: 'dijinadihwi', infinitive: 'diginadihwisdi'],
            [subject: 'SG2', object: '', present: 'dehinadiwsga', habitual: 'dehinadiwsgoi', remote_past: 'dejanadiwsvi', imperative: 'tinadihwi', infinitive: 'dijanadihwisdi'],
            [subject: 'SG3', object: '', present: 'deganadiwsga', habitual: 'deganadiwsgoi', remote_past: 'dunadiwsvi', imperative: 'dikanadihwi', infinitive: 'junadihwisdi'],
            [subject: 'PL3', object: '', present: 'daninadiwsga', habitual: 'daninadiwsgoi', remote_past: 'duninadiwsvi', imperative: 'dininadihwi', infinitive: 'juninadihwisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedinadiwsga', habitual: 'dedinadiwsgoi', remote_past: 'deginadiwsvi', imperative: 'didinadihwi', infinitive: 'diginadihwisdi']
        ]
    ]

    @Unroll
    def "conjugating Deganadiwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Deganadiwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejinadiwsga"
        "SG1" | "" | Tense.HABITUAL        | "dejinadiwsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "daginadiwsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijinadihwi"
        "SG1" | "" | Tense.INFINITIVE      | "diginadihwisdi"
        "SG2" | "" | Tense.PRESENT         | "dehinadiwsga"
        "SG2" | "" | Tense.HABITUAL        | "dehinadiwsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejanadiwsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tinadihwi"
        "SG2" | "" | Tense.INFINITIVE      | "dijanadihwisdi"
        "SG3" | "" | Tense.PRESENT         | "deganadiwsga"
        "SG3" | "" | Tense.HABITUAL        | "deganadiwsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunadiwsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikanadihwi"
        "SG3" | "" | Tense.INFINITIVE      | "junadihwisdi"
        "PL3" | "" | Tense.PRESENT         | "daninadiwsga"
        "PL3" | "" | Tense.HABITUAL        | "daninadiwsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "duninadiwsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dininadihwi"
        "PL3" | "" | Tense.INFINITIVE      | "juninadihwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedinadiwsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedinadiwsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "deginadiwsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didinadihwi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "diginadihwisdi"
    }
}
