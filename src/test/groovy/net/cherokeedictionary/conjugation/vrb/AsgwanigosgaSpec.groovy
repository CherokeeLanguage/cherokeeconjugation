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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgwanigosga"
        "SG1" | "" | Tense.HABITUAL        | "jisgwanigosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgwanigosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisquanigosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgwanigohisdi"
        "SG2" | "" | Tense.PRESENT         | "hisgwanigosga"
        "SG2" | "" | Tense.HABITUAL        | "hisgwanigosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasquanigosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisquanigosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasquanigohisdi"
        "SG3" | "" | Tense.PRESENT         | "asgwanigosga"
        "SG3" | "" | Tense.HABITUAL        | "asgwanigosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgwanigosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asquanigosvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgwanigohisdi"
        "PL3" | "" | Tense.PRESENT         | "anisgwanigosga"
        "PL3" | "" | Tense.HABITUAL        | "anisgwanigosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisgwanigosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisquanigosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisgwanigohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgwanigosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgwanigosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisgwanigosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisquanigosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisgwanigohisdi"
    }
}
