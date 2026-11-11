package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiladia', habitual: 'jiladisgoi', remote_past: 'agiladvi', imperative: 'jilada', infinitive: 'agiladisdi'],
            [subject: 'SG2', object: '', present: 'hiladia', habitual: 'haladisgoi', remote_past: 'jaladvi', imperative: 'hilada', infinitive: 'jaladisdi'],
            [subject: 'SG1', object: '', present: 'galadia', habitual: 'galadisgoi', remote_past: 'uladvi', imperative: 'wigalada', infinitive: 'uladisdi'],
            [subject: 'PL3', object: '', present: 'aniladia', habitual: 'aniladisgoi', remote_past: 'uniladvi', imperative: 'wanilada', infinitive: 'uniladisdi']
        ]
    ]

    @Unroll
    def "conjugating Galadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiladia"
        "SG1" | "" | Tense.HABITUAL        | "jiladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilada"
        "SG1" | "" | Tense.INFINITIVE      | "agiladisdi"
        "SG2" | "" | Tense.PRESENT         | "hiladia"
        "SG2" | "" | Tense.HABITUAL        | "haladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilada"
        "SG2" | "" | Tense.INFINITIVE      | "jaladisdi"
        "SG1" | "" | Tense.PRESENT         | "galadia"
        "SG1" | "" | Tense.HABITUAL        | "galadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigalada"
        "SG1" | "" | Tense.INFINITIVE      | "uladisdi"
        "PL3" | "" | Tense.PRESENT         | "aniladia"
        "PL3" | "" | Tense.HABITUAL        | "aniladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanilada"
        "PL3" | "" | Tense.INFINITIVE      | "uniladisdi"
    }
}
