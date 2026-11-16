// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72806 (entrya dasehiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasehihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Counting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degasehiha'],
            [subject: 'SG1', object: '', present: 'degasehiha', habitual: 'degasehihoi', remote_past: 'dagwasehlvi', imperative: 'digasega', infinitive: 'digwasesdi'],
            [subject: 'SG2', object: '', present: 'dehasehiha', habitual: 'dehasehihoi', remote_past: 'dejasehlvi', imperative: 'tasega', infinitive: 'dijasesdi'],
            [subject: 'SG3', object: '', habitual: 'dasehihoi', imperative: 'tasega', infinitive: 'jusesdi', present: 'dasehiha', remote_past: 'dusehlvi'],
            [subject: 'PL3', object: '', present: 'danasehiha', habitual: 'danasehihoi', remote_past: 'dunasehlvi', imperative: 'dinasega', infinitive: 'junasesdi'],
            [subject: 'PL1INCL', object: '', present: 'dedasehiha', habitual: 'dedasehihoi', remote_past: 'degasehlvi', imperative: 'didasega', infinitive: 'digasesdi']
        ]
    ]

    @Unroll
    def "conjugating Dasehiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasehiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gasehiha"
        "SG1" | "" | Tense.HABITUAL        | "gasehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquasetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisesdi"
        "SG2" | "" | Tense.PRESENT         | "hasehiha"
        "SG2" | "" | Tense.HABITUAL        | "hasehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasesdi"
        "SG3" | "" | Tense.PRESENT         | "dasehiha"
        "SG3" | "" | Tense.HABITUAL        | "dasehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "usesdi"
        "PL3" | "" | Tense.PRESENT         | "anasehiha"
        "PL3" | "" | Tense.HABITUAL        | "anasehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unasetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisesdi"
    }
}
