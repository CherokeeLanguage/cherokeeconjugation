// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73897) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73897 (entrya unaligoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnaligohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Together (They are) (175)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ogaligoha'],
            [subject: 'SG1', object: '', present: 'oginaligoha', habitual: 'oginaligosoi', remote_past: 'oginaligosvi', imperative: 'oginaligosesdi', infinitive: 'oginadalisohdi'],
            [subject: 'SG2', object: '', present: 'ogaligoha', habitual: 'ogaligosoi', remote_past: 'ogaligosvi', imperative: 'ogaligosesdi', infinitive: 'ogadalisohdi'],
            // tio 17Nov26: SG3 infinitive supplied from the 2012 book (Unaligoha, Together p.48: unadalisohdi) -- the yaml extraction left '----'.
            [subject: 'SG3', object: '', habitual: 'unaligosoi', imperative: 'itsaligosesdi', infinitive: 'unadalisohdi', present: 'unaligoha', remote_past: 'unaligosvi'],
            [subject: 'PL3', object: '', present: 'ijaligoha', habitual: 'ijaligosoi', remote_past: 'ijaligosvi', imperative: 'ijaligosesdi', infinitive: 'ijadalisohdi'],
            [subject: 'PL1INCL', object: '', present: 'igaligoha', habitual: 'igaligosoi', remote_past: 'igaligosvi', imperative: 'igaligosesdi', infinitive: 'igadalisohdi']
        ]
    ]

    @Unroll
    def "conjugating Unaligoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unaligoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginaligoha"
        "SG1" | "" | Tense.HABITUAL        | "aginaligosoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginaligosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginaligosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginadalisohdi"
        "SG2" | "" | Tense.PRESENT         | "ogaligoha"
        "SG2" | "" | Tense.HABITUAL        | "ogaligosoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ogaligosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanaligosvi"
        "SG2" | "" | Tense.INFINITIVE      | "ogadalisohdi"
        "SG3" | "" | Tense.PRESENT         | "unaligoha"
        "SG3" | "" | Tense.HABITUAL        | "unaligosoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unaligosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unaligosvi"
        "SG3" | "" | Tense.INFINITIVE      | "unadalisohdi"
        "PL3" | "" | Tense.PRESENT         | "ijaligoha"
        "PL3" | "" | Tense.HABITUAL        | "ijaligosoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "ijaligosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninaligosvi"
        "PL3" | "" | Tense.INFINITIVE      | "ijadalisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igaligoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igaligosoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaligosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginaligosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadalisohdi"
    }
}
