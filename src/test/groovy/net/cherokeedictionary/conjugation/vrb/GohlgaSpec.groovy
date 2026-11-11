package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GohlgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Recognizing Him (120)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoliga', habitual: 'jiyoligoi', remote_past: 'jiyohlvi', imperative: 'jiyoligi', infinitive: 'jiyohlisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyoliga', habitual: 'hiyoligoi', remote_past: 'hiyohljvi', imperative: 'hiyoligi', infinitive: 'hiyohlisdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'gohlga', habitual: 'gohlgoi', remote_past: 'uwohljvi', imperative: 'gohlgi', infinitive: 'uwohlisdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anohlga', habitual: 'anohlgoi', remote_past: 'unohlvi', imperative: 'anohlgi', infinitive: 'unohlisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edohlga', habitual: 'edohlgoi', remote_past: 'edohlvi', imperative: 'edohlgi', infinitive: 'edohlisdi']
        ]
    ]

    @Unroll
    def "conjugating Gohlga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gohlga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoliga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyoligoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyohlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyoligi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyohlisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyoliga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyoligoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyohljvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyoligi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyohlisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gohlga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gohlgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwohljvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "gohlgi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwohlisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anohlga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anohlgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unohlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anohlgi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unohlisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edohlga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edohlgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edohlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edohlgi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edohlisdi"
    }
}
