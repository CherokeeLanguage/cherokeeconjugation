package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Finishing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisgwadia', habitual: 'jisgwadisgoi', remote_past: 'aksgwadvi', imperative: 'jisgwada', infinitive: 'aksgwadisdi'],
            [subject: 'SG2', object: '', present: 'hisgwadia', habitual: 'hisgwadisgoi', remote_past: 'tsgwadvi', imperative: 'hisgwada', infinitive: 'tsgwadisdi'],
            [subject: 'SG3', object: '', present: 'asgwadia', habitual: 'asgwadisgoi', remote_past: 'usgwadvi', imperative: 'asgwada', infinitive: 'usgwadisdi'],
            [subject: 'PL3', object: '', present: 'anisgwadia', habitual: 'anisgwadisgoi', remote_past: 'unsgwadvi', imperative: 'anisgwada', infinitive: 'unsgwadisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwadia', habitual: 'idisgwadisgoi', remote_past: 'iksgwadvi', imperative: 'idisgwada', infinitive: 'iksgwadisdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgwadia"
        "SG1" | "" | Tense.HABITUAL        | "jisgwadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgwadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisgwada"
        "SG1" | "" | Tense.INFINITIVE      | "aksgwadisdi"
        "SG2" | "" | Tense.PRESENT         | "hisgwadia"
        "SG2" | "" | Tense.HABITUAL        | "hisgwadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsgwadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisgwada"
        "SG2" | "" | Tense.INFINITIVE      | "tsgwadisdi"
        "SG3" | "" | Tense.PRESENT         | "asgwadia"
        "SG3" | "" | Tense.HABITUAL        | "asgwadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgwadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgwada"
        "SG3" | "" | Tense.INFINITIVE      | "usgwadisdi"
        "PL3" | "" | Tense.PRESENT         | "anisgwadia"
        "PL3" | "" | Tense.HABITUAL        | "anisgwadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsgwadvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisgwada"
        "PL3" | "" | Tense.INFINITIVE      | "unsgwadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgwadia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgwadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksgwadvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisgwada"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksgwadisdi"
    }
}
