package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwehluhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Yelling/Howling, etc.",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwehluga', habitual: 'agwehluhgoi', remote_past: 'agwehluhnvi', imperative: 'geluvga', infinitive: 'agwehluhvsdi'],
            [subject: 'SG2', object: '', present: 'jehluga', habitual: 'jehluhgoi', remote_past: 'jehluhnvi', imperative: 'hehluhvga', infinitive: 'jehluhvsdi'],
            [subject: 'SG3', object: '', present: 'uwehluhga', habitual: 'uwehluhgoi', remote_past: 'uwehluhnvi', imperative: 'uwehluhvga', infinitive: 'uwehluhvsdi'],
            [subject: 'PL3', object: '', present: 'unehluhga', habitual: 'unehluhgoi', remote_past: 'unehluhnvi', imperative: 'unehluhvga', infinitive: 'unehluhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igehluhga', habitual: 'igehluhgoi', remote_past: 'igehluhnvi', imperative: 'igehluhvga', infinitive: 'igehluhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Uwehluhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwehluhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwehluga"
        "SG1" | "" | Tense.HABITUAL        | "agwehluhgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwehluhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "geluvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwehluhvsdi"
        "SG2" | "" | Tense.PRESENT         | "jehluga"
        "SG2" | "" | Tense.HABITUAL        | "jehluhgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jehluhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hehluhvga"
        "SG2" | "" | Tense.INFINITIVE      | "jehluhvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwehluhga"
        "SG3" | "" | Tense.HABITUAL        | "uwehluhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehluhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwehluhvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwehluhvsdi"
        "PL3" | "" | Tense.PRESENT         | "unehluhga"
        "PL3" | "" | Tense.HABITUAL        | "unehluhgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unehluhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unehluhvga"
        "PL3" | "" | Tense.INFINITIVE      | "unehluhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igehluhga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igehluhgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igehluhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igehluhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igehluhvsdi"
    }
}
