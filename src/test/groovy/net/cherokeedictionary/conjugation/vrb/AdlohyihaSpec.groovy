package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdlohyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Crying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadloyiha', habitual: 'gadloyihoi', remote_past: 'agwadlohyilvi', imperative: 'gadlohga', infinitive: 'agwadloysdi'],
            [subject: 'SG2', object: '', present: 'hadloyiha', habitual: 'hadlohyihoi', remote_past: 'jadlohyilvi', imperative: 'hadlohga', infinitive: 'jadloysdi'],
            [subject: 'SG3', object: '', present: 'adlohyiha', habitual: 'adlohyihoi', remote_past: 'udlohyilvi', imperative: 'adlohga', infinitive: 'udloysdi'],
            [subject: 'PL3', object: '', present: 'anadlohyiha', habitual: 'anadlohyihoi', remote_past: 'unadlohyilvi', imperative: 'anadlohga', infinitive: 'unadloysdi'],
            [subject: 'PL1INCL', object: '', present: 'idadlohyiha', habitual: 'idadlohyihoi', remote_past: 'igadlohyilvi', imperative: 'idadlohga', infinitive: 'igadloysdi']
        ]
    ]

    @Unroll
    def "conjugating Adlohyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlohyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadloyiha"
        "SG1" | "" | Tense.HABITUAL        | "gadloyihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadlohyilvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadlohga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadloysdi"
        "SG2" | "" | Tense.PRESENT         | "hadloyiha"
        "SG2" | "" | Tense.HABITUAL        | "hadlohyihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadlohyilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadlohga"
        "SG2" | "" | Tense.INFINITIVE      | "jadloysdi"
        "SG3" | "" | Tense.PRESENT         | "adlohyiha"
        "SG3" | "" | Tense.HABITUAL        | "adlohyihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlohyilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adlohga"
        "SG3" | "" | Tense.INFINITIVE      | "udloysdi"
        "PL3" | "" | Tense.PRESENT         | "anadlohyiha"
        "PL3" | "" | Tense.HABITUAL        | "anadlohyihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlohyilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadlohga"
        "PL3" | "" | Tense.INFINITIVE      | "unadloysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadlohyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadlohyihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlohyilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadlohga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadloysdi"
    }
}
