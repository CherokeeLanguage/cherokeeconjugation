// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73937 (entrya usihwasga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UsihwasgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Coughing (179)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aksihwasga'],
            [subject: 'SG1', object: '', present: 'aksihwasga', habitual: 'aksihwasgoi', remote_past: 'aksihwahvi', imperative: 'aksiwahi', infinitive: 'aksihwahisdi'],
            [subject: 'SG2', object: '', present: 'tsihwasga', habitual: 'tsihwasgoi', remote_past: 'tsihwahvi', imperative: 'tsiwahi', infinitive: 'tsihwahisdi'],
            [subject: 'SG3', object: '', habitual: 'usihwasgoi', imperative: 'tsihwahi', infinitive: 'usihwahisdi', present: 'usihwasga', remote_past: 'usihwahvi'],
            [subject: 'PL3', object: '', present: 'unsihwasga', habitual: 'unsihwasgoi', remote_past: 'unsihwahvi', imperative: 'unsiwahi', infinitive: 'unsihwahisdi'],
            [subject: 'PL1INCL', object: '', present: 'iksihwasga', habitual: 'iksihwasgoi', remote_past: 'iksihwahvi', imperative: 'iksiwahi', infinitive: 'iksihwahisdi']
        ]
    ]

    @Unroll
    def "conjugating Usihwasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Usihwasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agisiwasga"
        "SG1" | "" | Tense.HABITUAL        | "agisiwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisiwahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agisiwahvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisiwahisdi"
        "SG2" | "" | Tense.PRESENT         | "tsasiwasga"
        "SG2" | "" | Tense.HABITUAL        | "tsasiwasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasiwahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsasiwahvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasiwahisdi"
        "SG3" | "" | Tense.PRESENT         | "usiwasga"
        "SG3" | "" | Tense.HABITUAL        | "usiwasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usiwahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usiwahvi"
        "SG3" | "" | Tense.INFINITIVE      | "usiwahisdi"
        "PL3" | "" | Tense.PRESENT         | "unisiwasga"
        "PL3" | "" | Tense.HABITUAL        | "unisiwasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisiwahvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unisiwahvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisiwahisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igisiwasga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igisiwasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisiwahvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igisiwahvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisiwahisdi"
    }
}
