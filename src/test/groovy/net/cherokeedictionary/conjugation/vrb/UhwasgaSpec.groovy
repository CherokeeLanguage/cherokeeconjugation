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
            [subject: 'SG1', object: '', present: 'akihwasga', habitual: 'akihwasgoi', remote_past: 'akihwasvi', imperative: 'akiwahi', infinitive: 'akihwahisdi'],
            [subject: 'SG2', object: '', present: 'jahwasga', habitual: 'jahwasgoi', remote_past: 'jahwasvi', imperative: 'chawahi', infinitive: 'jahwahisdi'],
            [subject: 'SG3', object: '', present: 'uhwasga', habitual: 'uhwasgoi', remote_past: 'uhwasvi', imperative: 'uhwahi', infinitive: 'uhwahisdi'],
            [subject: 'PL3', object: '', present: 'unihwasga', habitual: 'unihwasgoi', remote_past: 'unihwasvi', imperative: 'unihwahi', infinitive: 'unihwahisdi'],
            [subject: 'PL1INCL', object: '', present: 'igihwasga', habitual: 'igihwasgoi', remote_past: 'igihwasvi', imperative: 'igihwahi', infinitive: 'igihwahisdi']
        ]
    ]

    @Unroll
    def "conjugating Uhwasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhwasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "akihwasga"
        "SG1" | "" | Tense.HABITUAL        | "akihwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akihwasvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "akiwahi"
        "SG1" | "" | Tense.INFINITIVE      | "akihwahisdi"
        "SG2" | "" | Tense.PRESENT         | "jahwasga"
        "SG2" | "" | Tense.HABITUAL        | "jahwasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahwasvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "chawahi"
        "SG2" | "" | Tense.INFINITIVE      | "jahwahisdi"
        "SG3" | "" | Tense.PRESENT         | "uhwasga"
        "SG3" | "" | Tense.HABITUAL        | "uhwasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwasvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uhwahi"
        "SG3" | "" | Tense.INFINITIVE      | "uhwahisdi"
        "PL3" | "" | Tense.PRESENT         | "unihwasga"
        "PL3" | "" | Tense.HABITUAL        | "unihwasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwasvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unihwahi"
        "PL3" | "" | Tense.INFINITIVE      | "unihwahisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihwasga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihwasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihwasvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igihwahi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihwahisdi"
    }
}
