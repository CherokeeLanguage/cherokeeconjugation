// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73009 (entrya gadvvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadvvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyadvvsga, gadvvsga'],
            [subject: 'SG1', object: '', present: 'gadvvsga', habitual: 'gadvvsgoi', remote_past: 'agwadvnvi', imperative: 'gadvvga', infinitive: 'agwadvdi'],
            [subject: 'SG2', object: '', present: 'hadvvsga', habitual: 'hadvvsgoi', remote_past: 'jadvnvi', imperative: 'hadvvga', infinitive: 'jadvdi'],
            [subject: 'SG1', object: '', present: 'gadvvsga', habitual: 'gadvvsgoi', remote_past: 'udvnvi', imperative: 'wigadvvga', infinitive: 'udvdi'],
            [subject: 'SG3', object: '', habitual: 'gadvvsgoi', imperative: 'hadvvga', infinitive: 'udvdi', present: 'gadvvsga', remote_past: 'udvnvi']
        ]
    ]

    @Unroll
    def "conjugating Gadvvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadvvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadvdi"
        "SG2" | "" | Tense.PRESENT         | "hadvvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadvvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadvdi"
        "SG1" | "" | Tense.PRESENT         | "gadvvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadvdi"
        "SG3" | "" | Tense.PRESENT         | "gadvvsga"
        "SG3" | "" | Tense.HABITUAL        | "gadvvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advnvi"
        "SG3" | "" | Tense.INFINITIVE      | "udvdi"
    }
}
