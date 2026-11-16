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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatlinoheha"
        "SG1" | "" | Tense.HABITUAL        | "gatlinohesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatlinohetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatlinohetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlinohedi"
        "SG2" | "" | Tense.PRESENT         | "hatlinoheha"
        "SG2" | "" | Tense.HABITUAL        | "hatlinohesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlinohetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatlinohetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlinohedi"
        "SG3" | "" | Tense.PRESENT         | "datlinoheha"
        "SG3" | "" | Tense.HABITUAL        | "datlinohesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlinohetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlinohetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlinohedi"
        "PL3" | "" | Tense.PRESENT         | "anatlinoheha"
        "PL3" | "" | Tense.HABITUAL        | "anatlinohesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatlinohetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatlinohetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitlinohedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatlinoheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatlinohesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatlinohetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatlinohetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitlinohedi"
    }
}
