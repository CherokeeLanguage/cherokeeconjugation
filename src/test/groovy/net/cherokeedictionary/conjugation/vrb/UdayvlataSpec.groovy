package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdayvlataSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its in View",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwadayvlata', habitual: 'agwadayvlatoi', remote_past: 'agwadayvlatvi', imperative: 'agwadayvlatesdi', infinitive: 'agwadayvlatdi'],
            [subject: 'SG2', object: '', present: 'jadayvlata', habitual: 'jadayvlatoi', remote_past: 'jadayvlatvi', imperative: 'jadayvlatesdi', infinitive: 'jadayvlatdi'],
            [subject: 'SG3', object: '', present: 'udayvlata', habitual: 'udayvlatoi', remote_past: 'udayvlatvi', imperative: 'udayvlatesdi', infinitive: 'udayvlatdi'],
            [subject: 'PL3', object: '', present: 'unadayvlata', habitual: 'unadayvlatoi', remote_past: 'unadayvlatvi', imperative: 'unadayvlatesdi', infinitive: 'unadayvlatdi'],
            [subject: 'PL1INCL', object: '', present: 'igadayvlata', habitual: 'igadayvlatoi', remote_past: 'igadayvlatvi', imperative: 'igadayvlatesdi', infinitive: 'igadayvlatdi']
        ]
    ]

    @Unroll
    def "conjugating Udayvlata (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udayvlata", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwadayvlata"
        "SG1" | "" | Tense.HABITUAL        | "agwadayvlatoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadayvlatvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadayvlatesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadayvlatdi"
        "SG2" | "" | Tense.PRESENT         | "jadayvlata"
        "SG2" | "" | Tense.HABITUAL        | "jadayvlatoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadayvlatvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadayvlatesdi"
        "SG2" | "" | Tense.INFINITIVE      | "jadayvlatdi"
        "SG3" | "" | Tense.PRESENT         | "udayvlata"
        "SG3" | "" | Tense.HABITUAL        | "udayvlatoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udayvlatvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udayvlatesdi"
        "SG3" | "" | Tense.INFINITIVE      | "udayvlatdi"
        "PL3" | "" | Tense.PRESENT         | "unadayvlata"
        "PL3" | "" | Tense.HABITUAL        | "unadayvlatoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadayvlatvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadayvlatesdi"
        "PL3" | "" | Tense.INFINITIVE      | "unadayvlatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadayvlata"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadayvlatoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadayvlatvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadayvlatesdi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadayvlatdi"
    }
}
