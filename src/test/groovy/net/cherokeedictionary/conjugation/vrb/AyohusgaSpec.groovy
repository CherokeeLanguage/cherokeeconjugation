package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohusgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dying (S/he)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyousga', habitual: 'jiyousgoi', remote_past: 'jiyousvi', imperative: 'jiyouhi', infinitive: 'agiyohuhisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyohusga', habitual: 'hiyohusgoi', remote_past: 'hiyohusvi', imperative: 'hiyohuhi', infinitive: 'jayohuhisdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayohusga', habitual: 'ayohusgoi', remote_past: 'uyohusvi', imperative: 'ayohuhi', infinitive: 'uyohuhisdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyohusga', habitual: 'aniyohusgoi', remote_past: 'uniyohusvi', imperative: 'aniyohuhi', infinitive: 'uniyohusdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyohusga', habitual: 'idiyohusgoi', remote_past: 'igiyohusvi', imperative: 'idiyohuhi', infinitive: 'igiyohusdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohusga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohusga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyousga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyousgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyousvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyouhi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyohuhisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyohusga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohusgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyohusvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyohuhi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayohuhisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayohusga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohusgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyohusvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayohuhi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyohuhisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyohusga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohusgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyohusvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyohuhi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyohusdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyohusga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyohusgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyohusvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyohuhi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyohusdi"
    }
}
