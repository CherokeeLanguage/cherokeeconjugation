// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73844 (entrya ujetsdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UjetsdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Grinning",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwajetsdi'],
            [subject: 'SG1', object: '', present: 'agwajetsdi', habitual: 'agwajetsdoi', remote_past: 'agwajetsdvi', imperative: 'agwajetsda', infinitive: 'agwajetsdohdi'],
            [subject: 'SG2', object: '', present: 'jajetsdi', habitual: 'jajetsdoi', remote_past: 'jajetsdvi', imperative: 'hajetsda', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'ujetsdoi', imperative: 'hajetsda', infinitive: 'ujetsdohdi', present: 'ujetsdi', remote_past: 'ujetsdvi'],
            [subject: 'PL3', object: '', present: 'unajetsdi', habitual: 'unajetsdoi', remote_past: 'unajetsdvi', imperative: 'anajetsda', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'igajetsdi', habitual: 'igajetsdoi', remote_past: 'igajetsdvi', imperative: 'idajetsda', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Ujetsdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ujetsdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquatsetsidi"
        "SG1" | "" | Tense.HABITUAL        | "aquatsetsidoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsetsidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquatsetsidvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsetsidodi"
        "SG2" | "" | Tense.PRESENT         | "tsatsetsidi"
        "SG2" | "" | Tense.HABITUAL        | "tsatsetsidoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsetsidvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsatsetsidvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "utsetsidi"
        "SG3" | "" | Tense.HABITUAL        | "utsetsidoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsetsidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utsetsidvi"
        // "SG3" | "" | Tense.INFINITIVE      | "/"
        "PL3" | "" | Tense.PRESENT         | "unatsetsidi"
        "PL3" | "" | Tense.HABITUAL        | "unatsetsidoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsetsidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unatsetsidvi"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "igatsetsidi"
        "PL1INCL" | "" | Tense.HABITUAL        | "igatsetsidoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsetsidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igatsetsidvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
