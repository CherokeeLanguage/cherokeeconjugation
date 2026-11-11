package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsuyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Choosing (Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasuyea', habitual: 'jiyasuyesgoi', remote_past: 'jiyasuyesvi', imperative: 'jiyasuyagi', infinitive: 'jiyasuyesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gasuyea', habitual: 'gasuyesgoi', remote_past: 'agwasuyesvi', imperative: 'gasuyagi', infinitive: 'agwasuyesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasuyea', habitual: 'hiyasuyesgoi', remote_past: 'hiyasuyesvi', imperative: 'hiyasuyagi', infinitive: 'hiyasuyesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hasuyea', habitual: 'hasuyesgoi', remote_past: 'jasuyesvi', imperative: 'hasuyagi', infinitive: 'jasuyesdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'asuyea', habitual: 'asuyesgoi', remote_past: 'usuyesvi', imperative: 'asuyagi', infinitive: 'usuyesdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anasuyea', habitual: 'anasuyesgoi', remote_past: 'unasuyesvi', imperative: 'anasuyagi', infinitive: 'unasuyesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idasuyea', habitual: 'idasuyesgoi', remote_past: 'igasuyesvi', imperative: 'idasuyagi', infinitive: 'igasuyesdi']
        ]
    ]

    @Unroll
    def "conjugating Asuyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasuyea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasuyesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasuyesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyasuyagi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyasuyesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gasuyea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gasuyesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwasuyesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gasuyagi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwasuyesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasuyea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasuyesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasuyesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasuyagi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasuyesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hasuyea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hasuyesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jasuyesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hasuyagi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jasuyesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "asuyea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "asuyesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "usuyesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "asuyagi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "usuyesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anasuyea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anasuyesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unasuyesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anasuyagi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unasuyesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idasuyea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idasuyesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igasuyesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idasuyagi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igasuyesdi"
    }
}
