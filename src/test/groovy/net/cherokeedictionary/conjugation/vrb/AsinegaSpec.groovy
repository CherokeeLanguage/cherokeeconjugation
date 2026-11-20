// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72624 (entrya asinega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsinegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Backing Up",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gasinega'],
            [subject: 'SG1', object: '', present: 'gasinega', habitual: 'gasinegoi', remote_past: 'agwasinvsvi', imperative: 'gasinuga', infinitive: 'agwasinvsdi'],
            [subject: 'SG2', object: '', present: 'hasinega', habitual: 'hasinegoi', remote_past: 'jasinvsvi', imperative: 'hasinuga', infinitive: 'jasinvsdi'],
            [subject: 'SG3', object: '', habitual: 'asinegoi', imperative: 'hasinuga', infinitive: 'usinvsdi', present: 'asinega', remote_past: 'usinvsvi'],
            [subject: 'PL3', object: '', present: 'anasinega', habitual: 'anasinegoi', remote_past: 'unasinvsvi', imperative: 'anisinuga', infinitive: 'unasinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idasinega', habitual: 'idasinegoi', remote_past: 'igasinvsvi', imperative: 'idisinuga', infinitive: 'igasinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Asinega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asinega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gasinega"
        "SG1" | "" | Tense.HABITUAL        | "gasinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwasinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwasinvsdi"
        "SG2" | "" | Tense.PRESENT         | "hasinega"
        "SG2" | "" | Tense.HABITUAL        | "hasinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jasinvsdi"
        "SG3" | "" | Tense.PRESENT         | "asinega"
        "SG3" | "" | Tense.HABITUAL        | "asinegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usinvsdi"
        "PL3" | "" | Tense.PRESENT         | "anasinega"
        "PL3" | "" | Tense.HABITUAL        | "anasinegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unasinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unasinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasinega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igasinvsdi"
    }
}
