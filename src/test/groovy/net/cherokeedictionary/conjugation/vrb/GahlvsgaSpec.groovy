// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73033 (entrya gahlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jilvsga'],
            [subject: 'SG1', object: '', present: 'jilvsga', habitual: 'jilvsgoi', remote_past: 'agihlvanvi', imperative: 'jilvga', infinitive: 'agihldi'],
            [subject: 'SG2', object: '', present: 'hihlvsga', habitual: 'hihlvsgoi', remote_past: 'jahlanvi', imperative: 'hihlvga', infinitive: 'jahldi'],
            [subject: 'SG3', object: '', habitual: 'gahlvsgoi', imperative: 'hihlvna', infinitive: 'uhlvnhdi', present: 'gahlvsga', remote_past: 'uhlvhnvi'],
            [subject: 'PL3', object: '', present: 'anihlvsga', habitual: 'anihlvsgoi', remote_past: 'unihlanvi', imperative: 'wanihlvga', infinitive: 'unihldi']
        ]
    ]

    @Unroll
    def "conjugating Gahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihlvanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihldi"
        "SG2" | "" | Tense.PRESENT         | "hihlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahlanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahldi"
        "SG1" | "" | Tense.PRESENT         | "jilvsga"
        "SG1" | "" | Tense.HABITUAL        | "jilvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihlvanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihldi"
        "PL3" | "" | Tense.PRESENT         | "anihlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anihlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihldi"
    }
}
