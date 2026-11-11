package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinidoha', habitual: 'jinidohoi', remote_past: 'aginidolvi', imperative: 'jinida', infinitive: 'aginidasdi'],
            [subject: 'SG2', object: '', present: 'hinidoha', habitual: 'hinidohoi', remote_past: 'janidolvi', imperative: 'hinida', infinitive: 'janidasdi'],
            [subject: 'SG1', object: '', present: 'ganidoha', habitual: 'ganidohoi', remote_past: 'uwanidolvi', imperative: 'ganida', infinitive: 'uwanidasdi'],
            [subject: 'PL3', object: '', present: 'aninidoha', habitual: 'aninidohoi', remote_past: 'uninidolvi', imperative: 'aninida', infinitive: 'uninidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinidoha"
        "SG1" | "" | Tense.HABITUAL        | "jinidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinida"
        "SG1" | "" | Tense.INFINITIVE      | "aginidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinida"
        "SG2" | "" | Tense.INFINITIVE      | "janidasdi"
        "SG1" | "" | Tense.PRESENT         | "ganidoha"
        "SG1" | "" | Tense.HABITUAL        | "ganidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uwanidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganida"
        "SG1" | "" | Tense.INFINITIVE      | "uwanidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninida"
        "PL3" | "" | Tense.INFINITIVE      | "uninidasdi"
    }
}
