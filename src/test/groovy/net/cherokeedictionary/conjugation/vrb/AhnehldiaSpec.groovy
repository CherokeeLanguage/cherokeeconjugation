package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnehldiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Translating / Interpreting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganehldiha', habitual: 'ganehldisgoi', remote_past: 'agwahnehltanvi', imperative: 'ganehlda', infinitive: 'agwahnehldohdi'],
            [subject: 'SG2', object: '', present: 'hahnehldia', habitual: 'hahnehldisgoi', remote_past: 'jahnehltanvi', imperative: 'hahnehlda', infinitive: 'jahnehldohdi'],
            [subject: 'SG3', object: '', present: 'ahnehldia', habitual: 'ahnehldisgoi', remote_past: 'uhnehltanvi', imperative: 'ahnehlda', infinitive: 'uhnehldohdi'],
            [subject: 'PL3', object: '', present: 'anahnehldia', habitual: 'anahnehldisgoi', remote_past: 'unahnehltanvi', imperative: 'anahnehlda', infinitive: 'unahnehldohdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnehldia', habitual: 'idahnehldisgoi', remote_past: 'igahnehltanvi', imperative: 'idahnehlda', infinitive: 'igahnehldohdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnehldia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnehldia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganelodia"
        "SG1" | "" | Tense.HABITUAL        | "ganelodisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanelotanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganelotanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanelododi"
        "SG2" | "" | Tense.PRESENT         | "hanelodia"
        "SG2" | "" | Tense.HABITUAL        | "hanelodisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanelotanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanelotanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanelododi"
        "SG3" | "" | Tense.PRESENT         | "anelodia"
        "SG3" | "" | Tense.HABITUAL        | "anelodisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unelotanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelotanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unelododi"
        "PL3" | "" | Tense.PRESENT         | "ananelodia"
        "PL3" | "" | Tense.HABITUAL        | "ananelodisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanelotanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananelotanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanelododi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanelodia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanelodisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganelotanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanelotanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganelododi"
    }
}
