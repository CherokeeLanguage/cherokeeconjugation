// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72449) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72449 (entrya akehega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AkehegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Chasing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsigehega'],
            [subject: 'SG3', object: '', habitual: 'agehegoi', imperative: 'higehuga, higehuga', infinitive: 'ugehvsdi', present: 'agehega', remote_past: 'ugehvsvi'],
            [subject: 'PL3', object: '', present: 'anikehega', habitual: 'anikehegoi', remote_past: 'unikehvsvi', imperative: 'anikehuga', infinitive: 'unikehvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idikehega', habitual: 'idikehegoi', remote_past: 'igikehvsvi', imperative: 'idikehuga', infinitive: 'igikehvsdi']
        ]
    ]

    @Unroll
    def "conjugating Akehega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Akehega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigehega"
        "SG1" | "" | Tense.HABITUAL        | "tsigehegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigehvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigehvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigehvsdi"
        "PL3" | "" | Tense.PRESENT         | "anigehega"
        "PL3" | "" | Tense.HABITUAL        | "anigehegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigehvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigehvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigehvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigehega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigehegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigehvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigehvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigehvsdi"
    }
}
