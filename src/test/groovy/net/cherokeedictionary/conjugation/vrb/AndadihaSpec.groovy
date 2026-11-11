package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AndadihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Remember",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyanvdadia', habitual: 'jiyanvdadisgoi', remote_past: 'jiyanvdadvi', imperative: 'jiyanvdada', infinitive: 'jiyanvdadisdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'ganvdadia', habitual: 'ganvdadisgoi', remote_past: 'agwanhdadvi', imperative: 'ganvdada', infinitive: 'agwanhdadisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyanvdadia', habitual: 'hiyanvdadisgoi', remote_past: 'hiyanhdadvi', imperative: 'hiyanvdada', infinitive: 'hiyanhdadisdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'handadiha', habitual: 'handadisgoi', remote_past: 'janhdadvi', imperative: 'hanhdada', infinitive: 'janhdadisdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'andadiha', habitual: 'andadisgoi', remote_past: 'unhdadvi', imperative: 'anhdada', infinitive: 'unhdadisdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anandadiha', habitual: 'anandadisgoi', remote_past: 'unanhdadvi', imperative: 'ananhdada', infinitive: 'unanhdadisdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idandadiha', habitual: 'idandadisgoi', remote_past: 'iganhdadvi', imperative: 'idanhdada', infinitive: 'iganhdadisdi']
        ]
    ]

    @Unroll
    def "conjugating Andadiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Andadiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyanvdadia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyanvdadisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyanvdadvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyanvdada"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyanvdadisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "ganvdadia"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "ganvdadisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwanhdadvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganvdada"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwanhdadisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyanvdadia"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyanvdadisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyanhdadvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyanvdada"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyanhdadisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "handadiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "handadisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "janhdadvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanhdada"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "janhdadisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "andadiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "andadisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unhdadvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anhdada"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unhdadisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anandadiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anandadisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanhdadvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananhdada"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unanhdadisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idandadiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idandadisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iganhdadvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idanhdada"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iganhdadisdi"
    }
}
