// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73825 (entrya uhwasga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhwasgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Buying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'akiwasga'],
            [subject: 'SG1', object: '', present: 'akihwasga', habitual: 'akihwasgoi', remote_past: 'akihwasvi', imperative: 'akiwahi', infinitive: 'akihwahisdi'],
            [subject: 'SG2', object: '', present: 'jahwasga', habitual: 'jahwasgoi', remote_past: 'jahwasvi', imperative: 'chawahi', infinitive: 'jahwahisdi'],
            [subject: 'SG3', object: '', habitual: 'uhwasgoi', imperative: 'chawahi', infinitive: 'uhwahisdi', present: 'uhwasga', remote_past: 'uhwasvi'],
            [subject: 'PL3', object: '', present: 'unihwasga', habitual: 'unihwasgoi', remote_past: 'unihwasvi', imperative: 'unihwahi', infinitive: 'unihwahisdi'],
            [subject: 'PL1INCL', object: '', present: 'igihwasga', habitual: 'igihwasgoi', remote_past: 'igihwasvi', imperative: 'igihwahi', infinitive: 'igihwahisdi']
        ]
    ]

    @Unroll
    def "conjugating Uhwasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhwasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiwasga"
        "SG1" | "" | Tense.HABITUAL        | "agiwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwasvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiwasvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwahisdi"
        "SG2" | "" | Tense.PRESENT         | "jahwasga"
        "SG2" | "" | Tense.HABITUAL        | "jahwasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahwasvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsawasvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahwahisdi"
        "SG3" | "" | Tense.PRESENT         | "uhwasga"
        "SG3" | "" | Tense.HABITUAL        | "uhwasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwasvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwasvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhwahisdi"
        "PL3" | "" | Tense.PRESENT         | "unihwasga"
        "PL3" | "" | Tense.HABITUAL        | "unihwasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwasvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniwasvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihwahisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihwasga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihwasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihwasvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiwasvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihwahisdi"
    }
}
