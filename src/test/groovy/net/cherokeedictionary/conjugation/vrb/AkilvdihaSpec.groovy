package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkilvdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Riding",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakilvdiha', habitual: 'jiyakilvdisgoi', remote_past: 'jiyakilvtanvi', imperative: 'jiyakilvda', infinitive: 'jiyakilvdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gakilvdiha', habitual: 'gakilvdisgoi', remote_past: 'agwakilvtanvi', imperative: 'gakilvda', infinitive: 'agwakilvdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakilvdiha', habitual: 'hiyakilvdisgoi', remote_past: 'hiyakilvtanvi', imperative: 'hiyakilvda', infinitive: 'hiyakilvdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hakilvdiha', habitual: 'hakilvdisgoi', remote_past: 'jakilvtanvi', imperative: 'hakilvda', infinitive: 'jakilvdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'akilvdiha', habitual: 'akilvdisgoi', remote_past: 'ukilvtanvi', imperative: 'akilvda', infinitive: 'ukilvdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anakilvdiha', habitual: 'anakilvdisgoi', remote_past: 'unakilvtanvi', imperative: 'anakilvda', infinitive: 'unakilvdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idakilvdiha', habitual: 'idakilvdisgoi', remote_past: 'igakilvtanvi', imperative: 'idakilvda', infinitive: 'igakilvdohdi']
        ]
    ]

    @Unroll
    def "conjugating Akilvdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akilvdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakilvdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakilvdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakilvtanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyakilvda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakilvdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gakilvdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gakilvdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwakilvtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gakilvda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwakilvdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakilvdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakilvdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakilvtanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyakilvda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakilvdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hakilvdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hakilvdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jakilvtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hakilvda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jakilvdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "akilvdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "akilvdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ukilvtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "akilvda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ukilvdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anakilvdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anakilvdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unakilvtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anakilvda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unakilvdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idakilvdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idakilvdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igakilvtanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idakilvda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igakilvdohdi"
    }
}
