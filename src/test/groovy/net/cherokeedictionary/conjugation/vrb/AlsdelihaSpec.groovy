package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsdelihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Helping",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galisdeliha', habitual: 'galisdelisgoi', remote_past: 'agwalsdelvhvi', imperative: 'galisdela', infinitive: 'agwalsdehldi'],
            [subject: 'SG2', object: '', present: 'halisdeliha', habitual: 'halisdelisgoi', remote_past: 'jalsdelvhvi', imperative: 'halsdela', infinitive: 'jalsdehldi'],
            [subject: 'SG3', object: '', present: 'alsdeliha', habitual: 'alsdelisgoi', remote_past: 'ulsdelvhvi', imperative: 'alsdela', infinitive: 'ulsdehldi'],
            [subject: 'PL3', object: '', present: 'analsdeliha', habitual: 'analsdelisgoi', remote_past: 'unalsdelvhvi', imperative: 'analsdela', infinitive: 'unalsdehldi'],
            [subject: 'PL1INCL', object: '', present: 'idalsdeliha', habitual: 'idalsdelisgoi', remote_past: 'igalsdelvhvi', imperative: 'idalsdela', infinitive: 'igalsdehldi']
        ]
    ]

    @Unroll
    def "conjugating Alsdeliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsdeliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisdeliha"
        "SG1" | "" | Tense.HABITUAL        | "galisdelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsdelvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisdela"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsdehldi"
        "SG2" | "" | Tense.PRESENT         | "halisdeliha"
        "SG2" | "" | Tense.HABITUAL        | "halisdelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsdelvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halsdela"
        "SG2" | "" | Tense.INFINITIVE      | "jalsdehldi"
        "SG3" | "" | Tense.PRESENT         | "alsdeliha"
        "SG3" | "" | Tense.HABITUAL        | "alsdelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsdelvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alsdela"
        "SG3" | "" | Tense.INFINITIVE      | "ulsdehldi"
        "PL3" | "" | Tense.PRESENT         | "analsdeliha"
        "PL3" | "" | Tense.HABITUAL        | "analsdelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsdelvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analsdela"
        "PL3" | "" | Tense.INFINITIVE      | "unalsdehldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsdeliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsdelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsdelvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalsdela"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsdehldi"
    }
}
