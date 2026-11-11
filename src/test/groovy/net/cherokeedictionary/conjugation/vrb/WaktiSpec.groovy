package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WaktiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going (Specific Direction)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'wijigati', habitual: 'wijitatoi', remote_past: 'wijigatvi', imperative: 'wijigatesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'hwakti', habitual: '/', remote_past: 'hwigati', imperative: 'hwaktoi', infinitive: '/'],
            [subject: 'SG3', object: '', present: 'wakti', habitual: 'waktoi', remote_past: 'waktvi', imperative: 'waktesdi', infinitive: ''],
            [subject: 'PL3', object: '', present: 'wanakti', habitual: 'wanaktoi', remote_past: 'wanaktvi', imperative: 'wanaktesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'widakti', habitual: 'widaktoi', remote_past: 'widaktvi', imperative: 'widaktesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Wakti (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wakti", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "wijigati"
        "SG1" | "" | Tense.HABITUAL        | "wijitatoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "wijigatvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wijigatesdi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "hwakti"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "hwigati"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwaktoi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "wakti"
        "SG3" | "" | Tense.HABITUAL        | "waktoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "waktvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waktesdi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "wanakti"
        "PL3" | "" | Tense.HABITUAL        | "wanaktoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "wanaktvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanaktesdi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "widakti"
        "PL1INCL" | "" | Tense.HABITUAL        | "widaktoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "widaktvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "widaktesdi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
