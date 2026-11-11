package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jideha', habitual: 'jidehoi', remote_past: 'jidelvi', imperative: 'jidisi', infinitive: 'jidehdi'],
            [subject: 'SG2', object: '', present: 'hideha', habitual: 'hidehoi', remote_past: 'hidelvi', imperative: 'hidisi', infinitive: 'hidehdi'],
            [subject: 'SG3', object: '', present: 'adeha', habitual: 'adehoi', remote_past: 'udelvi', imperative: 'adisi', infinitive: 'udehdi'],
            [subject: 'PL3', object: '', present: 'anideha', habitual: 'anidehoi', remote_past: 'unidelvi', imperative: 'anidisi', infinitive: 'unidehdi']
        ]
    ]

    @Unroll
    def "conjugating Adeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jideha"
        "SG1" | "" | Tense.HABITUAL        | "jidehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jidelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jidisi"
        "SG1" | "" | Tense.INFINITIVE      | "jidehdi"
        "SG2" | "" | Tense.PRESENT         | "hideha"
        "SG2" | "" | Tense.HABITUAL        | "hidehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hidelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidisi"
        "SG2" | "" | Tense.INFINITIVE      | "hidehdi"
        "SG3" | "" | Tense.PRESENT         | "adeha"
        "SG3" | "" | Tense.HABITUAL        | "adehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adisi"
        "SG3" | "" | Tense.INFINITIVE      | "udehdi"
        "PL3" | "" | Tense.PRESENT         | "anideha"
        "PL3" | "" | Tense.HABITUAL        | "anidehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidisi"
        "PL3" | "" | Tense.INFINITIVE      | "unidehdi"
    }
}
