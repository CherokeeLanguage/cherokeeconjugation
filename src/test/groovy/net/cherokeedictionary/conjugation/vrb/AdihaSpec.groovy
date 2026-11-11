package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Saying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadia', habitual: 'gadisgoi', remote_past: 'agwadvhnvi', imperative: 'gada', infinitive: 'agwatdi'],
            [subject: 'SG2', object: '', present: 'hadiha', habitual: 'hadisgoi', remote_past: 'jadvhnvi', imperative: 'hada', infinitive: 'jatdi'],
            [subject: 'SG3', object: '', present: 'adiha', habitual: 'adisgoi', remote_past: 'udvhnvi', imperative: 'ada', infinitive: 'utdi'],
            [subject: 'PL3', object: '', present: 'anadiha', habitual: 'anadisgoi', remote_past: 'unadvhnvi', imperative: 'anada', infinitive: 'unatdi'],
            [subject: 'PL1INCL', object: '', present: 'idadiha', habitual: 'idadisgoi', remote_past: 'igadvhnvi', imperative: 'idada', infinitive: 'igatdi']
        ]
    ]

    @Unroll
    def "conjugating Adiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadia"
        "SG1" | "" | Tense.HABITUAL        | "gadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gada"
        "SG1" | "" | Tense.INFINITIVE      | "agwatdi"
        "SG2" | "" | Tense.PRESENT         | "hadiha"
        "SG2" | "" | Tense.HABITUAL        | "hadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hada"
        "SG2" | "" | Tense.INFINITIVE      | "jatdi"
        "SG3" | "" | Tense.PRESENT         | "adiha"
        "SG3" | "" | Tense.HABITUAL        | "adisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ada"
        "SG3" | "" | Tense.INFINITIVE      | "utdi"
        "PL3" | "" | Tense.PRESENT         | "anadiha"
        "PL3" | "" | Tense.HABITUAL        | "anadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anada"
        "PL3" | "" | Tense.INFINITIVE      | "unatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idada"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatdi"
    }
}
