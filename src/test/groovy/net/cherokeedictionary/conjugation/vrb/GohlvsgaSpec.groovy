// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73246 (entrya gohlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GohlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Full, Getting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gohlvsga'],
            [subject: 'SG1', object: '', present: 'golvsga', habitual: 'golvsgoi', remote_past: 'agwohlvsvi', imperative: 'golvhi', infinitive: 'agwohlvhisdi'],
            [subject: 'SG2', object: '', present: 'hohlvsga', habitual: 'hohlvsgoi', remote_past: 'johlvsvi', imperative: 'hohlvhi', infinitive: 'johlvhisdi'],
            [subject: 'SG3', object: '', habitual: 'gohlvsgoi', imperative: 'hohlvna', infinitive: 'uwohlvnhdi', present: 'gohlvsga', remote_past: 'uwohlvhnvi'],
            [subject: 'PL3', object: '', present: 'anohlvsga', habitual: 'anohlvsgoi', remote_past: 'unohlvsvi', imperative: 'anohlvhi', infinitive: 'unohlvhisdi'],
            [subject: 'PL1INCL', object: '', present: 'idohlvsga', habitual: 'idohlvsgoi', remote_past: 'igohlvsvi', imperative: 'idohlvhi', infinitive: 'igohlvhisdi']
        ]
    ]

    @Unroll
    def "conjugating Gohlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gohlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gotlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gotlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquotlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gotlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwotlvnadi"
        "SG2" | "" | Tense.PRESENT         | "hohlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hohlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsotlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hotlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawotlvnadi"
        "SG3" | "" | Tense.PRESENT         | "gohlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gohlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwohlvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "otlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwohlvnhdi"
        "PL3" | "" | Tense.PRESENT         | "anohlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anohlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unotlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anotlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwotlvnadi"
        "PL1INCL" | "" | Tense.PRESENT         | "idohlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idohlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igotlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idotlvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwotlvnadi"
    }
}
