package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GuhiloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Washing It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'guiloa', habitual: 'guilosgoi', remote_past: 'agwuhilovi', imperative: 'guiloja', infinitive: 'agwuhilosdi'],
            [subject: 'SG2', object: '', present: 'huhiloa', habitual: 'huhilosgoi', remote_past: 'juhilovi', imperative: 'huhiloja', infinitive: 'juhilosdi'],
            [subject: 'SG3', object: '', present: 'guhiloa', habitual: 'guhilosgoi', remote_past: 'uwuhilovi', imperative: 'guhiloja', infinitive: 'uwuhilosdi'],
            [subject: 'PL3', object: '', present: 'anuhiloa', habitual: 'anuhilosgoi', remote_past: 'unuhilovi', imperative: 'anuhiloja', infinitive: 'unuhilosdi'],
            [subject: 'PL1INCL', object: '', present: 'iduhiloa', habitual: 'iduhilosgoi', remote_past: 'iguhilovi', imperative: 'iduhiloja', infinitive: 'iguhilosdi']
        ]
    ]

    @Unroll
    def "conjugating Guhiloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Guhiloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "guiloa"
        "SG1" | "" | Tense.HABITUAL        | "guilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwuhilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guiloja"
        "SG1" | "" | Tense.INFINITIVE      | "agwuhilosdi"
        "SG2" | "" | Tense.PRESENT         | "huhiloa"
        "SG2" | "" | Tense.HABITUAL        | "huhilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "juhilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "huhiloja"
        "SG2" | "" | Tense.INFINITIVE      | "juhilosdi"
        "SG3" | "" | Tense.PRESENT         | "guhiloa"
        "SG3" | "" | Tense.HABITUAL        | "guhilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuhilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "guhiloja"
        "SG3" | "" | Tense.INFINITIVE      | "uwuhilosdi"
        "PL3" | "" | Tense.PRESENT         | "anuhiloa"
        "PL3" | "" | Tense.HABITUAL        | "anuhilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuhilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anuhiloja"
        "PL3" | "" | Tense.INFINITIVE      | "unuhilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iduhiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "iduhilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguhilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iduhiloja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iguhilosdi"
    }
}
