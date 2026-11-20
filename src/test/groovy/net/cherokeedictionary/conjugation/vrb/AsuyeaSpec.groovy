// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72644 (entrya asuyea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyasuyea, gasuyea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyasuyea', habitual: 'jiyasuyesgoi', remote_past: 'jiyasuyesvi', imperative: 'jiyasuyagi', infinitive: 'jiyasuyesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gasuyea', habitual: 'gasuyesgoi', remote_past: 'agwasuyesvi', imperative: 'gasuyagi', infinitive: 'agwasuyesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyasuyea', habitual: 'hiyasuyesgoi', remote_past: 'hiyasuyesvi', imperative: 'hiyasuyagi', infinitive: 'hiyasuyesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hasuyea', habitual: 'hasuyesgoi', remote_past: 'jasuyesvi', imperative: 'hasuyagi', infinitive: 'jasuyesdi'],
            [subject: 'SG3', object: '', habitual: 'asuyesgoi', imperative: 'hiyasuyagi, hasuyagi', infinitive: 'usuyesdi', present: 'asuyea', remote_past: 'usuyesvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anasuyea', habitual: 'anasuyesgoi', remote_past: 'unasuyesvi', imperative: 'anasuyagi', infinitive: 'unasuyesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idasuyea', habitual: 'idasuyesgoi', remote_past: 'igasuyesvi', imperative: 'idasuyagi', infinitive: 'igasuyesdi']
        ]
    ]

    @Unroll
    def "conjugating Asuyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyasuyea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyasuyesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyasuyesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyasuyesvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyasuyesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gasuyea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gasuyesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwasuyesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gasuyesvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwasuyesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyasuyea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyasuyesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyasuyesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyasuyesvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyasuyesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hasuyea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hasuyesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jasuyesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hasuyesvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jasuyesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "asuyea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "asuyesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "usuyesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "asuyesvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "usuyesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anasuyea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anasuyesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unasuyesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anasuyesvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unasuyesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idasuyea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idasuyesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igasuyesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idasuyesvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igasuyesdi"
    }
}
