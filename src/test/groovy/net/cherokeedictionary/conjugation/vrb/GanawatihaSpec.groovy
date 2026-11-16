package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanawatihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinawatiha', habitual: 'jinawatisgoi', remote_past: 'aginawatvhvi', imperative: 'jinawata', infinitive: 'aginawatvhdi'],
            [subject: 'SG2', object: '', present: 'hinawatiha', habitual: 'hinawatisgoi', remote_past: 'janawatvhvi', imperative: 'hinawata', infinitive: 'janawatvhdi'],
            [subject: 'SG3', object: '', present: 'ganawatiha', habitual: 'ganawatisgoi', remote_past: 'unawatvhvi', imperative: 'ganawata', infinitive: 'unawatvhdi'],
            [subject: 'PL3', object: '', present: 'aninawatiha', habitual: 'aninawatisgoi', remote_past: 'uninawatvhvi', imperative: 'aninawata', infinitive: 'uninawatvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ganawatiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganawatiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinawatiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinawatisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawadvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinawadvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginawadvdi"
        "SG2" | "" | Tense.PRESENT         | "hinawatiha"
        "SG2" | "" | Tense.HABITUAL        | "hinawatisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanawadvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinawadvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanawadvdi"
        "SG1" | "" | Tense.PRESENT         | "tsinawatiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinawatisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawadvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinawadvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginawadvdi"
        "PL3" | "" | Tense.PRESENT         | "aninawatiha"
        "PL3" | "" | Tense.HABITUAL        | "aninawatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninawadvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninawadvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninawadvdi"
    }
}
