// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73771 (entrya uduliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdulihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Want",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwaduliha'],
            [subject: 'SG1', object: '', present: 'agwaduliha', habitual: 'agwadulihoi', remote_past: 'agwadulihvi', imperative: 'agwadula', infinitive: 'agwaduhldi'],
            [subject: 'SG2', object: '', present: 'jaduliha', habitual: 'jadulihoi', remote_past: 'jadulihvi', imperative: 'jadula', infinitive: 'jaduhldi'],
            [subject: 'SG3', object: '', habitual: 'udulisgoi', imperative: 'jadula', infinitive: 'uduhldi', present: 'uduliha', remote_past: 'udulvhvi'],
            [subject: 'PL3', object: '', present: 'unaduliha', habitual: 'unadulihoi', remote_past: 'unadulihvi', imperative: 'unadula', infinitive: 'unaduhldi'],
            [subject: 'PL1INCL', object: '', present: 'igaduliha', habitual: 'igadulihoi', remote_past: 'igadulihvi', imperative: 'igadula', infinitive: 'igaduhldi']
        ]
    ]

    @Unroll
    def "conjugating Uduliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uduliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwaduliha"
        "SG1" | "" | Tense.HABITUAL        | "agwadulihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadulihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadulvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwaduhldi"
        "SG2" | "" | Tense.PRESENT         | "jaduliha"
        "SG2" | "" | Tense.HABITUAL        | "jadulihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadulihvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadulvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "jaduhldi"
        "SG3" | "" | Tense.PRESENT         | "uduliha"
        "SG3" | "" | Tense.HABITUAL        | "udulisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udulvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udulvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uduhldi"
        "PL3" | "" | Tense.PRESENT         | "unaduliha"
        "PL3" | "" | Tense.HABITUAL        | "unadulihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadulihvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadulvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unaduhldi"
        "PL1INCL" | "" | Tense.PRESENT         | "igaduliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadulihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadulihvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadulvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaduhldi"
    }
}
