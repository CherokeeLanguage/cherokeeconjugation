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
        "SG1" | "" | Tense.PRESENT         | "tsitladia"
        "SG1" | "" | Tense.HABITUAL        | "tsitladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitladvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitladisdi"
        "SG2" | "" | Tense.PRESENT         | "hitladia"
        "SG2" | "" | Tense.HABITUAL        | "hitladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitladvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatladisdi"
        "SG3" | "" | Tense.PRESENT         | "atladia"
        "SG3" | "" | Tense.HABITUAL        | "atladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atladvi"
        "SG3" | "" | Tense.INFINITIVE      | "utladisdi"
        "PL3" | "" | Tense.PRESENT         | "anitladia"
        "PL3" | "" | Tense.HABITUAL        | "anitladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitladvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitladisdi"
    }
}
