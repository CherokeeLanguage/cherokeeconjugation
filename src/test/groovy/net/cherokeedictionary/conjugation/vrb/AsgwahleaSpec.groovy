// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72613 (entrya asgwahlea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwahleaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Catching It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisgwahlea'],
            [subject: 'SG1', object: '', present: 'jisgwahlea', habitual: 'jisgwahlesgoi', remote_past: 'aksgwahlesvi', imperative: 'jisgwahlagi', infinitive: 'aksgwahlesdi'],
            [subject: 'SG2', object: '', present: 'hisgwahlea', habitual: 'hisgwahlesgoi', remote_past: 'tsgwahlesvi', imperative: 'hisgwahlagi', infinitive: 'tsgwahlesdi'],
            [subject: 'SG3', object: '', habitual: 'asgwahlesgoi', imperative: 'hisgwahlagi', infinitive: 'usgwahlesdi', present: 'asgwahlea', remote_past: 'usgwahlesvi'],
            [subject: 'PL3', object: '', present: 'anisgwahlea', habitual: 'anisgwahlesgoi', remote_past: 'unisgwahlesvi', imperative: 'anisgwahlagi', infinitive: 'unisgwahlesdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwahlea', habitual: 'idisgwahlesgoi', remote_past: 'iksgwahlesvi', imperative: 'idisgwahlagi', infinitive: 'iksgwahlesdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwahlea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwahlea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisquatlea"
        "SG1" | "" | Tense.HABITUAL        | "tsisquatlesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisquatlesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisquatlesvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisquatlesdi"
        "SG2" | "" | Tense.PRESENT         | "hisquatlea"
        "SG2" | "" | Tense.HABITUAL        | "hisquatlesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasquatlesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisquatlesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasquatlesdi"
        "SG3" | "" | Tense.PRESENT         | "asquatlea"
        "SG3" | "" | Tense.HABITUAL        | "asquatlesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usquatlesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asquatlesvi"
        "SG3" | "" | Tense.INFINITIVE      | "usquatlesdi"
        "PL3" | "" | Tense.PRESENT         | "anisquatlea"
        "PL3" | "" | Tense.HABITUAL        | "anisquatlesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisquatlesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisquatlesvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisquatlesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisquatlea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisquatlesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisquatlesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisquatlesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisquatlesdi"
    }
}
