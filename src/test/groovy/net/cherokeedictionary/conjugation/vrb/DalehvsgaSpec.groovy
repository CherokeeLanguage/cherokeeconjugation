package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DalehvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Up (From Sitting) (73)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degalevsga', habitual: 'degalevsgoi', remote_past: 'dagwalehnvi', imperative: 'digalevga', infinitive: 'digwalehdi'],
            [subject: 'SG2', object: '', present: 'dehalehvsga', habitual: 'dehalehvsgoi', remote_past: 'dejalehnvi', imperative: 'talehvga', infinitive: 'dijalehdi'],
            [subject: 'SG3', object: '', present: 'dalehvsga', habitual: 'dalehvsgoi', remote_past: 'dulehnvi', imperative: 'dilehvga', infinitive: 'julehdi'],
            [subject: 'PL3', object: '', present: 'danalehvsga', habitual: 'danalehvsgoi', remote_past: 'dunalehnvi', imperative: 'dinalehvga', infinitive: 'junalehdi'],
            [subject: 'PL1INCL', object: '', present: 'dedalehvsga', habitual: 'dedalehvsgoi', remote_past: 'degalehnvi', imperative: 'didalehvga', infinitive: 'digalehdi']
        ]
    ]

    @Unroll
    def "conjugating Dalehvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dalehvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalevsga"
        "SG1" | "" | Tense.HABITUAL        | "degalevsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwalehnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digalevga"
        "SG1" | "" | Tense.INFINITIVE      | "digwalehdi"
        "SG2" | "" | Tense.PRESENT         | "dehalehvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehalehvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalehnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "talehvga"
        "SG2" | "" | Tense.INFINITIVE      | "dijalehdi"
        "SG3" | "" | Tense.PRESENT         | "dalehvsga"
        "SG3" | "" | Tense.HABITUAL        | "dalehvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulehnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dilehvga"
        "SG3" | "" | Tense.INFINITIVE      | "julehdi"
        "PL3" | "" | Tense.PRESENT         | "danalehvsga"
        "PL3" | "" | Tense.HABITUAL        | "danalehvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunalehnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinalehvga"
        "PL3" | "" | Tense.INFINITIVE      | "junalehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedalehvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedalehvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degalehnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didalehvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digalehdi"
    }
}
