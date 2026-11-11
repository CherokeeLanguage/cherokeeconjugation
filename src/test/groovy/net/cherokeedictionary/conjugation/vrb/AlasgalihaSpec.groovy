package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlasgalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Playing Ball",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galasgaliha', habitual: 'galasgalisgoi', remote_past: 'agwalasgalvhvi', imperative: 'galasgala', infinitive: 'agwalasgahldi'],
            [subject: 'SG2', object: '', present: 'halasgaliha', habitual: 'halasgalisgoi', remote_past: 'jalasgalvhvi', imperative: 'halasgala', infinitive: 'jalasgahldi'],
            [subject: 'SG3', object: '', present: 'alasgaliha', habitual: 'alasgalisgoi', remote_past: 'ulasgalvhvi', imperative: 'alasgala', infinitive: 'ulasgahldi'],
            [subject: 'PL3', object: '', present: 'analasgaliha', habitual: 'analasgalisgoi', remote_past: 'unalasgalvhvi', imperative: 'analasgala', infinitive: 'unalasgahldi'],
            [subject: 'PL1INCL', object: '', present: 'idalasgaliha', habitual: 'idalasgalisgoi', remote_past: 'igalasgalvhvi', imperative: 'idalasgala', infinitive: 'igalasgahldi']
        ]
    ]

    @Unroll
    def "conjugating Alasgaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alasgaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galasgaliha"
        "SG1" | "" | Tense.HABITUAL        | "galasgalisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalasgalvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galasgala"
        "SG1" | "" | Tense.INFINITIVE      | "agwalasgahldi"
        "SG2" | "" | Tense.PRESENT         | "halasgaliha"
        "SG2" | "" | Tense.HABITUAL        | "halasgalisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalasgalvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halasgala"
        "SG2" | "" | Tense.INFINITIVE      | "jalasgahldi"
        "SG3" | "" | Tense.PRESENT         | "alasgaliha"
        "SG3" | "" | Tense.HABITUAL        | "alasgalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulasgalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alasgala"
        "SG3" | "" | Tense.INFINITIVE      | "ulasgahldi"
        "PL3" | "" | Tense.PRESENT         | "analasgaliha"
        "PL3" | "" | Tense.HABITUAL        | "analasgalisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalasgalvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analasgala"
        "PL3" | "" | Tense.INFINITIVE      | "unalasgahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalasgaliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalasgalisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalasgalvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalasgala"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalasgahldi"
    }
}
