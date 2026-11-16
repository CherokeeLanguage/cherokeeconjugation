// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72339 (entrya agvsgwoa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gagvsgwoa'],
            [subject: 'SG1', object: '', present: 'gagvsgwoa', habitual: 'gagvsgwosgoi', remote_past: 'agwagvsgwovi', imperative: 'gagvsgwoja', infinitive: 'agwagvsgwosdi'],
            [subject: 'SG2', object: '', present: 'hagvsgwoa', habitual: 'hagvsgwosgoi', remote_past: 'jagvsgwovi', imperative: 'hagvsgwoja', infinitive: 'jagvsgwosdi'],
            [subject: 'SG3', object: '', habitual: 'agvsgwosgoi', imperative: 'hagvsgwoja', infinitive: 'ugvsgwosdi', present: 'agvsgwoa', remote_past: 'ugvsgwovi'],
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
        "SG1" | "" | Tense.PRESENT         | "gagvsquoa"
        "SG1" | "" | Tense.HABITUAL        | "gagvsquosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquagvsquovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gagvsquovi"
        "SG1" | "" | Tense.INFINITIVE      | "aquagvsquosdi"
        "SG2" | "" | Tense.PRESENT         | "hagvsquoa"
        "SG2" | "" | Tense.HABITUAL        | "hagvsquosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagvsquovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hagvsquovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagvsquosdi"
        "SG3" | "" | Tense.PRESENT         | "agvsquoa"
        "SG3" | "" | Tense.HABITUAL        | "agvsquosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugvsquovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agvsquovi"
        "SG3" | "" | Tense.INFINITIVE      | "ugvsquosdi"
        "PL3" | "" | Tense.PRESENT         | "anagvsquoa"
        "PL3" | "" | Tense.HABITUAL        | "anagvsquosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unagvsquovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anagvsquovi"
        "PL3" | "" | Tense.INFINITIVE      | "unagvsquosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idagvsquoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idagvsquosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igagvsquovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idagvsquovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igagvsquosdi"
    }
}
