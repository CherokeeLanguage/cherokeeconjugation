// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72685 (entrya atsgovsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtsgovsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gajisgovsga'],
            [subject: 'SG1', object: '', present: 'gajisgovsga', habitual: 'gajisgovsgoi', remote_past: 'agwatsgonvi', imperative: 'gajisgovga', infinitive: 'agwatsgodi'],
            [subject: 'SG2', object: '', present: 'hatsgovsga', habitual: 'hatsgovsgoi', remote_past: 'jatsgonvi', imperative: 'hatsgovga', infinitive: 'jatsgodi'],
            [subject: 'SG3', object: '', habitual: 'atsgovsgoi', imperative: 'hatsgovga', infinitive: 'utsgodi', present: 'atsgovsga', remote_past: 'utsgonvi'],
            [subject: 'PL3', object: '', present: 'anatsgovsga', habitual: 'anatsgovsgoi', remote_past: 'unatsgonvi', imperative: 'anatsgovga', infinitive: 'unatsgodi'],
            [subject: 'PL1INCL', object: '', present: 'idatsgovsga', habitual: 'idatsgovsgoi', remote_past: 'igatsgonvi', imperative: 'idatsgovga', infinitive: 'igatsgodi']
        ]
    ]

    @Unroll
    def "conjugating Atsgovsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atsgovsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajisgovsga"
        "SG1" | "" | Tense.HABITUAL        | "gajisgovsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatsgonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwatsgonvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatsgodi"
        "SG2" | "" | Tense.PRESENT         | "hatsgovsga"
        "SG2" | "" | Tense.HABITUAL        | "hatsgovsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatsgonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jatsgonvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatsgodi"
        "SG3" | "" | Tense.PRESENT         | "atsgovsga"
        "SG3" | "" | Tense.HABITUAL        | "atsgovsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsgonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utsgonvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsgodi"
        "PL3" | "" | Tense.PRESENT         | "anatsgovsga"
        "PL3" | "" | Tense.HABITUAL        | "anatsgovsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsgonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unatsgonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsgodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsgovsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsgovsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsgonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igatsgonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsgodi"
    }
}
