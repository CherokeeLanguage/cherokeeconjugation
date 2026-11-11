package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgvsgwoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Washing His/Her Face",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gagvsgwoa', habitual: 'gagvsgwosgoi', remote_past: 'agwagvsgwovi', imperative: 'gagvsgwoja', infinitive: 'agwagvsgwosdi'],
            [subject: 'SG2', object: '', present: 'hagvsgwoa', habitual: 'hagvsgwosgoi', remote_past: 'jagvsgwovi', imperative: 'hagvsgwoja', infinitive: 'jagvsgwosdi'],
            [subject: 'SG3', object: '', present: 'agvsgwoa', habitual: 'agvsgwosgoi', remote_past: 'ugvsgwovi', imperative: 'agvsgwoja', infinitive: 'ugvsgwosdi'],
            [subject: 'PL3', object: '', present: 'anagvsgwoa', habitual: 'anagvsgwosgoi', remote_past: 'unagvsgwovi', imperative: 'anagvsgwoja', infinitive: 'unagvsgwosdi'],
            [subject: 'PL1INCL', object: '', present: 'idagvsgwoa', habitual: 'idagvsgwosgoi', remote_past: 'igagvsgwovi', imperative: 'idagvsgwoja', infinitive: 'igagvsgwosdi']
        ]
    ]

    @Unroll
    def "conjugating Agvsgwoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agvsgwoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gagvsgwoa"
        "SG1" | "" | Tense.HABITUAL        | "gagvsgwosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwagvsgwovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gagvsgwoja"
        "SG1" | "" | Tense.INFINITIVE      | "agwagvsgwosdi"
        "SG2" | "" | Tense.PRESENT         | "hagvsgwoa"
        "SG2" | "" | Tense.HABITUAL        | "hagvsgwosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jagvsgwovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hagvsgwoja"
        "SG2" | "" | Tense.INFINITIVE      | "jagvsgwosdi"
        "SG3" | "" | Tense.PRESENT         | "agvsgwoa"
        "SG3" | "" | Tense.HABITUAL        | "agvsgwosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugvsgwovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agvsgwoja"
        "SG3" | "" | Tense.INFINITIVE      | "ugvsgwosdi"
        "PL3" | "" | Tense.PRESENT         | "anagvsgwoa"
        "PL3" | "" | Tense.HABITUAL        | "anagvsgwosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unagvsgwovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anagvsgwoja"
        "PL3" | "" | Tense.INFINITIVE      | "unagvsgwosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idagvsgwoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idagvsgwosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igagvsgwovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idagvsgwoja"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igagvsgwosdi"
    }
}
