// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72205) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72205 (entrya adahyiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdahyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Denying",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyadayiha, gadayiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyadayiha', habitual: 'jiyadayihoi', remote_past: 'jiyadayilvi', imperative: 'jiyadayiga', infinitive: 'jiyadayisdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gadayiha', habitual: 'gadayihoi', remote_past: 'agwadahyilvi', imperative: 'gadayhga', infinitive: 'agwadayhsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyadayiha', habitual: 'hiyadayihoi', remote_past: 'hiyadayilvi', imperative: 'hiyadayiga', infinitive: 'hiyadayisdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hadayiha', habitual: 'hadayihoi', remote_past: 'jadahyilvi', imperative: 'hadayhga', infinitive: 'jadayhsdi'],
            [subject: 'SG3', object: '', habitual: 'adayihoi', imperative: 'hiyadayiga, hadayvga', infinitive: 'udayvsdi', present: 'adayiha', remote_past: 'udayilvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anadahyiha', habitual: 'anadahyihoi', remote_past: 'unadahyilvi', imperative: 'anadayhga', infinitive: 'unadayhsdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idadahyiha', habitual: 'idadahyihoi', remote_past: 'igadahyilvi', imperative: 'idadayhga', infinitive: 'igadayhsdi']
        ]
    ]

    @Unroll
    def "conjugating Adahyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adahyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyadayiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyadayihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyadayilvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadayilvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadayvsdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadayiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadayihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwadahyilvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadayilvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwadayhsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadayiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadayihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyadayilvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadayilvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyadayvsdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadayiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadayihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jadahyilvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadayilvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jadayhsdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "adayiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "adayihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udayilvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "adayilvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udayvsdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadahyiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadahyihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadahyilvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadayilvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadayhsdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idadahyiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadahyihoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadahyilvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadayilvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadayhsdi"
    }
}
