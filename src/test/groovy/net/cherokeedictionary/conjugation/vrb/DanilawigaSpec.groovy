package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanilawigaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They're Having Church",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dosdilawiga', habitual: 'dosdilawigoi', remote_past: 'doginilawijvi', imperative: 'josdilawigi', infinitive: 'joginilawisdi'],
            [subject: 'SG2', object: '', present: 'dojilawiga', habitual: 'dojilawigoi', remote_past: 'dogilawijvi', imperative: 'jojilawigi', infinitive: 'jogilawisdi'],
            [subject: 'SG3', object: '', present: 'danilawiga', habitual: 'danilawigoi', remote_past: 'dunilawijvi', imperative: 'dinilawigi', infinitive: 'junilawisdi'],
            [subject: 'PL3', object: '', present: 'dejilawiga', habitual: 'dejilawigoi', remote_past: 'dejilawijvi', imperative: 'dijilawigi', infinitive: 'dijilawisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedilawiga', habitual: 'dedilawigoi', remote_past: 'degilawijvi', imperative: 'didilawigi', infinitive: 'digilawisdi']
        ]
    ]

    @Unroll
    def "conjugating Danilawiga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danilawiga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dosdilawiga"
        "SG1" | "" | Tense.HABITUAL        | "dosdilawigoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "doginilawijvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "josdilawigi"
        "SG1" | "" | Tense.INFINITIVE      | "joginilawisdi"
        "SG2" | "" | Tense.PRESENT         | "dojilawiga"
        "SG2" | "" | Tense.HABITUAL        | "dojilawigoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dogilawijvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jojilawigi"
        "SG2" | "" | Tense.INFINITIVE      | "jogilawisdi"
        "SG3" | "" | Tense.PRESENT         | "danilawiga"
        "SG3" | "" | Tense.HABITUAL        | "danilawigoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunilawijvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dinilawigi"
        "SG3" | "" | Tense.INFINITIVE      | "junilawisdi"
        "PL3" | "" | Tense.PRESENT         | "dejilawiga"
        "PL3" | "" | Tense.HABITUAL        | "dejilawigoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dejilawijvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dijilawigi"
        "PL3" | "" | Tense.INFINITIVE      | "dijilawisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedilawiga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedilawigoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degilawijvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didilawigi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digilawisdi"
    }
}
