// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72690 (entrya atvdvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvdvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Asking",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyatvdvhvsga, gatvdvhvsga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdvhvsga', habitual: 'jiyatvdvhvsgoi', remote_past: 'jiyatvdvhnvi', imperative: 'jiyatvdvhvga', infinitive: 'jiyatvtdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvdvhvsga', habitual: 'gatvdvhvsgoi', remote_past: 'agwatvdvhnvi', imperative: 'gatvdvhvga', infinitive: 'agwatvtdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdvhvsga', habitual: 'hiyatvdvhvsgoi', remote_past: 'hiyatvdvhnvi', imperative: 'hiyatvdvhvga', infinitive: 'hiyatvtdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvdvhvsga', habitual: 'hatvdvhvsgoi', remote_past: 'jatvdvhnvi', imperative: 'hatvdvhvga', infinitive: 'jatvtdi'],
            [subject: 'SG3', object: '', habitual: 'atvdvhvsgoi', imperative: 'hiyatvdvhvga, hatvdvhvga', infinitive: 'utvtdi', present: 'atvdvhvsga', remote_past: 'utvdvhnvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvdvhvsga', habitual: 'anatvdvhvsgoi', remote_past: 'unatvdvhnvi', imperative: 'anatvdvhvga', infinitive: 'unatvtdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvdvhvsga', habitual: 'idatvdvhvsgoi', remote_past: 'igatvdvhnvi', imperative: 'idatvdvhvga', infinitive: 'igatvtdi']
        ]
    ]

    @Unroll
    def "conjugating Atvdvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvdvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdvhvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdvhvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdvhnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdvnvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvtdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gatvdvhvsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gatvdvhvsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwatvdvhnvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvdvnvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwatvtdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdvhvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdvhvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdvhnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvdvnvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyatvtdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hatvdvhvsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hatvdvhvsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jatvdvhnvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvdvnvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jatvtdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advdvhvsga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advdvhvsgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdvnvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advdvnvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvtidi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anatvdvhvsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anatvdvhvsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unatvdvhnvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvdvnvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unatvtdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idatvdvhvsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idatvdvhvsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igatvdvhnvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvdvnvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igatvtdi"
    }
}
