package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvhisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Raising/Growing Him/It",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyadvhisdiha', habitual: 'jiyadvhisdisgoi', remote_past: 'jiyatvhistanvi', imperative: 'jiyadvhisda', infinitive: 'jiyatvhisdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gadvhisdiha', habitual: 'gadvhisdisgoi', remote_past: 'aktvhistanvi', imperative: 'gadvhisda', infinitive: 'aktvhisdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyadvhisdiha', habitual: 'hiyadvhisdisgoi', remote_past: 'hiyatvhistanvi', imperative: 'hiyadvhisda', infinitive: 'hiyatvhisdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvhisdiha', habitual: 'hatvhisdisgoi', remote_past: 'tstvhistanvi', imperative: 'hatvhisda', infinitive: 'tstvhisdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'atvhisdiha', habitual: 'atvhisdisgoi', remote_past: 'utvhistanvi', imperative: 'atvhisda', infinitive: 'utvhisdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvhisdiha', habitual: 'anatvhisdisgoi', remote_past: 'unatvhistanvi', imperative: 'anatvhisda', infinitive: 'unatvhisdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'edatvhisdiha', habitual: 'edatvhisdisgoi', remote_past: 'edatvhistanvi', imperative: 'edatvhisda', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Atvhisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvhisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyadvhisdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyadvhisdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvhistanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyadvhisda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvhisdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadvhisdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadvhisdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aktvhistanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvhisda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aktvhisdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadvhisdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadvhisdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvhistanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvhisda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvhisdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvhisdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvhisdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tstvhistanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hatvhisda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tstvhisdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "atvhisdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "atvhisdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "utvhistanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "atvhisda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utvhisdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvhisdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvhisdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvhistanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anatvhisda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvhisdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "edatvhisdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "edatvhisdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "edatvhistanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "edatvhisda"
        // "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "/"
    }
}
