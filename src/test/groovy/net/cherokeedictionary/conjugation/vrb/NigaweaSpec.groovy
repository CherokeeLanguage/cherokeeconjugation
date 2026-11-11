package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigaweaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Saying/Meowing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'nijiwea', habitual: 'nijiwesgoi', remote_past: 'nagiwesvi', imperative: 'nijiwi', infinitive: 'iyagiwesdi'],
            [subject: 'SG2', object: '', present: 'hniwea', habitual: 'hniwesgoi', remote_past: 'nijawesvi', imperative: 'hniwi', infinitive: 'iyijawesdi'],
            [subject: 'SG3', object: '', present: 'nigawea', habitual: 'nigawesgoi', remote_past: 'nuwesvi', imperative: 'nigawi', infinitive: 'iyuwesdi'],
            [subject: 'PL3', object: '', present: 'naniwea', habitual: 'naniwesgoi', remote_past: 'nuniwesvi', imperative: 'naniwi', infinitive: 'iyuniwesdi'],
            [subject: 'PL1INCL', object: '', present: 'nidiwea', habitual: 'nidiwesgoi', remote_past: 'nigiwesvi', imperative: 'nidiwi', infinitive: 'iyigiwesdi']
        ]
    ]

    @Unroll
    def "conjugating Nigawea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigawea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "nijiwea"
        "SG1" | "" | Tense.HABITUAL        | "nijiwesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "nagiwesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "nijiwi"
        "SG1" | "" | Tense.INFINITIVE      | "iyagiwesdi"
        "SG2" | "" | Tense.PRESENT         | "hniwea"
        "SG2" | "" | Tense.HABITUAL        | "hniwesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "nijawesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hniwi"
        "SG2" | "" | Tense.INFINITIVE      | "iyijawesdi"
        "SG3" | "" | Tense.PRESENT         | "nigawea"
        "SG3" | "" | Tense.HABITUAL        | "nigawesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nuwesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "nigawi"
        "SG3" | "" | Tense.INFINITIVE      | "iyuwesdi"
        "PL3" | "" | Tense.PRESENT         | "naniwea"
        "PL3" | "" | Tense.HABITUAL        | "naniwesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "nuniwesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "naniwi"
        "PL3" | "" | Tense.INFINITIVE      | "iyuniwesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "nidiwea"
        "PL1INCL" | "" | Tense.HABITUAL        | "nidiwesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "nigiwesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "nidiwi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iyigiwesdi"
    }
}
