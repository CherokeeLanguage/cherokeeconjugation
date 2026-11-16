// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72350) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72350 (entrya ahili) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhiliSpec extends VerbBaseSpec {
    static def details = [
        definition: "Driving",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiili'],
            [subject: 'SG1', object: '', present: 'tsiili', habitual: 'jiilegoi', remote_past: '/', imperative: 'jiilisoi', infinitive: 'agihilvsvi'],
            [subject: 'SG2', object: '', present: 'hihili', habitual: 'hihilegoi', remote_past: '/', imperative: 'hihilisoi', infinitive: 'jahilvsvi'],
            [subject: 'SG3', object: '', habitual: 'ahilisoi', imperative: '', infinitive: 'uhilvsdi', present: 'ahili', remote_past: 'uhilvsvi'],
            [subject: 'PL3', object: '', present: 'anihili', habitual: 'anihilegoi', remote_past: '/', imperative: 'anihilisoi', infinitive: 'unihilvsvi'],
            [subject: 'PL1INCL', object: '', present: 'idihili', habitual: 'idihilegoi', remote_past: '/', imperative: 'idihilisoi', infinitive: 'igihilvsvi']
        ]
    ]

    @Unroll
    def "conjugating Ahili (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahili", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsihili"
        "SG1" | "" | Tense.HABITUAL        | "tsihilisoi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "/"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG1" | "" | Tense.INFINITIVE      | "agihilvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihili"
        "SG2" | "" | Tense.HABITUAL        | "hihilisoi"
        // "SG2" | "" | Tense.REMOTE_PAST     | "/"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG2" | "" | Tense.INFINITIVE      | "tsahilvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahili"
        "SG3" | "" | Tense.HABITUAL        | "ahilisoi"
        // "SG3" | "" | Tense.REMOTE_PAST     | "/"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG3" | "" | Tense.INFINITIVE      | "uhilvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihili"
        "PL3" | "" | Tense.HABITUAL        | "anihilisoi"
        // "PL3" | "" | Tense.REMOTE_PAST     | "/"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "/"
        "PL3" | "" | Tense.INFINITIVE      | "unihilvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihili"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihilisoi"
        // "PL1INCL" | "" | Tense.REMOTE_PAST     | "/"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "/"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihilvsdi"
    }
}
