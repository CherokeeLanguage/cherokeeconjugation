package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigvnhdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Putting It On (147)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'nigvnhdiha', habitual: 'nigvnhdisgoi', remote_past: 'nagwvnhtanvi', imperative: 'nigvnhda', infinitive: 'iyagwvnhdohdi'],
            [subject: 'SG2', object: '', present: 'hnvnhdiha', habitual: 'hnvnhdisgoi', remote_past: 'nijvnhtanvi', imperative: 'hnvnhda', infinitive: 'iyijvnhdohdi'],
            [subject: 'SG3', object: '', present: 'nigvnhdiha', habitual: 'nigvnhdisgoi', remote_past: 'nuwanhtanvi', imperative: 'nigvnhda', infinitive: 'iyuwanhdohdi'],
            [subject: 'PL3', object: '', present: 'nanvnhdiha', habitual: 'nanvnhdisgoi', remote_past: 'nunvnhtanvi', imperative: 'nanvnhda', infinitive: 'iyunvnhdohdi'],
            [subject: 'PL1INCL', object: '', present: 'nidvnhdiha', habitual: 'nidvnhdisgoi', remote_past: 'nigvnhtanvi', imperative: 'nidvnhda', infinitive: 'iyigvnhdohdi']
        ]
    ]

    @Unroll
    def "conjugating Nigvnhdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigvnhdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "nigvnhdiha"
        "SG1" | "" | Tense.HABITUAL        | "nigvnhdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "nagwvnhtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "nigvnhda"
        "SG1" | "" | Tense.INFINITIVE      | "iyagwvnhdohdi"
        "SG2" | "" | Tense.PRESENT         | "hnvnhdiha"
        "SG2" | "" | Tense.HABITUAL        | "hnvnhdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "nijvnhtanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hnvnhda"
        "SG2" | "" | Tense.INFINITIVE      | "iyijvnhdohdi"
        "SG3" | "" | Tense.PRESENT         | "nigvnhdiha"
        "SG3" | "" | Tense.HABITUAL        | "nigvnhdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "nuwanhtanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "nigvnhda"
        "SG3" | "" | Tense.INFINITIVE      | "iyuwanhdohdi"
        "PL3" | "" | Tense.PRESENT         | "nanvnhdiha"
        "PL3" | "" | Tense.HABITUAL        | "nanvnhdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "nunvnhtanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "nanvnhda"
        "PL3" | "" | Tense.INFINITIVE      | "iyunvnhdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "nidvnhdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "nidvnhdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "nigvnhtanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "nidvnhda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iyigvnhdohdi"
    }
}
