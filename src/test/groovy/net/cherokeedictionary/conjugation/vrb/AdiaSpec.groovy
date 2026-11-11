package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidia', habitual: 'jidisgoi', remote_past: 'agidvi', imperative: 'jida', infinitive: 'agidisdi'],
            [subject: 'SG2', object: '', present: 'hidia', habitual: 'hidisgoi', remote_past: 'jadvi', imperative: 'hida', infinitive: 'jadisdi'],
            [subject: 'SG3', object: '', present: 'adia', habitual: 'adisgoi', remote_past: 'udvi', imperative: 'wada', infinitive: 'udisdi'],
            [subject: 'PL3', object: '', present: 'anidia', habitual: 'anidisgoi', remote_past: 'unidvi', imperative: 'wanida', infinitive: 'unidisdi']
        ]
    ]

    @Unroll
    def "conjugating Adia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidia"
        "SG1" | "" | Tense.HABITUAL        | "jidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jida"
        "SG1" | "" | Tense.INFINITIVE      | "agidisdi"
        "SG2" | "" | Tense.PRESENT         | "hidia"
        "SG2" | "" | Tense.HABITUAL        | "hidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hida"
        "SG2" | "" | Tense.INFINITIVE      | "jadisdi"
        "SG3" | "" | Tense.PRESENT         | "adia"
        "SG3" | "" | Tense.HABITUAL        | "adisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wada"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "PL3" | "" | Tense.PRESENT         | "anidia"
        "PL3" | "" | Tense.HABITUAL        | "anidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanida"
        "PL3" | "" | Tense.INFINITIVE      | "unidisdi"
    }
}
