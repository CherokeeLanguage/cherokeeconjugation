package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtkohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Becoming Wise",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jigatohvsga', habitual: 'jigatohvsgoi', remote_past: 'agiktohvsvi', imperative: 'jigatovhi', infinitive: 'agiktovhisdi'],
            [subject: 'SG2', object: '', present: 'hiktohvsga', habitual: 'hiktohvsgoi', remote_past: 'jaktohvsvi', imperative: 'hiktovhi', infinitive: 'jaktovhisdi'],
            [subject: 'SG3', object: '', present: 'aktohvsga', habitual: 'aktohvsgoi', remote_past: 'uktohvsvi', imperative: 'aktovhi', infinitive: 'uktovhisdi'],
            [subject: 'PL3', object: '', present: 'aniktohvsga', habitual: 'aniktohvsgoi', remote_past: 'uniktohvsvi', imperative: 'aniktovhi', infinitive: 'uniktovhisdi'],
            [subject: 'PL1INCL', object: '', present: 'idiktohvsga', habitual: 'idiktohvsgoi', remote_past: 'igiktohvsvi', imperative: 'idiktovhi', infinitive: 'igiktovhisdi']
        ]
    ]

    @Unroll
    def "conjugating Atkohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atkohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigidohvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsigidohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigidohvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigidohvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigidovhisdi"
        "SG2" | "" | Tense.PRESENT         | "higidohvsga"
        "SG2" | "" | Tense.HABITUAL        | "higidohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagidohvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higidohvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagidovhisdi"
        "SG3" | "" | Tense.PRESENT         | "agidohvsga"
        "SG3" | "" | Tense.HABITUAL        | "agidohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugidohvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agidohvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugidovhisdi"
        "PL3" | "" | Tense.PRESENT         | "anigidohvsga"
        "PL3" | "" | Tense.HABITUAL        | "anigidohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigidohvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigidohvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigidovhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigidohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigidohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigidohvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigidohvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigidovhisdi"
    }
}
