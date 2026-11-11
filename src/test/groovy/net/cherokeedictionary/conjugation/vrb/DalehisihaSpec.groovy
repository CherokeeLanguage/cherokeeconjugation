package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DalehisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Recuperating",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degaleisiha', habitual: 'degalehisisgoi', remote_past: 'dagwalehisahnvi', imperative: 'digalehisa', infinitive: 'digwalehisohdi'],
            [subject: 'SG2', object: '', present: 'dehaleisiha', habitual: 'dehalehisisgoi', remote_past: 'dejalehisahnvi', imperative: 'talehisa', infinitive: 'dijalehisohdi'],
            [subject: 'SG3', object: '', present: 'daleisiha', habitual: 'dalehisisgoi', remote_past: 'dulehisahnvi', imperative: 'dilehisa', infinitive: 'julehisohdi'],
            [subject: 'PL3', object: '', present: 'danaleisiha', habitual: 'danalehisisgoi', remote_past: 'dunalehisahnvi', imperative: 'dinalehisa', infinitive: 'junalehisohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedaleisiha', habitual: 'dedalehisisgoi', remote_past: 'degalehisahnvi', imperative: 'didalehisa', infinitive: 'digalehisohdi']
        ]
    ]

    @Unroll
    def "conjugating Dalehisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dalehisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degaleisiha"
        "SG1" | "" | Tense.HABITUAL        | "degalehisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwalehisahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digalehisa"
        "SG1" | "" | Tense.INFINITIVE      | "digwalehisohdi"
        "SG2" | "" | Tense.PRESENT         | "dehaleisiha"
        "SG2" | "" | Tense.HABITUAL        | "dehalehisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalehisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "talehisa"
        "SG2" | "" | Tense.INFINITIVE      | "dijalehisohdi"
        "SG3" | "" | Tense.PRESENT         | "daleisiha"
        "SG3" | "" | Tense.HABITUAL        | "dalehisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulehisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dilehisa"
        "SG3" | "" | Tense.INFINITIVE      | "julehisohdi"
        "PL3" | "" | Tense.PRESENT         | "danaleisiha"
        "PL3" | "" | Tense.HABITUAL        | "danalehisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunalehisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinalehisa"
        "PL3" | "" | Tense.INFINITIVE      | "junalehisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedaleisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedalehisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degalehisahnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didalehisa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digalehisohdi"
    }
}
