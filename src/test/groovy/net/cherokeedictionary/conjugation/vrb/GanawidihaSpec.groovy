package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanawidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinawidiha', habitual: 'jinawidisgoi', remote_past: 'aginawidvhvi', imperative: 'jinawida', infinitive: 'aginawitdi'],
            [subject: 'SG2', object: '', present: 'hinawidiha', habitual: 'hinawidisgoi', remote_past: 'janawidvhvi', imperative: 'hinawida', infinitive: 'janawitdi'],
            [subject: 'SG1', object: '', present: 'ganawidiha', habitual: 'ganawidisgoi', remote_past: 'unawidvhvi', imperative: 'ganawida', infinitive: 'unawitdi'],
            [subject: 'PL3', object: '', present: 'aninawidiha', habitual: 'aninawidisgoi', remote_past: 'uninawidvhvi', imperative: 'aninawida', infinitive: 'uninawitdi']
        ]
    ]

    @Unroll
    def "conjugating Ganawidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganawidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinawidiha"
        "SG1" | "" | Tense.HABITUAL        | "jinawidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinawida"
        "SG1" | "" | Tense.INFINITIVE      | "aginawitdi"
        "SG2" | "" | Tense.PRESENT         | "hinawidiha"
        "SG2" | "" | Tense.HABITUAL        | "hinawidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janawidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinawida"
        "SG2" | "" | Tense.INFINITIVE      | "janawitdi"
        "SG1" | "" | Tense.PRESENT         | "ganawidiha"
        "SG1" | "" | Tense.HABITUAL        | "ganawidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unawidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganawida"
        "SG1" | "" | Tense.INFINITIVE      | "unawitdi"
        "PL3" | "" | Tense.PRESENT         | "aninawidiha"
        "PL3" | "" | Tense.HABITUAL        | "aninawidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninawidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninawida"
        "PL3" | "" | Tense.INFINITIVE      | "uninawitdi"
    }
}
