// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72379 (entrya ahnehiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnehihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Wrestling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gahnehiha'],
            [subject: 'SG1', object: '', present: 'gahnehiha', habitual: 'gahnehihoi', remote_past: 'agwahnehlvi', imperative: 'gahnega', infinitive: 'agwahnesdi'],
            [subject: 'SG2', object: '', present: 'hahnehiha', habitual: 'hahnehihoi', remote_past: 'jahnehlvi', imperative: 'hahnega', infinitive: 'jahnesdi'],
            [subject: 'SG3', object: '', habitual: 'ahnehihoi', imperative: 'hahnega', infinitive: 'uhnesdi', present: 'ahnehiha', remote_past: 'uhnehlvi'],
            [subject: 'PL3', object: '', present: 'anahnehiha', habitual: 'anahnehihoi', remote_past: 'unahnehlvi', imperative: 'anahnega', infinitive: 'unahnesdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnehiha', habitual: 'idahnehihoi', remote_past: 'igahnehlvi', imperative: 'idahnega', infinitive: 'igahnesdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnehiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnehiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganehiha"
        "SG1" | "" | Tense.HABITUAL        | "ganehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanesdi"
        "SG2" | "" | Tense.PRESENT         | "hanehiha"
        "SG2" | "" | Tense.HABITUAL        | "hanehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanesdi"
        "SG3" | "" | Tense.PRESENT         | "anehiha"
        "SG3" | "" | Tense.HABITUAL        | "anehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "unesdi"
        "PL3" | "" | Tense.PRESENT         | "ananehiha"
        "PL3" | "" | Tense.HABITUAL        | "ananehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganesdi"
    }
}
