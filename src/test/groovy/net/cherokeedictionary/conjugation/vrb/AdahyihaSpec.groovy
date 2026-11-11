package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdahyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Denying",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyadayiha', habitual: 'jiyadayihoi', remote_past: 'jiyadayilvi', imperative: 'jiyadayiga', infinitive: 'jiyadayisdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gadayiha', habitual: 'gadayihoi', remote_past: 'agwadahyilvi', imperative: 'gadayhga', infinitive: 'agwadayhsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyadayiha', habitual: 'hiyadayihoi', remote_past: 'hiyadayilvi', imperative: 'hiyadayiga', infinitive: 'hiyadayisdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hadayiha', habitual: 'hadayihoi', remote_past: 'jadahyilvi', imperative: 'hadayhga', infinitive: 'jadayhsdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'adahyiha', habitual: 'adahyihoi', remote_past: 'udahyilvi', imperative: 'adayhga', infinitive: 'udayhsdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anadahyiha', habitual: 'anadahyihoi', remote_past: 'unadahyilvi', imperative: 'anadayhga', infinitive: 'unadayhsdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idadahyiha', habitual: 'idadahyihoi', remote_past: 'igadahyilvi', imperative: 'idadayhga', infinitive: 'igadayhsdi']
        ]
    ]

    @Unroll
    def "conjugating Adahyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adahyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyadayiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyadayihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyadayilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyadayiga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyadayisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadayiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadayihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwadahyilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadayhga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwadayhsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadayiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadayihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyadayilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadayiga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyadayisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadayiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadayihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jadahyilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadayhga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jadayhsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "adahyiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "adahyihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udahyilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "adayhga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udayhsdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadahyiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadahyihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadahyilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadayhga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadayhsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idadahyiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadahyihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadahyilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadayhga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadayhsdi"
    }
}
