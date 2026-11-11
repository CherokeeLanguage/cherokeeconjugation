package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsdelihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Helping (Him/Her)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisdeliha', habitual: 'jisdelisgoi', remote_past: 'jisdelvhvi', imperative: 'jisdela', infinitive: 'jisdehldi'],
            [subject: 'SG2', object: '', present: 'hisdeliha', habitual: 'hisdelisgoi', remote_past: 'hisdelvhvi', imperative: 'hisdela', infinitive: 'hisdehldi'],
            [subject: 'SG3', object: '', present: 'asdeliha', habitual: 'asdelisgoi', remote_past: 'usdelvhvi', imperative: 'asdela', infinitive: 'usdehldi'],
            [subject: 'PL3', object: '', present: 'anisdeliha', habitual: 'anisdelisgoi', remote_past: 'unsdelvhvi', imperative: 'anisdela', infinitive: 'unsdehldi'],
            [subject: 'PL1INCL', object: '', present: 'edisdeliha', habitual: 'edisdelisgoi', remote_past: 'edisdelvhvi', imperative: 'edisdela', infinitive: 'edisdehldi']
        ]
    ]

    @Unroll
    def "conjugating Asdeliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asdeliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisdeliha"
        "SG1" | "" | Tense.HABITUAL        | "jisdelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jisdelvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisdela"
        "SG1" | "" | Tense.INFINITIVE      | "jisdehldi"
        "SG2" | "" | Tense.PRESENT         | "hisdeliha"
        "SG2" | "" | Tense.HABITUAL        | "hisdelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hisdelvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdela"
        "SG2" | "" | Tense.INFINITIVE      | "hisdehldi"
        "SG3" | "" | Tense.PRESENT         | "asdeliha"
        "SG3" | "" | Tense.HABITUAL        | "asdelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usdelvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdela"
        "SG3" | "" | Tense.INFINITIVE      | "usdehldi"
        "PL3" | "" | Tense.PRESENT         | "anisdeliha"
        "PL3" | "" | Tense.HABITUAL        | "anisdelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsdelvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdela"
        "PL3" | "" | Tense.INFINITIVE      | "unsdehldi"
        "PL1INCL" | "" | Tense.PRESENT         | "edisdeliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "edisdelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edisdelvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edisdela"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edisdehldi"
    }
}
