package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiwidiha', habitual: 'jiwidisgoi', remote_past: 'akiwidvhvi', imperative: 'jiwida', infinitive: 'akiwitdi'],
            [subject: 'SG2', object: '', present: 'hihwidiha', habitual: 'hihwidisgoi', remote_past: 'jahwidvhvi', imperative: 'hihwida', infinitive: 'jahwitdi'],
            [subject: 'SG3', object: '', present: 'ahwidiha', habitual: 'ahwidisgoi', remote_past: 'uhwidvhvi', imperative: 'ahwida', infinitive: 'uhwitdi'],
            [subject: 'PL3', object: '', present: 'anihwidiha', habitual: 'anihwidisgoi', remote_past: 'unihwidvhvi', imperative: 'anihwida', infinitive: 'unihwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwidiha"
        "SG1" | "" | Tense.HABITUAL        | "jiwidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akiwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiwida"
        "SG1" | "" | Tense.INFINITIVE      | "akiwitdi"
        "SG2" | "" | Tense.PRESENT         | "hihwidiha"
        "SG2" | "" | Tense.HABITUAL        | "hihwidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahwidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihwida"
        "SG2" | "" | Tense.INFINITIVE      | "jahwitdi"
        "SG3" | "" | Tense.PRESENT         | "ahwidiha"
        "SG3" | "" | Tense.HABITUAL        | "ahwidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahwida"
        "SG3" | "" | Tense.INFINITIVE      | "uhwitdi"
        "PL3" | "" | Tense.PRESENT         | "anihwidiha"
        "PL3" | "" | Tense.HABITUAL        | "anihwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihwida"
        "PL3" | "" | Tense.INFINITIVE      | "unihwitdi"
    }
}
