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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gotlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gotlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquotlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gotlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwotlvnidi"
        "SG2" | "" | Tense.PRESENT         | "hotlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hotlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsotlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hotlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawotlvnidi"
        "SG3" | "" | Tense.PRESENT         | "gotlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gotlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwotlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "otlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwotlvnidi"
        "PL3" | "" | Tense.PRESENT         | "anotlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anotlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unotlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anotlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwotlvnidi"
        "PL1INCL" | "" | Tense.PRESENT         | "idotlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idotlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igotlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idotlvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwotlvnidi"
    }
}
