package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanawogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Cold (139)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinawoga', habitual: 'jinawogoi', remote_past: 'agihnawojvi', imperative: 'jinawogi', infinitive: 'agihnawosdi'],
            [subject: 'SG2', object: '', present: 'hinawoga', habitual: 'hinawogoi', remote_past: 'jahnawojvi', imperative: 'hihnawogi', infinitive: 'jahnawosdi'],
            [subject: 'SG3', object: '', present: 'kanawoga', habitual: 'kanawogoi', remote_past: 'uhnawojvi', imperative: 'kanawogi', infinitive: 'uhnawosdi'],
            [subject: 'PL3', object: '', present: 'aninawoga', habitual: 'aninawogoi', remote_past: 'unihnawojvi', imperative: 'anihnawogi', infinitive: 'unihnawosdi'],
            [subject: 'PL1INCL', object: '', present: 'idinawoga', habitual: 'idinawogoi', remote_past: 'igihnawojvi', imperative: 'idihnawogi', infinitive: 'igihnawosdi']
        ]
    ]

    @Unroll
    def "conjugating Kanawoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanawoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinawoga"
        "SG1" | "" | Tense.HABITUAL        | "jinawogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnawojvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinawogi"
        "SG1" | "" | Tense.INFINITIVE      | "agihnawosdi"
        "SG2" | "" | Tense.PRESENT         | "hinawoga"
        "SG2" | "" | Tense.HABITUAL        | "hinawogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnawojvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnawogi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnawosdi"
        "SG3" | "" | Tense.PRESENT         | "kanawoga"
        "SG3" | "" | Tense.HABITUAL        | "kanawogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnawojvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kanawogi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnawosdi"
        "PL3" | "" | Tense.PRESENT         | "aninawoga"
        "PL3" | "" | Tense.HABITUAL        | "aninawogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnawojvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihnawogi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinawoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinawogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnawojvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihnawogi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnawosdi"
    }
}
