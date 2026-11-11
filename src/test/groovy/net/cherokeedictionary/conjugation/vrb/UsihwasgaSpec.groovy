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
            [subject: 'SG1', object: '', present: 'aksihwasga', habitual: 'aksihwasgoi', remote_past: 'aksihwahvi', imperative: 'aksiwahi', infinitive: 'aksihwahisdi'],
            [subject: 'SG2', object: '', present: 'tsihwasga', habitual: 'tsihwasgoi', remote_past: 'tsihwahvi', imperative: 'tsiwahi', infinitive: 'tsihwahisdi'],
            [subject: 'SG3', object: '', present: 'usihwasga', habitual: 'usihwasgoi', remote_past: 'usihwahvi', imperative: 'usiwahi', infinitive: 'usihwahisdi'],
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
        "SG1" | "" | Tense.PRESENT         | "aksihwasga"
        "SG1" | "" | Tense.HABITUAL        | "aksihwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksihwahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aksiwahi"
        "SG1" | "" | Tense.INFINITIVE      | "aksihwahisdi"
        "SG2" | "" | Tense.PRESENT         | "tsihwasga"
        "SG2" | "" | Tense.HABITUAL        | "tsihwasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsihwahvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsiwahi"
        "SG2" | "" | Tense.INFINITIVE      | "tsihwahisdi"
        "SG3" | "" | Tense.PRESENT         | "usihwasga"
        "SG3" | "" | Tense.HABITUAL        | "usihwasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usihwahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usiwahi"
        "SG3" | "" | Tense.INFINITIVE      | "usihwahisdi"
        "PL3" | "" | Tense.PRESENT         | "unsihwasga"
        "PL3" | "" | Tense.HABITUAL        | "unsihwasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsihwahvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unsiwahi"
        "PL3" | "" | Tense.INFINITIVE      | "unsihwahisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iksihwasga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iksihwasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksihwahvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iksiwahi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksihwahisdi"
    }
}
