// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72752 (entrya dahlinoheha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DahlinohehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Talking To, Conversing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degalinoheha'],
            [subject: 'SG1', object: '', present: 'degalinoheha', habitual: 'degalinohesgoi', remote_past: 'dagwahlinohehlvi', imperative: 'digalinohvla', infinitive: 'digwahlinohehdi'],
            [subject: 'SG2', object: '', present: 'dehahlinoheha', habitual: 'dehahlinohesgoi', remote_past: 'dejahlinohehlvi', imperative: 'tahlinohvla', infinitive: 'dijahlinohehdi'],
            [subject: 'SG3', object: '', habitual: 'dahlinohesgoi', imperative: 'tahlinohvla', infinitive: 'juhlinohehdi', present: 'dahlinoheha', remote_past: 'duhlinohehlvi'],
            [subject: 'PL3', object: '', present: 'danahlinoheha', habitual: 'danahlinohesgoi', remote_past: 'dunahlinohehlvi', imperative: 'dinahlinohvla', infinitive: 'junahlinohehdi'],
            [subject: 'PL1INCL', object: '', present: 'dedahlinoheha', habitual: 'dedahlinohesgoi', remote_past: 'degahlinohehlvi', imperative: 'didahlinohvla', infinitive: 'didahlinohehdi']
        ]
    ]

    @Unroll
    def "conjugating Dahlinoheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahlinoheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalinoheha"
        "SG1" | "" | Tense.HABITUAL        | "degalinohesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwahlinohehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatlinohetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwahlinohehdi"
        "SG2" | "" | Tense.PRESENT         | "dehahlinoheha"
        "SG2" | "" | Tense.HABITUAL        | "dehahlinohesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejahlinohehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatlinohetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijahlinohehdi"
        "SG3" | "" | Tense.PRESENT         | "dahlinoheha"
        "SG3" | "" | Tense.HABITUAL        | "dahlinohesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhlinohehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlinohetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "juhlinohehdi"
        "PL3" | "" | Tense.PRESENT         | "danahlinoheha"
        "PL3" | "" | Tense.HABITUAL        | "danahlinohesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunahlinohehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatlinohetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "junahlinohehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedahlinoheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedahlinohesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degahlinohehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatlinohetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "didahlinohehdi"
    }
}
