package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlenihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Beginning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galenia', habitual: 'galenisgoi', remote_past: 'agwalenvhvi', imperative: 'galena', infinitive: 'agwalenhdi'],
            [subject: 'SG2', object: '', present: 'haleniha', habitual: 'halenisgoi', remote_past: 'jalenvhvi', imperative: 'halena', infinitive: 'jalenhdi'],
            [subject: 'SG3', object: '', present: 'aleniha', habitual: 'alenisgoi', remote_past: 'ulenvhvi', imperative: 'alena', infinitive: 'ulenhdi'],
            [subject: 'PL3', object: '', present: 'analeniha', habitual: 'analenisgoi', remote_past: 'unalenvhvi', imperative: 'analena', infinitive: 'unalenhdi'],
            [subject: 'PL1INCL', object: '', present: 'idaleniha', habitual: 'idalenisgoi', remote_past: 'igalenvhvi', imperative: 'idalena', infinitive: 'igalenhdi']
        ]
    ]

    @Unroll
    def "conjugating Aleniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aleniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galenia"
        "SG1" | "" | Tense.HABITUAL        | "galenisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalenvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galena"
        "SG1" | "" | Tense.INFINITIVE      | "agwalenhdi"
        "SG2" | "" | Tense.PRESENT         | "haleniha"
        "SG2" | "" | Tense.HABITUAL        | "halenisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalenvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halena"
        "SG2" | "" | Tense.INFINITIVE      | "jalenhdi"
        "SG3" | "" | Tense.PRESENT         | "aleniha"
        "SG3" | "" | Tense.HABITUAL        | "alenisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulenvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alena"
        "SG3" | "" | Tense.INFINITIVE      | "ulenhdi"
        "PL3" | "" | Tense.PRESENT         | "analeniha"
        "PL3" | "" | Tense.HABITUAL        | "analenisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalenvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analena"
        "PL3" | "" | Tense.INFINITIVE      | "unalenhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaleniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalenisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalenvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalena"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalenhdi"
    }
}
