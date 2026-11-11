package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Hiring Him",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinahlvsga', habitual: 'jinahlvsgoi', remote_past: 'jinahlvnvi', imperative: 'jinahlvvga', infinitive: 'jinahlvdi'],
            [subject: 'SG2', object: '', present: 'hinahlvsga', habitual: 'hinahlvsgoi', remote_past: 'hinahlvnvi', imperative: 'hinahlvvga', infinitive: 'hinahlvdi'],
            [subject: 'SG3', object: '', present: 'ganahlvsga', habitual: 'ganahlvsgoi', remote_past: 'unahlvnvi', imperative: 'ganahlvvga', infinitive: 'unahlvdi'],
            [subject: 'PL3', object: '', present: 'aninahlvsga', habitual: 'aninahlvsgoi', remote_past: 'aninahlvnvi', imperative: 'aninahlvvga', infinitive: 'uninahlvdi'],
            [subject: 'PL1INCL', object: '', present: 'edinahlvsga', habitual: 'edinahlvsgoi', remote_past: 'edinahlvnvi', imperative: 'edinahlvvga', infinitive: 'edinahlvdi']
        ]
    ]

    @Unroll
    def "conjugating Ganahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinahlvsga"
        "SG1" | "" | Tense.HABITUAL        | "jinahlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinahlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinahlvvga"
        "SG1" | "" | Tense.INFINITIVE      | "jinahlvdi"
        "SG2" | "" | Tense.PRESENT         | "hinahlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hinahlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinahlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinahlvvga"
        "SG2" | "" | Tense.INFINITIVE      | "hinahlvdi"
        "SG3" | "" | Tense.PRESENT         | "ganahlvsga"
        "SG3" | "" | Tense.HABITUAL        | "ganahlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unahlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganahlvvga"
        "SG3" | "" | Tense.INFINITIVE      | "unahlvdi"
        "PL3" | "" | Tense.PRESENT         | "aninahlvsga"
        "PL3" | "" | Tense.HABITUAL        | "aninahlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "aninahlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninahlvvga"
        "PL3" | "" | Tense.INFINITIVE      | "uninahlvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edinahlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "edinahlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edinahlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edinahlvvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edinahlvdi"
    }
}
