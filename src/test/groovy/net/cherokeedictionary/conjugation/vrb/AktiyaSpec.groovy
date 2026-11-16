// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72473) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72473 (entrya aktiya) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktiyaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waiting",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsigatiya, tsigatiya'],
            [subject: 'SG2', object: 'SG3AN', present: 'higatiya', habitual: '/', remote_past: 'hiktiya', imperative: 'higatiyoi', infinitive: '/'],
            [subject: 'SG1', object: '', present: 'aktiya', habitual: 'aktiyoi', remote_past: 'uktidvi', imperative: 'aktida', infinitive: 'uktidisdi'],
            [subject: 'SG3', object: '', habitual: 'agatiyoi', imperative: 'higatida, higatida', infinitive: 'ugatidisdi', present: 'agatiya', remote_past: 'ugatidvi'],
            [subject: 'PL1INCL', object: '', present: 'idaktiya', habitual: 'idaktiyoi', remote_past: 'igaktidvi', imperative: 'idaktida', infinitive: 'igaktidisdi']
        ]
    ]

    @Unroll
    def "conjugating Aktiya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktiya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG2" | "SG3AN" | Tense.PRESENT         | "higatiya"
        // "SG2" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "gatidvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "higatidvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "tsigatiya"
        "SG1" | "" | Tense.HABITUAL        | "tsigatiyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigatidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigatidvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigatidisdi"
        "SG3" | "" | Tense.PRESENT         | "agatiya"
        "SG3" | "" | Tense.HABITUAL        | "agatiyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugatidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agatidvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugatidisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigatiya"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigatiyoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigatidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigatidvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigatidisdi"
    }
}
