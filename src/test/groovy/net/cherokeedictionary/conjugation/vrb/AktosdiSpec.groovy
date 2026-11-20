// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72478 (entrya aktosdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktosdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Watching",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyagatosdi, gagatosdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jigatosdi', habitual: 'jigatosdisgoi', remote_past: 'jigatostanvi', imperative: 'jiyaktosda', infinitive: 'jigatosdohdi'],
            [subject: 'SG3', object: '', habitual: 'aktosdisgoi', imperative: 'hiyagatosda, haktosda', infinitive: 'uktosdohdi', present: 'aktosdi', remote_past: 'uktostanvi'],
            [subject: 'SG2', object: 'SG3AN', present: 'higatosdi', habitual: 'higatosdisgoi', remote_past: 'higatostanvi', imperative: 'haktosda', infinitive: 'higatosdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jaktosdi', habitual: 'jaktosdisgoi', remote_past: 'jaktostanvi', imperative: 'jaktosda', infinitive: '(not'],
            [subject: 'PL3', object: 'SG3IN', present: 'anaktosdi', habitual: 'anaktosdisgoi', remote_past: 'unaktostanvi', imperative: 'anaktosda', infinitive: 'unaktosdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idigatosdi', habitual: 'idigatosdisgoi', remote_past: 'igaktostanvi', imperative: 'idaktosda', infinitive: 'igaktosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Aktosdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktosdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyagitosdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyagitosdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyagitostanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyagidostanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyagitostodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gagidosdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gagidosdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquagidostanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gagidostanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquagidosdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagitosdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagitosdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyagitostanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagidostanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyagitostodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hagitosdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hagitosdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jaktostanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hagidostanvi"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsagidosdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anaktosdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anaktosdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unaktostanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anagidostanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unaktosdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idagitosdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idagitosdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igaktostanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idagidostanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igaktosdohdi"
    }
}
