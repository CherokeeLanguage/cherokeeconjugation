package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Place on Something (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiladia', habitual: 'jiladisgoi', remote_past: 'akhladvi', imperative: 'jilada', infinitive: 'akhladisdi'],
            [subject: 'SG2', object: '', present: 'hihladia', habitual: 'hihladisgoi', remote_past: 'tshladvi', imperative: 'hihlada', infinitive: 'tshladisdi'],
            [subject: 'SG3', object: '', present: 'ahladia', habitual: 'ahladisgoi', remote_past: 'uhladvi', imperative: 'ahlada', infinitive: 'uhladisdi'],
            [subject: 'PL3', object: '', present: 'anihladia', habitual: 'anihladisgoi', remote_past: 'unihladvi', imperative: 'anihlada', infinitive: 'unihladisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiladia"
        "SG1" | "" | Tense.HABITUAL        | "jiladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akhladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilada"
        "SG1" | "" | Tense.INFINITIVE      | "akhladisdi"
        "SG2" | "" | Tense.PRESENT         | "hihladia"
        "SG2" | "" | Tense.HABITUAL        | "hihladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tshladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihlada"
        "SG2" | "" | Tense.INFINITIVE      | "tshladisdi"
        "SG3" | "" | Tense.PRESENT         | "ahladia"
        "SG3" | "" | Tense.HABITUAL        | "ahladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahlada"
        "SG3" | "" | Tense.INFINITIVE      | "uhladisdi"
        "PL3" | "" | Tense.PRESENT         | "anihladia"
        "PL3" | "" | Tense.HABITUAL        | "anihladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihlada"
        "PL3" | "" | Tense.INFINITIVE      | "unihladisdi"
    }
}
