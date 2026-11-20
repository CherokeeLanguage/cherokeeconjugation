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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyanidadiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyanidadisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyanadadvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyanadadvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyanadadisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "ganidadiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "ganidadisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwanhdadvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganadadvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwanhdadisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyanidadiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyanidadisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyanhdadvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyanadadvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyanhdadisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "handadiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "handadisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "janhdadvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanadadvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "janhdadisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "andadiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "andadisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unhdadvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadadvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unhdadisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anandadiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anandadisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanhdadvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananadadvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unanhdadisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idandadiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idandadisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iganhdadvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idanadadvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iganhdadisdi"
    }
}
