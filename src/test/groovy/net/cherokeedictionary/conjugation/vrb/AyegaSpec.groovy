package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waking Up",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyega', habitual: 'jiyegoi', remote_past: 'agiyejvi', imperative: 'jiyegi', infinitive: 'agiyeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyega', habitual: 'hiyegoi', remote_past: 'jayejvi', imperative: 'hiyegi', infinitive: 'jayeisdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayega', habitual: 'ayegoi', remote_past: 'uyejvi', imperative: 'ayegi', infinitive: 'uyeisdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyega', habitual: 'aniyegoi', remote_past: 'uniyejvi', imperative: 'aniyegi', infinitive: 'uniyeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyega', habitual: 'idiyegoi', remote_past: 'igiyejvi', imperative: 'idiyegi', infinitive: 'igiyeisdi']
        ]
    ]

    @Unroll
    def "conjugating Ayega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyejvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyegi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayejvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyegi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyejvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayegi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyejvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyegi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyejvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyegi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyeisdi"
    }
}
