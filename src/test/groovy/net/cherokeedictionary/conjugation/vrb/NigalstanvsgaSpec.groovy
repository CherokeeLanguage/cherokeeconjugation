package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigalstanvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It is Happening/Becoming",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'nigalstanvsga', habitual: 'nigalstanvsgoi', remote_past: 'nigalsda', imperative: '/', infinitive: 'nulstanvi']
        ]
    ]

    @Unroll
    def "conjugating Nigalstanvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigalstanvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "nigalstanvsga"
        "SG3" | "" | Tense.HABITUAL        | "nigalstanvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nigalsda"
        // "SG3" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG3" | "" | Tense.INFINITIVE      | "nulstanvi"
    }
}
