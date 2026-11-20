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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degasehiha"
        "SG1" | "" | Tense.HABITUAL        | "degasehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwasehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwasesdi"
        "SG2" | "" | Tense.PRESENT         | "dehasehiha"
        "SG2" | "" | Tense.HABITUAL        | "dehasehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejasehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijasesdi"
        "SG3" | "" | Tense.PRESENT         | "dasehiha"
        "SG3" | "" | Tense.HABITUAL        | "dasehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dusehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "jusesdi"
        "PL3" | "" | Tense.PRESENT         | "danasehiha"
        "PL3" | "" | Tense.HABITUAL        | "danasehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunasehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "junasesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedasehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedasehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degasehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digasesdi"
    }
}
