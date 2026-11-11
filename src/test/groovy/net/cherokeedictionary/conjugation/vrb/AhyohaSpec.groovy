package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for Him",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoha', habitual: 'jiyohoi', remote_past: 'jiyalvi', imperative: 'jiyga', infinitive: 'jiysdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hihyoha', habitual: 'hihyohoi', remote_past: 'hiyalvi', imperative: 'hiyhga', infinitive: 'hiysdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ahyoha', habitual: 'ahyohoi', remote_past: 'uhyalvi', imperative: 'ayhga', infinitive: 'uysdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anihyoha', habitual: 'anihyohoi', remote_past: 'unihyalvi', imperative: 'aniyhga', infinitive: 'uniysdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edihyoha', habitual: 'edihyohoi', remote_past: 'edihyalvi', imperative: 'ediyhga', infinitive: 'ediysdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyoha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyohoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyalvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiysdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hihyoha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hihyohoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyhga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiysdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ahyoha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ahyohoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uhyalvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayhga"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uysdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anihyoha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anihyohoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unihyalvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyhga"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniysdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edihyoha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edihyohoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edihyalvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyhga"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediysdi"
    }
}
