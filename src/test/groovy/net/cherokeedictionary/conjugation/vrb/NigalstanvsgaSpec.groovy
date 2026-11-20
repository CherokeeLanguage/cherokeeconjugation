package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigalstanvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It is Happening/Becoming",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'nigalstanvsga', habitual: 'nigalstanvsgoi', remote_past: 'nigalsda', imperative: '/', infinitive: 'nulstanvi']
        ]
    ]

    @Unroll
    def "conjugating Nigalstanvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigalstanvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "nigalstanvsga"
        "SG3" | "" | Tense.HABITUAL        | "nigalstanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nigalsda"
        // "SG3" | "" | Tense.FUTURE_COMMAND      | "gagalisda"
        "SG3" | "" | Tense.INFINITIVE      | "nulstanvi"
    }
}
