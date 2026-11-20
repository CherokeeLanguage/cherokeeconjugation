// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72261 (entrya adiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Saying",
        // tio 17Nov26: D6 verdict from the 2012 book (p.6): SG2/SG3 keep the present suffix
        // -ha (hadiha/adiha -- the engine composes these correctly), but SG1 surfaces the
        // laryngeal as a glottal: gadi'a (the yaml romanization agreed). The engine
        // recomposes the citation's glottal to -ha, so the SG1 present is registered as a
        // whole-form surface (D14 follow-up mechanism). -- tio 17Nov26
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'SG1', obj: 'NONE', form: 'gadia']
        ],
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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        // tio 17Nov26: SG1 present re-aligned to the book glottal form (D6).
        "SG1" | "" | Tense.PRESENT         | "gadia"
        "SG1" | "" | Tense.HABITUAL        | "gadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatdi"
        "SG2" | "" | Tense.PRESENT         | "hadiha"
        "SG2" | "" | Tense.HABITUAL        | "hadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatdi"
        "SG3" | "" | Tense.PRESENT         | "adiha"
        "SG3" | "" | Tense.HABITUAL        | "adisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advnvi"
        "SG3" | "" | Tense.INFINITIVE      | "utdi"
        "PL3" | "" | Tense.PRESENT         | "anadiha"
        "PL3" | "" | Tense.HABITUAL        | "anadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatdi"
    }
}
