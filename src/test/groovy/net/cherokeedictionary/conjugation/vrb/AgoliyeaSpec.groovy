// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72324 (entrya agoliyea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgoliyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Reading",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jigoliyea, jigoliyea'],
            [subject: 'SG1', object: '', present: 'jigoliyea', habitual: 'jigoliyesgoi', remote_past: 'agigoliyevi', imperative: 'jigoliya', infinitive: 'agigoliyedi'],
            [subject: 'SG2', object: '', present: 'higoliyea', habitual: 'higoliyesgoi', remote_past: 'jagoliyevi', imperative: 'higoliya', infinitive: 'jagoliyedi'],
            [subject: 'SG3', object: '', habitual: 'agoliyesgoi', imperative: 'higoliya, higoliya', infinitive: 'ugoliyedi', present: 'agoliyea', remote_past: 'ugoliyevi'],
            [subject: 'PL3', object: '', present: 'anigoliyea', habitual: 'anigoliyesgoi', remote_past: 'unigoliyevi', imperative: 'anigoliya', infinitive: 'unigoliyedi'],
            [subject: 'PL1INCL', object: '', present: 'idigoliyea', habitual: 'idigoliyesgoi', remote_past: 'igigoliyevi', imperative: 'idigoliya', infinitive: 'igigoliyedi']
        ]
    ]

    @Unroll
    def "conjugating Agoliyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agoliyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigoliyea"
        "SG1" | "" | Tense.HABITUAL        | "tsigoliyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigoliyevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigoliyevi"
        "SG1" | "" | Tense.INFINITIVE      | "agigoliyedi"
        "SG2" | "" | Tense.PRESENT         | "higoliyea"
        "SG2" | "" | Tense.HABITUAL        | "higoliyesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagoliyevi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higoliyevi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagoliyedi"
        "SG3" | "" | Tense.PRESENT         | "agoliyea"
        "SG3" | "" | Tense.HABITUAL        | "agoliyesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugoliyevi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agoliyevi"
        "SG3" | "" | Tense.INFINITIVE      | "ugoliyedi"
        "PL3" | "" | Tense.PRESENT         | "anigoliyea"
        "PL3" | "" | Tense.HABITUAL        | "anigoliyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigoliyevi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigoliyevi"
        "PL3" | "" | Tense.INFINITIVE      | "unigoliyedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigoliyea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigoliyesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigoliyevi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigoliyevi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigoliyedi"
    }
}
