package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AneladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Married, S/he is Getting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganeladia', habitual: 'ganeladisgoi', remote_past: 'agwaneladvi', imperative: 'ganelada', infinitive: 'agwaneladisdi'],
            [subject: 'SG2', object: '', present: 'haneladia', habitual: 'haneladisgoi', remote_past: 'janeladvi', imperative: 'hanelada', infinitive: 'janeladisdi'],
            [subject: 'SG3', object: '', present: 'aneladia', habitual: 'aneladisgoi', remote_past: 'uneladvi', imperative: 'anelada', infinitive: 'uneladisdi'],
            [subject: 'PL3', object: '', present: 'ananeladia', habitual: 'ananeladisgoi', remote_past: 'unaneladvi', imperative: 'ananelada', infinitive: 'unaneladisdi'],
            [subject: 'PL1INCL', object: '', present: 'idaneladia', habitual: 'idaneladisgoi', remote_past: 'iganeladvi', imperative: 'idanelada', infinitive: 'iganeladisdi']
        ]
    ]

    @Unroll
    def "conjugating Aneladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aneladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganeladia"
        "SG1" | "" | Tense.HABITUAL        | "ganeladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwaneladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganelada"
        "SG1" | "" | Tense.INFINITIVE      | "agwaneladisdi"
        "SG2" | "" | Tense.PRESENT         | "haneladia"
        "SG2" | "" | Tense.HABITUAL        | "haneladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janeladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanelada"
        "SG2" | "" | Tense.INFINITIVE      | "janeladisdi"
        "SG3" | "" | Tense.PRESENT         | "aneladia"
        "SG3" | "" | Tense.HABITUAL        | "aneladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uneladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelada"
        "SG3" | "" | Tense.INFINITIVE      | "uneladisdi"
        "PL3" | "" | Tense.PRESENT         | "ananeladia"
        "PL3" | "" | Tense.HABITUAL        | "ananeladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaneladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananelada"
        "PL3" | "" | Tense.INFINITIVE      | "unaneladisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaneladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaneladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganeladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanelada"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganeladisdi"
    }
}
