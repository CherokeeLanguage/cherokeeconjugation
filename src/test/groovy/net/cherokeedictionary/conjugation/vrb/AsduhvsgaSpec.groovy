// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72580 (entrya asduhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsduhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Closing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisduhvsga'],
            [subject: 'SG1', object: '', present: 'jisduhvsga', habitual: 'jisduhvsgoi', remote_past: 'aksduhnvi', imperative: 'jisduhvga', infinitive: 'aksdudi'],
            [subject: 'SG2', object: '', present: 'hisduhvsga', habitual: 'hisduhvsgoi', remote_past: 'tsduhnvi', imperative: 'hisduhvga', infinitive: 'tsdudi'],
            [subject: 'SG3', object: '', habitual: 'asduhvsgoi', imperative: 'hisduhvga, hisduhvga', infinitive: 'usdudi', present: 'asduhvsga', remote_past: 'usduhnvi'],
            [subject: 'PL3', object: '', present: 'anisduhvsga', habitual: 'anisduhvsgoi', remote_past: 'unsduhnvi', imperative: 'anisduhvga', infinitive: 'unsdudi'],
            [subject: 'PL1INCL', object: '', present: 'idisduhvsga', habitual: 'idisduhvsgoi', remote_past: 'iksduhnvi', imperative: 'idisduhvga', infinitive: 'iksdudi']
        ]
    ]

    @Unroll
    def "conjugating Asduhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asduhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisduhvsga"
        "SG1" | "" | Tense.HABITUAL        | "jisduhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksduhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisdunvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksdudi"
        "SG2" | "" | Tense.PRESENT         | "hisduhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hisduhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsduhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdunvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsdudi"
        "SG3" | "" | Tense.PRESENT         | "asduhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asduhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usduhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usdudi"
        "PL3" | "" | Tense.PRESENT         | "anisduhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anisduhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsduhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdunvi"
        "PL3" | "" | Tense.INFINITIVE      | "unsdudi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisduhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisduhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksduhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksdudi"
    }
}
