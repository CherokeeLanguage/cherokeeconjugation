package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agihyoha', habitual: 'agihyohoi', remote_past: 'agihyalvi', imperative: 'agiyhga', infinitive: 'agiysdi'],
            [subject: 'SG2', object: '', present: 'jahyhoha', habitual: 'jahyohoi', remote_past: 'jahyalvi', imperative: 'jayhga', infinitive: 'jaysdi'],
            [subject: 'SG3', object: '', present: 'uhyoha', habitual: 'uhyohoi', remote_past: 'uhyalvi', imperative: 'uyhga', infinitive: 'uysdi'],
            [subject: 'PL3', object: '', present: 'unihyoha', habitual: 'unihyohoi', remote_past: 'unihyalvi', imperative: 'uniyhga', infinitive: 'uniysdi'],
            [subject: 'PL1INCL', object: '', present: 'igihyoha', habitual: 'igihyohoi', remote_past: 'igihyalvi', imperative: 'igiyhga', infinitive: 'igiysdi']
        ]
    ]

    @Unroll
    def "conjugating Uhyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agihyoha"
        "SG1" | "" | Tense.HABITUAL        | "agihyohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihyalvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyhga"
        "SG1" | "" | Tense.INFINITIVE      | "agiysdi"
        "SG2" | "" | Tense.PRESENT         | "jahyhoha"
        "SG2" | "" | Tense.HABITUAL        | "jahyohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahyalvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jayhga"
        "SG2" | "" | Tense.INFINITIVE      | "jaysdi"
        "SG3" | "" | Tense.PRESENT         | "uhyoha"
        "SG3" | "" | Tense.HABITUAL        | "uhyohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyalvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyhga"
        "SG3" | "" | Tense.INFINITIVE      | "uysdi"
        "PL3" | "" | Tense.PRESENT         | "unihyoha"
        "PL3" | "" | Tense.HABITUAL        | "unihyohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihyalvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyhga"
        "PL3" | "" | Tense.INFINITIVE      | "uniysdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihyoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihyohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihyalvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyhga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiysdi"
    }
}
