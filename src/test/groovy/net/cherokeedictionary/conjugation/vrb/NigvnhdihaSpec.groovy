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
        "SG1" | "" | Tense.PRESENT         | "gvnadiha"
        "SG1" | "" | Tense.HABITUAL        | "gvnadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvnatanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnatanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyuwanadodi"
        "SG2" | "" | Tense.PRESENT         | "hvnadiha"
        "SG2" | "" | Tense.HABITUAL        | "hvnadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvnatanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnatanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayuwanadodi"
        "SG3" | "" | Tense.PRESENT         | "nigvnadiha"
        "SG3" | "" | Tense.HABITUAL        | "nigvnadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanatanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnatanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyuwanadodi"
        "PL3" | "" | Tense.PRESENT         | "anvnadiha"
        "PL3" | "" | Tense.HABITUAL        | "anvnadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvnatanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnatanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyuwanadodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvnadiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvnadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnatanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnatanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyuwanadodi"
    }
}
