package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktahvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Turning Back / S/hes Turning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gagatahva', habitual: 'gagatahvsgoi', remote_past: 'agwaktahvsvi', imperative: 'gagatahvna', infinitive: 'agwaktahvsdi'],
            [subject: 'SG2', object: '', present: 'haktahva', habitual: 'haktahvsgoi', remote_past: 'jaktahvsvi', imperative: 'haktahvna', infinitive: 'jaktahvsdi'],
            [subject: 'SG3', object: '', present: 'aktahva', habitual: 'aktahvsgoi', remote_past: 'uktahvsvi', imperative: 'aktahvna', infinitive: 'uktahvsdi'],
            [subject: 'PL3', object: '', present: 'anaktahva', habitual: 'anaktahvsgoi', remote_past: 'unaktahvsvi', imperative: 'anaktahvna', infinitive: 'unaktahvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idaktahva', habitual: 'idaktahvsgoi', remote_past: 'igaktahvsvi', imperative: 'idaktahvna', infinitive: 'igaktahvsdi']
        ]
    ]

    @Unroll
    def "conjugating Aktahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gagatahva"
        "SG1" | "" | Tense.HABITUAL        | "gagatahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwaktahvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gagatahvna"
        "SG1" | "" | Tense.INFINITIVE      | "agwaktahvsdi"
        "SG2" | "" | Tense.PRESENT         | "haktahva"
        "SG2" | "" | Tense.HABITUAL        | "haktahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaktahvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haktahvna"
        "SG2" | "" | Tense.INFINITIVE      | "jaktahvsdi"
        "SG3" | "" | Tense.PRESENT         | "aktahva"
        "SG3" | "" | Tense.HABITUAL        | "aktahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uktahvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aktahvna"
        "SG3" | "" | Tense.INFINITIVE      | "uktahvsdi"
        "PL3" | "" | Tense.PRESENT         | "anaktahva"
        "PL3" | "" | Tense.HABITUAL        | "anaktahvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaktahvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anaktahvna"
        "PL3" | "" | Tense.INFINITIVE      | "unaktahvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaktahva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaktahvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaktahvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaktahvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaktahvsdi"
    }
}
