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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyagilvdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyagilvdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyagilvtanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyagilvtanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyagilvdodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gagilvdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gagilvdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquagilvtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gagilvtanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquagilvdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagilvdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagilvdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "agilvtanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagilvtanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "agilvdodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hagilvdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hagilvdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsagilvtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hagilvtanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsagilvdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "agilvdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "agilvdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ugilvtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "agilvtanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ugilvdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anagilvdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anagilvdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unagilvtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anagilvtanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unagilvdodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idagilvdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idagilvdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igagilvtanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idagilvtanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igagilvdodi"
    }
}
