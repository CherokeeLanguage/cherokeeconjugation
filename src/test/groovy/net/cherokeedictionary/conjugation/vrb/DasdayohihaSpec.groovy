package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasdayohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shooting (75)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejisdayohiha', habitual: 'dejisdayohihoi', remote_past: 'daksdayohlvi', imperative: 'dijisdayoha', infinitive: 'diksdayosdi'],
            [subject: 'SG2', object: '', present: 'deihisdayohiha', habitual: 'dehisdayohihoi', remote_past: 'detsdayohlvi', imperative: 'tisdayoha', infinitive: 'ditsdayosdi'],
            [subject: 'SG3', object: '', present: 'dasdayohiha', habitual: 'dasdayohihoi', remote_past: 'dusdayohlvi', imperative: 'disdayoha', infinitive: 'jusdayosdi'],
            [subject: 'PL3', object: '', present: 'danisdayohiha', habitual: 'danisdayohihoi', remote_past: 'dunisdayohlvi', imperative: 'dinasdayoha', infinitive: 'junisdayosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedisdayohiha', habitual: 'dedisdayohihoi', remote_past: 'deksdayohlvi', imperative: 'didisdayoha', infinitive: 'diksdayosdi']
        ]
    ]

    @Unroll
    def "conjugating Dasdayohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasdayohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejisdayohiha"
        "SG1" | "" | Tense.HABITUAL        | "dejisdayohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "daksdayohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijisdayoha"
        "SG1" | "" | Tense.INFINITIVE      | "diksdayosdi"
        "SG2" | "" | Tense.PRESENT         | "deihisdayohiha"
        "SG2" | "" | Tense.HABITUAL        | "dehisdayohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "detsdayohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tisdayoha"
        "SG2" | "" | Tense.INFINITIVE      | "ditsdayosdi"
        "SG3" | "" | Tense.PRESENT         | "dasdayohiha"
        "SG3" | "" | Tense.HABITUAL        | "dasdayohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dusdayohlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "disdayoha"
        "SG3" | "" | Tense.INFINITIVE      | "jusdayosdi"
        "PL3" | "" | Tense.PRESENT         | "danisdayohiha"
        "PL3" | "" | Tense.HABITUAL        | "danisdayohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunisdayohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinasdayoha"
        "PL3" | "" | Tense.INFINITIVE      | "junisdayosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedisdayohiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedisdayohihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "deksdayohlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didisdayoha"
        "PL1INCL" | "" | Tense.INFINITIVE      | "diksdayosdi"
    }
}
