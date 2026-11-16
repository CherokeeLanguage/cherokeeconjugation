// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72619 (entrya asgwanigosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwanigosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Amazed",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisgwanigosga'],
            [subject: 'SG1', object: '', present: 'jisgwanigosga', habitual: 'jisgwanigosgoi', remote_past: 'aksgwanigosvi', imperative: 'jisgwanigohi', infinitive: 'aksgwanigohisdi'],
            [subject: 'SG2', object: '', present: 'hisgwanigosga', habitual: 'hisgwanigosgoi', remote_past: 'tsgwanigosvi', imperative: 'hisgwanigohi', infinitive: 'tsgwanigohisdi'],
            [subject: 'SG3', object: '', habitual: 'asgwanigosgoi', imperative: 'hisgwanigohi', infinitive: 'usgwanigohisdi', present: 'asgwanigosga', remote_past: 'usgwanigosvi'],
            [subject: 'PL3', object: '', present: 'anisgwanigosga', habitual: 'anisgwanigosgoi', remote_past: 'unisgwanigosvi', imperative: 'anisgwanigohi', infinitive: 'unisgwanigohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwanigosga', habitual: 'idisgwanigosgoi', remote_past: 'igisgwanigosvi', imperative: 'idisgwanigohi', infinitive: 'igisgwanigohisdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwanigosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwanigosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisquanigosga"
        "SG1" | "" | Tense.HABITUAL        | "tsisquanigosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisquanigosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisquanigosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisquanigohisdi"
        "SG2" | "" | Tense.PRESENT         | "hisquanigosga"
        "SG2" | "" | Tense.HABITUAL        | "hisquanigosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasquanigosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisquanigosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasquanigohisdi"
        "SG3" | "" | Tense.PRESENT         | "asquanigosga"
        "SG3" | "" | Tense.HABITUAL        | "asquanigosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usquanigosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asquanigosvi"
        "SG3" | "" | Tense.INFINITIVE      | "usquanigohisdi"
        "PL3" | "" | Tense.PRESENT         | "anisquanigosga"
        "PL3" | "" | Tense.HABITUAL        | "anisquanigosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisquanigosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisquanigosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisquanigohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisquanigosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisquanigosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisquanigosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisquanigosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisquanigohisdi"
    }
}
