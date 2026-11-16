// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72678 (entrya atolsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtolsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Loaning",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyatolsdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatolsdiha', habitual: 'jiyatolsdisgoi', remote_past: 'jiyatolstanvi', imperative: 'jiyatolsda', infinitive: 'jiyatolsdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatolsdiha', habitual: 'hiyatolsdisgoi', remote_past: 'hiyatolstanvi', imperative: 'hiyatolsda', infinitive: 'hiyatolsdohdi'],
            [subject: 'SG3', object: '', habitual: 'atolsdisgoi', imperative: 'hiyatolsda', infinitive: 'utolsdohdi', present: 'atolsdiha', remote_past: 'utolstanvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anatolsdiha', habitual: 'anatolsdisgoi', remote_past: 'unatolstanvi', imperative: 'anatolsda', infinitive: 'unatolsdohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idatolsdiha', habitual: 'idatolsdisgoi', remote_past: 'igatolstanvi', imperative: 'idatolsda', infinitive: 'igatolsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Atolsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atolsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadolisdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadolisdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadolistanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadolistanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadolisdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadolisdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadolisdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "adolistanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadolistanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "adolisdodi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "agadolisdiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "adolisdisgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwadolistanvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "adolistanvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwadolisdodi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anadolisdiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anadolisdisgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "anadolistanvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anadolistanvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "anadolisdodi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edadolisdiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edadolisdisgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "adolistanvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edadolistanvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "adolisdodi"
    }
}
