// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72383 (entrya ahnesgeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnesgehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Building It (25)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ganesgeha'],
            [subject: 'SG1', object: '', present: 'ganesgeha', habitual: 'ganesgesgoi', remote_past: 'agwahnesgehvi', imperative: 'ganesgvla', infinitive: 'agwahnesgehdi'],
            [subject: 'SG2', object: '', present: 'hahnesgeha', habitual: 'hahnesgesgoi', remote_past: 'jahnesgehvi', imperative: 'hahnesgvla', infinitive: 'jahnesgehdi'],
            [subject: 'SG3', object: '', habitual: 'ahnesgesgoi', imperative: 'hahnesgvla', infinitive: 'uhnesgehdi', present: 'ahnesgeha', remote_past: 'uhnesgehvi'],
            [subject: 'PL3', object: '', present: 'anahnesgeha', habitual: 'anahnesgesgoi', remote_past: 'unahnesgehvi', imperative: 'anahnesgvla', infinitive: 'unahnesgehdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnesgeha', habitual: 'idahnesgesgoi', remote_past: 'igahnesgehvi', imperative: 'idahnesgvla', infinitive: 'igahnesgehdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnesgeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnesgeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganesgeha"
        "SG1" | "" | Tense.HABITUAL        | "ganesgesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanesgehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganesgehvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanesgedi"
        "SG2" | "" | Tense.PRESENT         | "hanesgeha"
        "SG2" | "" | Tense.HABITUAL        | "hanesgesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanesgehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanesgehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanesgedi"
        "SG3" | "" | Tense.PRESENT         | "anesgeha"
        "SG3" | "" | Tense.HABITUAL        | "anesgesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unesgehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anesgehvi"
        "SG3" | "" | Tense.INFINITIVE      | "unesgedi"
        "PL3" | "" | Tense.PRESENT         | "ananesgeha"
        "PL3" | "" | Tense.HABITUAL        | "ananesgesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanesgehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananesgehvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanesgedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanesgeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanesgesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganesgehvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanesgehvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganesgedi"
    }
}
