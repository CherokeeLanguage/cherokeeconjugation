package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jigia', habitual: 'jigisgoi', remote_past: 'agigvi', imperative: 'jiga', infinitive: 'agigisdi'],
            [subject: 'SG2', object: '', present: 'higia', habitual: 'higisgoi', remote_past: 'jagvi', imperative: 'higa', infinitive: 'jagisdi'],
            [subject: 'SG1', object: '', present: 'agia', habitual: 'agisgoi', remote_past: 'ugvi', imperative: 'aga', infinitive: 'ugisdi'],
            [subject: 'PL3', object: '', present: 'anigia', habitual: 'anigisgoi', remote_past: 'unigvi', imperative: 'aniga', infinitive: 'anigisdi']
        ]
    ]

    @Unroll
    def "conjugating Agia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jigia"
        "SG1" | "" | Tense.HABITUAL        | "jigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiga"
        "SG1" | "" | Tense.INFINITIVE      | "agigisdi"
        "SG2" | "" | Tense.PRESENT         | "higia"
        "SG2" | "" | Tense.HABITUAL        | "higisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jagvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higa"
        "SG2" | "" | Tense.INFINITIVE      | "jagisdi"
        "SG1" | "" | Tense.PRESENT         | "agia"
        "SG1" | "" | Tense.HABITUAL        | "agisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ugvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aga"
        "SG1" | "" | Tense.INFINITIVE      | "ugisdi"
        "PL3" | "" | Tense.PRESENT         | "anigia"
        "PL3" | "" | Tense.HABITUAL        | "anigisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniga"
        "PL3" | "" | Tense.INFINITIVE      | "anigisdi"
    }
}
