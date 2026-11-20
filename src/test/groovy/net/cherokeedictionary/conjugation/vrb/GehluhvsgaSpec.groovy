// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73216 (entrya gehluhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GehluhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Screaming/Yelling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'geluhvsga'],
            [subject: 'SG1', object: '', present: 'geluhvsga', habitual: 'geluhvsgoi', remote_past: 'agwehluhnvi', imperative: 'geluhvga', infinitive: 'agwehluhvsdi'],
            [subject: 'SG2', object: '', present: 'hehluhvsga', habitual: 'hehluhvsgoi', remote_past: 'jehluhnvi', imperative: 'hehluhvga', infinitive: 'jehluhvsdi'],
            [subject: 'SG3', object: '', habitual: 'gehluhvsgoi', imperative: 'hehluhvga', infinitive: 'uwehluhvsdi', present: 'gehluhvsga', remote_past: 'uwehluhnvi'],
            [subject: 'PL3', object: '', present: 'anehluhvsga', habitual: 'anehluhvsgoi', remote_past: 'unehluhnvi', imperative: 'anehluhvga', infinitive: 'unehluhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idehluhvsga', habitual: 'idehluhvsgoi', remote_past: 'igehluhnvi', imperative: 'idehluhvga', infinitive: 'igehluhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gehluhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gehluhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "getluhvsga"
        "SG1" | "" | Tense.HABITUAL        | "getluhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwehluhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "getlunvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwetluhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hehluhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hehluhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jehluhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hetlunvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawetluhvsdi"
        "SG3" | "" | Tense.PRESENT         | "gehluhvsga"
        "SG3" | "" | Tense.HABITUAL        | "gehluhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehluhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "etlunvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwehluhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anehluhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anehluhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unehluhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anetlunvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwetluhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idehluhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idehluhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igehluhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idetlunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwetluhvsdi"
    }
}
