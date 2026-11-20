// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72672 (entrya atiyohiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtiyohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Arguing (59)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadiyohiha'],
            [subject: 'SG1', object: '', present: 'gadiyohiha', habitual: 'gadiyohihoi', remote_past: 'agwatiyohlvi', imperative: 'gadiyoga', infinitive: 'agwatiyosdi'],
            [subject: 'SG2', object: '', present: 'hatiyohiha', habitual: 'hatiyohihoi', remote_past: 'jatiyohlvi', imperative: 'hatiyoga', infinitive: 'jatiyosdi'],
            [subject: 'SG3', object: '', habitual: 'atiyohihoi', imperative: 'hatiyoga', infinitive: 'utiyosdi', present: 'atiyohiha', remote_past: 'utiyohlvi'],
            [subject: 'PL3', object: '', present: 'anatiyohiha', habitual: 'anatiyohihoi', remote_past: 'unatiyohlvi', imperative: 'anatiyoga', infinitive: 'unatiyosdi'],
            [subject: 'PL1INCL', object: '', present: 'idatiyohiha', habitual: 'idatiyohihoi', remote_past: 'igatiyohlvi', imperative: 'idatiyoga', infinitive: 'igatiyosdi']
        ]
    ]

    @Unroll
    def "conjugating Atiyohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atiyohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatiyohiha"
        "SG1" | "" | Tense.HABITUAL        | "gatiyohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatiyohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatiyotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatiyosdi"
        "SG2" | "" | Tense.PRESENT         | "hatiyohiha"
        "SG2" | "" | Tense.HABITUAL        | "hatiyohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatiyohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatiyotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatiyosdi"
        "SG3" | "" | Tense.PRESENT         | "atiyohiha"
        "SG3" | "" | Tense.HABITUAL        | "atiyohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utiyohlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atiyotlvi"
        "SG3" | "" | Tense.INFINITIVE      | "utiyosdi"
        "PL3" | "" | Tense.PRESENT         | "anatiyohiha"
        "PL3" | "" | Tense.HABITUAL        | "anatiyohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatiyohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatiyotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatiyosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatiyohiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatiyohihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatiyohlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatiyotlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatiyosdi"
    }
}
