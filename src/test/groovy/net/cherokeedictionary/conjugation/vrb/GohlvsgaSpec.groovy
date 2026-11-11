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
            [subject: 'SG1', object: '', present: 'golvsga', habitual: 'golvsgoi', remote_past: 'agwohlvsvi', imperative: 'golvhi', infinitive: 'agwohlvhisdi'],
            [subject: 'SG2', object: '', present: 'hohlvsga', habitual: 'hohlvsgoi', remote_past: 'johlvsvi', imperative: 'hohlvhi', infinitive: 'johlvhisdi'],
            [subject: 'SG3', object: '', present: 'gohlvsga', habitual: 'gohlvsgoi', remote_past: 'uwohlvsvi', imperative: 'gohlvhi', infinitive: 'uwohlvhisdi'],
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
        "SG1" | "" | Tense.PRESENT         | "golvsga"
        "SG1" | "" | Tense.HABITUAL        | "golvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwohlvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "golvhi"
        "SG1" | "" | Tense.INFINITIVE      | "agwohlvhisdi"
        "SG2" | "" | Tense.PRESENT         | "hohlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hohlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "johlvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hohlvhi"
        "SG2" | "" | Tense.INFINITIVE      | "johlvhisdi"
        "SG3" | "" | Tense.PRESENT         | "gohlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gohlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwohlvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gohlvhi"
        "SG3" | "" | Tense.INFINITIVE      | "uwohlvhisdi"
        "PL3" | "" | Tense.PRESENT         | "anohlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anohlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unohlvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anohlvhi"
        "PL3" | "" | Tense.INFINITIVE      | "unohlvhisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idohlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idohlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igohlvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idohlvhi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igohlvhisdi"
    }
}
