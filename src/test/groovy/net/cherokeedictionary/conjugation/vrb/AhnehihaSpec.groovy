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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gahnehiha"
        "SG1" | "" | Tense.HABITUAL        | "gahnehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwahnesdi"
        "SG2" | "" | Tense.PRESENT         | "hahnehiha"
        "SG2" | "" | Tense.HABITUAL        | "hahnehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnesdi"
        "SG3" | "" | Tense.PRESENT         | "ahnehiha"
        "SG3" | "" | Tense.HABITUAL        | "ahnehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnesdi"
        "PL3" | "" | Tense.PRESENT         | "anahnehiha"
        "PL3" | "" | Tense.HABITUAL        | "anahnehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unahnesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahnehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahnehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahnesdi"
    }
}
