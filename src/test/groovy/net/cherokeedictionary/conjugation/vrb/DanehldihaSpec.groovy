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
        distributiveDst2: true, // tio 20Nov26: infinitive uses the DST2 di- form (M-A §10.1; dijiyanehldohdi/digwanehldohdi rows)
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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: PL3 Set B cells re-pinned per user ruling + guide P7(15)/126a (uni- serves all 3rd-person objects; y/a stem spelling per the SG3 row)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "dejiyanehldiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "dejiyanehldisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "dejiyanehltanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyanelotanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "dijiyanehldohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "deganehldiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "deganehldisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "dagwanehltanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganelotanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "digwanehldohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "dehiyanehldiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "dehiyanehldisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "dehiyanehltanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyanelotanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "tiyanehldohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "dehanehldiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "dehanehldisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "dejanehltanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanelotanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "dijanehldohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "danelodiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "danelodisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "dunelotanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anelotanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unelododi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "dananehldiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "dananehldisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "dunanehltanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananelotanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "tsuninelotodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "dadanelodiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "dadanelodisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "daganelotanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idanelotanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "diganehldohdi"
    }
}
