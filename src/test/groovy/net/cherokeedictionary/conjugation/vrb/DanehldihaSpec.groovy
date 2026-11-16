// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72798 (entrya danehldiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanehldihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Playing (with Him/It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejiyanehldiha, deganehldiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'dejiyanehldiha', habitual: 'dejiyanehldisgoi', remote_past: 'dejiyanehltanvi', imperative: 'dijiyanehlda', infinitive: 'dijiyanehldohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'deganehldiha', habitual: 'deganehldisgoi', remote_past: 'dagwanehltanvi', imperative: 'diganehlda', infinitive: 'digwanehldohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'dehiyanehldiha', habitual: 'dehiyanehldisgoi', remote_past: 'dehiyanehltanvi', imperative: 'tiyanehlda', infinitive: 'tiyanehldohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'dehanehldiha', habitual: 'dehanehldisgoi', remote_past: 'dejanehltanvi', imperative: 'tanehlda', infinitive: 'dijanehldohdi'],
            [subject: 'SG3', object: '', habitual: 'danehldisgoi', imperative: 'tiyanehlda, tanehlda', infinitive: 'junehldohdi', present: 'danehldiha', remote_past: 'dunehltanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'dananehldiha', habitual: 'dananehldisgoi', remote_past: 'dunanehltanvi', imperative: 'dinanehlda', infinitive: 'junanehldohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'dedanehldiha', habitual: 'dedanehldisgoi', remote_past: 'deganehltanvi', imperative: 'didanehlda', infinitive: 'diganehldohdi']
        ]
    ]

    @Unroll
    def "conjugating Danehldiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danehldiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyanelodiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyanelodisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyanelotanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyanelotanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsinelododi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "ganelodiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "ganelodisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquanelotanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganelotanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aginelododi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyanelodiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyanelodisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "anelotanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyanelotanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "nelododi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hanelodiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hanelodisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsanelotanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanelotanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsanelododi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "danelodiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "danelodisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unelotanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anelotanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unelododi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "ananelodiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "ananelodisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanelotanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananelotanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uninelododi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idanelodiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idanelodisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iganelotanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idanelotanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iginelododi"
    }
}
