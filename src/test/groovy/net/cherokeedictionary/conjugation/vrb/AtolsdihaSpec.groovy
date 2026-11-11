package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtolsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Loaning",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatolsdiha', habitual: 'jiyatolsdisgoi', remote_past: 'jiyatolstanvi', imperative: 'jiyatolsda', infinitive: 'jiyatolsdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatolsdiha', habitual: 'hiyatolsdisgoi', remote_past: 'hiyatolstanvi', imperative: 'hiyatolsda', infinitive: 'hiyatolsdohdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'atolsdiha', habitual: 'atolsdisgoi', remote_past: 'utolstanvi', imperative: 'atolsda', infinitive: 'utolsdohdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anatolsdiha', habitual: 'anatolsdisgoi', remote_past: 'unatolstanvi', imperative: 'anatolsda', infinitive: 'unatolsdohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idatolsdiha', habitual: 'idatolsdisgoi', remote_past: 'igatolstanvi', imperative: 'idatolsda', infinitive: 'igatolsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Atolsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atolsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatolsdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatolsdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatolstanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyatolsda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatolsdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatolsdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatolsdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatolstanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyatolsda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatolsdohdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "atolsdiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "atolsdisgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "utolstanvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "atolsda"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "utolsdohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anatolsdiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anatolsdisgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unatolstanvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anatolsda"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unatolsdohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idatolsdiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idatolsdisgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igatolstanvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idatolsda"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igatolsdohdi"
    }
}
