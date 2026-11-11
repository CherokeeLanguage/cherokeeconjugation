package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgvhalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Cutting/Slicing It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jigvaliha', habitual: 'jigvalisgoi', remote_past: 'agigvhalvhvi', imperative: 'jigvala', infinitive: 'agigvhahldi'],
            [subject: 'SG2', object: '', present: 'higvhaliha', habitual: 'higvhalisgoi', remote_past: 'jagvhalvhvi', imperative: 'higvhala', infinitive: 'jagvhahldi'],
            [subject: 'SG3', object: '', present: 'agvhaliha', habitual: 'agvhalisgoi', remote_past: 'ugvhalvhvi', imperative: 'agvhala', infinitive: 'ugvhahldi'],
            [subject: 'PL3', object: '', present: 'anigvhaliha', habitual: 'anigvhalisgoi', remote_past: 'unigvhalvhvi', imperative: 'anigvhala', infinitive: 'unigvhahldi'],
            [subject: 'PL1INCL', object: '', present: 'idigvhaliha', habitual: 'idigvhalisgoi', remote_past: 'igigvhalvhvi', imperative: 'idigvhala', infinitive: 'idigvhahldi']
        ]
    ]

    @Unroll
    def "conjugating Agvhaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agvhaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jigvaliha"
        "SG1" | "" | Tense.HABITUAL        | "jigvalisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigvhalvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jigvala"
        "SG1" | "" | Tense.INFINITIVE      | "agigvhahldi"
        "SG2" | "" | Tense.PRESENT         | "higvhaliha"
        "SG2" | "" | Tense.HABITUAL        | "higvhalisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jagvhalvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higvhala"
        "SG2" | "" | Tense.INFINITIVE      | "jagvhahldi"
        "SG3" | "" | Tense.PRESENT         | "agvhaliha"
        "SG3" | "" | Tense.HABITUAL        | "agvhalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugvhalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agvhala"
        "SG3" | "" | Tense.INFINITIVE      | "ugvhahldi"
        "PL3" | "" | Tense.PRESENT         | "anigvhaliha"
        "PL3" | "" | Tense.HABITUAL        | "anigvhalisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigvhalvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigvhala"
        "PL3" | "" | Tense.INFINITIVE      | "unigvhahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigvhaliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigvhalisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigvhalvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigvhala"
        "PL1INCL" | "" | Tense.INFINITIVE      | "idigvhahldi"
    }
}
