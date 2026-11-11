package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DakanedliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Untying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejiganedliyva', habitual: 'dejiganedliyvsgoi', remote_past: 'dagikanedlihyvsvi', imperative: 'dijiganeya', infinitive: 'digikanehyohdi'],
            [subject: 'SG2', object: '', present: 'dehikanedliyva', habitual: 'dehikanedliyvsgoi', remote_past: 'dejakanedlihyvsvi', imperative: 'tikanehya', infinitive: 'dijakanehyohdi'],
            [subject: 'SG3', object: '', present: 'dakanedliyva', habitual: 'dakanedliyvsgoi', remote_past: 'dukanedlihyvsvi', imperative: 'dikanehya', infinitive: 'jukanehyohdi'],
            [subject: 'PL3', object: '', present: 'danikanedliyva', habitual: 'danikanedliyvsgoi', remote_past: 'dunikanedlihyvsvi', imperative: 'dinikanehya', infinitive: 'dunikanehyohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedikanedliyva', habitual: 'dedikanedliyvsgoi', remote_past: 'degikanedlihyvsvi', imperative: 'didikanehya', infinitive: 'digikanehyohdi']
        ]
    ]

    @Unroll
    def "conjugating Dakanedliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dakanedliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejiganedliyva"
        "SG1" | "" | Tense.HABITUAL        | "dejiganedliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagikanedlihyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijiganeya"
        "SG1" | "" | Tense.INFINITIVE      | "digikanehyohdi"
        "SG2" | "" | Tense.PRESENT         | "dehikanedliyva"
        "SG2" | "" | Tense.HABITUAL        | "dehikanedliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejakanedlihyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tikanehya"
        "SG2" | "" | Tense.INFINITIVE      | "dijakanehyohdi"
        "SG3" | "" | Tense.PRESENT         | "dakanedliyva"
        "SG3" | "" | Tense.HABITUAL        | "dakanedliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dukanedlihyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikanehya"
        "SG3" | "" | Tense.INFINITIVE      | "jukanehyohdi"
        "PL3" | "" | Tense.PRESENT         | "danikanedliyva"
        "PL3" | "" | Tense.HABITUAL        | "danikanedliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunikanedlihyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinikanehya"
        "PL3" | "" | Tense.INFINITIVE      | "dunikanehyohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedikanedliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedikanedliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degikanedlihyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didikanehya"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digikanehyohdi"
    }
}
