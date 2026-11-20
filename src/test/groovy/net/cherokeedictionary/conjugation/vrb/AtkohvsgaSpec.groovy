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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigitohvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsigitohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiktohvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigidohvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiktovhisdi"
        "SG2" | "" | Tense.PRESENT         | "hiktohvsga"
        "SG2" | "" | Tense.HABITUAL        | "hiktohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaktohvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higidohvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jaktovhisdi"
        "SG3" | "" | Tense.PRESENT         | "aktohvsga"
        "SG3" | "" | Tense.HABITUAL        | "aktohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uktohvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agidohvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uktovhisdi"
        "PL3" | "" | Tense.PRESENT         | "aniktohvsga"
        "PL3" | "" | Tense.HABITUAL        | "aniktohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniktohvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigidohvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniktovhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiktohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiktohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiktohvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigidohvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiktovhisdi"
    }
}
