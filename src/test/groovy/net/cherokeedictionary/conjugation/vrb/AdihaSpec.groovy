// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72261 (entrya adiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gadia'],
            [subject: 'SG1', object: '', present: 'gadia', habitual: 'gadisgoi', remote_past: 'agwadvhnvi', imperative: 'gada', infinitive: 'agwatdi'],
            [subject: 'SG2', object: '', present: 'hadiha', habitual: 'hadisgoi', remote_past: 'jadvhnvi', imperative: 'hada', infinitive: 'jatdi'],
            [subject: 'SG3', object: '', habitual: 'adisgoi', imperative: 'hada', infinitive: 'utdi', present: 'adiha', remote_past: 'udvhnvi'],
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
        "SG1" | "" | Tense.PRESENT         | "gadiha"
        "SG1" | "" | Tense.HABITUAL        | "gadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatidi"
        "SG2" | "" | Tense.PRESENT         | "hadiha"
        "SG2" | "" | Tense.HABITUAL        | "hadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatidi"
        "SG3" | "" | Tense.PRESENT         | "adiha"
        "SG3" | "" | Tense.HABITUAL        | "adisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advnvi"
        "SG3" | "" | Tense.INFINITIVE      | "utidi"
        "PL3" | "" | Tense.PRESENT         | "anadiha"
        "PL3" | "" | Tense.HABITUAL        | "anadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatidi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatidi"
    }
}
