// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73200 (entrya gawehliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GawehlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Joking / Teasing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwehliha'],
            [subject: 'SG1', object: '', present: 'jiwehliha', habitual: 'jiwehlisgoi', remote_past: 'agiwehlvhnvi', imperative: 'jiwehlvha', infinitive: 'agiwehlvhdi'],
            [subject: 'SG2', object: '', present: 'hiwehliha', habitual: 'hiwehlisgoi', remote_past: 'jawehlvhnvi', imperative: 'hiwehlvha', infinitive: 'jawehlvhdi'],
            [subject: 'SG3', object: '', habitual: 'gawehlisgoi', imperative: 'hiwehlvna', infinitive: 'uwehlvhdi', present: 'gawehliha', remote_past: 'uwehlvhnvi'],
            [subject: 'PL3', object: '', present: 'aniwehliha', habitual: 'aniwehlisgoi', remote_past: 'uniwehlvhnvi', imperative: 'aniwehlvha', infinitive: 'uniwehlvhdi'],
            [subject: 'PL1INCL', object: '', present: 'idiwehliha', habitual: 'idiwehlisgoi', remote_past: 'igiwehlvhnvi', imperative: 'idiwehlvha', infinitive: 'igiwehlvhdi']
        ]
    ]

    @Unroll
    def "conjugating Gawehliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gawehliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwehliha"
        "SG1" | "" | Tense.HABITUAL        | "jiwehlisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwehlvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwetlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwehlvhdi"
        "SG2" | "" | Tense.PRESENT         | "hiwehliha"
        "SG2" | "" | Tense.HABITUAL        | "hiwehlisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawehlvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwetlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jawehlvhdi"
        "SG3" | "" | Tense.PRESENT         | "gawehliha"
        "SG3" | "" | Tense.HABITUAL        | "gawehlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehlvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawetlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwehlvhdi"
        "PL3" | "" | Tense.PRESENT         | "aniwehliha"
        "PL3" | "" | Tense.HABITUAL        | "aniwehlisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwehlvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwetlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwehlvhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwehliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwehlisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwehlvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwetlvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwehlvhdi"
    }
}
