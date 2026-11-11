package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinewidiha', habitual: 'jinewidisgoi', remote_past: 'aginehwidvhvi', imperative: 'jinewida', infinitive: 'aginehwitdi'],
            [subject: 'SG2', object: '', present: 'hinehwidiha', habitual: 'hinehwidisgoi', remote_past: 'jenehwidvhvi', imperative: 'hinehwida', infinitive: 'janehwitdi'],
            [subject: 'SG1', object: '', present: 'ganehwidiha', habitual: 'ganehwidisgoi', remote_past: 'unehwidvhvi', imperative: 'ganehwida', infinitive: 'unehwitdi'],
            [subject: 'PL3', object: '', present: 'aninehwidiha', habitual: 'aninehwidisgoi', remote_past: 'uninehwidvhvi', imperative: 'aninehwida', infinitive: 'uninehwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinewidiha"
        "SG1" | "" | Tense.HABITUAL        | "jinewidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinewida"
        "SG1" | "" | Tense.INFINITIVE      | "aginehwitdi"
        "SG2" | "" | Tense.PRESENT         | "hinehwidiha"
        "SG2" | "" | Tense.HABITUAL        | "hinehwidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jenehwidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehwida"
        "SG2" | "" | Tense.INFINITIVE      | "janehwitdi"
        "SG1" | "" | Tense.PRESENT         | "ganehwidiha"
        "SG1" | "" | Tense.HABITUAL        | "ganehwidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unehwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehwida"
        "SG1" | "" | Tense.INFINITIVE      | "unehwitdi"
        "PL3" | "" | Tense.PRESENT         | "aninehwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aninehwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehwida"
        "PL3" | "" | Tense.INFINITIVE      | "uninehwitdi"
    }
}
