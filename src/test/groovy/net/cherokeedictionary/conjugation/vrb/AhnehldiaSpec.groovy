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
        "SG1" | "" | Tense.PRESENT         | "ganehldiha"
        "SG1" | "" | Tense.HABITUAL        | "ganehldisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnehltanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganehlda"
        "SG1" | "" | Tense.INFINITIVE      | "agwahnehldohdi"
        "SG2" | "" | Tense.PRESENT         | "hahnehldia"
        "SG2" | "" | Tense.HABITUAL        | "hahnehldisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnehltanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahnehlda"
        "SG2" | "" | Tense.INFINITIVE      | "jahnehldohdi"
        "SG3" | "" | Tense.PRESENT         | "ahnehldia"
        "SG3" | "" | Tense.HABITUAL        | "ahnehldisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnehltanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahnehlda"
        "SG3" | "" | Tense.INFINITIVE      | "uhnehldohdi"
        "PL3" | "" | Tense.PRESENT         | "anahnehldia"
        "PL3" | "" | Tense.HABITUAL        | "anahnehldisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnehltanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahnehlda"
        "PL3" | "" | Tense.INFINITIVE      | "unahnehldohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahnehldia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahnehldisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnehltanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idahnehlda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahnehldohdi"
    }
}
