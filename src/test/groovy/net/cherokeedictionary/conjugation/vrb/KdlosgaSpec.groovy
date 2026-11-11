package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fire/Light is Going Out (143)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'kdlosga', habitual: 'kdlosgoi', remote_past: 'uwadlosvi', imperative: 'kdlohi', infinitive: 'uwadlohisdi'],
            [subject: 'SG3', object: '', present: 'anvhdlosga', habitual: 'anvhdlosgoi', remote_past: 'unhdlosvi', imperative: 'anvhdlohi', infinitive: 'unhdlohisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "kdlosga"
        "SG3" | "" | Tense.HABITUAL        | "kdlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kdlohi"
        "SG3" | "" | Tense.INFINITIVE      | "uwadlohisdi"
        "SG3" | "" | Tense.PRESENT         | "anvhdlosga"
        "SG3" | "" | Tense.HABITUAL        | "anvhdlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unhdlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anvhdlohi"
        "SG3" | "" | Tense.INFINITIVE      | "unhdlohisdi"
    }
}
