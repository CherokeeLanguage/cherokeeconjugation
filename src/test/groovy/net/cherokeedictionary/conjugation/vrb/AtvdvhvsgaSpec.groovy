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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadvdvhvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadvdvhvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadvdvnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdvnvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadvtidi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadvdvhvsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadvdvhvsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquadvdvnvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvdvnvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquadvtidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadvdvhvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadvdvhvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "advdvnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvdvnvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "advtidi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadvdvhvsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadvdvhvsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsadvdvnvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvdvnvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsadvtidi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advdvhvsga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advdvhvsgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdvnvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advdvnvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvtidi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadvdvhvsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadvdvhvsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadvdvnvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvdvnvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadvtidi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idadvdvhvsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadvdvhvsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadvdvnvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvdvnvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadvtidi"
    }
}
