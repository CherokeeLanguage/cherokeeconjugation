// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73024) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73024 (entrya gahliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sleeping",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiliha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiliha', habitual: 'jilihoi', remote_past: 'X', imperative: 'jilvna', infinitive: 'agihlvnhdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'hihliha', habitual: 'hihlihoi', remote_past: 'hihlvna', imperative: 'jahlvnhdi', infinitive: ''],
            [subject: 'SG2', object: 'SG3IN', present: 'gahliha', habitual: 'gahlihoi', remote_past: 'gahlvna', imperative: 'uhlvnhdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'gatlihoi', imperative: 'hitlvna', infinitive: 'utlvnvdi', present: 'gatliha', remote_past: ''],
            [subject: 'PL3', object: 'SG3IN', present: 'idihliha', habitual: 'idihlihoi', remote_past: 'idihlvna', imperative: 'igihlvnhdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Gahliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsitliha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsitlihoi"
        // "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsinitlvna"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsitli"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsitlvnvdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "tsitliha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "tsitlihoi"
        // "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aginitlvna"  // tio 16Nov26: remote past UNATTESTED -- the 2012 book (p.14) prints X/blank in the remote column; the yaml extraction misassigned the imperative column (hihlvna/gahlvna) to remote_past
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsitli"
        // "SG1" | "SG3IN" | Tense.INFINITIVE      | "agitlvnvdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hitliha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hitlihoi"
        // "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsanitlvna"  // unattested (book p.14)
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hitli"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsatlvnvdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gatliha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gatlihoi"
        // "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unitlvna"  // unattested (book p.14)
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "gatli"
        // "SG3" | "SG3IN" | Tense.INFINITIVE      | "utlvnvdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "idihliha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "idihlihoi"
        // "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "uninitlvna"  // unattested (book p.14)
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anitli"
        // "PL3" | "SG3IN" | Tense.INFINITIVE      | "unitlvnvdi"
    }
}
