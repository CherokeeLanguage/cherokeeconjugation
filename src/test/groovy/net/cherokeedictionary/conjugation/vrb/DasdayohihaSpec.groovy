// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72803 (entrya dasdayohiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasdayohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shooting (75)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejisdayohiha'],
            [subject: 'SG1', object: '', present: 'dejisdayohiha', habitual: 'dejisdayohihoi', remote_past: 'daksdayohlvi', imperative: 'dijisdayoha', infinitive: 'diksdayosdi'],
            [subject: 'SG2', object: '', present: 'deihisdayohiha', habitual: 'dehisdayohihoi', remote_past: 'detsdayohlvi', imperative: 'tisdayoha', infinitive: 'ditsdayosdi'],
            [subject: 'SG3', object: '', habitual: 'dasdayohihoi', imperative: 'tisdayoha, tisdayoha', infinitive: 'jusdayosdi', present: 'dasdayohiha', remote_past: 'dusdayohlvi'],
            [subject: 'PL3', object: '', present: 'danisdayohiha', habitual: 'danisdayohihoi', remote_past: 'dunisdayohlvi', imperative: 'dinasdayoha', infinitive: 'junisdayosdi'],
            [subject: 'PL1INCL', object: '', present: 'dedisdayohiha', habitual: 'dedisdayohihoi', remote_past: 'deksdayohlvi', imperative: 'didisdayoha', infinitive: 'diksdayosdi']
        ]
    ]

    @Unroll
    def "conjugating Dasdayohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasdayohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisdayohiha"
        "SG1" | "" | Tense.HABITUAL        | "tsisdayohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisdayotlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisdayotlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisdayosdi"
        "SG2" | "" | Tense.PRESENT         | "hisdayohiha"
        "SG2" | "" | Tense.HABITUAL        | "hisdayohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasdayotlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdayotlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasdayosdi"
        "SG3" | "" | Tense.PRESENT         | "dasdayohiha"
        "SG3" | "" | Tense.HABITUAL        | "dasdayohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdayotlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gasdayotlvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdayosdi"
        "PL3" | "" | Tense.PRESENT         | "anisdayohiha"
        "PL3" | "" | Tense.HABITUAL        | "anisdayohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisdayotlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdayotlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisdayosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisdayohiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisdayohihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisdayotlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdayotlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisdayosdi"
    }
}
