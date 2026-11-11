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
            [subject: 'SG1', object: '', present: 'geluhvsga', habitual: 'geluhvsgoi', remote_past: 'agwehluhnvi', imperative: 'geluhvga', infinitive: 'agwehluhvsdi'],
            [subject: 'SG2', object: '', present: 'hehluhvsga', habitual: 'hehluhvsgoi', remote_past: 'jehluhnvi', imperative: 'hehluhvga', infinitive: 'jehluhvsdi'],
            [subject: 'SG3', object: '', present: 'gehluhvsga', habitual: 'gehluhvsgoi', remote_past: 'uwehluhnvi', imperative: 'gehluhvga', infinitive: 'uwehluhvsdi'],
            [subject: 'PL3', object: '', present: 'anehluhvsga', habitual: 'anehluhvsgoi', remote_past: 'unehluhnvi', imperative: 'anehluhvga', infinitive: 'unehluhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idehluhvsga', habitual: 'idehluhvsgoi', remote_past: 'igehluhnvi', imperative: 'idehluhvga', infinitive: 'igehluhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gehluhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gehluhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "geluhvsga"
        "SG1" | "" | Tense.HABITUAL        | "geluhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwehluhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "geluhvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwehluhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hehluhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hehluhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jehluhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hehluhvga"
        "SG2" | "" | Tense.INFINITIVE      | "jehluhvsdi"
        "SG3" | "" | Tense.PRESENT         | "gehluhvsga"
        "SG3" | "" | Tense.HABITUAL        | "gehluhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwehluhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gehluhvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwehluhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anehluhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anehluhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unehluhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anehluhvga"
        "PL3" | "" | Tense.INFINITIVE      | "unehluhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idehluhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idehluhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igehluhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idehluhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igehluhvsdi"
    }
}
