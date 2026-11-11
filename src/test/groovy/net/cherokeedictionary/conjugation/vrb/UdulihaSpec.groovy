package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdulihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Want",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwaduliha', habitual: 'agwadulihoi', remote_past: 'agwadulihvi', imperative: 'agwadula', infinitive: 'agwaduhldi'],
            [subject: 'SG2', object: '', present: 'jaduliha', habitual: 'jadulihoi', remote_past: 'jadulihvi', imperative: 'jadula', infinitive: 'jaduhldi'],
            [subject: 'SG3', object: '', present: 'uduliha', habitual: 'udulihoi', remote_past: 'udulihvi', imperative: 'udula', infinitive: 'uduhldi'],
            [subject: 'PL3', object: '', present: 'unaduliha', habitual: 'unadulihoi', remote_past: 'unadulihvi', imperative: 'unadula', infinitive: 'unaduhldi'],
            [subject: 'PL1INCL', object: '', present: 'igaduliha', habitual: 'igadulihoi', remote_past: 'igadulihvi', imperative: 'igadula', infinitive: 'igaduhldi']
        ]
    ]

    @Unroll
    def "conjugating Uduliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uduliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwaduliha"
        "SG1" | "" | Tense.HABITUAL        | "agwadulihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadulihvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadula"
        "SG1" | "" | Tense.INFINITIVE      | "agwaduhldi"
        "SG2" | "" | Tense.PRESENT         | "jaduliha"
        "SG2" | "" | Tense.HABITUAL        | "jadulihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadulihvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadula"
        "SG2" | "" | Tense.INFINITIVE      | "jaduhldi"
        "SG3" | "" | Tense.PRESENT         | "uduliha"
        "SG3" | "" | Tense.HABITUAL        | "udulihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udulihvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udula"
        "SG3" | "" | Tense.INFINITIVE      | "uduhldi"
        "PL3" | "" | Tense.PRESENT         | "unaduliha"
        "PL3" | "" | Tense.HABITUAL        | "unadulihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadulihvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadula"
        "PL3" | "" | Tense.INFINITIVE      | "unaduhldi"
        "PL1INCL" | "" | Tense.PRESENT         | "igaduliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadulihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadulihvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadula"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaduhldi"
    }
}
