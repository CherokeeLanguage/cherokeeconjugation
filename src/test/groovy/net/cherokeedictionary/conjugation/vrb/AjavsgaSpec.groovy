package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjavsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Getting in a Car, Box, Etc.",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gajavsga', habitual: 'gajavsgoi', remote_past: 'agwajanvi', imperative: 'gajavga', infinitive: 'agwajodi'],
            [subject: 'SG2', object: '', present: 'hajavsga', habitual: 'hajavsgoi', remote_past: 'jajanvi', imperative: 'hajavga', infinitive: 'jajodi'],
            [subject: 'SG3', object: '', present: 'ajavsga', habitual: 'ajavsgoi', remote_past: 'ujanvi', imperative: 'ajavga', infinitive: 'ujodi'],
            [subject: 'PL3', object: '', present: 'anajavsga', habitual: 'anajavsgoi', remote_past: 'unajanvi', imperative: 'anajavga', infinitive: 'unajodi'],
            [subject: 'PL1INCL', object: '', present: 'idajavsga', habitual: 'idajavsgoi', remote_past: 'igajanvi', imperative: 'idajavga', infinitive: 'igajodi']
        ]
    ]

    @Unroll
    def "conjugating Ajavsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajavsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajavsga"
        "SG1" | "" | Tense.HABITUAL        | "gajavsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gajavga"
        "SG1" | "" | Tense.INFINITIVE      | "agwajodi"
        "SG2" | "" | Tense.PRESENT         | "hajavsga"
        "SG2" | "" | Tense.HABITUAL        | "hajavsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hajavga"
        "SG2" | "" | Tense.INFINITIVE      | "jajodi"
        "SG3" | "" | Tense.PRESENT         | "ajavsga"
        "SG3" | "" | Tense.HABITUAL        | "ajavsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajavga"
        "SG3" | "" | Tense.INFINITIVE      | "ujodi"
        "PL3" | "" | Tense.PRESENT         | "anajavsga"
        "PL3" | "" | Tense.HABITUAL        | "anajavsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anajavga"
        "PL3" | "" | Tense.INFINITIVE      | "unajodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajavsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajavsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idajavga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajodi"
    }
}
