// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73277 (entrya guhiloa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'guiloa'],
            [subject: 'SG1', object: '', present: 'guiloa', habitual: 'guilosgoi', remote_past: 'agwuhilovi', imperative: 'guiloja', infinitive: 'agwuhilosdi'],
            [subject: 'SG2', object: '', present: 'huhiloa', habitual: 'huhilosgoi', remote_past: 'juhilovi', imperative: 'huhiloja', infinitive: 'juhilosdi'],
            [subject: 'SG3', object: '', habitual: 'guhilosgoi', imperative: 'huhiloja', infinitive: 'uwuhilosdi', present: 'guhiloa', remote_past: 'uwuhilovi'],
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
        "SG1" | "" | Tense.PRESENT         | "guhiloa"
        "SG1" | "" | Tense.HABITUAL        | "guhilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquuhilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guhilovi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwuhilosdi"
        "SG2" | "" | Tense.PRESENT         | "huhiloa"
        "SG2" | "" | Tense.HABITUAL        | "huhilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuhilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "huhilovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawuhilosdi"
        "SG3" | "" | Tense.PRESENT         | "guhiloa"
        "SG3" | "" | Tense.HABITUAL        | "guhilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuhilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhilovi"
        "SG3" | "" | Tense.INFINITIVE      | "uwuhilosdi"
        "PL3" | "" | Tense.PRESENT         | "anuhiloa"
        "PL3" | "" | Tense.HABITUAL        | "anuhilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuhilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anuhilovi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwuhilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iduhiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "iduhilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguhilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iduhilovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwuhilosdi"
    }
}
