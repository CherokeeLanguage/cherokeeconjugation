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
        "SG1" | "" | Tense.PRESENT         | "gvnidiha"
        "SG1" | "" | Tense.HABITUAL        | "gvnidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvnitanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnitanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyuwanidodi"
        "SG2" | "" | Tense.PRESENT         | "hvnidiha"
        "SG2" | "" | Tense.HABITUAL        | "hvnidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvnitanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnitanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayuwanidodi"
        "SG3" | "" | Tense.PRESENT         | "nigvnidiha"
        "SG3" | "" | Tense.HABITUAL        | "nigvnidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanitanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnitanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyuwanidodi"
        "PL3" | "" | Tense.PRESENT         | "anvnidiha"
        "PL3" | "" | Tense.HABITUAL        | "anvnidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanitanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnitanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyuwanidodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvnidiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvnidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnitanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnitanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyuwanidodi"
    }
}
