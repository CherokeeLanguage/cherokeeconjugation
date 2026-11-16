// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72641 (entrya asuligoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsuligogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Quitting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisuligoga'],
            [subject: 'SG1', object: '', present: 'jisuligoga', habitual: 'jisuligogoi', remote_past: 'aksuligojvi', imperative: 'jisuligoi', infinitive: 'aksuligosdi'],
            [subject: 'SG2', object: '', present: 'hisuligoga', habitual: 'hisuligogoi', remote_past: 'tsuligojvi', imperative: 'hisuligoi', infinitive: 'tsuligosdi'],
            [subject: 'SG3', object: '', habitual: 'asuligogoi', imperative: 'hisuligoi', infinitive: 'usuligosdi', present: 'asuligoga', remote_past: 'usuligojvi'],
            [subject: 'PL3', object: '', present: 'anisuligoga', habitual: 'anisuligogoi', remote_past: 'unisuligojvi', imperative: 'anisuligoi', infinitive: 'unsuligosdi'],
            [subject: 'PL1INCL', object: '', present: 'idisuligoga', habitual: 'idisuligogoi', remote_past: 'iksuligojvi', imperative: 'idisuligoi', infinitive: 'iksuligosdi']
        ]
    ]

    @Unroll
    def "conjugating Asuligoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuligoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisuligoga"
        "SG1" | "" | Tense.HABITUAL        | "tsisuligogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisuligotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisuligotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisuligosdi"
        "SG2" | "" | Tense.PRESENT         | "hisuligoga"
        "SG2" | "" | Tense.HABITUAL        | "hisuligogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasuligotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisuligotsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasuligosdi"
        "SG3" | "" | Tense.PRESENT         | "asuligoga"
        "SG3" | "" | Tense.HABITUAL        | "asuligogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usuligotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asuligotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "usuligosdi"
        "PL3" | "" | Tense.PRESENT         | "anisuligoga"
        "PL3" | "" | Tense.HABITUAL        | "anisuligogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisuligotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisuligotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisuligosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisuligoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisuligogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisuligotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisuligotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisuligosdi"
    }
}
