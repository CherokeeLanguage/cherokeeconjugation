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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyanidadiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyanidadisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyanidadvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyanidadvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyanidadisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "ganidadiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "ganidadisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquanidadvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganidadvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquanidadisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyanidadiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyanidadisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "anidadvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyanidadvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "anidadisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hanidadiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hanidadisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsanidadvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanidadvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsanidadisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "anidadiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "anidadisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unidadvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anidadvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unidadisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "ananidadiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "ananidadisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanidadvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananidadvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unanidadisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idanidadiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idanidadisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iganidadvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idanidadvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iganidadisdi"
    }
}
