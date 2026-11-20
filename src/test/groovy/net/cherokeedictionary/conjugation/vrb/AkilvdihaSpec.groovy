// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72451 (entrya akilvdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyakilvdiha, gakilvdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyakilvdiha', habitual: 'jiyakilvdisgoi', remote_past: 'jiyakilvtanvi', imperative: 'jiyakilvda', infinitive: 'jiyakilvdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gakilvdiha', habitual: 'gakilvdisgoi', remote_past: 'agwakilvtanvi', imperative: 'gakilvda', infinitive: 'agwakilvdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyakilvdiha', habitual: 'hiyakilvdisgoi', remote_past: 'hiyakilvtanvi', imperative: 'hiyakilvda', infinitive: 'hiyakilvdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hakilvdiha', habitual: 'hakilvdisgoi', remote_past: 'jakilvtanvi', imperative: 'hakilvda', infinitive: 'jakilvdohdi'],
            [subject: 'SG3', object: '', habitual: 'akilvdisgoi', imperative: 'hiyakilvda, hakilvda', infinitive: 'ukilvdohdi', present: 'akilvdiha', remote_past: 'ukilvtanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anakilvdiha', habitual: 'anakilvdisgoi', remote_past: 'unakilvtanvi', imperative: 'anakilvda', infinitive: 'unakilvdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idakilvdiha', habitual: 'idakilvdisgoi', remote_past: 'igakilvtanvi', imperative: 'idakilvda', infinitive: 'igakilvdohdi']
        ]
    ]

    @Unroll
    def "conjugating Akilvdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akilvdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyakilvdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyakilvdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyakilvtanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyagilvtanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyakilvdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gakilvdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gakilvdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwakilvtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gagilvtanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwakilvdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyakilvdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyakilvdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyakilvtanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagilvtanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyakilvdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hakilvdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hakilvdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jakilvtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hagilvtanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jakilvdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "agilvdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "agilvdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ugilvtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "agilvtanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ugilvdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anakilvdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anakilvdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unakilvtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anagilvtanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unakilvdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idakilvdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idakilvdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igakilvtanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idagilvtanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igakilvdohdi"
    }
}
