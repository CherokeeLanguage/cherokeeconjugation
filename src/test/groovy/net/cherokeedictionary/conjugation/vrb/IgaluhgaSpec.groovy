package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class IgaluhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Returning (131)*",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ijiluhga', habitual: 'ijiluhgoi', remote_past: 'vagiluhjvi', imperative: 'jijiluhgi', infinitive: 'vagiluhisdi'],
            [subject: 'SG3', object: '', present: 'ihiluhga', habitual: 'ihiluhgoi', remote_past: 'vjaluhjvi', imperative: 'jihiluhgi', infinitive: 'vjaluhisdi'],
            [subject: 'SG3', object: '', present: 'ianiluhga', habitual: 'ianiluhgoi', remote_past: 'vuniluhjvi', imperative: 'jianiluhgi', infinitive: 'vuniluhisdi'],
            [subject: 'SG3', object: '', present: 'iidiluhga', habitual: 'iidiluhgoi', remote_past: 'vigiluhjvi', imperative: 'jiidiluhgi', infinitive: 'vigiluhisdi']
        ]
    ]

    @Unroll
    def "conjugating Igaluhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Igaluhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ijiluhga"
        "SG3" | "" | Tense.HABITUAL        | "ijiluhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "vagiluhjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jijiluhgi"
        "SG3" | "" | Tense.INFINITIVE      | "vagiluhisdi"
        "SG3" | "" | Tense.PRESENT         | "ihiluhga"
        "SG3" | "" | Tense.HABITUAL        | "ihiluhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "vjaluhjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jihiluhgi"
        "SG3" | "" | Tense.INFINITIVE      | "vjaluhisdi"
        "SG3" | "" | Tense.PRESENT         | "ianiluhga"
        "SG3" | "" | Tense.HABITUAL        | "ianiluhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "vuniluhjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jianiluhgi"
        "SG3" | "" | Tense.INFINITIVE      | "vuniluhisdi"
        "SG3" | "" | Tense.PRESENT         | "iidiluhga"
        "SG3" | "" | Tense.HABITUAL        | "iidiluhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "vigiluhjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jiidiluhgi"
        "SG3" | "" | Tense.INFINITIVE      | "vigiluhisdi"
    }
}
