// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73552) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73552 (entrya nania) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NaniaSpec extends VerbBaseSpec {
    static def details = [
        definition: "There Are (#)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'notsia'],
            [subject: 'SG1', object: '', present: 'nosdia', habitual: 'nosdioi', remote_past: 'X', imperative: 'nosdiesdi', infinitive: 'There'],
            [subject: 'SG2', object: '', present: 'nojia', habitual: 'nojioi', remote_past: 'nojiesdi', imperative: 'There', infinitive: 'Are'],
            [subject: 'SG3', object: '', habitual: 'nanioi', imperative: 'nitsiesdi', infinitive: '----', present: 'nania', remote_past: '----'],
            [subject: 'PL3', object: '', present: 'nijia', habitual: 'nijioi', remote_past: 'nijiesdi', imperative: 'There', infinitive: 'Are'],
            [subject: 'PL1INCL', object: '', present: 'nania', habitual: 'nanioi', remote_past: 'naniesdi', imperative: 'There', infinitive: 'Are']
        ]
    ]

    @Unroll
    def "conjugating Nania (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nania", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gania"
        "SG1" | "" | Tense.HABITUAL        | "ganioi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "aginisdiesdi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gani"
        "SG1" | "" | Tense.INFINITIVE      | "There"
        "SG2" | "" | Tense.PRESENT         | "hania"
        "SG2" | "" | Tense.HABITUAL        | "hanioi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanisdiesdi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hani"
        "SG2" | "" | Tense.INFINITIVE      | "Are"
        "SG3" | "" | Tense.PRESENT         | "nania"
        "SG3" | "" | Tense.HABITUAL        | "nanioi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unisdiesdi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ani"
        "SG3" | "" | Tense.INFINITIVE      | "Are"
        "PL3" | "" | Tense.PRESENT         | "anania"
        "PL3" | "" | Tense.HABITUAL        | "ananioi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninisdiesdi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anani"
        "PL3" | "" | Tense.INFINITIVE      | "Are"
        "PL1INCL" | "" | Tense.PRESENT         | "idania"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanioi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginisdiesdi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idani"
        "PL1INCL" | "" | Tense.INFINITIVE      | "Are"
    }
}
